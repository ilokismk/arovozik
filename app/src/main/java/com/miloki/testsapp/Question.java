package com.miloki.testsapp;

import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.List;

public class Question {
    private String text;
    private String type;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String ans;
    private int weight;

    public Question() {
        this.text = "";
        this.type = "one";
        this.ans = "1";
        this.weight = 1;
    }

    public Question(
            String text,
            String type,
            String option1,
            String option2,
            String option3,
            String option4,
            String ans) {
        this.text = text;
        this.type = type;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.ans = ans;
    }


    public void setText(String text) {
        this.text = text;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setOptions(String o1, String o2, String o3, String o4) {
        this.option1 = o1;
        this.option2 = o2;
        this.option3 = o3;
        this.option4 = o4;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public void setWeight (int weight) {
        this.weight = weight;
    }

    public String getText() {
        return this.text;
    }
    public String getType() {
        return this.type;
    }
    public String getOption1() {
        return this.option1;
    }
    public String getOption2() {
        return this.option2;
    }
    public String getOption3() {
        return this.option3;
    }
    public String getOption4() {
        return this.option4;
    }
    public String getAns() {
        return this.ans;
    }
    public int getWeight() {
        return this.weight;
    }

    public String stringOptions() {
        return option1 + "\n" + option2 + "\n" + option3 + "\n" + option4;
    }
}
