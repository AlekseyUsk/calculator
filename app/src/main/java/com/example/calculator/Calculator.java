package com.example.calculator;

import android.os.Parcelable;

import java.io.Serializable;

public class Calculator implements Serializable {
    String oldNumber;
    String operator;
    String number;

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
}
