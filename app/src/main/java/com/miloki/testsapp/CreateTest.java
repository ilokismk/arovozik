
package com.miloki.testsapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.transition.Visibility;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.CollectionReference;

import java.util.Arrays;

public class CreateTest extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_test);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference tests = db.collection("tests");
        final int[] qcount = {1};

        LinearLayout oo1 = findViewById(R.id.oneOption1);
        EditText ans1 = findViewById(R.id.ans1);
        RadioButton one1 = findViewById(R.id.one1);
        RadioButton word1 = findViewById(R.id.word1);
        RadioButton first1 = findViewById(R.id.first1);
        RadioButton second1 = findViewById(R.id.second1);
        RadioButton third1 = findViewById(R.id.third1);
        RadioButton fourth1 = findViewById(R.id.fourth1);
        Button ok = findViewById(R.id.ok);
        Button back = findViewById(R.id.back);
        oo1.setVisibility(View.VISIBLE);
        ans1.setVisibility(View.GONE);
        final String[] type1 = {"one"};

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String name = user.getDisplayName();
        String email = user.getEmail();
        Uri photoUrl = user.getPhotoUrl();

        boolean emailVerified = user.isEmailVerified();
        String uid = user.getUid();

        one1.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            String t = "one";
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (one1.isChecked() == true) {
                    oo1.setVisibility(View.VISIBLE);
                    ans1.setVisibility(View.GONE);
                    type1[0] = "one";
                } else {
                    oo1.setVisibility(View.GONE);
                    ans1.setVisibility(View.VISIBLE);
                    type1[0] = "ans";
                }
            }
        });
        final String[] aans1 = {"1"};
        first1.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (first1.isChecked() == true) {
                    aans1[0] = "1";
                }
            }
        });
        second1.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (second1.isChecked() == true) {
                    aans1[0] = "2";
                }
            }
        });
        third1.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (third1.isChecked() == true) {
                    aans1[0] = "3";
                }
            }
        });
        fourth1.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (fourth1.isChecked() == true) {
                    aans1[0] = "4";
                }
            }
        });
        LinearLayout oo2 = findViewById(R.id.oneOption2);
        EditText ans2 = findViewById(R.id.ans2);
        RadioButton one2 = findViewById(R.id.one2);
        RadioButton word2 = findViewById(R.id.word2);
        RadioButton first2 = findViewById(R.id.first2);
        RadioButton second2 = findViewById(R.id.second2);
        RadioButton third2 = findViewById(R.id.third2);
        RadioButton fourth2 = findViewById(R.id.fourth2);
        oo2.setVisibility(View.VISIBLE);
        ans1.setVisibility(View.GONE);
        final String[] type2 = {"one"};

        one2.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (one2.isChecked() == true) {
                    oo2.setVisibility(View.VISIBLE);
                    ans2.setVisibility(View.GONE);
                    type2[0] = "one";
                } else {
                    oo2.setVisibility(View.GONE);
                    ans2.setVisibility(View.VISIBLE);
                    type2[0] = "ans";
                }
            }
        });
        final String[] aans2 = {"1"};
        first2.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (first2.isChecked() == true) {
                    aans2[0] = "2";
                }
            }
        });
        second2.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (second2.isChecked() == true) {
                    aans2[0] = "2";
                }
            }
        });
        third2.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (third2.isChecked() == true) {
                    aans2[0] = "3";
                }
            }
        });
        fourth2.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (fourth2.isChecked() == true) {
                    aans2[0] = "4";
                }
            }
        });
        LinearLayout question2 = findViewById(R.id.question2);

        LinearLayout oo3 = findViewById(R.id.oneOption3);
        EditText ans3 = findViewById(R.id.ans3);
        RadioButton one3 = findViewById(R.id.one3);
        RadioButton word3 = findViewById(R.id.word3);
        RadioButton first3 = findViewById(R.id.first3);
        RadioButton second3 = findViewById(R.id.second3);
        RadioButton third3 = findViewById(R.id.third3);
        RadioButton fourth3 = findViewById(R.id.fourth3);
        oo3.setVisibility(View.VISIBLE);
        ans3.setVisibility(View.GONE);
        final String[] type3 = {"one"};

        one3.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (one3.isChecked() == true) {
                    oo3.setVisibility(View.VISIBLE);
                    ans3.setVisibility(View.GONE);
                    type3[0] = "one";
                } else {
                    oo3.setVisibility(View.GONE);
                    ans3.setVisibility(View.VISIBLE);
                    type3[0] = "ans";
                }
            }
        });
        final String[] aans3 = {"1"};
        first3.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (first3.isChecked() == true) {
                    aans3[0] = "1";
                }
            }
        });
        second3.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (second3.isChecked() == true) {
                    aans3[0] = "2";
                }
            }
        });
        third3.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (third3.isChecked() == true) {
                    aans3[0] = "3";
                }
            }
        });
        fourth3.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (fourth3.isChecked() == true) {
                    aans3[0] = "4";
                }
            }
        });
        LinearLayout question3 = findViewById(R.id.question3);

        LinearLayout oo4 = findViewById(R.id.oneOption4);
        EditText ans4 = findViewById(R.id.ans4);
        RadioButton one4 = findViewById(R.id.one4);
        RadioButton word4 = findViewById(R.id.word4);
        RadioButton first4 = findViewById(R.id.first4);
        RadioButton second4 = findViewById(R.id.second4);
        RadioButton third4 = findViewById(R.id.third4);
        RadioButton fourth4 = findViewById(R.id.fourth4);
        oo4.setVisibility(View.VISIBLE);
        ans4.setVisibility(View.GONE);
        final String[] type4 = {"one"};

        one4.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (one4.isChecked() == true) {
                    oo4.setVisibility(View.VISIBLE);
                    ans4.setVisibility(View.GONE);
                    type4[0] = "one";
                } else {
                    oo4.setVisibility(View.GONE);
                    ans4.setVisibility(View.VISIBLE);
                    type4[0] = "ans";
                }
            }
        });
        final String[] aans4 = {"1"};
        first4.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (first4.isChecked() == true) {
                    aans4[0] = "1";
                }
            }
        });
        second4.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (second4.isChecked() == true) {
                    aans4[0] = "2";
                }
            }
        });
        third4.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (third4.isChecked() == true) {
                    aans4[0] = "3";
                }
            }
        });
        fourth4.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (fourth4.isChecked() == true) {
                    aans4[0] = "4";
                }
            }
        });
        LinearLayout question4 = findViewById(R.id.question4);

        LinearLayout oo5 = findViewById(R.id.oneOption5);
        EditText ans5 = findViewById(R.id.ans5);
        RadioButton one5 = findViewById(R.id.one5);
        RadioButton word5 = findViewById(R.id.word5);
        RadioButton first5 = findViewById(R.id.first5);
        RadioButton second5 = findViewById(R.id.second5);
        RadioButton third5 = findViewById(R.id.third5);
        RadioButton fourth5 = findViewById(R.id.fourth5);
        oo5.setVisibility(View.VISIBLE);
        ans5.setVisibility(View.GONE);
        final String[] type5 = {"one"};

        one5.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (one5.isChecked() == true) {
                    oo5.setVisibility(View.VISIBLE);
                    ans5.setVisibility(View.GONE);
                    type5[0] = "one";
                } else {
                    oo5.setVisibility(View.GONE);
                    ans5.setVisibility(View.VISIBLE);
                    type5[0] = "ans";
                }
            }
        });
        final String[] aans5 = {"1"};
        first5.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (first5.isChecked() == true) {
                    aans5[0] = "1";
                }
            }
        });
        second5.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (second5.isChecked() == true) {
                    aans5[0] = "2";
                }
            }
        });
        third5.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (third5.isChecked() == true) {
                    aans5[0] = "3";
                }
            }
        });
        fourth5.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (fourth5.isChecked() == true) {
                    aans5[0] = "4";
                }
            }
        });
        LinearLayout question5 = findViewById(R.id.question5);

        LinearLayout oo6 = findViewById(R.id.oneOption6);
        EditText ans6 = findViewById(R.id.ans6);
        RadioButton one6 = findViewById(R.id.one6);
        RadioButton word6 = findViewById(R.id.word6);
        RadioButton first6 = findViewById(R.id.first6);
        RadioButton second6 = findViewById(R.id.second6);
        RadioButton third6 = findViewById(R.id.third6);
        RadioButton fourth6 = findViewById(R.id.fourth6);
        oo6.setVisibility(View.VISIBLE);
        ans6.setVisibility(View.GONE);
        final String[] type6 = {"one"};

        one6.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (one6.isChecked() == true) {
                    oo6.setVisibility(View.VISIBLE);
                    ans6.setVisibility(View.GONE);
                    type6[0] = "one";
                } else {
                    oo6.setVisibility(View.GONE);
                    ans6.setVisibility(View.VISIBLE);
                    type6[0] = "ans";
                }
            }
        });
        final String[] aans6 = {"1"};
        first6.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (first6.isChecked() == true) {
                    aans6[0] = "1";
                }
            }
        });
        second6.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (second6.isChecked() == true) {
                    aans6[0] = "2";
                }
            }
        });
        third6.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (third6.isChecked() == true) {
                    aans6[0] = "3";
                }
            }
        });
        fourth6.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (fourth6.isChecked() == true) {
                    aans6[0] = "4";
                }
            }
        });
        LinearLayout question6 = findViewById(R.id.question6);

        LinearLayout oo7 = findViewById(R.id.oneOption7);
        EditText ans7 = findViewById(R.id.ans7);
        RadioButton one7 = findViewById(R.id.one7);
        RadioButton word7 = findViewById(R.id.word7);
        RadioButton first7 = findViewById(R.id.first7);
        RadioButton second7 = findViewById(R.id.second7);
        RadioButton third7 = findViewById(R.id.third7);
        RadioButton fourth7 = findViewById(R.id.fourth7);
        oo7.setVisibility(View.VISIBLE);
        ans7.setVisibility(View.GONE);
        final String[] type7 = {"one"};

        one7.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (one7.isChecked() == true) {
                    oo7.setVisibility(View.VISIBLE);
                    ans7.setVisibility(View.GONE);
                    type7[0] = "one";
                } else {
                    oo7.setVisibility(View.GONE);
                    ans7.setVisibility(View.VISIBLE);
                    type7[0] = "ans";
                }
            }
        });
        final String[] aans7 = {"1"};
        first7.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (first7.isChecked() == true) {
                    aans7[0] = "1";
                }
            }
        });
        second7.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (second7.isChecked() == true) {
                    aans7[0] = "2";
                }
            }
        });
        third7.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (third7.isChecked() == true) {
                    aans7[0] = "3";
                }
            }
        });
        fourth7.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (fourth7.isChecked() == true) {
                    aans7[0] = "4";
                }
            }
        });
        LinearLayout question7 = findViewById(R.id.question7);

        LinearLayout oo8 = findViewById(R.id.oneOption8);
        EditText ans8 = findViewById(R.id.ans8);
        RadioButton one8 = findViewById(R.id.one8);
        RadioButton word8 = findViewById(R.id.word8);
        RadioButton first8 = findViewById(R.id.first8);
        RadioButton second8 = findViewById(R.id.second8);
        RadioButton third8 = findViewById(R.id.third8);
        RadioButton fourth8 = findViewById(R.id.fourth8);
        oo8.setVisibility(View.VISIBLE);
        ans8.setVisibility(View.GONE);
        final String[] type8 = {"one"};

        one8.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (one8.isChecked() == true) {
                    oo8.setVisibility(View.VISIBLE);
                    ans8.setVisibility(View.GONE);
                    type8[0] = "one";
                } else {
                    oo8.setVisibility(View.GONE);
                    ans8.setVisibility(View.VISIBLE);
                    type8[0] = "ans";
                }
            }
        });
        final String[] aans8 = {"1"};
        first8.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (first8.isChecked() == true) {
                    aans8[0] = "1";
                }
            }
        });
        second8.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (second8.isChecked() == true) {
                    aans8[0] = "2";
                }
            }
        });
        third8.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (third8.isChecked() == true) {
                    aans8[0] = "3";
                }
            }
        });
        fourth8.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (fourth8.isChecked() == true) {
                    aans8[0] = "4";
                }
            }
        });
        LinearLayout question8 = findViewById(R.id.question8);

        LinearLayout oo9 = findViewById(R.id.oneOption9);
        EditText ans9 = findViewById(R.id.ans9);
        RadioButton one9 = findViewById(R.id.one9);
        RadioButton word9 = findViewById(R.id.word9);
        RadioButton first9 = findViewById(R.id.first9);
        RadioButton second9 = findViewById(R.id.second9);
        RadioButton third9 = findViewById(R.id.third9);
        RadioButton fourth9 = findViewById(R.id.fourth9);
        oo9.setVisibility(View.VISIBLE);
        ans9.setVisibility(View.GONE);
        final String[] type9 = {"one"};

        one9.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (one9.isChecked() == true) {
                    oo9.setVisibility(View.VISIBLE);
                    ans9.setVisibility(View.GONE);
                    type9[0] = "one";
                } else {
                    oo9.setVisibility(View.GONE);
                    ans9.setVisibility(View.VISIBLE);
                    type9[0] = "ans";
                }
            }
        });
        final String[] aans9 = {"1"};
        first9.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (first9.isChecked() == true) {
                    aans9[0] = "1";
                }
            }
        });
        second9.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (second9.isChecked() == true) {
                    aans9[0] = "2";
                }
            }
        });
        third9.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (third9.isChecked() == true) {
                    aans9[0] = "3";
                }
            }
        });
        fourth9.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (fourth9.isChecked() == true) {
                    aans9[0] = "4";
                }
            }
        });
        LinearLayout question9 = findViewById(R.id.question9);

        LinearLayout oo10 = findViewById(R.id.oneOption10);
        EditText ans10 = findViewById(R.id.ans10);
        RadioButton one10 = findViewById(R.id.one10);
        RadioButton word10 = findViewById(R.id.word10);
        RadioButton first10 = findViewById(R.id.first10);
        RadioButton second10 = findViewById(R.id.second10);
        RadioButton third10 = findViewById(R.id.third10);
        RadioButton fourth10 = findViewById(R.id.fourth10);
        oo10.setVisibility(View.VISIBLE);
        ans10.setVisibility(View.GONE);
        final String[] type10 = {"one"};

        one10.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (one10.isChecked() == true) {
                    oo10.setVisibility(View.VISIBLE);
                    ans10.setVisibility(View.GONE);
                    type10[0] = "one";
                } else {
                    oo10.setVisibility(View.GONE);
                    ans10.setVisibility(View.VISIBLE);
                    type10[0] = "ans";
                }
            }
        });
        final String[] aans10 = {"1"};
        first10.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (first10.isChecked() == true) {
                    aans10[0] = "1";
                }
            }
        });
        second10.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (second10.isChecked() == true) {
                    aans10[0] = "2";
                }
            }
        });
        third10.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (third10.isChecked() == true) {
                    aans10[0] = "3";
                }
            }
        });
        fourth10.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (fourth10.isChecked() == true) {
                    aans10[0] = "4";
                }
            }
        });
        LinearLayout question10 = findViewById(R.id.question10);

        SeekBar seekBar = findViewById(R.id.seekBar);
        TextView countText = findViewById(R.id.countText);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seek, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seek) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seek) {
                qcount[0] = seek.getProgress();
                countText.setText("Количество вопросов: " + Integer.toString(qcount[0]));
                if (qcount[0] < 2) {
                    question2.setVisibility(View.GONE);
                } else {
                    question2.setVisibility(View.VISIBLE);
                }
                if (qcount[0] < 3) {
                    question3.setVisibility(View.GONE);
                } else {
                    question3.setVisibility(View.VISIBLE);
                }
                if (qcount[0] < 4) {
                    question4.setVisibility(View.GONE);
                } else {
                    question4.setVisibility(View.VISIBLE);
                }
                if (qcount[0] < 5) {
                    question5.setVisibility(View.GONE);
                } else {
                    question5.setVisibility(View.VISIBLE);
                }
                if (qcount[0] < 6) {
                    question6.setVisibility(View.GONE);
                } else {
                    question6.setVisibility(View.VISIBLE);
                }
                if (qcount[0] < 7) {
                    question7.setVisibility(View.GONE);
                } else {
                    question7.setVisibility(View.VISIBLE);
                }
                if (qcount[0] < 8) {
                    question8.setVisibility(View.GONE);
                } else {
                    question8.setVisibility(View.VISIBLE);
                }
                if (qcount[0] < 9) {
                    question9.setVisibility(View.GONE);
                } else {
                    question9.setVisibility(View.VISIBLE);
                }
                if (qcount[0] < 10) {
                    question10.setVisibility(View.GONE);
                } else {
                    question10.setVisibility(View.VISIBLE);
                }
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText tname = findViewById(R.id.testName);
                EditText qtext1 = findViewById(R.id.qtext1);
                EditText qtext2 = findViewById(R.id.qtext2);
                EditText qtext3 = findViewById(R.id.qtext3);
                EditText qtext4 = findViewById(R.id.qtext4);
                EditText qtext5 = findViewById(R.id.qtext5);
                EditText qtext6 = findViewById(R.id.qtext6);
                EditText qtext7 = findViewById(R.id.qtext7);
                EditText qtext8 = findViewById(R.id.qtext8);
                EditText qtext9 = findViewById(R.id.qtext9);
                EditText qtext10 = findViewById(R.id.qtext10);

                if (type1[0].equals("ans")) {
                    aans1[0] = ans1.getText().toString();
                }
                if (type2[0].equals("ans")) {
                    aans2[0] = ans2.getText().toString();
                }
                if (type3[0].equals("ans")) {
                    aans3[0] = ans3.getText().toString();
                }
                if (type4[0].equals("ans")) {
                    aans4[0] = ans4.getText().toString();
                }
                if (type5[0].equals("ans")) {
                    aans5[0] = ans5.getText().toString();
                }
                if (type6[0].equals("ans")) {
                    aans6[0] = ans6.getText().toString();
                }
                if (type7[0].equals("ans")) {
                    aans7[0] = ans7.getText().toString();
                }
                if (type8[0].equals("ans")) {
                    aans8[0] = ans8.getText().toString();
                }
                if (type9[0].equals("ans")) {
                    aans9[0] = ans9.getText().toString();
                }
                if (type10[0].equals("ans")) {
                    aans10[0] = ans10.getText().toString();
                }



                String testName = tname.getText().toString();
                DocumentReference docRef = db.collection("tests").document(testName);

                //db.collection("tests").document(testName).set(tst);
                //Toast.makeText(this, "Тест успешно создан", Toast.LENGTH_SHORT).show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity2.class));
            }
        });


    }
}

