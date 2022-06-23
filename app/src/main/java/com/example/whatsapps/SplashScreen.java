package com.example.whatsapps;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;



@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed((Runnable) () -> {
            SharedPreferences preferences=getSharedPreferences("login",MODE_PRIVATE);
            boolean flag=preferences.getBoolean("flag",false);
            Intent intent;
            if(flag){
                intent=new Intent(SplashScreen.this,MainActivity.class);
            }else {
                intent = new Intent(SplashScreen.this, Welcome_activity.class);
            }
            startActivity(intent);
        },3000);

    }
}