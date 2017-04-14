package com.wahaj.alarmclock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import java.util.Calendar;

import static com.wahaj.alarmclock.ViewAlarms.arrayAdapter;
import static com.wahaj.alarmclock.ViewAlarms.listOfAlarms;
import static com.wahaj.alarmclock.ViewAlarms.listView;


public class CreateAlarmActivity extends AppCompatActivity {
    private static CreateAlarmActivity inst;

    TextView hoursView;
    TextView minsView;
    TextView ampm;

    // Alarm manager stuff
    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private TimePicker alarmTimePicker;




    /**
     *
     * @return instance of this activity
     */
    public static CreateAlarmActivity instance() {
        return inst;
    }

    /**
     * Get's called every time the activity is launched/ restarted
     */
    @Override
    public void onStart() {
        super.onStart();
        inst = this;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_alarm);
        hoursView = (TextView) findViewById(R.id.textViewh);
        minsView = (TextView) findViewById(R.id.textViewm);
        ampm = (TextView) findViewById(R.id.textViewampm);

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
    }

    /**
     *
     * @param view The object that fired the event
     *
     * Increments hours text view once the up arrow is pressed for hours
     *
     */
    public void onHoursUp(View view) {
        // Getting hours set
        int hours = Integer.parseInt(hoursView.getText().toString());

        // Incrementing and padding if necessary
        hours = (hours + 1) % 13;
        if (hours == 0){
            hours++;
        }

        String text = Integer.toString(hours);
        if(text.length() == 1){
            text = "0" + text;
        }

        // Setting hours text view
        hoursView.setText(text);
    }

    /**
     *
     * @param view the object that fired the event
     *
     * decrements hours text view when the down arrow is pressed for hours
     */
    public void onHoursDown(View view) {
        // Getting hours set
        int hours = Integer.parseInt(hoursView.getText().toString());

        // Decrementing and padding if necessary
        hours = hours - 1;
        if (hours <= 0){
            hours = 12;
        }

        String text = Integer.toString(hours);
        if(text.length() == 1){
            text = "0" + text;
        }

        // Setting hours text view
        hoursView.setText(text);
    }

    /**
     *
     * @param view The object that fired the event
     *
     * Increments minutes text view once the up arrow is pressed for minutes
     *
     */
    public void onMinsUp(View view) {
        // Getting mins set
        int mins = Integer.parseInt(minsView.getText().toString());

        // Incrementing and padding if necessary
        mins = (mins + 1) % 60;
        String text = Integer.toString(mins);
        if(text.length() == 1){
            text = "0" + text;
        }

        // Setting mins text view
        minsView.setText(text);
    }


    /**
     *
     * @param view the object that fired the event
     *
     * decrements minutes text view when the down arrow is pressed for minutes
     */
    public void onMinsDown(View view) {
        // Getting mins set
        int mins = Integer.parseInt(minsView.getText().toString());

        // Decrementing and padding if necessary
        mins = mins - 1;
        if (mins < 0){
            mins = 59;
        }

        String text = Integer.toString(mins);
        if(text.length() == 1){
            text = "0" + text;
        }

        // Setting mins text view
        minsView.setText(text);
    }


    /**
     *
     * @param view the object that fired the event
     *
     * Toggles AM/PM view
     */
    public void ampmToggle(View view) {
        // Getting and toggling AM/PM
        String toggle = ampm.getText().toString();
        if(toggle.equals("AM")) toggle = "PM";
        else toggle = "AM";
        ampm.setText(toggle);
    }



    /**
     *
     * @param view the button that fired the event
     *
     * Creates an alarm in array list
     */
    public void CreateAlarm(View view) {

        int hours = Integer.parseInt(hoursView.getText().toString());
        int mins = Integer.parseInt(minsView.getText().toString());
        int s;
        if (ampm.getText().toString().equals("AM")) {
            s = 0;
        }
        else {
            s = 1;
        }


        boolean repeat  = false;
        String label = "my alarm";
        boolean days[] = {false, false,false,false,false,false,false};

        Alarm alarm = new Alarm(hours, mins, s, repeat, label, days);

        listOfAlarms.add(alarm);

        ArrayAdapter<Alarm> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                listOfAlarms );

        //listView.setAdapter(arrayAdapter);

        Toast.makeText(getApplicationContext(), "Alarm has been set", Toast.LENGTH_LONG).show();


        // Set up alarm
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hours);
        calendar.set(Calendar.MINUTE, mins);
        Intent myIntent = new Intent(CreateAlarmActivity.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(CreateAlarmActivity.this, 0, myIntent, 0);
        alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);













        finish();

    }
}




