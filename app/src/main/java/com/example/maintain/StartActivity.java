package com.example.maintain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;

import com.example.maintain.utils.ThreadUtils;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //停留3秒进入登陆界面
        ThreadUtils.runInThread(new Runnable() {
            @Override
            public void run() {
                //停留3秒
                SystemClock.sleep(3000);
                Intent intent = new Intent(StartActivity.this,MainActivity.class);
                // Start the activity
                startActivity(intent);
                finish();
            }
        });
    }
}