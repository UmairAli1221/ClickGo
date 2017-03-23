package com.example.gh.clickgo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gh.clickgo.ListAdapter.customButtonListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Search_Results extends ActionBarActivity implements customButtonListener {
    private ListView listView;
    com.example.gh.clickgo.ListAdapter adapter;
    ArrayList<String> dataItems = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__results);
        String[] dataArray = getResources().getStringArray(R.array.listBusCompanise);
        List<String> dataTemp = Arrays.asList(dataArray);
        dataItems.addAll(dataTemp);
        listView = (ListView) findViewById(R.id.listView);
        adapter = new com.example.gh.clickgo.ListAdapter(Search_Results.this,dataItems);
        adapter.setCustomButtonListner(Search_Results.this);
        listView.setAdapter(adapter);
    }
    @Override
    public void onButtonClickListner(int position, String value) {
        Toast.makeText(Search_Results.this, "Button click " + value,
                Toast.LENGTH_SHORT).show();
        SharedPreferences sharedRef= getSharedPreferences("User_Plan", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedRef.edit();
        editor.putString("Service",value);
        editor.apply();
        startActivity(new Intent(Search_Results.this,results_output.class));

    }
}
