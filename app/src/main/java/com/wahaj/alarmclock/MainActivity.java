package com.wahaj.alarmclock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import static com.wahaj.alarmclock.R.id.date;

public class MainActivity extends AppCompatActivity {

    java.util.Date noteTS;
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
    TextView tvTime, tvDate;
    ImageButton addAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTime = (TextView) findViewById(R.id.time);
        tvDate = (TextView) findViewById(date);
        addAlarm = (ImageButton) findViewById(R.id.imageButton);



        // I know this is scary
        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                updateTextView();
                            }
                        });
                    }
                } catch (InterruptedException e) {}
            }
        };

        t.start();

        //timeText = (TextView)findViewById(R.id.time);
        //String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        //timeText.setText(currentDateTimeString);
    }

    /**
     * Updates time and date in the two text views
     */
    public void updateTextView() {
        long date = System.currentTimeMillis();

        // For displaying time
        sdf.applyPattern("hh:mm:ss a");
        String dateString = sdf.format(date);
        tvTime.setText(dateString);

        // For displaying date
        sdf.applyPattern("MMM dd yyyy");
        dateString = sdf.format(date);
        tvDate.setText(dateString);




        //noteTS = Calendar.getInstance().getTime();


        //String time = "hh:mm"; // 12:00
       // tvTime.setText( new SimpleDateFormat("dd/MM/yy HH:mm").format(date));

        //String date = "dd mm yyyy"; // 01 January 2013
        //tvDate.setText(DateFormat.getDateInstance().format(date));
    }

    public void addAlarmClick(View view) {
        Toast.makeText(getApplicationContext(), "Button is clicked", Toast.LENGTH_LONG).show();
        startActivity(new Intent(MainActivity.this, CreateAlarmActivity.class));
    }
}
