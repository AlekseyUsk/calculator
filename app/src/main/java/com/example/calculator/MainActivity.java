package com.example.calculator;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable {


    Calculator calculator = new Calculator();
    String num;
    String num2;


    //region КЛЮЧ ЗНАЧЕНИЯ ДЛЯ sharedPreferences
    private static final String THEME_KEY = "THEME_KEY";
    private static final String THEME_LIGHT = "THEME_LIGHT";
    private static final String THEME_DARK = "THEME_DARK";
//endregion

    private static final String TAG = "myLog";

    private static final String DISPLAY = "DISPLAY";
    private static final String CALCULATOR = "CALCULATOR";

    //  boolean isNew = true;

    //region ИНИЦИАЛИЗИРОВАЛ КНОПКИ

    Button light;
    Button dark;
    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button sum;
    Button division;
    Button multiply;
    Button result;
    Button cha;
    Button min;
    Button del;
//endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);

        String theme = sharedPreferences.getString(THEME_KEY, THEME_LIGHT);
        switch (theme) {
            case THEME_DARK:
                setTheme(R.style.Theme_Calculatorv2);
                break;
            default:
                setTheme(R.style.Theme_Calculator);
                break;
        }

        setContentView(R.layout.activity_main);

        calculator = new Calculator();


        if (savedInstanceState != null) {
            calculator = (Calculator) savedInstanceState.getSerializable("CALCULATOR");
        }
        showResult();


//region findViewById
        TextView info = findViewById(R.id.info);

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
//endregion


// region ОБРАБОТЧИКИ НАЖАТИЙ ВЫБОРА ТЕМЫ + sharedPreferences
/*        findViewById(R.id.dark).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPreferences.edit()
                        .putString(THEME_KEY, THEME_DARK)
                        .apply();


                recreate();
            }
        });
        findViewById(R.id.light).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit()
                        .putString(THEME_KEY, THEME_LIGHT)
                        .apply();

                recreate();
            }
        });*/

//endregion

//region numberButtonClickListener
        View.OnClickListener numberButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = findViewById(R.id.textView);

                /*   if (isNew) {
                    textView.setText("");
                }
                isNew = false;*/

                switch (view.getId()) {
                    case R.id.zero:
                        calculator.sb.append("0");
                        Log.d(TAG, "НАЖАТА КНОПКА 0");
                        break;
                    case R.id.one:
                        calculator.sb.append("1");
                        Log.d(TAG, "НАЖАТА КНОПКА 1");
                        break;
                    case R.id.two:
                        calculator.sb.append("2");
                        Log.d(TAG, "НАЖАТА КНОПКА 2");
                        break;
                    case R.id.three:
                        calculator.sb.append("3");
                        Log.d(TAG, "НАЖАТА КНОПКА 3");
                        break;
                    case R.id.four:
                        calculator.sb.append("4");
                        Log.d(TAG, "НАЖАТА КНОПКА 4");
                        break;
                    case R.id.five:
                        calculator.sb.append("5");
                        Log.d(TAG, "НАЖАТА КНОПКА 5");
                        break;
                    case R.id.six:
                        calculator.sb.append("6");
                        Log.d(TAG, "НАЖАТА КНОПКА 6");
                        break;
                    case R.id.seven:
                        calculator.sb.append("7");
                        Log.d(TAG, "НАЖАТА КНОПКА 7");
                        break;
                    case R.id.eight:
                        calculator.sb.append("8");
                        Log.d(TAG, "НАЖАТА КНОПКА 8");
                        break;
                    case R.id.nine:
                        calculator.sb.append("9");
                        Log.d(TAG, "НАЖАТА КНОПКА 9");
                        break;
                    case R.id.sum:
                        calculator.setOperator("+");
                        Log.d(TAG, "НАЖАТА КНОПКА +");
                        break;
                    case R.id.division:
                        calculator.setOperator("/");
                        Log.d(TAG, "НАЖАТА КНОПКА ДЕЛЕНИЕ");
                        break;
                    case R.id.multiply:
                        calculator.setOperator("*");
                        Log.d(TAG, "НАЖАТА КНОПКА *");
                        break;
                    case R.id.result:
                        calculator.setOperator("=");
                        Log.d(TAG, "НАЖАТА КНОПКА =");
                        break;
                    case R.id.cha:
                        calculator.setOperator(",");
                        Log.d(TAG, "НАЖАТА КНОПКА ,");
                        break;
                    case R.id.min:
                        calculator.setOperator("-");
                        Log.d(TAG, "НАЖАТА КНОПКА -");
                        break;
                    case R.id.del:
                        if (calculator.sb != null) {
                            calculator.sb = new StringBuilder();
                        }
                        Log.d(TAG, "НАЖАТА КНОПКА ДЕЛЕНИЕ");
                        break;
                }
                textView.setText(calculator.getOldNumber());
                textView.setText(calculator.sb.toString());
            }

        };


//endregion

//region ДОБАВИЛ СЛУШАТЕЛЯ кнопкам
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
        sum.setOnClickListener(numberButtonClickListener);
        division.setOnClickListener(numberButtonClickListener);
        multiply.setOnClickListener(numberButtonClickListener);
        result.setOnClickListener(numberButtonClickListener);
        cha.setOnClickListener(numberButtonClickListener);
        min.setOnClickListener(numberButtonClickListener);
        del.setOnClickListener(numberButtonClickListener);
        minplus.setOnClickListener(numberButtonClickListener);

//endregion

    }

    //region ДОБАВИЛ МЕНЮ
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);//внутри метод getMenuInflater() который создает или раздувает наше меню из ресурсов
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(getApplicationContext(), "Выбрана тема 1", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "НАЖАТИЕ НА item1");
                break;
            case R.id.item2:
                Toast.makeText(getApplicationContext(), "Выбрана тема 2", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "НАЖАТИЕ НА item2");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //endregion

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(CALCULATOR, calculator);

    }

    public void showResult() {
        TextView textView = findViewById(R.id.textView);
        Log.d(TAG, "МЕТОД ВЫЗОВА ИНФОРМАЦИИ НА ЭКРАН");
        textView.setText(calculator.sb.toString());
    }
}
