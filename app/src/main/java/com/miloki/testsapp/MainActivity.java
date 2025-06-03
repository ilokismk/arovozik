package com.miloki.testsapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.Source;
import com.miloki.testsapp.MainActivity2;
import com.miloki.testsapp.SignupActivity;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView email = findViewById(R.id.email);
        TextView password = findViewById(R.id.password);
        ConstraintLayout button = findViewById(R.id.button);
        TextView signuptext = findViewById(R.id.signuptext);
        mAuth = FirebaseAuth.getInstance();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        SharedPreferences sp = getSharedPreferences("username", MODE_PRIVATE);

        signuptext.setOnClickListener(v -> {
            Intent intent = new Intent(this, SignupActivity.class);
            startActivity(intent);
        });

        button.setOnClickListener(v -> {
            mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                db.collection("usernames").document(email.getText().toString())
                                        .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                            @Override
                                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                                Username un = documentSnapshot.toObject(Username.class);
                                                sp.edit().putString("name", un.getName()).apply();
                                                //email.setText(un.getName());
                                            }
                                        });
                                Toast.makeText(MainActivity.this, "Вы вошли в аккаунт",
                                        Toast.LENGTH_SHORT).show();



                                startActivity(new Intent(MainActivity.this, MainActivity2.class));
                                //updateUI(user);
                            } else {
                                Toast.makeText(MainActivity.this, "Войти не удалось",
                                        Toast.LENGTH_SHORT).show();
                                //updateUI(null);
                            }
                        }
                    });
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            startActivity(new Intent(this, MainActivity2.class));
        }
    }

    @Override
    public void onBackPressed() {

    }

}

