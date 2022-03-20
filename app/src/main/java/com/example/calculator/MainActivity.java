package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected boolean isNew = true;
    String oldNumber;


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

    public static final String TAG = "myLog";

    private CalculatorModel calculatorModel;//потом на старте в OnCreate ее присвоил

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatorModel = new CalculatorModel();

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


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNew) textView.setText(""); //убрал ноль вначале ввода
                isNew = false;
                String number = textView.getText().toString();


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
                    case R.id.sum:
                        textView.setText("+");
                        Log.d(TAG, "НАЖАТА КНОПКА +");
                        break;
                    case R.id.division:
                        textView.setText("0");
                        Log.d(TAG, "НАЖАТА КНОПКА ДЕЛЕНИЕ");
                        break;
                    case R.id.multiply:
                        textView.setText("0");
                        Log.d(TAG, "НАЖАТА КНОПКА *");
                        break;
                    case R.id.result:
                        textView.setText("0");
                        Log.d(TAG, "НАЖАТА КНОПКА =");
                        break;
                    case R.id.cha:
                        textView.setText("0");
                        Log.d(TAG, "НАЖАТА КНОПКА ,");
                        break;
                    case R.id.min:
                        textView.setText("0");
                        Log.d(TAG, "НАЖАТА КНОПКА -");
                        break;
                    case R.id.del:
                        number = null;
                        Log.d(TAG, "НАЖАТА КНОПКА стереть С");
                        break;
                }
                textView.setText(number);
            }
        };
        zero.setOnClickListener(onClickListener);
        one.setOnClickListener(onClickListener);
        two.setOnClickListener(onClickListener);
        three.setOnClickListener(onClickListener);
        four.setOnClickListener(onClickListener);
        five.setOnClickListener(onClickListener);
        six.setOnClickListener(onClickListener);
        seven.setOnClickListener(onClickListener);
        eight.setOnClickListener(onClickListener);
        nine.setOnClickListener(onClickListener);
        sum.setOnClickListener(onClickListener);
        division.setOnClickListener(onClickListener);
        multiply.setOnClickListener(onClickListener);
        result.setOnClickListener(onClickListener);
        cha.setOnClickListener(onClickListener);
        min.setOnClickListener(onClickListener);
        del.setOnClickListener(onClickListener);


    }


}