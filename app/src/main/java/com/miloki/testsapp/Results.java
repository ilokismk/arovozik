package com.miloki.testsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class Results extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        TextView result = findViewById(R.id.result);
        int res = getIntent().getIntExtra("res", 0);
        int cnt = getIntent().getIntExtra("cnt", 1);
        String tn = getIntent().getStringExtra("tn");


        SharedPreferences sp = getSharedPreferences("username", MODE_PRIVATE);
        String uname = sp.getString("name", "");

        result.setText(res + "/" + cnt);


        db.collection("tests").document(tn).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Test u = documentSnapshot.toObject(Test.class);
                ArrayList<String> t = u.getSolves();
                if(t.get(0) == "") {
                    t.remove(0);
                }
                t.add(uname + " : " + res + "/" + cnt);
                DocumentReference usr = db.collection("tests").document(tn);
                usr.update("solves", t);
            }
        });


        Button ok = findViewById(R.id.ok);
        ok.setOnClickListener(v -> startActivity(new Intent(this, MainActivity2.class)));
    }
}