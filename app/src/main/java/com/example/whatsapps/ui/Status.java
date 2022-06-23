package com.example.whatsapps.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapps.R;
import com.example.whatsapps.StatusProfile;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;


public class Status extends Fragment {
    ShapeableImageView imageView;
    AppCompatTextView name, status;
    RecyclerView recyclerView;
    ArrayList<StatusProfile> list;

    public Status() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_status, container, false);
        imageView = view.findViewById(R.id.profile_picture);
        name = view.findViewById(R.id.name);
        status = view.findViewById(R.id.status);
        recyclerView = view.findViewById(R.id.status_view);
        /*recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list.add(new StatusProfile(R.drawable.profile, "BhagchNdjat", "I am busy"));
        list.add(new StatusProfile(R.drawable.profile, "BhagchNdjat", "I am busy"));
        list.add(new StatusProfile(R.drawable.profile, "BhagchNdjat", "I am busy"));
        list.add(new StatusProfile(R.drawable.profile, "BhagchNdjat", "I am busy"));
        list.add(new StatusProfile(R.drawable.profile, "BhagchNdjat", "I am busy"));
        StatusViewAdapter statusViewAdapter = new StatusViewAdapter(getContext(), list);
        recyclerView.setAdapter(statusViewAdapter);*/
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.status_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @SuppressLint("InflateParams")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.search) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.search_bar, null);


        } else if (id == R.id.status_privacy) {
            Toast.makeText(getContext(), "Status_privacy", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Setting", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}