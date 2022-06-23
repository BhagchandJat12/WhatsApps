package com.example.whatsapps.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.whatsapps.R;


public class Calls extends Fragment {


    public Calls() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_calls, container, false);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.whatsapp_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (R.id.search == id) {
            Toast.makeText(getContext(), "Search", Toast.LENGTH_SHORT).show();
        } else if (R.id.chats == id) {
            Toast.makeText(getContext(), "chats", Toast.LENGTH_SHORT).show();
        } else if (R.id.status == id) {
            Toast.makeText(getContext(), "status", Toast.LENGTH_SHORT).show();
        } else if (R.id.calls == id) {
            Toast.makeText(getContext(), "calls", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}