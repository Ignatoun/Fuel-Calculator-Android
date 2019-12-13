package com.example.version1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;

    Button yourValuesButton;
    Button databaseValuesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        yourValuesButton = (Button) findViewById(R.id.yourValuesButton);
        databaseValuesButton = (Button) findViewById(R.id.databaseValuesButton);

        yourValuesButton.setOnClickListener(this);
        databaseValuesButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.yourValuesButton:
                intent = new Intent("android.intent.action.yourValuesActivity");
                startActivity(intent);
                break;
            case R.id.databaseValuesButton:
                intent = new Intent("android.intent.action.databaseValuesActivity");
                startActivity(intent);
                break;
        }
    }
}
