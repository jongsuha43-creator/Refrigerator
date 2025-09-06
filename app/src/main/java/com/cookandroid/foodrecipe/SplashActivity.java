package com.cookandroid.foodrecipe;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // 1. SplashScreen API를 설치합니다.
        // 이 코드는 반드시 super.onCreate()와 setContentView()보다 먼저 호출되어야 합니다.
        SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);

        // 2. 스플래시 화면이 표시된 후, 바로 다음 화면(LoginActivity)으로 넘어갑니다.
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);

        // 3. SplashActivity를 종료하여, 사용자가 뒤로가기 버튼을 눌렀을 때
        //    다시 스플래시 화면으로 돌아오지 않도록 합니다.
        finish();

    }
}
