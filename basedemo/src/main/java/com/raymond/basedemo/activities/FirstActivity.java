package com.raymond.basedemo.activities;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import com.raymond.basedemo.R;


/**
 * Created by ray on 2017/9/14.
 */

public class FirstActivity extends BaseActivity implements View.OnClickListener{
    private TextView content;
    private EditText userName,password;
    private Button register,login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        init();
        register.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    private void init(){
        content=findViewById(R.id.tv);
        register=findViewById(R.id.register);
        login=findViewById(R.id.login);
        userName=findViewById(R.id.username);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.register:
                Intent intentrigister = new Intent();
                intentrigister.setClass(FirstActivity.this,SecondActivity.class);
                startActivity(intentrigister);
                break;
            case R.id.login:
                Toast.makeText(this,"userName"+userName.getText().toString(),Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
