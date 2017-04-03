package com.zwe.newsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by Asus on 2017/4/2.
 */

public class LoginActivity extends AppCompatActivity{
    private EditText mEditText;
    private Button mButton;
    private TextView mTextView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {
        mEditText= (EditText) findViewById(R.id.edtUser);
        mButton= (Button) findViewById(R.id.btnLogin);
        mButton.setOnClickListener(mOnClickListener);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        mTextView= (TextView) findViewById(R.id.tvRegist);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    View.OnClickListener mOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String user=mEditText.getText().toString().trim();
            if (!TextUtils.isEmpty(user)){
                EventBus.getDefault().post(new LoginSuccessEvent(user));
/*                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);*/
                //finish();
                finish();
            }else {
                Toast.makeText(getApplicationContext(),"参数错误",Toast.LENGTH_SHORT).show();
                return;
            }
        }
    };

}
