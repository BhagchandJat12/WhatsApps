package com.example.whatsapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.imageview.ShapeableImageView;

public class Welcome_activity extends AppCompatActivity{
    AppCompatButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        button=findViewById(R.id.agree);

        button.setOnClickListener(v->{
            Intent i=new Intent(this,Enter_Phone_NO.class);
            startActivity(i);
        });
    }
}