package com.cookandroid.foodrecipe;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class JoinActivity extends AppCompatActivity {
    private FirebaseAuth JmAuth;
    private EditText JETemail, JETpassword, JETpasswordCheck;
    private Button btnJoin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        // Firebase Auth 인스턴스 초기화
        JmAuth = FirebaseAuth.getInstance();

        //변수 설정
        JETemail = findViewById(R.id.etEmail);
        JETpassword = findViewById(R.id.etPassword);
        JETpasswordCheck = findViewById(R.id.etPasswordConfirm);
        btnJoin = findViewById(R.id.btnRegister);

        // 회원가입 버튼 클릭 시 동작 설정
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = JETemail.getText().toString().trim();
                String password = JETpassword.getText().toString().trim();
                String passwordCheck = JETpasswordCheck.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty() || passwordCheck.isEmpty()) {
                    Toast.makeText(JoinActivity.this, "모든 항목을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!password.equals(passwordCheck)) {
                    Toast.makeText(JoinActivity.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Firebase로 회원가입 시도
                registerUser(email, password);

            }
        });


    }


    //입력받은 이메일과 비밀번호로 Firebase에 새로운 사용자를 등록하는 메서드
    private void registerUser(String email, String password) {
        JmAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // 회원가입 성공
                            Toast.makeText(JoinActivity.this, "회원가입 성공! 로그인해주세요.", Toast.LENGTH_SHORT).show();
                            finish(); // 회원가입 화면을 종료하고 로그인 화면으로 돌아갑니다.
                        } else {
                            // 회원가입 실패
                            Toast.makeText(JoinActivity.this, "회원가입에 실패했습니다. 이미 가입된 이메일일 수 있습니다.", Toast.LENGTH_LONG).show();
                        }
                    }
                });


    }

}
