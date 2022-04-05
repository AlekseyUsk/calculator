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

public class MainActivity extends AppCompatActivity {


    Calculator calculator = new Calculator();
    private TextView info;
    private TextView textView;


    //region КЛЮЧ ЗНАЧЕНИЯ ДЛЯ sharedPreferences
    private static final String THEME_KEY = "THEME_KEY";
    private static final String THEME_LIGHT = "THEME_LIGHT";
    private static final String THEME_DARK = "THEME_DARK";
//endregion

    private static final String TAG = "myLog";

    private static final String DISPLAY = "DISPLAY";
    private static final String CALCULATOR = "CALCULATOR";
    //  private static boolean isNew = "ARG_IS_NEW";

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
        TextView info = findViewById(R.id.info);
        TextView textView = findViewById(R.id.textView);

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


      /*  if (savedInstanceState != null) {
            oldNumber = savedInstanceState.getString("ARG_OLD_NUMBER");
            number = savedInstanceState.getString("ARG_NUMBER");
            // operator = savedInstanceState.getString("ARG_OPERATOR");
            // isNew = savedInstanceState.getBoolean("ARG_ISNEW");
        }
        showResult();*/

//region findViewById
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
        findViewById(R.id.dark).setOnClickListener(new View.OnClickListener() {
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
        });

//endregion

//region numberButtonClickListener
        View.OnClickListener numberButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             /*   if (isNew) {
                    textView.setText("");
                }
                isNew = false;*/

                switch (view.getId()) {
                    case R.id.zero:
                        calculator.setOldNumber("0");
                        showResult();
                        Log.d(TAG, "НАЖАТА КНОПКА 0");
                        break;
                    case R.id.one:
                        calculator.setOldNumber("1");
                        Log.d(TAG, "НАЖАТА КНОПКА 1");
                        break;
                    case R.id.two:
                        calculator.setOldNumber("2");
                        Log.d(TAG, "НАЖАТА КНОПКА 2");
                        break;
                    case R.id.three:
                        calculator.setOldNumber("3");
                        Log.d(TAG, "НАЖАТА КНОПКА 3");
                        break;
                    case R.id.four:
                        calculator.setOldNumber("4");
                        Log.d(TAG, "НАЖАТА КНОПКА 4");
                        break;
                    case R.id.five:
                        calculator.setOldNumber("5");
                        Log.d(TAG, "НАЖАТА КНОПКА 5");
                        break;
                    case R.id.six:
                        calculator.setOldNumber("6");
                        Log.d(TAG, "НАЖАТА КНОПКА 6");
                        break;
                    case R.id.seven:
                        calculator.setOldNumber("7");
                        Log.d(TAG, "НАЖАТА КНОПКА 7");
                        break;
                    case R.id.eight:
                        calculator.setOldNumber("8");
                        Log.d(TAG, "НАЖАТА КНОПКА 8");
                        break;
                    case R.id.nine:
                        calculator.setOldNumber("9");
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
                }
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


/*
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        oldNumber = (String) savedInstanceState.getString("ARG_OLD_NUMBER");
        number = (String) savedInstanceState.getString("ARG_NUMBER");
        operator = (String) savedInstanceState.getString("ARG_OPERATOR");
      //  isNew = (boolean) savedInstanceState.getBoolean("ARG_IS_NEW");
        Log.d(TAG, "onRestoreInstanceState: ВОССТАНОВЛЕНИЕ ДАННЫХ");
        showResult();
 }*/

    public void showResult() {
        Log.d(TAG, "МЕТОД ВЫЗОВА ИНФОРМАЦИИ НА ЭКРАН");
        textView.setText(calculator.getOldNumber());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DISPLAY, (String) info.getText());
        outState.putSerializable(CALCULATOR, calculator);

    }
}
/**
 * Process: com.example.calculator, PID: 2579
 * java.lang.RuntimeException: Unable to start activity ComponentInfo{com.example.calculator/com.example.calculator.MainActivity}: java.lang.NullPointerException: Attempt to invoke virtual method 'void android.widget.TextView.setText(java.lang.CharSequence)' on a null object reference
 * <p>
 * Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'void android.widget.TextView.setText(java.lang.CharSequence)' on a null object reference
 * at com.example.calculator.MainActivity.showResult(MainActivity.java:333)
 * at com.example.calculator.MainActivity.onCreate(MainActivity.java:80)
 */