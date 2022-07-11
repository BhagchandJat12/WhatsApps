package com.example.whatsapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.imageview.ShapeableImageView;

public class Settings extends AppCompatActivity {
    ShapeableImageView profile;
    AppCompatTextView name,status;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        profile=findViewById(R.id.profile_picture);
        name=findViewById(R.id.name);
        status=findViewById(R.id.status);

        profile.setImageResource(R.drawable.profile);
        name.setText("Hello");
        status.setText("HEllo");
    }
}