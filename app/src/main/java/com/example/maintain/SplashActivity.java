package com.example.maintain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import com.example.maintain.utils.ThreadUtils;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //停留3秒进入登陆界面
        ThreadUtils.runInThread(new Runnable() {
            @Override
            public void run() {
                //停留3秒
                SystemClock.sleep(3000);
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
               //启动LoginActivity
                startActivity(intent);
                //销毁当前Activity
                finish();
            }
        });
    }
}