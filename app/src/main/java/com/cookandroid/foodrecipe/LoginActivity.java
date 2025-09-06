package com.cookandroid.foodrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText etEmail, etPassword;
    private Button btnLogin;
    private TextView tvJoin, tvFindId, tvFindPassword; // 회원가입은 TextView 입니다.

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 이 Activity가 화면에 보여줄 디자인으로 activity_login.xml 파일을 사용하라고 설정합니다.
        setContentView(R.layout.activity_login);

        // Firebase Auth 인스턴스 초기화
        mAuth = FirebaseAuth.getInstance();

        //변수
        btnLogin = (Button) findViewById(R.id.login_btn);
        etEmail = (EditText) findViewById(R.id.ETemail);
        etPassword = (EditText) findViewById(R.id.ETpassword);
        tvJoin = (TextView) findViewById(R.id.joinT);


        //로그인 버튼 클릭 시 동작 설정
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "이메일과 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                loginUser(email, password);

            }
        });

        // 회원가입 텍스트 클릭 시 동작 설정
        tvJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,JoinActivity.class);
                startActivity(intent);
            }
        });


    }

    //입력받은 이메일과 비밀번호로 Firebase 로그인을 시도하는 메서드
    private void loginUser(String email,String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //로그인 성공
                            Toast.makeText(LoginActivity.this, "로그인 성공!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish(); // 로그인 화면 종료
                        }else{
                            //로그인 실패
                            Toast.makeText(LoginActivity.this, "로그인에 실패했습니다. 계정을 확인해주세요.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

}
