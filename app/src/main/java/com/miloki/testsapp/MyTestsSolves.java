package com.miloki.testsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyTestsSolves extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_tests_solves);

        ListView listView = findViewById(R.id.listView);

        SharedPreferences sp = getSharedPreferences("username", MODE_PRIVATE);

        Button createTest = findViewById(R.id.back);
        createTest.setOnClickListener(v -> startActivity(new Intent(this, MyTests.class)));

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Intent intent = getIntent();
        String name = intent.getStringExtra("test");
        db.collection("tests").document(name)
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        Test test = documentSnapshot.toObject(Test.class);
                        List<String> tests = test.getSolves();

                        ArrayAdapter<String> adapter = new ArrayAdapter<>(MyTestsSolves.this,
                                android.R.layout.simple_list_item_1, tests);
                        listView.setAdapter(adapter);
                        TextView tv= findViewById(R.id.textView4);
                        if (tests.get(0) == "") {
                            tv.setText("Пока никто не проходил этот тест");
                        } else {
                            tv.setText("Результаты тестирования");
                        }
                    }
                });
    }
}