package com.example.calculator;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //  private static final String THEME_KEY = "THEME_KEY";

    // private static final String THEME_TWO = "THEME_TWO";

    public static final String TAG = "myLog";

    private static final String OLDNUMBER = "oldNumber"; // ключ значение для onSaveInstanceState
    String oldNumber;
    String operator;            // арифметические действия при нажатии кнопок(пока незадействовал)
    String number;   // числа при нажатии кнопок

    TextView textView;

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
    boolean isNew = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //   SharedPreferences sharedPreferences = getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE);
        //  setTheme(R.style.Theme_Calculatorv2);


        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            oldNumber = (String) savedInstanceState.get("oldNumber");
            showResult();
        }


      /*  findViewById(R.id.item2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPreferences.edit();

                recreate();
            }
        });*/


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

                if (isNew) {
                    textView.setText("");
                }
                isNew = false;

                String number = textView.getText().toString();
                String oldNumber = textView.getText().toString();

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
                oldNumber = number;
                textView.setText(oldNumber); // на экран вывожу при вводе цифры
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
                //  setTheme(R.style.Theme_Calculatorv2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("oldNumber", oldNumber);
        Log.d(TAG, "onSaveInstanceState: СОХРАНЕНИЕ ДАННЫХ");
    }



   /* @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        oldNumber = (String) savedInstanceState.getSerializable("oldNumber");
        Log.d(TAG, "onRestoreInstanceState: ВОССТАНОВЛЕНИЕ ДАННЫХ");
        showResult();

    }*/

    private void showResult() {
        Log.d(TAG, "МЕТОД ВЫЗОВА ИНФОРМАЦИИ НА ЭКРАН");
        textView.setText(oldNumber);
    }

}
