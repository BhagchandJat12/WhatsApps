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


        Controller controller = Controller.getDb(this);
        controller.repository().insertDb(new Db("Ram jat", "97764", "it is really nice"));
        controller.repository().insertDb(new Db("Ravan jat", "9483478494", "it is really bad"));

        List<Db> list = controller.repository().findAll();
        for (int i = 0; i < list.size(); i++) {
            Log.d("element" + i, "{" + list.get(i).getId() + "," + list.get(i).getName() + "," + list.get(i).getStatus() + "}");
        }

        controller.repository().updatedata(1, "Bhagchandjat");

        List<Db> lis = controller.repository().findAll();
        for (int i = 0; i < lis.size(); i++) {
            Log.d("element" + i, "{" + lis.get(i).getId() + "," + lis.get(i).getName() + "," + lis.get(i).getStatus() + "}");
        }


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);


        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = null;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
           notification = new Notification.Builder(this, "101")

                    .setLargeIcon(((BitmapDrawable) Objects.requireNonNull(ResourcesCompat.getDrawable(getResources(), R.drawable.whatsapp, null))).getBitmap())
                    .setSmallIcon(R.id.profile_picture)
                    .setContentIntent(PendingIntent.getActivities(this, 101, new Intent[]{intent}, PendingIntent.FLAG_UPDATE_CURRENT))
                    .setContentTitle("Bhagchand jat")
                    .setSubText("Ram").build();
        }
        nm.notify(101,notification);

    }


}