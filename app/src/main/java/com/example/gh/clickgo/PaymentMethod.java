package com.example.gh.clickgo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PaymentMethod extends AppCompatActivity {

    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);
        textView=(TextView)findViewById(R.id.book);
        SharedPreferences sharedpreferences = getSharedPreferences("User_Plan", Context.MODE_PRIVATE);
        String departure = sharedpreferences.getString("Departure", "");
        String destination = sharedpreferences.getString("Destination", "");
        String time = sharedpreferences.getString("Date", "");
        String book=sharedpreferences.getString("Time","");
        textView.setText(book);
        button=(Button)findViewById(R.id.btnBook);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PaymentMethod.this,umair.class));
            }
        });



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
