package com.miloki.testsapp;

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

    public Test() {
        this.name = "";
        this.author = "";
        this.questionCount = 1;
    }

    public Test(
            String name,
            String author,
            int questionCount,
            Question q1) {
        this.name = name;
        this.author = author;
        this.questionCount = questionCount;
        this.q1 = q1;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String name) {
        this.author = name;
    }

    public void setQ1(Question q1) {
        this.q1 = q1;
    }

    public void setQuestionCount(int q) {
        this.questionCount = q;
    }
}