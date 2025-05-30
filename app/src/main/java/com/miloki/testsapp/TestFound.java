
package com.miloki.testsapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CompoundButton;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;
import java.io.Serializable;

public class TestFound extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_found);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Button button = findViewById(R.id.find);
        EditText testName = findViewById(R.id.testName);
        Button startTest = findViewById(R.id.startTest);
        startTest.setVisibility(View.GONE);

        TextView testtext = findViewById(R.id.testtext);
        testtext.setVisibility(View.GONE);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.collection("tests").document(testName.getText().toString())
                        .get()
                        .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot document) {
                                if (document.getData() != null) {
                                    startTest.setVisibility(View.VISIBLE);
                                    db.collection("tests").document(testName.getText().toString())
                                            .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                                @Override
                                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                                    db.collection("tests").document(testName.getText().toString())
                                                            .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                                                @Override
                                                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                                                    Test test = documentSnapshot.toObject(Test.class);
                                                                    if (test != null) {
                                                                        testtext.setText("Автор: " + test.getAuthor().toString() + "\nКоличество вопросов: " + test.getQuestionCount());
                                                                        testtext.setVisibility(View.VISIBLE);

                                                                        startTest.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                button.setVisibility(View.GONE);
                                                                                testName.setVisibility(View.GONE);
                                                                                startTest.setVisibility(View.GONE);
                                                                                TextView testtext = findViewById(R.id.testtext);
                                                                                ((TextView) findViewById(R.id.NAME)).setText(test.getName());
                                                                                testtext.setVisibility(View.GONE);
                                                                                findViewById(R.id.scrollView2).setVisibility(View.VISIBLE);

                                                                                LinearLayout oo1 = findViewById(R.id.oneOption1);
                                                                                EditText ans1 = findViewById(R.id.ans1);
                                                                                RadioButton first1 = findViewById(R.id.first1);
                                                                                RadioButton second1 = findViewById(R.id.second1);
                                                                                RadioButton third1 = findViewById(R.id.third1);
                                                                                RadioButton fourth1 = findViewById(R.id.fourth1);
                                                                                TextView qtext1 = findViewById(R.id.qtext1);
                                                                                qtext1.setText(test.getQ1().getText());
                                                                                oo1.setVisibility(View.VISIBLE);
                                                                                ans1.setVisibility(View.GONE);
                                                                                final String[] aans1 = {"1"};

                                                                                first1.setText(test.getQ1().getOption1());
                                                                                second1.setText(test.getQ1().getOption2());
                                                                                third1.setText(test.getQ1().getOption3());
                                                                                fourth1.setText(test.getQ1().getOption4());

                                                                                if (test.getQ1().getType().equals("one")) {
                                                                                    first1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (first1.isChecked() == true) {
                                                                                                aans1[0] = "1";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    second1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (second1.isChecked() == true) {
                                                                                                aans1[0] = "2";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    third1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (third1.isChecked() == true) {
                                                                                                aans1[0] = "3";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    fourth1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (fourth1.isChecked() == true) {
                                                                                                aans1[0] = "4";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                } else {
                                                                                    oo1.setVisibility(View.GONE);
                                                                                    ans1.setVisibility(View.VISIBLE);
                                                                                }

                                                                                Button ok = findViewById(R.id.ok);
                                                                                ok.setOnClickListener(new View.OnClickListener() {
                                                                                    @Override
                                                                                    public void onClick(View v) {
                                                                                        Intent intent = new Intent(TestFound.this, Results.class);
                                                                                        int res = 0;
                                                                                        if (test.getQ1().getType().equals("ans")) {
                                                                                            aans1[0] = ans1.getText().toString();
                                                                                        }
                                                                                        if (aans1[0].equals(test.getQ1().getAns())) {
                                                                                            ++res;
                                                                                        }
                                                                                        intent.putExtra("res", res);
                                                                                        intent.putExtra("cnt", test.getQuestionCount());
                                                                                        intent.putExtra("tn", test.getName().toString());
                                                                                        startActivity(intent);
                                                                                    }
                                                                                });
                                                                            }
                                                                        });
                                                                    }
                                                                }
                                                            });
                                                    Toast.makeText(TestFound.this, "Тест найден!", Toast.LENGTH_SHORT).show();
                                                    testtext.setVisibility(View.GONE);
                                                }
                                            });
                                } else {
                                    Toast.makeText(TestFound.this, "No such document", Toast.LENGTH_SHORT).show();
                                    startTest.setVisibility(View.GONE);
                                    testtext.setVisibility(View.GONE);
                                }
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(Exception exception) {
                                Toast.makeText(TestFound.this, "Не получилось☹, попробуйте снова", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}

