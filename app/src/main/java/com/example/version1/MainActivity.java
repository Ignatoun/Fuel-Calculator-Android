package com.example.version1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;

    EditText cityContribution;
    EditText highwayContribution;
    EditText cityDistance;
    EditText highwayDistance;

    Button count;

    TextView result;

    String oper = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  поиск элементов
        cityContribution = (EditText) findViewById(R.id.inputCityContr);
        highwayContribution = (EditText) findViewById(R.id.inputHighwayContr);
        cityDistance = (EditText) findViewById(R.id.inputCityDist);
        highwayDistance = (EditText) findViewById(R.id.inputHighwayDist);

        count = (Button) findViewById(R.id.countButton);

        result = (TextView) findViewById(R.id.result);

        // обработчик нажатия кнопки
        count.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        float cityContribution = 0;
        float highwayContribution = 0;
        float cityDistance = 0;
        float highwayDistance = 0;
        float result = 0;


    }
}

