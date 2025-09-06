package com.cookandroid.foodrecipe;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 이 Activity가 화면에 보여줄 디자인으로 activity_login.xml 파일을 사용하라고 설정합니다.
        setContentView(R.layout.activity_login);

    }
}
