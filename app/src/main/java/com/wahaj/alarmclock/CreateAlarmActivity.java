package com.wahaj.alarmclock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CreateAlarmActivity extends AppCompatActivity {

    TextView hoursView;
    TextView minsView;
    TextView ampm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_alarm);
        hoursView = (TextView) findViewById(R.id.textViewh);
        minsView = (TextView) findViewById(R.id.textViewm);
        ampm = (TextView) findViewById(R.id.textViewampm);
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
        hours = (hours + 1) % 12;
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
        if (hours < 0){
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
            mins = 60;
        }

        String text = Integer.toString(mins);
        if(text.length() == 1){
            text = "0" + text;
        }

        // Setting mins text view
        minsView.setText(text);
    }

    public void ampmToggle(View view) {
        // Getting and toggling AM/PM
        String toggle = ampm.getText().toString();
        if(toggle.equals("AM")) toggle = "PM";
        else toggle = "AM";
        ampm.setText(toggle);
    }
}
