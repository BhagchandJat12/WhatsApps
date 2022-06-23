package com.example.whatsapps;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.whatsapps.ui.Calls;
import com.example.whatsapps.ui.Chat;
import com.example.whatsapps.ui.Status;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new Chat();
        }else if(position==1){
            return  new Status();
        }else{
            return new Calls();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "CHATS";
        }else if(position==1){
            return  "STATUS";
        }else{
            return "CALLS";
        }

    }
}
