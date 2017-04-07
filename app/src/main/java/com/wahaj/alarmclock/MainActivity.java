package com.wahaj.alarmclock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView timeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeText = (TextView)findViewById(R.id.texto);
    }


    String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
    timeText.setText(currentDateTimeString);
}
