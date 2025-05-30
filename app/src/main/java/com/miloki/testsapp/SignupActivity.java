package com.miloki.testsapp;

import android.content.Context;
import android.content.Intent;
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

public class SignupActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        var sp = getSharedPreferences("PC", Context.MODE_PRIVATE);

        TextView email = findViewById(R.id.email);
        TextView password = findViewById(R.id.password);
        ConstraintLayout button = findViewById(R.id.button);
        TextView signin = findViewById(R.id.signintext);
        signin.setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));
        mAuth = FirebaseAuth.getInstance();

        button.setOnClickListener(v -> {
            mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();

                                Toast.makeText(SignupActivity.this, "Вы зарегестрированы!",
                                        Toast.LENGTH_SHORT).show();

                                EditText un = findViewById(R.id.username);

                                Intent intent = new Intent(SignupActivity.this, MainActivity2.class);
                                updateProfile(un.getText().toString());
                                //intent.putExtra("un", un.getText().toString());
                                startActivity((intent));
                                //updateUI(user);
                            } else {
                                Toast.makeText(SignupActivity.this, "Произошла ошибка. Попробуйте снова",
                                        Toast.LENGTH_SHORT).show();
                                //updateUI(null);
                            }
                        }
                    });
        });

    }

    @Override
    public void onBackPressed() {

    }

    public void updateProfile(String un) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(un)
                .build();

        user.updateProfile(profileUpdates);
    }
}

