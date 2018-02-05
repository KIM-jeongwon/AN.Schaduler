package com.bitcamp.app.schaduler;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.CalendarView;

import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CalendarView calendar = findViewById(R.id.calendar);
        final TimePicker timePicker =findViewById(R.id.time_picker);
        final TextView today =findViewById(R.id.today);
        final TextView year = findViewById(R.id.year);
        final TextView month = findViewById(R.id.month);
        final TextView hour = findViewById(R.id.hour);
        final TextView day = findViewById(R.id.day);
        final TextView minute = findViewById(R.id.minute);
        timePicker.setVisibility(View.INVISIBLE);
        today.setText(new SimpleDateFormat("현재시간 : yyyy년 MM월 hh시 mm분").format(new Date()));

        findViewById(R.id.time_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.VISIBLE);
            }
        });
        findViewById(R.id.date_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
            }
        });
        findViewById(R.id.reserv_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] arr = date.split("-");
                year.setText(arr[0]);
                month.setText(arr[1]);
                day.setText(arr[2]);
                hour.setText(String.valueOf(timePicker.getHour()));
                minute.setText(String.valueOf(timePicker.getMinute()));
            }
        });
    calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

        @Override
        public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month,int day) {
            date= year +"-"+(month+1)+"-"+day;
        }
    });
    }
}
