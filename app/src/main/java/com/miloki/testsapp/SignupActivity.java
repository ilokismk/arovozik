package com.miloki.testsapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        SharedPreferences sp = getSharedPreferences("username", MODE_PRIVATE);

        TextView email = findViewById(R.id.email);
        TextView password = findViewById(R.id.password);
        ConstraintLayout button = findViewById(R.id.button);
        TextView signin = findViewById(R.id.signintext);
        EditText un = findViewById(R.id.username);
        signin.setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));
        mAuth = FirebaseAuth.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        button.setOnClickListener(v -> {
            if (passwordCheck(password.getText().toString()) && emailCheck(email.getText().toString()) && usernameCheck(un.getText().toString())) {
                mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(SignupActivity.this, "Вы зарегестрированы!", Toast.LENGTH_SHORT).show();

                                    sp.edit().putString("name", un.getText().toString()).apply();
                                    User user = new User();
                                    user.setUname(un.getText().toString());

                                    Map<String, Object> m = new HashMap<>();
                                    m.put("name", un.getText().toString());

                                    db.collection("usernames").document(email.getText().toString()).set(m);
                                    db.collection("users").document(un.getText().toString()).set(user);

                                    startActivity(new Intent(SignupActivity.this, MainActivity2.class));
                                    //updateUI(user);
                                } else {
                                    Toast.makeText(SignupActivity.this, "Произошла ошибка. Возможно такой email уже зарегестрирован", Toast.LENGTH_SHORT).show();
                                    //updateUI(null);
                                }
                            }
                        });
            }
            else {
                if (!emailCheck(email.getText().toString())) {
                    Toast.makeText(SignupActivity.this, "Введите корректный email", Toast.LENGTH_SHORT).show();
                }
                if (!passwordCheck(password.getText().toString())) {
                    Toast.makeText(SignupActivity.this, "Пароль должен содержать от 6 до 20 цифр", Toast.LENGTH_SHORT).show();
                }
                if (!usernameCheck(un.getText().toString())) {
                    Toast.makeText(SignupActivity.this, "Имя пользователя должно содержать от 3 до 14 символов", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

    @Override
    public void onBackPressed() {

    }

    public boolean passwordCheck(String p) {
        if (p.length() >= 6 && p.length() <= 20 && p.matches("-?\\d+")) {
            return true;
        }
        return false;
    }
    public boolean emailCheck(String p) {
        if (isValidEmail(p)) {
            return true;
        }
        return false;
    }
    public boolean usernameCheck(String p) {
        if (p.length() >= 3 && p.length() <= 14) {
            return true;
        }
        return false;
    }
    public boolean isValidEmail(String email) {
        String regex = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,6}$"; // Регулярное выражение для проверки email
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(email).matches();
    }

}

