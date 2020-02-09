package com.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.Window;
import android.os.Handler;

public class jiazailayout extends AppCompatActivity {
    private static int SPLASH_DISPLAY_LENGHT= 4000;    //延迟2秒

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_NO_TITLE);//去掉标题
        setContentView(R.layout.activity_jiazailayout);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(jiazailayout.this, MainActivity.class);	//第二个参数即为执行完跳转后的Activity
                startActivity(intent);
                jiazailayout.this.finish();   //关闭splashActivity，将其回收，否则按返回键会返回此界面
            }
        }, SPLASH_DISPLAY_LENGHT);
    }
}
