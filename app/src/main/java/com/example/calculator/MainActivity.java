package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Serializable {

    public static final String TAG = "myLog";
    private static String OLDNUBER = "oldNumber";
    protected String operator;
    protected String oldNumber; // первые числа или число для вычисления
    protected String number;    // числа при нажатии кнопок

    protected TextView textView;

    protected Button zero;
    protected Button one;
    protected Button two;
    protected Button three;
    protected Button four;
    protected Button five;
    protected Button six;
    protected Button seven;
    protected Button eight;
    protected Button nine;
    protected Button sum;
    protected Button division;
    protected Button multiply;
    protected Button result;
    protected Button cha;
    protected Button min;
    protected Button del;
    boolean isNew = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        if (savedInstanceState != null) {
            oldNumber = (String) savedInstanceState.getSerializable(OLDNUBER);
        }


        TextView textView = findViewById(R.id.textView);

        Button zero = findViewById(R.id.zero);
        Button one = findViewById(R.id.one);
        Button two = findViewById(R.id.two);
        Button three = findViewById(R.id.three);
        Button four = findViewById(R.id.four);
        Button five = findViewById(R.id.five);
        Button six = findViewById(R.id.six);
        Button seven = findViewById(R.id.seven);
        Button eight = findViewById(R.id.eight);
        Button nine = findViewById(R.id.nine);

        Button sum = findViewById(R.id.sum);            //сложение
        Button division = findViewById(R.id.division);  //деление
        Button multiply = findViewById(R.id.multiply);  //умножение
        Button result = findViewById(R.id.result);      // результат
        Button cha = findViewById(R.id.cha);            //дробные " , "
        Button min = findViewById(R.id.min);            //вычитание
        Button del = findViewById(R.id.del);            //стереть
        Button minplus = findViewById(R.id.minusplus);  //минус плюс


        View.OnClickListener numberButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (isNew)
                    textView.setText(""); //убрал ноль вначале ввода
                isNew = false;

                number = textView.getText().toString();
                switch (view.getId()) {
                    case R.id.zero:
                        number = number + "0";
                        Log.d(TAG, "НАЖАТА КНОПКА 0");
                        break;
                    case R.id.one:
                        number = number + "1";
                        Log.d(TAG, "НАЖАТА КНОПКА 1");
                        break;
                    case R.id.two:
                        number = number + "2";
                        Log.d(TAG, "НАЖАТА КНОПКА 2");
                        break;
                    case R.id.three:
                        number = number + "3";
                        Log.d(TAG, "НАЖАТА КНОПКА 3");
                        break;
                    case R.id.four:
                        number = number + "4";
                        Log.d(TAG, "НАЖАТА КНОПКА 4");
                        break;
                    case R.id.five:
                        number = number + "5";
                        Log.d(TAG, "НАЖАТА КНОПКА 5");
                        break;
                    case R.id.six:
                        number = number + "6";
                        Log.d(TAG, "НАЖАТА КНОПКА 6");
                        break;
                    case R.id.seven:
                        number = number + "7";
                        Log.d(TAG, "НАЖАТА КНОПКА 7");
                        break;
                    case R.id.eight:
                        number = number + "8";
                        Log.d(TAG, "НАЖАТА КНОПКА 8");
                        break;
                    case R.id.nine:
                        number = number + "9";
                        Log.d(TAG, "НАЖАТА КНОПКА 9");
                        break;
                    case R.id.del:
                        number = null;
                        Log.d(TAG, "НАЖАТА КНОПКА стереть С");
                        break;
                    case R.id.minusplus:
                        number = "-" + number;
                        Log.d(TAG, "НАЖАТА КНОПКА +/-");
                        break;
                }
                oldNumber = number; // В oldNumber записываю нажатые цифры
                textView.setText(oldNumber);

            }
        };

        View.OnClickListener actionClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isNew = true;

                switch (view.getId()) {
                    case R.id.sum:
                        operator = "+";
                        Log.d(TAG, "НАЖАТА КНОПКА +");
                        break;
                    case R.id.division:
                        operator = "/";
                        Log.d(TAG, "НАЖАТА КНОПКА ДЕЛЕНИЕ");
                        break;
                    case R.id.multiply:
                        operator = "*";
                        Log.d(TAG, "НАЖАТА КНОПКА *");
                        break;
                    case R.id.result:
                        operator = "=";
                        Log.d(TAG, "НАЖАТА КНОПКА =");
                        break;
                    case R.id.cha:
                        operator = ".";
                        Log.d(TAG, "НАЖАТА КНОПКА ,");
                        break;
                    case R.id.min:
                        operator = "-";
                        Log.d(TAG, "НАЖАТА КНОПКА -");
                        break;
                    case R.id.del:
                        operator = null;
                        Log.d(TAG, "НАЖАТА КНОПКА стереть С");
                        break;
                }
                textView.setText(operator);
            }
        };
        zero.setOnClickListener(numberButtonClickListener);
        one.setOnClickListener(numberButtonClickListener);
        two.setOnClickListener(numberButtonClickListener);
        three.setOnClickListener(numberButtonClickListener);
        four.setOnClickListener(numberButtonClickListener);
        five.setOnClickListener(numberButtonClickListener);
        six.setOnClickListener(numberButtonClickListener);
        seven.setOnClickListener(numberButtonClickListener);
        eight.setOnClickListener(numberButtonClickListener);
        nine.setOnClickListener(numberButtonClickListener);
        sum.setOnClickListener(actionClickListener);
        division.setOnClickListener(actionClickListener);
        multiply.setOnClickListener(actionClickListener);
        result.setOnClickListener(actionClickListener);
        cha.setOnClickListener(actionClickListener);
        min.setOnClickListener(actionClickListener);
        del.setOnClickListener(actionClickListener);
        minplus.setOnClickListener(actionClickListener);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(OLDNUBER,oldNumber);
        Log.d(TAG, "onSaveInstanceState: СОХРАНЕНИЕ");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG,"onRestoreInstanceState");


    }
// тут думал метод сделать для вывода информации
    private void showResult() {
        //  textView.
    }

}
