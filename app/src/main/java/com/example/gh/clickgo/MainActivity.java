package com.example.gh.clickgo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner1, spinner2;
    private Button btnSubmit;
    TextView sdate;
    private Calendar calendar;
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sdate=(TextView) findViewById(R.id.date);
        addItemsOnSpinner2();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);
    }
    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 999) {
            DatePickerDialog dialog=new DatePickerDialog(this,myDateListener, year, month, day);
            long now = System.currentTimeMillis() - 1000;
            dialog.getDatePicker().setMinDate(now);
            dialog.getDatePicker().setMaxDate(now+(1000*60*60*24*7));
            return dialog;
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {sdate.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }
    private void addItemsOnSpinner2() {
        spinner2=(Spinner)findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }
    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());

    }
    public void addListenerOnButton() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        btnSubmit = (Button) findViewById(R.id.btnSearch);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "OnClickListener : " +
                                "\nSpinner 1 : "+ String.valueOf(spinner1.getSelectedItem()) +
                                "\nSpinner 2 : "+ String.valueOf(spinner2.getSelectedItem())+
                        "\nTime"+String.valueOf(sdate.getText().toString()),
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,Search_Results.class));
                SharedPreferences sharedRef= getSharedPreferences("User_Plan", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedRef.edit();
                editor.putString("Departure",spinner1.getSelectedItem().toString());
                editor.putString("Destination",spinner2.getSelectedItem().toString());
                editor.putString("Date",sdate.getText().toString());
                editor.apply();

            }
        });


    }
}
