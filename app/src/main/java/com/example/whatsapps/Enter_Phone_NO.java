package com.example.whatsapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.Objects;


public class Enter_Phone_NO extends AppCompatActivity {
    AppCompatTextView select_country ;
   static  AppCompatEditText country_code,phone_no;
    AppCompatButton send_otp;
   Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_phone_no);
      //  toolbar=findViewById(R.id.toolbar);
        country_code=findViewById(R.id.country_code);
        send_otp=findViewById(R.id.send_otp);
        phone_no=findViewById(R.id.Phone_no);
        select_country = findViewById(R.id.select_country);

       // setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("Enter Your phone number");
        }

        select_country.setOnClickListener(v->{
            Intent intent=new Intent(this,SelectCountry.class);
             Bundle bundle=new Bundle();
             bundle.putString("country", Objects.requireNonNull(select_country.getText().toString()));
             bundle.putString("con_code", (Objects.requireNonNull(country_code.getText()).toString()));
             intent.putExtras(bundle);
            startActivity(intent);
        });


        if(getIntent().getStringExtra("name")!=null) {
            select_country.setText(getIntent().getStringExtra("name"));
            country_code.setText(getIntent().getStringExtra("code"));

        }

        send_otp.setOnClickListener(v->{
            if(phone_no.getText()!=null) {
                Intent intent = new Intent(this, Otp.class);
                intent.putExtra("phone_no", Objects.requireNonNull(country_code.getText()) + Objects.requireNonNull(phone_no.getText()).toString());
                startActivity(intent);
            }else {
                AlertDialog.Builder builder= new AlertDialog.Builder(this)
                        .setMessage("please enter your phone number.")
                        .setNegativeButton("ok",(dialog, which) -> {});
                builder.show();
            }
        });



    }


}