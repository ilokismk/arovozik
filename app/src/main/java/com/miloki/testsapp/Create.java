package com.miloki.testsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class Create extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create);

        SharedPreferences sp = getSharedPreferences("username", MODE_PRIVATE);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uname = sp.getString("name", "");
        String uemail = user.getEmail();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Test test = new Test();
        Question q1 = new Question();
        findViewById(R.id.one1).setOnClickListener((view)->{
            q1.setType("one");
            findViewById(R.id.ans1).setVisibility(View.GONE);
            findViewById(R.id.oneOption1).setVisibility(View.VISIBLE);
        });
        findViewById(R.id.word1).setOnClickListener((view)->{
            q1.setType("ans");
            findViewById(R.id.oneOption1).setVisibility(View.GONE);
            findViewById(R.id.ans1).setVisibility(View.VISIBLE);
        });

        findViewById(R.id.first1).setOnClickListener((view)->{
            q1.setAns("1");
        });
        findViewById(R.id.second1).setOnClickListener((view)->{
            q1.setAns("2");
        });
        findViewById(R.id.third1).setOnClickListener((view)->{
            q1.setAns("3");
        });
        findViewById(R.id.fourth1).setOnClickListener((view)->{
            q1.setAns("4");
        });

        findViewById(R.id.ok).setOnClickListener((view)->{
            EditText name = findViewById(R.id.testName);

            test.setName(name.getText().toString());

            name = findViewById(R.id.qtext1);
            test.setAuthor(uname);
            q1.setText(name.getText().toString());
            List<EditText> o1= Arrays.asList(findViewById(R.id.option1_1), findViewById(R.id.option2_1), findViewById(R.id.option3_1), findViewById(R.id.option4_1));
            q1.setOptions(o1.get(0).getText().toString(), o1.get(1).getText().toString(), o1.get(2).getText().toString(), o1.get(3).getText().toString());
            if (q1.getType() == "ans") {
                EditText ans = findViewById(R.id.ans1);
                q1.setAns(ans.getText().toString());
            }

            test.setQ1(q1);
            db.collection("tests").document(test.getName()).set(test);
            Toast.makeText(this, "Тест успешно создан", Toast.LENGTH_SHORT).show();

            db.collection("users").document(uname).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    User u = documentSnapshot.toObject(User.class);
                    ArrayList <String> t = u.getTests();
                    if(t.get(0) == "") {
                        t.remove(0);
                    }
                    t.add(test.getName().toString());
                    DocumentReference usr = db.collection("users").document(uname);
                    usr.update("tests", t);
                }
            });


            startActivity(new Intent(this, MainActivity2.class));
        });
    }

    public void onRadioButtonClicked(View view) {

        RadioButton radio = (RadioButton) view;
        boolean checked = radio.isChecked();
        String text = radio.getText().toString();

        switch(text) {
            case "1":
                if (checked) Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                break;
            case "2":
                if (checked) Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}