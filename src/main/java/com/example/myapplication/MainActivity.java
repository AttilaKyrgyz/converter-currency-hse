package com.example.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity {

    //Объявляем переменные EditText и RadioButtom:
    private EditText mEdit;
    private RadioButton mConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Привязываем объявленную переменную к созданному в activity_main.xml элементу EditText:
        mEdit=(EditText)findViewById(R.id.enter);

        //Объявленную выше RadioButton привязываем к кнопке преобразования рублей в доллары,
        // дальше это будет использоваться
        mConvert=(RadioButton)findViewById(R.id.Rubles);
    }
    //Вводим функцию преобразования рублей в доллары по курсу 74 рубля за доллар:
    private float convertRtoD (float rubs) {
        return (float) (rubs/74);
    }
    //Вводим функцию преобразования долларов в рубли по курсу 74 рубля за доллар:
    private float convertDtoR (float doll) {
        return (float) (doll*74);
    }
    //Обрабатываем щелчок по кнопке "Сконвертировать":
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.convert:
                float enterNumber=Float.parseFloat(mEdit.getText().toString());
                //В случае выбранного первого RadioButton, программа будет пересчитывать
                //введенное значение в рубли:
                if (mConvert.isChecked()) {
                    mEdit.setText(String.valueOf(convertDtoR(enterNumber)));
                }
                //В другом случае (а у нас их всего 2) будет работать обратная формула:
                else {
                    mEdit.setText(String.valueOf(convertRtoD(enterNumber)));
                }
                break;
        }
    }
}