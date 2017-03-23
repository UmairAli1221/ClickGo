package com.example.gh.clickgo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class results_output extends AppCompatActivity {
    TextView depart,desti,date,serv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_output);
        depart=(TextView)findViewById(R.id.depart);
        desti=(TextView)findViewById(R.id.desti);
        date=(TextView)findViewById(R.id.time);
        serv=(TextView)findViewById(R.id.service);
        SharedPreferences sharedpreferences=getSharedPreferences("User_Plan", Context.MODE_PRIVATE);
        String departure=sharedpreferences.getString("Departure","");
        String destination=sharedpreferences.getString("Destination","");
        String time=sharedpreferences.getString("Date","");
        String service=sharedpreferences.getString("Service","");
        depart.setText(departure);
        desti.setText(destination);
        date.setText(time);
        serv.setText(service);
    }
}
