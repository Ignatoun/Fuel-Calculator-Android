package com.example.version1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.decimal4j.util.DoubleRounder;


public class YourValuesActivity extends AppCompatActivity implements View.OnClickListener {

    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;

    EditText cityContribution;
    EditText highwayContribution;
    EditText cityDistance;
    EditText highwayDistance;

    Button count;

    TextView result;

    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_values);

        //  поиск элементов
        cityContribution = (EditText) findViewById(R.id.inputCityContr);
        highwayContribution = (EditText) findViewById(R.id.inputHighwayContr);
        cityDistance = (EditText) findViewById(R.id.inputCityDist);
        highwayDistance = (EditText) findViewById(R.id.inputHighwayDist);

        count = (Button) findViewById(R.id.countButton);

        result = (TextView) findViewById(R.id.result);

        scrollView = (ScrollView) findViewById(R.id.scrollView);

        // обработчик нажатия кнопки
        count.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        float cityContributionNum = 0;
        float highwayContributionNum = 0;
        float cityDistanceNum = 0;
        float highwayDistanceNum = 0;
        float resultNum = 0;

        // считвание данных
        cityContributionNum = Float.parseFloat(cityContribution.getText().toString());
        highwayContributionNum = Float.parseFloat(highwayContribution.getText().toString());
        cityDistanceNum = Float.parseFloat(cityDistance.getText().toString());
        highwayDistanceNum = Float.parseFloat(highwayDistance.getText().toString());

        try {
            resultNum = cityDistanceNum * (cityContributionNum / 100) + highwayDistanceNum *
                    (highwayContributionNum / 100);
            if(resultNum == 0 || resultNum < 1) {
                Toast toast = Toast.makeText(this, "Пожалуйста, введите данные", Toast.LENGTH_LONG);
                toast.show();
                throw new Exception("The number is equal to 0");
            } else {

                // плавный скролл к низу экрана, если размер экрана
                // мал для полного отображения приложения
                scrollView.smoothScrollBy(0,  scrollView.getBottom());

                // строка с выводом результата
                result.setText(DoubleRounder.round(resultNum, 2) + " литров");


            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_RESET_ID, 0, "Reset");
        menu.add(0, MENU_QUIT_ID, 0, "Quit");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case MENU_RESET_ID:
                cityContribution.setText("");
                highwayContribution.setText("");
                cityDistance.setText("");
                highwayDistance.setText("");
                break;
            case MENU_QUIT_ID:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

