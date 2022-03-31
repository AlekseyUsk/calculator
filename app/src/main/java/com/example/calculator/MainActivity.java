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

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Serializable {

    public static final String TAG = "myLog";
    protected static String oldNumber = "oldNumber"; // ключ значение для onSaveInstanceState
    protected String operator;            // арифметические действия при нажатии кнопок(пока незадействовал)
    protected String number = "number";   // числа при нажатии кнопок

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
    boolean isNew = true;// переменная чтобы убрать ввод 0 при начальном вводе


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState != null)
            //  number = (String) savedInstanceState.getSerializable(number);как то попробовать записать в Bundle другие переменные?
            oldNumber = (String) savedInstanceState.getSerializable(oldNumber);


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
                textView.setText(oldNumber); // на экран вывожу при вводе цифры
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


    /**
     * -------СОХРАНЕНИЕ СОСТОЯНИЯ------
     */
 /*   @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(oldNumber, oldNumber);
        outState.putSerializable(number, number);
        Log.d(TAG, "onSaveInstanceState: СОХРАНЕНИЕ ДАННЫХ");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        oldNumber = (String) savedInstanceState.getSerializable(oldNumber);
        Log.d(TAG, "onRestoreInstanceState: ВОССТАНОВЛЕНИЕ ДАННЫХ");
        setTextCalc(oldNumber);

    }

    public void setTextCalc(String oldNumber) {
        Log.d(TAG, "МЕТОД ВЫЗОВА ИНФОРМАЦИИ НА ЭКРАН");
        textView.setText(this.oldNumber);
    }*/
}
/**
 * ---------------При повороте экрана тупо вылетает приложение(вот в логах что отображает)немогу понять что вызвало мою FATAL EXCEPTION: main
 * ----------------и по сохранению состояния я все правильно сделал?
 * 2022-03-28 14:14:03.439 21000-21000/com.example.calculator D/myLog: onSaveInstanceState: СОХРАНЕНИЕ ДАННЫХ
 * 2022-03-28 14:14:03.441 21000-21000/com.example.calculator D/ActivityThread: Remove activity client record, r= ActivityRecord{9d71e8b token=android.os.BinderProxy@8b8c1fb {com.example.calculator/com.example.calculator.MainActivity}} token= android.os.BinderProxy@8b8c1fb
 * 2022-03-28 14:14:03.477 21000-21050/com.example.calculator W/libEGL: EGLNativeWindowType 0x6f4ae456d0 disconnect failed
 * 2022-03-28 14:14:03.525 21000-21000/com.example.calculator V/ActivityThread: callActivityOnCreate
 * 2022-03-28 14:14:03.543 21000-21000/com.example.calculator I/DecorView[]:  old windowMode:0 new windoMode:1
 * 2022-03-28 14:14:03.754 21000-21000/com.example.calculator D/ActivityThread: add activity client record, r= ActivityRecord{9d71e8b token=android.os.BinderProxy@8b8c1fb {com.example.calculator/com.example.calculator.MainActivity}} token= android.os.BinderProxy@8b8c1fb
 * 2022-03-28 14:14:03.760 21000-21000/com.example.calculator D/myLog: onRestoreInstanceState: ВОССТАНОВЛЕНИЕ ДАННЫХ
 * 2022-03-28 14:14:03.760 21000-21000/com.example.calculator D/myLog: МЕТОД ВЫЗОВА ИНФОРМАЦИИ НА ЭКРАН
 * 2022-03-28 14:14:03.761 21000-21000/com.example.calculator D/AndroidRuntime: Shutting down VM
 * 2022-03-28 14:14:03.761 21000-21000/com.example.calculator I/QarthLog: [PatchStore] createDisableExceptionQarthFile
 * 2022-03-28 14:14:03.761 21000-21000/com.example.calculator I/QarthLog: [PatchStore] create disable file for com.example.calculator uid is 10118
 * 2022-03-28 14:14:03.763 21000-21000/com.example.calculator E/AndroidRuntime: FATAL EXCEPTION: main
 * Process: com.example.calculator, PID: 21000
 * java.lang.NullPointerException: Attempt to invoke virtual method 'void android.widget.TextView.setText(java.lang.CharSequence)' on a null object reference
 * at com.example.calculator.MainActivity.setTextCalc(MainActivity.java:222)
 * at com.example.calculator.MainActivity.onRestoreInstanceState(MainActivity.java:216)
 * at android.app.Activity.performRestoreInstanceState(Activity.java:1580)
 * at android.app.Instrumentation.callActivityOnRestoreInstanceState(Instrumentation.java:1367)
 * at android.app.ActivityThread.handleStartActivity(ActivityThread.java:3937)
 * at android.app.servertransaction.TransactionExecutor.performLifecycleSequence(TransactionExecutor.java:235)
 * at android.app.servertransaction.TransactionExecutor.cycleToPath(TransactionExecutor.java:215)
 * at android.app.servertransaction.TransactionExecutor.executeLifecycleState(TransactionExecutor.java:187)
 * at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:105)
 * at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2473)
 * at android.os.Handler.dispatchMessage(Handler.java:110)
 * at android.os.Looper.loop(Looper.java:219)
 * at android.app.ActivityThread.main(ActivityThread.java:8349)
 * at java.lang.reflect.Method.invoke(Native Method)
 * at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:513)
 * at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1055)
 * 2022-03-28 14:14:03.785 21000-21000/com.example.calculator I/Process: Sending signal. PID: 21000 SIG:
 */