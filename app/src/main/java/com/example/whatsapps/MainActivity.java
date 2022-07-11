package com.example.whatsapps;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.List;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    Toolbar toolbar;
    ViewPager viewPager;


    @SuppressLint({"ResourceType", "UnspecifiedImmutableFlag"})
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tab_view);
        toolbar = findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.view_pager);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("WhatsApp");
        }
/*


        Controller controller = Controller.getDb(this);
        controller.repository().insertDb(new Db("Ram jat", "97764", "it is really nice"));
        controller.repository().insertDb(new Db("Ravan jat", "9483478494", "it is really bad"));

        List<Db> list = controller.repository().findAll();


        controller.repository().updatedata(1, "Bhagchandjat");

        List<Db> lis = controller.repository().findAll();

*/


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }


}