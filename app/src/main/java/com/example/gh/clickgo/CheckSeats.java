package com.example.gh.clickgo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gh.clickgo.ListAdapter.customButtonListener;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckSeats extends AppCompatActivity implements  customButtonListener{

    private TextView depart;
    private DatabaseReference mDatabaseUsers;
    private ListView listView;
    com.example.gh.clickgo.ListAdapter adapter;
    ArrayList<String> dataItems = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_seats);
       listView= (ListView) findViewById(R.id.myList);
        depart = (TextView) findViewById(R.id.departure);
        SharedPreferences sharedpreferences = getSharedPreferences("User_Plan", Context.MODE_PRIVATE);
        String departure = sharedpreferences.getString("Departure", "");
        String destination = sharedpreferences.getString("Destination", "");
        String time = sharedpreferences.getString("Date", "");
        depart.setText(destination);
        String[] dataArray = getResources().getStringArray(R.array.listBusCompanise);
        List<String> dataTemp = Arrays.asList(dataArray);
        dataItems.addAll(dataTemp);
        adapter = new com.example.gh.clickgo.ListAdapter(CheckSeats.this,dataItems);
        adapter.setCustomButtonListner(CheckSeats.this);
        listView.setAdapter(adapter);
    }
    @Override
    public void onButtonClickListner(int position, String value) {
        Toast.makeText(CheckSeats.this, "Button click " + value,
                Toast.LENGTH_SHORT).show();
        SharedPreferences sharedRef= getSharedPreferences("User_Plan", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedRef.edit();
        editor.putString("Time",value);
        editor.apply();
        startActivity(new Intent(CheckSeats.this,PaymentMethod.class));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this,Settings.class));
        }
        if (id == R.id.action_partner) {
            startActivity(new Intent(this,OurPartner.class));
        }

        return super.onOptionsItemSelected(item);
    }
}