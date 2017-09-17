package com.raymond.basedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.baseDemo.activities.FirstActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start= (Button) findViewById(R.id.start_btn);
        btn_start.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_btn:
                Log.d("MainActivity","pre start FirstActivity");
                Intent intentLauncher=new Intent(MainActivity.this, FirstActivity.class);
                startActivity(intentLauncher);
                break;
            default:
                break;
        }
    }
}
