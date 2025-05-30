package com.miloki.testsapp;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class TestFound extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_test_found);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        TextView tv = findViewById(R.id.proba);

        DocumentReference docRef = db.collection("tests").document("Пипися");
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Test test = documentSnapshot.toObject(Test.class);
                tv.setText(test.getName() + "\nАвтор: " + test.getAuthor() + "\nКоличество вопросов: " + test.getQuestionCount() + "\nВопрос1: "
                +test.getQ1().getText() + "\n" + test.getQ1().stringOptions() + "\n" + test.getQ1().getAns());
            }
        });
    }
}