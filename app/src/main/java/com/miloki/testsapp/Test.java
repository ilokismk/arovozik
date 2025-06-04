package com.miloki.testsapp;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private String name;
    private String author;
    private int questionCount;
    //private List <String> q1;
    // [0] questionText;
    // [1] type;
    // [2] option1;
    // [3] option2;
    // [4] option3;
    // [5] option4;
    // [6] ans;
    private Question q1;
    private Question q2;
    private Question q3;
    private Question q4;
    private Question q5;
    private Question q6;
    private Question q7;
    private Question q8;
    private Question q9;
    private Question q10;

    private ArrayList<String> solves;

    public Test() {
        this.name = "";
        this.author = "";
        this.questionCount = 1;
        solves = new ArrayList<String>();
        solves.add("");
    }


    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }
    public int getQuestionCount () {
        return questionCount;
    }
    public Question getQ1() {
        return q1;
    }

    public Question getQ2() {
        return q2;
    }

    public Question getQ3() {
        return q3;
    }

    public Question getQ4() {
        return q4;
    }

    public Question getQ5() {
        return q5;
    }

    public Question getQ6() {
        return q6;
    }

    public Question getQ7() {
        return q7;
    }

    public Question getQ8() {
        return q8;
    }

    public Question getQ9() {
        return q9;
    }

    public Question getQ10() {
        return q10;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String name) {
        this.author = name;
    }

    public void setQ1(Question q1) {
        this.q1 = q1;
    }

    public void setQ2(Question q2) {
        this.q2 = q2;
    }

    public void setQ3(Question q3) {
        this.q3 = q3;
    }

    public void setQ4(Question q4) {
        this.q4 = q4;
    }

    public void setQ5(Question q5) {
        this.q5 = q5;
    }

    public void setQ6(Question q6) {
        this.q6 = q6;
    }

    public void setQ7(Question q7) {
        this.q7 = q7;
    }

    public void setQ8(Question q8) {
        this.q8 = q8;
    }

    public void setQ9(Question q9) {
        this.q9 = q9;
    }

    public void setQ10(Question q10) {
        this.q10 = q10;
    }

    public void setQuestionCount(int q) {
        this.questionCount = q;
    }
    public ArrayList<String> getSolves () {
        return solves;
    }

    public void setSolves(ArrayList<String> tests) {
        this.solves = tests;
    }
}