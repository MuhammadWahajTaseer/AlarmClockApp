package com.wahaj.alarmclock;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


import static com.wahaj.alarmclock.R.id.activity_chooser_view_content;
import static com.wahaj.alarmclock.R.id.date;
import static com.wahaj.alarmclock.ViewAlarms.arrayAdapter;
import static com.wahaj.alarmclock.ViewAlarms.listOfAlarms;
import static com.wahaj.alarmclock.ViewAlarms.listView;
import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity implements Serializable {


    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
    TextView tvTime, tvDate;
    Button addAlarm, viewButton;



    /**
     *
     * @param savedInstanceState Instance of activity
     * Method that gets invoked when activity starts
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTime = (TextView) findViewById(R.id.time);
        tvDate = (TextView) findViewById(date);
        addAlarm = (Button) findViewById(R.id.imageButton);
        viewButton = (Button) findViewById(R.id.viewButton);



        // I know this is scary lol
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


    }

    /**
     *
     * @param view the button that fired the event
     *
     *        Starts new activity which is a template to create an alarm
     */
    public void addAlarmClick(View view) {
        Intent intent = new Intent(this, CreateAlarmActivity.class);
        startActivity(intent);
    }

    /**
     *
     * @param view The button that fired the event
     *
     *        Starts new activity that shows a lsit of alarms
     */
    public void viewAlarmClick(View view) {
        Intent intent = new Intent(this, ViewAlarms.class);
        startActivity(intent);
    }
}


