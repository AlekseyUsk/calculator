package com.example.calculator;

import android.util.Log;


import java.io.Serializable;

public class Calculator implements Serializable {
    private static final String TAG = "myLog";

    StringBuilder sb = new StringBuilder();

    String oldNumber;
    String operator;
    String number;




    public void setNumber(String number) {
        this.number = number;
    }


    public void setOldNumber(String oldNumber) {
        this.oldNumber = oldNumber;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOldNumber() {
        return oldNumber;
    }

    public String getOperator() {
        return operator;
    }

    public String getNumber() {
        return number;
    }


}

