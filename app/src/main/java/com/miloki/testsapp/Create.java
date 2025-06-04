package com.miloki.testsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
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
        SeekBar sb = findViewById(R.id.seekBar);
        TextView qcount = findViewById(R.id.countText);

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

        Question q2 = new Question();
        findViewById(R.id.one2).setOnClickListener((view)->{
            q2.setType("one");
            findViewById(R.id.ans2).setVisibility(View.GONE);
            findViewById(R.id.oneOption2).setVisibility(View.VISIBLE);
        });
        findViewById(R.id.word2).setOnClickListener((view)->{
            q2.setType("ans");
            findViewById(R.id.oneOption2).setVisibility(View.GONE);
            findViewById(R.id.ans2).setVisibility(View.VISIBLE);
        });

        findViewById(R.id.first2).setOnClickListener((view)->{
            q2.setAns("1");
        });
        findViewById(R.id.second2).setOnClickListener((view)->{
            q2.setAns("2");
        });
        findViewById(R.id.third2).setOnClickListener((view)->{
            q2.setAns("3");
        });
        findViewById(R.id.fourth2).setOnClickListener((view)->{
            q2.setAns("4");
        });


        Question q3 = new Question();
        findViewById(R.id.one3).setOnClickListener((view)->{
            q3.setType("one");
            findViewById(R.id.ans3).setVisibility(View.GONE);
            findViewById(R.id.oneOption3).setVisibility(View.VISIBLE);
        });
        findViewById(R.id.word3).setOnClickListener((view)->{
            q3.setType("ans");
            findViewById(R.id.oneOption3).setVisibility(View.GONE);
            findViewById(R.id.ans3).setVisibility(View.VISIBLE);
        });

        findViewById(R.id.first3).setOnClickListener((view)->{
            q3.setAns("1");
        });
        findViewById(R.id.second3).setOnClickListener((view)->{
            q3.setAns("2");
        });
        findViewById(R.id.third3).setOnClickListener((view)->{
            q3.setAns("3");
        });
        findViewById(R.id.fourth3).setOnClickListener((view)->{
            q3.setAns("4");
        });

        Question q4 = new Question();
        findViewById(R.id.one4).setOnClickListener((view)->{
            q4.setType("one");
            findViewById(R.id.ans4).setVisibility(View.GONE);
            findViewById(R.id.oneOption4).setVisibility(View.VISIBLE);
        });
        findViewById(R.id.word4).setOnClickListener((view)->{
            q4.setType("ans");
            findViewById(R.id.oneOption4).setVisibility(View.GONE);
            findViewById(R.id.ans4).setVisibility(View.VISIBLE);
        });

        findViewById(R.id.first4).setOnClickListener((view)->{
            q4.setAns("1");
        });
        findViewById(R.id.second4).setOnClickListener((view)->{
            q4.setAns("2");
        });
        findViewById(R.id.third4).setOnClickListener((view)->{
            q4.setAns("3");
        });
        findViewById(R.id.fourth4).setOnClickListener((view)->{
            q4.setAns("4");
        });

        Question q5 = new Question();
        findViewById(R.id.one5).setOnClickListener((view)->{
            q5.setType("one");
            findViewById(R.id.ans5).setVisibility(View.GONE);
            findViewById(R.id.oneOption5).setVisibility(View.VISIBLE);
        });
        findViewById(R.id.word5).setOnClickListener((view)->{
            q5.setType("ans");
            findViewById(R.id.oneOption5).setVisibility(View.GONE);
            findViewById(R.id.ans5).setVisibility(View.VISIBLE);
        });

        findViewById(R.id.first5).setOnClickListener((view)->{
            q5.setAns("1");
        });
        findViewById(R.id.second5).setOnClickListener((view)->{
            q5.setAns("2");
        });
        findViewById(R.id.third5).setOnClickListener((view)->{
            q5.setAns("3");
        });
        findViewById(R.id.fourth5).setOnClickListener((view)->{
            q5.setAns("4");
        });

        Question q6 = new Question();
        findViewById(R.id.one6).setOnClickListener((view)->{
            q6.setType("one");
            findViewById(R.id.ans6).setVisibility(View.GONE);
            findViewById(R.id.oneOption6).setVisibility(View.VISIBLE);
        });
        findViewById(R.id.word6).setOnClickListener((view)->{
            q6.setType("ans");
            findViewById(R.id.oneOption6).setVisibility(View.GONE);
            findViewById(R.id.ans6).setVisibility(View.VISIBLE);
        });

        findViewById(R.id.first6).setOnClickListener((view)->{
            q6.setAns("1");
        });
        findViewById(R.id.second6).setOnClickListener((view)->{
            q6.setAns("2");
        });
        findViewById(R.id.third6).setOnClickListener((view)->{
            q6.setAns("3");
        });
        findViewById(R.id.fourth6).setOnClickListener((view)->{
            q6.setAns("4");
        });

        Question q7 = new Question();
        findViewById(R.id.one7).setOnClickListener((view)->{
            q7.setType("one");
            findViewById(R.id.ans7).setVisibility(View.GONE);
            findViewById(R.id.oneOption7).setVisibility(View.VISIBLE);
        });
        findViewById(R.id.word7).setOnClickListener((view)->{
            q7.setType("ans");
            findViewById(R.id.oneOption7).setVisibility(View.GONE);
            findViewById(R.id.ans7).setVisibility(View.VISIBLE);
        });

        findViewById(R.id.first7).setOnClickListener((view)->{
            q7.setAns("1");
        });
        findViewById(R.id.second7).setOnClickListener((view)->{
            q7.setAns("2");
        });
        findViewById(R.id.third7).setOnClickListener((view)->{
            q7.setAns("3");
        });
        findViewById(R.id.fourth7).setOnClickListener((view)->{
            q7.setAns("4");
        });

        Question q8 = new Question();
        findViewById(R.id.one8).setOnClickListener((view)->{
            q8.setType("one");
            findViewById(R.id.ans8).setVisibility(View.GONE);
            findViewById(R.id.oneOption8).setVisibility(View.VISIBLE);
        });
        findViewById(R.id.word8).setOnClickListener((view)->{
            q8.setType("ans");
            findViewById(R.id.oneOption8).setVisibility(View.GONE);
            findViewById(R.id.ans8).setVisibility(View.VISIBLE);
        });

        findViewById(R.id.first8).setOnClickListener((view)->{
            q8.setAns("1");
        });
        findViewById(R.id.second8).setOnClickListener((view)->{
            q8.setAns("2");
        });
        findViewById(R.id.third8).setOnClickListener((view)->{
            q8.setAns("3");
        });
        findViewById(R.id.fourth8).setOnClickListener((view)->{
            q8.setAns("4");
        });

        Question q9 = new Question();
        findViewById(R.id.one9).setOnClickListener((view)->{
            q9.setType("one");
            findViewById(R.id.ans9).setVisibility(View.GONE);
            findViewById(R.id.oneOption9).setVisibility(View.VISIBLE);
        });
        findViewById(R.id.word9).setOnClickListener((view)->{
            q9.setType("ans");
            findViewById(R.id.oneOption9).setVisibility(View.GONE);
            findViewById(R.id.ans9).setVisibility(View.VISIBLE);
        });

        findViewById(R.id.first9).setOnClickListener((view)->{
            q9.setAns("1");
        });
        findViewById(R.id.second9).setOnClickListener((view)->{
            q9.setAns("2");
        });
        findViewById(R.id.third9).setOnClickListener((view)->{
            q9.setAns("3");
        });
        findViewById(R.id.fourth9).setOnClickListener((view)->{
            q9.setAns("4");
        });

        Question q10 = new Question();
        findViewById(R.id.one10).setOnClickListener((view)->{
            q10.setType("one");
            findViewById(R.id.ans10).setVisibility(View.GONE);
            findViewById(R.id.oneOption10).setVisibility(View.VISIBLE);
        });
        findViewById(R.id.word10).setOnClickListener((view)->{
            q10.setType("ans");
            findViewById(R.id.oneOption10).setVisibility(View.GONE);
            findViewById(R.id.ans10).setVisibility(View.VISIBLE);
        });

        findViewById(R.id.first10).setOnClickListener((view)->{
            q10.setAns("1");
        });
        findViewById(R.id.second10).setOnClickListener((view)->{
            q10.setAns("2");
        });
        findViewById(R.id.third10).setOnClickListener((view)->{
            q10.setAns("3");
        });
        findViewById(R.id.fourth10).setOnClickListener((view)->{
            q10.setAns("4");
        });

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                qcount.setText("Количество вопросов: " + String.valueOf(progress));
                test.setQuestionCount(progress);

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (test.getQuestionCount() < 2) {
                    findViewById(R.id.question2).setVisibility(View.GONE);
                } else {
                    findViewById(R.id.question2).setVisibility(View.VISIBLE);
                }
                if (test.getQuestionCount() < 3) {
                    findViewById(R.id.question3).setVisibility(View.GONE);
                } else {
                    findViewById(R.id.question3).setVisibility(View.VISIBLE);
                }
                if (test.getQuestionCount() < 4) {
                    findViewById(R.id.question4).setVisibility(View.GONE);
                } else {
                    findViewById(R.id.question4).setVisibility(View.VISIBLE);
                }
                if (test.getQuestionCount() < 5) {
                    findViewById(R.id.question5).setVisibility(View.GONE);
                } else {
                    findViewById(R.id.question5).setVisibility(View.VISIBLE);
                }
                if (test.getQuestionCount() < 6) {
                    findViewById(R.id.question6).setVisibility(View.GONE);
                } else {
                    findViewById(R.id.question6).setVisibility(View.VISIBLE);
                }
                if (test.getQuestionCount() < 7) {
                    findViewById(R.id.question7).setVisibility(View.GONE);
                } else {
                    findViewById(R.id.question7).setVisibility(View.VISIBLE);
                }
                if (test.getQuestionCount() < 8) {
                    findViewById(R.id.question8).setVisibility(View.GONE);
                } else {
                    findViewById(R.id.question8).setVisibility(View.VISIBLE);
                }
                if (test.getQuestionCount() < 9) {
                    findViewById(R.id.question9).setVisibility(View.GONE);
                } else {
                    findViewById(R.id.question9).setVisibility(View.VISIBLE);
                }
                if (test.getQuestionCount() < 10) {
                    findViewById(R.id.question10).setVisibility(View.GONE);
                } else {
                    findViewById(R.id.question10).setVisibility(View.VISIBLE);
                }
            }
        });

        findViewById(R.id.ok).setOnClickListener((view)->{
            EditText name = findViewById(R.id.testName);
            DocumentReference docRef = db.collection("tests").document(name.getText().toString());
            docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if (documentSnapshot.exists()) {
                        Toast.makeText(Create.this, "Тест с таким названием уже существует!", Toast.LENGTH_SHORT).show();
                    }
                    else if (!name.getText().toString().isEmpty())
                    {
                        EditText tn = findViewById(R.id.testName);
                        test.setName(tn.getText().toString());
                        test.setAuthor(uname);

                        tn = findViewById(R.id.qtext1);
                        EditText w = findViewById(R.id.weight1);
                        q1.setText(tn.getText().toString());
                        if (!w.getText().toString().isEmpty()) {
                            q1.setWeight(Integer.parseInt(w.getText().toString()));
                        }
                        List<EditText> o1 = Arrays.asList(findViewById(R.id.option1_1), findViewById(R.id.option2_1), findViewById(R.id.option3_1), findViewById(R.id.option4_1));
                        q1.setOptions(o1.get(0).getText().toString(), o1.get(1).getText().toString(), o1.get(2).getText().toString(), o1.get(3).getText().toString());
                        if (q1.getType() == "ans") {
                            EditText ans = findViewById(R.id.ans1);
                            q1.setAns(ans.getText().toString());
                        }
                        test.setQ1(q1);

                        tn = findViewById(R.id.qtext2);
                        w = findViewById(R.id.weight2);
                        q2.setText(tn.getText().toString());
                        if (!w.getText().toString().isEmpty()) {
                            q2.setWeight(Integer.parseInt(w.getText().toString()));
                        }
                        List<EditText> o2 = Arrays.asList(findViewById(R.id.option1_2), findViewById(R.id.option2_2), findViewById(R.id.option3_2), findViewById(R.id.option4_2));
                        q2.setOptions(o2.get(0).getText().toString(), o2.get(1).getText().toString(), o2.get(2).getText().toString(), o2.get(3).getText().toString());
                        if (q2.getType() == "ans") {
                            EditText ans = findViewById(R.id.ans2);
                            q2.setAns(ans.getText().toString());
                        }
                        test.setQ2(q2);

                        tn = findViewById(R.id.qtext3);
                        w = findViewById(R.id.weight3);
                        q3.setText(tn.getText().toString());
                        if (!w.getText().toString().isEmpty()) {
                            q3.setWeight(Integer.parseInt(w.getText().toString()));
                        }
                        List<EditText> o3 = Arrays.asList(findViewById(R.id.option1_3), findViewById(R.id.option2_3), findViewById(R.id.option3_3), findViewById(R.id.option4_3));
                        q3.setOptions(o3.get(0).getText().toString(), o3.get(1).getText().toString(), o3.get(2).getText().toString(), o3.get(3).getText().toString());
                        if (q3.getType() == "ans") {
                            EditText ans = findViewById(R.id.ans3);
                            q3.setAns(ans.getText().toString());
                        }
                        test.setQ3(q3);

                        tn = findViewById(R.id.qtext4);
                        w = findViewById(R.id.weight4);
                        q4.setText(tn.getText().toString());
                        if (!w.getText().toString().isEmpty()) {
                            q4.setWeight(Integer.parseInt(w.getText().toString()));
                        }
                        List<EditText> o4 = Arrays.asList(findViewById(R.id.option1_4), findViewById(R.id.option2_4), findViewById(R.id.option3_4), findViewById(R.id.option4_4));
                        q4.setOptions(o4.get(0).getText().toString(), o4.get(1).getText().toString(), o4.get(2).getText().toString(), o4.get(3).getText().toString());
                        if (q4.getType() == "ans") {
                            EditText ans = findViewById(R.id.ans4);
                            q4.setAns(ans.getText().toString());
                        }
                        test.setQ4(q4);

                        tn = findViewById(R.id.qtext5);
                        w = findViewById(R.id.weight5);
                        q5.setText(tn.getText().toString());
                        if (!w.getText().toString().isEmpty()) {
                            q5.setWeight(Integer.parseInt(w.getText().toString()));
                        }
                        List<EditText> o5 = Arrays.asList(findViewById(R.id.option1_5), findViewById(R.id.option2_5), findViewById(R.id.option3_5), findViewById(R.id.option4_5));
                        q5.setOptions(o5.get(0).getText().toString(), o5.get(1).getText().toString(), o5.get(2).getText().toString(), o5.get(3).getText().toString());
                        if (q5.getType() == "ans") {
                            EditText ans = findViewById(R.id.ans5);
                            q5.setAns(ans.getText().toString());
                        }
                        test.setQ5(q5);

                        tn = findViewById(R.id.qtext6);
                        w = findViewById(R.id.weight6);
                        q6.setText(tn.getText().toString());
                        if (!w.getText().toString().isEmpty()) {
                            q6.setWeight(Integer.parseInt(w.getText().toString()));
                        }
                        List<EditText> o6 = Arrays.asList(findViewById(R.id.option1_6), findViewById(R.id.option2_6), findViewById(R.id.option3_6), findViewById(R.id.option4_6));
                        q6.setOptions(o6.get(0).getText().toString(), o6.get(1).getText().toString(), o6.get(2).getText().toString(), o6.get(3).getText().toString());
                        if (q6.getType() == "ans") {
                            EditText ans = findViewById(R.id.ans6);
                            q6.setAns(ans.getText().toString());
                        }
                        test.setQ6(q6);

                        tn = findViewById(R.id.qtext7);
                        w = findViewById(R.id.weight7);
                        q7.setText(tn.getText().toString());
                        if (!w.getText().toString().isEmpty()) {
                            q7.setWeight(Integer.parseInt(w.getText().toString()));
                        }
                        List<EditText> o7 = Arrays.asList(findViewById(R.id.option1_7), findViewById(R.id.option2_7), findViewById(R.id.option3_7), findViewById(R.id.option4_7));
                        q7.setOptions(o7.get(0).getText().toString(), o7.get(1).getText().toString(), o7.get(2).getText().toString(), o7.get(3).getText().toString());
                        if (q7.getType() == "ans") {
                            EditText ans = findViewById(R.id.ans7);
                            q7.setAns(ans.getText().toString());
                        }
                        test.setQ7(q7);

                        tn = findViewById(R.id.qtext8);
                        w = findViewById(R.id.weight8);
                        q8.setText(tn.getText().toString());
                        if (!w.getText().toString().isEmpty()) {
                            q8.setWeight(Integer.parseInt(w.getText().toString()));
                        }
                        List<EditText> o8 = Arrays.asList(findViewById(R.id.option1_8), findViewById(R.id.option2_8), findViewById(R.id.option3_8), findViewById(R.id.option4_8));
                        q8.setOptions(o8.get(0).getText().toString(), o8.get(1).getText().toString(), o8.get(2).getText().toString(), o8.get(3).getText().toString());
                        if (q8.getType() == "ans") {
                            EditText ans = findViewById(R.id.ans8);
                            q8.setAns(ans.getText().toString());
                        }
                        test.setQ8(q8);

                        tn = findViewById(R.id.qtext9);
                        w = findViewById(R.id.weight9);
                        q9.setText(tn.getText().toString());
                        if (!w.getText().toString().isEmpty()) {
                            q9.setWeight(Integer.parseInt(w.getText().toString()));
                        }
                        List<EditText> o9 = Arrays.asList(findViewById(R.id.option1_9), findViewById(R.id.option2_9), findViewById(R.id.option3_9), findViewById(R.id.option4_9));
                        q9.setOptions(o9.get(0).getText().toString(), o9.get(1).getText().toString(), o9.get(2).getText().toString(), o9.get(3).getText().toString());
                        if (q9.getType() == "ans") {
                            EditText ans = findViewById(R.id.ans9);
                            q9.setAns(ans.getText().toString());
                        }
                        test.setQ9(q9);


                        tn = findViewById(R.id.qtext10);
                        w = findViewById(R.id.weight10);
                        q10.setText(tn.getText().toString());
                        if (!w.getText().toString().isEmpty()) {
                            q10.setWeight(Integer.parseInt(w.getText().toString()));
                        }
                        List<EditText> o10 = Arrays.asList(findViewById(R.id.option1_10), findViewById(R.id.option2_10), findViewById(R.id.option3_10), findViewById(R.id.option4_10));
                        q10.setOptions(o10.get(0).getText().toString(), o10.get(1).getText().toString(), o10.get(2).getText().toString(), o10.get(3).getText().toString());
                        if (q10.getType() == "ans") {
                            EditText ans = findViewById(R.id.ans10);
                            q10.setAns(ans.getText().toString());
                        }
                        test.setQ10(q10);



                        db.collection("tests").document(test.getName()).set(test);
                        Toast.makeText(Create.this, "Тест успешно создан", Toast.LENGTH_SHORT).show();

                        db.collection("users").document(uname).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                User u = documentSnapshot.toObject(User.class);
                                ArrayList<String> t = u.getTests();
                                if (t.get(0) == "") {
                                    t.remove(0);
                                }
                                t.add(test.getName().toString());
                                DocumentReference usr = db.collection("users").document(uname);
                                usr.update("tests", t);
                            }
                        });
                        startActivity(new Intent(Create.this, MainActivity2.class));
                    }
                    else {
                        Toast.makeText(Create.this, "Название теста не должно быть пустым", Toast.LENGTH_SHORT).show();
                    }
                }
            });



        });

        findViewById(R.id.back).setOnClickListener((view) -> {
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