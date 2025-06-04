
package com.miloki.testsapp;

import static android.view.View.VISIBLE;

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
                                    startTest.setVisibility(VISIBLE);
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
                                                                        testtext.setVisibility(VISIBLE);

                                                                        startTest.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                button.setVisibility(View.GONE);
                                                                                testName.setVisibility(View.GONE);
                                                                                startTest.setVisibility(View.GONE);
                                                                                TextView testtext = findViewById(R.id.testtext);
                                                                                ((TextView) findViewById(R.id.NAME)).setText(test.getName());
                                                                                testtext.setVisibility(View.GONE);
                                                                                findViewById(R.id.scrollView2).setVisibility(VISIBLE);

                                                                                LinearLayout oo1 = findViewById(R.id.oneOption1);
                                                                                EditText ans1 = findViewById(R.id.ans1);
                                                                                RadioButton first1 = findViewById(R.id.first1);
                                                                                RadioButton second1 = findViewById(R.id.second1);
                                                                                RadioButton third1 = findViewById(R.id.third1);
                                                                                RadioButton fourth1 = findViewById(R.id.fourth1);
                                                                                TextView qtext1 = findViewById(R.id.qtext1);
                                                                                qtext1.setText(test.getQ1().getText());
                                                                                oo1.setVisibility(VISIBLE);
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
                                                                                    ans1.setVisibility(VISIBLE);
                                                                                }

                                                                                LinearLayout oo2 = findViewById(R.id.oneOption2);
                                                                                EditText ans2 = findViewById(R.id.ans2);
                                                                                RadioButton first2 = findViewById(R.id.first2);
                                                                                RadioButton second2 = findViewById(R.id.second2);
                                                                                RadioButton third2 = findViewById(R.id.third2);
                                                                                RadioButton fourth2 = findViewById(R.id.fourth2);
                                                                                TextView qtext2 = findViewById(R.id.qtext2);
                                                                                qtext2.setText(test.getQ2().getText());
                                                                                oo2.setVisibility(VISIBLE);
                                                                                ans2.setVisibility(View.GONE);
                                                                                final String[] aans2 = {"1"};

                                                                                first2.setText(test.getQ2().getOption1());
                                                                                second2.setText(test.getQ2().getOption2());
                                                                                third2.setText(test.getQ2().getOption3());
                                                                                fourth2.setText(test.getQ2().getOption4());

                                                                                if (test.getQ2().getType().equals("one")) {
                                                                                    first2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (first2.isChecked() == true) {
                                                                                                aans2[0] = "1";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    second2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (second2.isChecked() == true) {
                                                                                                aans2[0] = "2";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    third2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (third2.isChecked() == true) {
                                                                                                aans2[0] = "3";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    fourth2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (fourth2.isChecked() == true) {
                                                                                                aans2[0] = "4";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                } else {
                                                                                    oo2.setVisibility(View.GONE);
                                                                                    ans2.setVisibility(VISIBLE);
                                                                                }

                                                                                LinearLayout oo3 = findViewById(R.id.oneOption3);
                                                                                EditText ans3 = findViewById(R.id.ans3);
                                                                                RadioButton first3 = findViewById(R.id.first3);
                                                                                RadioButton second3 = findViewById(R.id.second3);
                                                                                RadioButton third3 = findViewById(R.id.third3);
                                                                                RadioButton fourth3 = findViewById(R.id.fourth3);
                                                                                TextView qtext3 = findViewById(R.id.qtext3);
                                                                                qtext3.setText(test.getQ3().getText());
                                                                                oo3.setVisibility(VISIBLE);
                                                                                ans3.setVisibility(View.GONE);
                                                                                final String[] aans3 = {"1"};

                                                                                first3.setText(test.getQ3().getOption1());
                                                                                second3.setText(test.getQ3().getOption2());
                                                                                third3.setText(test.getQ3().getOption3());
                                                                                fourth3.setText(test.getQ3().getOption4());

                                                                                if (test.getQ3().getType().equals("one")) {
                                                                                    first3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (first3.isChecked() == true) {
                                                                                                aans3[0] = "1";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    second3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (second3.isChecked() == true) {
                                                                                                aans3[0] = "2";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    third3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (third3.isChecked() == true) {
                                                                                                aans3[0] = "3";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    fourth3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (fourth3.isChecked() == true) {
                                                                                                aans3[0] = "4";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                } else {
                                                                                    oo3.setVisibility(View.GONE);
                                                                                    ans3.setVisibility(VISIBLE);
                                                                                }

                                                                                LinearLayout oo4 = findViewById(R.id.oneOption4);
                                                                                EditText ans4 = findViewById(R.id.ans4);
                                                                                RadioButton first4 = findViewById(R.id.first4);
                                                                                RadioButton second4 = findViewById(R.id.second4);
                                                                                RadioButton third4 = findViewById(R.id.third4);
                                                                                RadioButton fourth4 = findViewById(R.id.fourth4);
                                                                                TextView qtext4 = findViewById(R.id.qtext4);
                                                                                qtext4.setText(test.getQ4().getText());
                                                                                oo4.setVisibility(View.VISIBLE);
                                                                                ans4.setVisibility(View.GONE);
                                                                                final String[] aans4 = {"1"};
//
                                                                                first4.setText(test.getQ4().getOption1());
                                                                                second4.setText(test.getQ4().getOption2());
                                                                                third4.setText(test.getQ4().getOption3());
                                                                                fourth4.setText(test.getQ4().getOption4());
//
                                                                                if (test.getQ4().getType().equals("one")) {
                                                                                    first4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (first4.isChecked() == true) {
                                                                                                aans4[0] = "1";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    second4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (second4.isChecked() == true) {
                                                                                                aans4[0] = "2";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    third4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (third4.isChecked() == true) {
                                                                                                aans4[0] = "3";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    fourth4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (fourth4.isChecked() == true) {
                                                                                                aans4[0] = "4";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                } else {
                                                                                    oo4.setVisibility(View.GONE);
                                                                                    ans4.setVisibility(View.VISIBLE);
                                                                                }
//
                                                                                LinearLayout oo5 = findViewById(R.id.oneOption5);
                                                                                EditText ans5 = findViewById(R.id.ans5);
                                                                                RadioButton first5 = findViewById(R.id.first5);
                                                                                RadioButton second5 = findViewById(R.id.second5);
                                                                                RadioButton third5 = findViewById(R.id.third5);
                                                                                RadioButton fourth5 = findViewById(R.id.fourth5);
                                                                                TextView qtext5 = findViewById(R.id.qtext5);
                                                                                qtext5.setText(test.getQ5().getText());
                                                                                oo5.setVisibility(View.VISIBLE);
                                                                                ans5.setVisibility(View.GONE);
                                                                                final String[] aans5 = {"1"};
//
                                                                                first5.setText(test.getQ5().getOption1());
                                                                                second5.setText(test.getQ5().getOption2());
                                                                                third5.setText(test.getQ5().getOption3());
                                                                                fourth5.setText(test.getQ5().getOption4());
//
                                                                                if (test.getQ5().getType().equals("one")) {
                                                                                    first5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (first5.isChecked() == true) {
                                                                                                aans5[0] = "1";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    second5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (second5.isChecked() == true) {
                                                                                                aans5[0] = "2";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    third5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (third5.isChecked() == true) {
                                                                                                aans5[0] = "3";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    fourth5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (fourth5.isChecked() == true) {
                                                                                                aans5[0] = "4";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                } else {
                                                                                    oo5.setVisibility(View.GONE);
                                                                                    ans5.setVisibility(View.VISIBLE);
                                                                                }
//
                                                                                LinearLayout oo6 = findViewById(R.id.oneOption6);
                                                                                EditText ans6 = findViewById(R.id.ans6);
                                                                                RadioButton first6 = findViewById(R.id.first6);
                                                                                RadioButton second6 = findViewById(R.id.second6);
                                                                                RadioButton third6 = findViewById(R.id.third6);
                                                                                RadioButton fourth6 = findViewById(R.id.fourth6);
                                                                                TextView qtext6 = findViewById(R.id.qtext6);
                                                                                qtext6.setText(test.getQ6().getText());
                                                                                oo6.setVisibility(View.VISIBLE);
                                                                                ans6.setVisibility(View.GONE);
                                                                                final String[] aans6 = {"1"};
//
                                                                                first6.setText(test.getQ6().getOption1());
                                                                                second6.setText(test.getQ6().getOption2());
                                                                                third6.setText(test.getQ6().getOption3());
                                                                                fourth6.setText(test.getQ6().getOption4());
//
                                                                                if (test.getQ6().getType().equals("one")) {
                                                                                    first6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (first6.isChecked() == true) {
                                                                                                aans6[0] = "1";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    second6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (second6.isChecked() == true) {
                                                                                                aans6[0] = "2";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    third6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (third6.isChecked() == true) {
                                                                                                aans6[0] = "3";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    fourth6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (fourth6.isChecked() == true) {
                                                                                                aans6[0] = "4";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                } else {
                                                                                    oo6.setVisibility(View.GONE);
                                                                                    ans6.setVisibility(View.VISIBLE);
                                                                                }
//
                                                                                LinearLayout oo7 = findViewById(R.id.oneOption7);
                                                                                EditText ans7 = findViewById(R.id.ans7);
                                                                                RadioButton first7 = findViewById(R.id.first7);
                                                                                RadioButton second7 = findViewById(R.id.second7);
                                                                                RadioButton third7 = findViewById(R.id.third7);
                                                                                RadioButton fourth7 = findViewById(R.id.fourth7);
                                                                                TextView qtext7 = findViewById(R.id.qtext7);
                                                                                qtext7.setText(test.getQ7().getText());
                                                                                oo7.setVisibility(View.VISIBLE);
                                                                                ans7.setVisibility(View.GONE);
                                                                                final String[] aans7 = {"1"};
//
                                                                                first7.setText(test.getQ7().getOption1());
                                                                                second7.setText(test.getQ7().getOption2());
                                                                                third7.setText(test.getQ7().getOption3());
                                                                                fourth7.setText(test.getQ7().getOption4());
//
                                                                                if (test.getQ7().getType().equals("one")) {
                                                                                    first7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (first7.isChecked() == true) {
                                                                                                aans7[0] = "1";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    second7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (second7.isChecked() == true) {
                                                                                                aans7[0] = "2";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    third7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (third7.isChecked() == true) {
                                                                                                aans7[0] = "3";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    fourth7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (fourth7.isChecked() == true) {
                                                                                                aans7[0] = "4";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                } else {
                                                                                    oo7.setVisibility(View.GONE);
                                                                                    ans7.setVisibility(View.VISIBLE);
                                                                                }
//
                                                                                LinearLayout oo8 = findViewById(R.id.oneOption8);
                                                                                EditText ans8 = findViewById(R.id.ans8);
                                                                                RadioButton first8 = findViewById(R.id.first8);
                                                                                RadioButton second8 = findViewById(R.id.second8);
                                                                                RadioButton third8 = findViewById(R.id.third8);
                                                                                RadioButton fourth8 = findViewById(R.id.fourth8);
                                                                                TextView qtext8 = findViewById(R.id.qtext8);
                                                                                qtext8.setText(test.getQ8().getText());
                                                                                oo8.setVisibility(View.VISIBLE);
                                                                                ans8.setVisibility(View.GONE);
                                                                                final String[] aans8 = {"1"};
//
                                                                                first8.setText(test.getQ8().getOption1());
                                                                                second8.setText(test.getQ8().getOption2());
                                                                                third8.setText(test.getQ8().getOption3());
                                                                                fourth8.setText(test.getQ8().getOption4());
//
                                                                                if (test.getQ8().getType().equals("one")) {
                                                                                    first8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (first8.isChecked() == true) {
                                                                                                aans8[0] = "1";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    second8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (second8.isChecked() == true) {
                                                                                                aans8[0] = "2";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    third8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (third8.isChecked() == true) {
                                                                                                aans8[0] = "3";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    fourth8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (fourth8.isChecked() == true) {
                                                                                                aans8[0] = "4";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                } else {
                                                                                    oo8.setVisibility(View.GONE);
                                                                                    ans8.setVisibility(View.VISIBLE);
                                                                                }
//
                                                                                LinearLayout oo9 = findViewById(R.id.oneOption9);
                                                                                EditText ans9 = findViewById(R.id.ans9);
                                                                                RadioButton first9 = findViewById(R.id.first9);
                                                                                RadioButton second9 = findViewById(R.id.second9);
                                                                                RadioButton third9 = findViewById(R.id.third9);
                                                                                RadioButton fourth9 = findViewById(R.id.fourth9);
                                                                                TextView qtext9 = findViewById(R.id.qtext9);
                                                                                qtext9.setText(test.getQ9().getText());
                                                                                oo9.setVisibility(View.VISIBLE);
                                                                                ans9.setVisibility(View.GONE);
                                                                                final String[] aans9 = {"1"};
//
                                                                                first9.setText(test.getQ9().getOption1());
                                                                                second9.setText(test.getQ9().getOption2());
                                                                                third9.setText(test.getQ9().getOption3());
                                                                                fourth9.setText(test.getQ9().getOption4());
//
                                                                                if (test.getQ9().getType().equals("one")) {
                                                                                    first9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (first9.isChecked() == true) {
                                                                                                aans9[0] = "1";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    second9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (second9.isChecked() == true) {
                                                                                                aans9[0] = "2";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    third9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (third9.isChecked() == true) {
                                                                                                aans9[0] = "3";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    fourth9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (fourth9.isChecked() == true) {
                                                                                                aans9[0] = "4";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                } else {
                                                                                    oo9.setVisibility(View.GONE);
                                                                                    ans9.setVisibility(View.VISIBLE);
                                                                                }
//
                                                                                LinearLayout oo10 = findViewById(R.id.oneOption10);
                                                                                EditText ans10 = findViewById(R.id.ans10);
                                                                                RadioButton first10 = findViewById(R.id.first10);
                                                                                RadioButton second10 = findViewById(R.id.second10);
                                                                                RadioButton third10 = findViewById(R.id.third10);
                                                                                RadioButton fourth10 = findViewById(R.id.fourth10);
                                                                                TextView qtext10 = findViewById(R.id.qtext10);
                                                                                qtext10.setText(test.getQ10().getText());
                                                                                oo10.setVisibility(View.VISIBLE);
                                                                                ans10.setVisibility(View.GONE);
                                                                                final String[] aans10 = {"1"};
//
                                                                                first10.setText(test.getQ10().getOption1());
                                                                                second10.setText(test.getQ10().getOption2());
                                                                                third10.setText(test.getQ10().getOption3());
                                                                                fourth10.setText(test.getQ10().getOption4());
//
                                                                                if (test.getQ10().getType().equals("one")) {
                                                                                    first10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (first10.isChecked() == true) {
                                                                                                aans10[0] = "1";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    second10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (second10.isChecked() == true) {
                                                                                                aans10[0] = "2";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    third10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (third10.isChecked() == true) {
                                                                                                aans10[0] = "3";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                    fourth10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                                                        @Override
                                                                                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                            if (fourth10.isChecked() == true) {
                                                                                                aans10[0] = "4";
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                } else {
                                                                                    oo10.setVisibility(View.GONE);
                                                                                    ans10.setVisibility(View.VISIBLE);
                                                                                }

                                                                                int all = test.getQ1().getWeight();
                                                                                if(test.getQuestionCount() > 1) {
                                                                                    findViewById(R.id.question2).setVisibility(VISIBLE);
                                                                                    all += test.getQ2().getWeight();
                                                                                }
                                                                                if(test.getQuestionCount() > 2) {
                                                                                    findViewById(R.id.question3).setVisibility(VISIBLE);
                                                                                    all += test.getQ3().getWeight();
                                                                                }
                                                                                if(test.getQuestionCount() > 3) {
                                                                                    findViewById(R.id.question4).setVisibility(VISIBLE);
                                                                                    all += test.getQ4().getWeight();
                                                                                }
                                                                                if(test.getQuestionCount() > 4) {
                                                                                    findViewById(R.id.question5).setVisibility(VISIBLE);
                                                                                    all += test.getQ5().getWeight();
                                                                                }
                                                                                if(test.getQuestionCount() > 5) {
                                                                                    findViewById(R.id.question6).setVisibility(VISIBLE);
                                                                                    all += test.getQ6().getWeight();
                                                                                }
                                                                                if(test.getQuestionCount() > 6) {
                                                                                    findViewById(R.id.question7).setVisibility(VISIBLE);
                                                                                    all += test.getQ7().getWeight();
                                                                                }
                                                                                if(test.getQuestionCount() > 7) {
                                                                                    findViewById(R.id.question8).setVisibility(VISIBLE);
                                                                                    all += test.getQ8().getWeight();
                                                                                }
                                                                                if(test.getQuestionCount() > 8) {
                                                                                    findViewById(R.id.question9).setVisibility(VISIBLE);
                                                                                    all += test.getQ9().getWeight();
                                                                                }
                                                                                if(test.getQuestionCount() > 9) {
                                                                                    findViewById(R.id.question10).setVisibility(VISIBLE);
                                                                                    all += test.getQ10().getWeight();
                                                                                }

                                                                                Button ok = findViewById(R.id.ok);
                                                                                int finalAll = all;
                                                                                ok.setOnClickListener(new View.OnClickListener() {
                                                                                    @Override
                                                                                    public void onClick(View v) {
                                                                                        Intent intent = new Intent(TestFound.this, Results.class);
                                                                                        int res = 0;
                                                                                        if (test.getQ1().getType().equals("ans")) {
                                                                                            aans1[0] = ans1.getText().toString();
                                                                                        }
                                                                                        if (test.getQ2().getType().equals("ans")) {
                                                                                            aans2[0] = ans2.getText().toString();
                                                                                        }
                                                                                        if (test.getQ3().getType().equals("ans")) {
                                                                                            aans3[0] = ans3.getText().toString();
                                                                                        }
                                                                                        if (test.getQ4().getType().equals("ans")) {
                                                                                            aans4[0] = ans4.getText().toString();
                                                                                        }
                                                                                        if (test.getQ5().getType().equals("ans")) {
                                                                                            aans5[0] = ans5.getText().toString();
                                                                                        }
                                                                                        if (test.getQ6().getType().equals("ans")) {
                                                                                            aans6[0] = ans6.getText().toString();
                                                                                        }
                                                                                        if (test.getQ7().getType().equals("ans")) {
                                                                                            aans7[0] = ans7.getText().toString();
                                                                                        }
                                                                                        if (test.getQ8().getType().equals("ans")) {
                                                                                            aans8[0] = ans8.getText().toString();
                                                                                        }
                                                                                        if (test.getQ9().getType().equals("ans")) {
                                                                                            aans9[0] = ans9.getText().toString();
                                                                                        }
                                                                                        if (test.getQ10().getType().equals("ans")) {
                                                                                            aans10[0] = ans10.getText().toString();
                                                                                        }

                                                                                        if (aans1[0].equals(test.getQ1().getAns())) {
                                                                                            res += test.getQ1().getWeight();
                                                                                        }
                                                                                        if (aans2[0].equals(test.getQ2().getAns()) && test.getQuestionCount() > 1) {
                                                                                            res += test.getQ2().getWeight();
                                                                                        }
                                                                                        if (aans3[0].equals(test.getQ3().getAns()) && test.getQuestionCount() > 2) {
                                                                                            res += test.getQ3().getWeight();
                                                                                        }
                                                                                        if (aans4[0].equals(test.getQ4().getAns()) && test.getQuestionCount() > 3) {
                                                                                            res += test.getQ4().getWeight();
                                                                                        }
                                                                                        if (aans5[0].equals(test.getQ5().getAns()) && test.getQuestionCount() > 4) {
                                                                                            res += test.getQ5().getWeight();
                                                                                        }
                                                                                        if (aans6[0].equals(test.getQ6().getAns()) && test.getQuestionCount() > 5) {
                                                                                            res += test.getQ6().getWeight();
                                                                                        }
                                                                                        if (aans7[0].equals(test.getQ7().getAns()) && test.getQuestionCount() > 6) {
                                                                                            res += test.getQ7().getWeight();
                                                                                        }
                                                                                        if (aans8[0].equals(test.getQ8().getAns()) && test.getQuestionCount() > 7) {
                                                                                            res += test.getQ8().getWeight();
                                                                                        }
                                                                                        if (aans9[0].equals(test.getQ9().getAns()) && test.getQuestionCount() > 8) {
                                                                                            res += test.getQ9().getWeight();
                                                                                        }
                                                                                        if (aans10[0].equals(test.getQ10().getAns()) && test.getQuestionCount() > 9) {
                                                                                            res += test.getQ10().getWeight();
                                                                                        }
                                                                                        intent.putExtra("res", res);
                                                                                        intent.putExtra("cnt", finalAll);
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

