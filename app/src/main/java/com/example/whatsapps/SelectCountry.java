package com.example.whatsapps;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SelectCountry extends AppCompatActivity {
    RecyclerView listView;
    Toolbar toolbar;
    ArrayList<countryList> list = new ArrayList<>();

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_country);
        listView = findViewById(R.id.list);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Choose a country");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        } else {
            setSupportActionBar(toolbar);
        }

        list.add(new countryList(R.drawable.ic_baseline_flag_24, "India", "+91"));
        list.add(new countryList(R.drawable.ic_baseline_flag_24, "Japan", "+94"));
        list.add(new countryList(R.drawable.ic_baseline_flag_24, "America", "+98"));
        list.add(new countryList(R.drawable.ic_baseline_flag_24, "Bhutan", "+90"));
        list.add(new countryList((R.drawable.ic_baseline_flag_24), "Nepal", "+95"));
        list.add(new countryList((R.drawable.ic_baseline_flag_24), "Hubli", "+97"));

        listView.setLayoutManager(new LinearLayoutManager(this));
        SelectCountryAdapter listAdapter = new SelectCountryAdapter(SelectCountry.this, list);
        listView.setAdapter(listAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.search, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search) {
            Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();

        } else {
            onBackPressed();

        }

        return super.onOptionsItemSelected(item);
    }

}