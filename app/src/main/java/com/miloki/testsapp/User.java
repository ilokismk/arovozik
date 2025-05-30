package com.miloki.testsapp;

import java.util.ArrayList;
import java.util.Arrays;

public class User {
    private String uname;
    private ArrayList<String> tests;

    public User() {
        tests = new ArrayList<String>();
        tests.add("");
    }

    public String getUname() {
        return uname;
    }

    public ArrayList<String> getTests () {
        return tests;
    }

    public void setTests(ArrayList<String> tests) {
        this.tests = tests;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
