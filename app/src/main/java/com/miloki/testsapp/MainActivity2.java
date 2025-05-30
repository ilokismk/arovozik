package com.miloki.testsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String name = user.getDisplayName();
        String email = user.getEmail();
        Uri photoUrl = user.getPhotoUrl();

        boolean emailVerified = user.isEmailVerified();
        String uid = user.getUid();

        Intent intent = getIntent();
        TextView emailName = findViewById(R.id.emailName);
        emailName.setText("Email: " + email);
        TextView username = findViewById(R.id.username);
        username.setText("Имя пользователя: " + intent.getStringExtra("un"));
        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder().setDisplayName(intent.getStringExtra("un")).build();
        user.updateProfile(profileUpdates);

        Button logout = findViewById(R.id.logout);
        logout.setOnClickListener(v -> {
            Toast.makeText(this, "Вы вышли из аккаунта", Toast.LENGTH_SHORT).show();
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this, MainActivity.class));
        });

        Button toTest = findViewById(R.id.goToTest);
        toTest.setOnClickListener(v -> startActivity(new Intent(this, TestFound.class)));
//
        Button createTest = findViewById(R.id.createTest);
        createTest.setOnClickListener(v -> startActivity(new Intent(this, Create.class)));

    }

    @Override
    public void onBackPressed() {

    }
}

