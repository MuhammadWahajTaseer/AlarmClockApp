package com.wahaj.alarmclock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewAlarms extends AppCompatActivity {


    static ArrayList<Alarm> listOfAlarms = new ArrayList<>();
    static ListView listView;
    static ArrayAdapter<Alarm> arrayAdapter;


    /**
     *
     * @param savedInstanceState instance of activity
     *
     *        Initializes the list of alarms when activity is created
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_alarms);


        // Initializing alarms in list view
        listView = (ListView) findViewById(R.id.listView);


        arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                listOfAlarms );

        listView.setAdapter(arrayAdapter);
    }
}
