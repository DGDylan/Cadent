package com.example.demo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    CalendarView calendarView;
    String selectedDate;
    Button overviewBtn;
    HashMap<String, ArrayList<String>> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set sample hashmap
        map = populateMap();

        //Point CalendarView to activity CalendarView
        calendarView = (CalendarView) findViewById(R.id.CalenderView);

        //Set current date by default
        Calendar c = Calendar.getInstance();
        int currMonth = c.get(c.MONTH) + 1;
        int currDay = c.get(c.DAY_OF_MONTH);
        int currYear = c.get(c.YEAR);
        setSelectedDate(currMonth + "/" + currDay + "/" + currYear);

        //Set date change listener
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = (month + 1) + "/" + dayOfMonth + "/" + year;
                setSelectedDate(date);
            }
        });


        //Set overview button function
        overviewBtn = (Button) findViewById(R.id.OverviewBtn);

        overviewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, overviewpg.class);
                i.putExtra("Date", getSelectedDate());
                i.putExtra("HashMap", getMap());
                startActivity(i);
            }
        });

    }

    //Method to set selected date
    public void setSelectedDate(String date) {
        this.selectedDate = date;
    }

    //Method to get selected date
    public String getSelectedDate() {
        return this.selectedDate;
    }

    public HashMap<String, ArrayList<String>> getMap() {
        return this.map;
    }

    //Add info to sample hashmap
    public HashMap<String, ArrayList<String>> populateMap() {
        HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
        ArrayList<String> events = new ArrayList<String>();

        //Add events to 12/13/2019
        events.add("Reading Day");
        events.add("Friday the 13th");
        hm.put("12/13/2019", events);

        ArrayList<String> events2 = new ArrayList<String>();
        events2.add("Christmas Day");
        hm.put("12/25/2019", events2);


        ArrayList<String> events3 = new ArrayList<String>();
        events3.add("Christmas Eve");
        hm.put("12/24/2019", events3);

        return hm;
    }

}
