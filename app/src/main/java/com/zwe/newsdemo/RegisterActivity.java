package com.zwe.newsdemo;

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
import android.widget.Toast;

/**
 * Created by Asus on 2017/4/3.
 */

public class RegisterActivity extends AppCompatActivity{
    private EditText edtName;
    private EditText edtPass;
    private EditText edtPassAgain;
    private Button mButton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
    }

    private void initViews() {
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        edtName= (EditText) findViewById(R.id.edtRegisterUser);
        edtPass= (EditText) findViewById(R.id.edtRegisterPass);
        edtPassAgain= (EditText) findViewById(R.id.edtRegisterPassAgain);
        mButton= (Button) findViewById(R.id.btnRegister);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=edtName.getText().toString().trim();
                String pass=edtPass.getText().toString().trim();
                String passAgain=edtPassAgain.getText().toString().trim();
                Toast.makeText(getApplication(),"暂时无服务器(Bmob的依赖与RxJava的依赖冲突)，账户随意啦，密码也可不填",Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean checkMsg(String name, String pass, String passAgain) {
        if (!TextUtils.isEmpty(name)||!TextUtils.isEmpty(pass)||!TextUtils.isEmpty(passAgain)){
            if (pass.equals(passAgain)){
                return true;
            }else {
                return false;
            }
        }
        return false;
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
}
