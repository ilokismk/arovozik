package com.miloki.testsapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SharedPreferences sp = getSharedPreferences("username", MODE_PRIVATE);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail();

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("usernames").document(email)
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        Username un = documentSnapshot.toObject(Username.class);
                        TextView username = findViewById(R.id.username);
                        username.setText("Имя пользователя: " + un.getName());
                    }
                });


        String name = sp.getString("name", "");



        TextView emailName = findViewById(R.id.emailName);
        emailName.setText("Email: " + email);
        TextView username = findViewById(R.id.username);
        username.setText("Имя пользователя: " + name);



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

