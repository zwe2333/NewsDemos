package com.zwe.newsdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private RecyclerView mRecyclerView;
    private List<NewsList> mNewsLists=new ArrayList<>();
    private MyAdapter mMyAdapter;
    private String currentType="sport";
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private TextView nav_user;
    private TextView logout;
    private boolean isLogined=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        initViews();
        initData("sport");
    }

    private void initData(final String type) {
        //Observable.create()
        Observable observable=Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter e) throws Exception {
                String data=getData(type);
                e.onNext(data);
            }
        });
        Consumer consumer=new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                String data= (String) o;
                parseJson(data);
                mMyAdapter.notifyDataSetChanged();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        };
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer);
    }


    public String getData(String type) {
        String data="";
        try {
            String url="http://wangyi.butterfly.mopaasapp.com/news/api?type="+type+"&page=1&limit=10";
            OkHttpClient client=new OkHttpClient();
            Request request=new Request.Builder()
                    .url(url)
                    .build();
            Response response=client.newCall(request).execute();
            data=response.body().string();
            //parseJson(data);
            //return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private void parseJson(String data) {
        mNewsLists.clear();
        Gson gson=new Gson();
        NewsItemList newsItemList = gson.fromJson(data, NewsItemList.class);
        for (int i=0;i<newsItemList.getList().size();i++){
            String title=newsItemList.getList().get(i).getTitle();
            String time=newsItemList.getList().get(i).getTime();
            String url=newsItemList.getList().get(i).getImgurl();
            String newsUrl=newsItemList.getList().get(i).getDocurl();
            NewsList newsList=new NewsList(url,time,title,newsUrl);
            mNewsLists.add(newsList);
        }
        //loadSuccess();
    }

/*    private void loadSuccess() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mMyAdapter.notifyDataSetChanged();
            }
        });

    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.sport:
                initData("sport");
                currentType="sport";
                break;
            case R.id.science:
                initData("tech");
                currentType="tech";
                break;
            case R.id.education:
                initData("edu");
                currentType="edu";
                break;
            case R.id.entertainment:
                initData("ent");
                currentType="ent";
                break;
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
    }


    private void initViews() {

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawerlayout);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.logohead3);
        }


        mNavigationView= (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                mDrawerLayout.closeDrawers();
                return true;
            }
        });


        mSwipeRefreshLayout= (SwipeRefreshLayout) findViewById(R.id.swipe);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData(currentType);
            }
        });


        mTextView= (TextView) findViewById(R.id.tvUser);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });


        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mMyAdapter=new MyAdapter(mNewsLists);
        mRecyclerView.setAdapter(mMyAdapter);



        //获取导航栏控件textview
        View tView=mNavigationView.getHeaderView(0);
        nav_user= (TextView) tView.findViewById(R.id.nav_user);


        logout= (TextView) findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nav_user.setText("未登录");
                mTextView.setVisibility(View.VISIBLE);
                logout.setVisibility(View.GONE);
                mTextView.setText("还没登录？快去登录");
                isLogined=false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isLogined){
            logout.setVisibility(View.VISIBLE);
            mTextView.setVisibility(View.GONE);
        }
    }

    @Subscribe
    public void onEventMainThread(LoginSuccessEvent event){
        String user=event.getUser();
        Toast.makeText(getApplicationContext(),"账号是伪装的，退出时不会保存",Toast.LENGTH_LONG).show();
        //mTextView.setVisibility(View.GONE);
        isLogined=true;
        nav_user.setText(user);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


}
