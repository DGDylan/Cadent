package com.example.demo1;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class overviewpg extends AppCompatActivity {
    TextView dateOverview;
    TextView eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overviewpg);

        Intent i1 = getIntent();
        String date = i1.getStringExtra("Date");

        Intent i2 = getIntent();
        HashMap<String, ArrayList<String>> map = (HashMap<String, ArrayList<String>>) i2.getSerializableExtra("HashMap");

        //Set dateOverview text
        dateOverview = (TextView) findViewById(R.id.dateOverview);
        dateOverview.setText(date + " overview");

        //Get first event from arraylist
        eventList = (TextView) findViewById(R.id.eventList);

        //If date has no events(not in hashmap), then print that there are no dates, otherwise print the events
        if(!map.containsKey(date)) {
            eventList.setText("-No events for " + date);
        }

        else {
            for (int i = 0; i < map.get(date).size(); i++) {
                eventList.append(("-" + map.get(date).get(i) + "\n"));
            }
        }
    }

}
