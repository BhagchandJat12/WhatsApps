package com.example.whatsapps.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.whatsapps.ChatProfile;
import com.example.whatsapps.ChatViewAdapter;
import com.example.whatsapps.Enter_Phone_NO;
import com.example.whatsapps.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;


public class Chat extends Fragment {


    public Chat() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_chat, container, false);
        setHasOptionsMenu(true);
       RecyclerView recyclerView=view.findViewById(R.id.chat_view);
       recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        ArrayList<ChatProfile> list=new ArrayList<>();



        list.add(new ChatProfile(R.mipmap.ic_launcher, "Bhagchand jat", "I am busy", "7:PM", "9"));
        list.add(new ChatProfile(R.mipmap.ic_launcher, "Rishi jat", "work hard", "8:PM", "4"));
        list.add(new ChatProfile(R.mipmap.ic_launcher, "Hemraj jat", "Never give up", "1:PM", "0"));
        list.add(new ChatProfile(R.mipmap.ic_launcher, "Girdhari jat", "life is mortal", "yesterday", "1"));
        list.add(new ChatProfile(R.mipmap.ic_launcher, "Amit jat", "I am working", "9:PM", "1"));
        list.add(new ChatProfile(R.mipmap.ic_launcher, "Ram jat", "I am smooth", "3:PM", "2"));
        list.add(new ChatProfile(R.mipmap.ic_launcher, "Hanuman jat", "I am free", "yesterday", "0"));
        list.add(new ChatProfile(R.mipmap.ic_launcher, "Bhagchand jat", "I am busy", "7:PM", "9"));
        list.add(new ChatProfile(R.mipmap.ic_launcher, "Rishi jat", "work hard", "8:PM", "4"));
        list.add(new ChatProfile(R.mipmap.ic_launcher, "Hemraj jat", "Never give up", "1:PM", "8"));
        list.add(new ChatProfile(R.mipmap.ic_launcher, "Girdhari jat", "life is mortal", "yesterday", "1"));
        list.add(new ChatProfile(R.mipmap.ic_launcher, "Amit jat", "I am working", "9:PM", "1"));
        list.add(new ChatProfile(R.mipmap.ic_launcher, "Ram jat", "I am smooth", "3:PM", "2"));
        ChatViewAdapter viewAdapter=new ChatViewAdapter(view.getContext(), list);
        recyclerView.setAdapter(viewAdapter);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.chat_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (R.id.search == id) {
            Toast.makeText(getContext(), "Search", Toast.LENGTH_SHORT).show();
        } else if (R.id.new_group == id) {
            Toast.makeText(getContext(), "new group", Toast.LENGTH_SHORT).show();
        } else if (R.id.new_broadcast == id) {
            Toast.makeText(getContext(), "broadcast", Toast.LENGTH_SHORT).show();
        } else if (R.id.linked_devices == id) {
            Toast.makeText(getContext(), "linked device", Toast.LENGTH_SHORT).show();
        } else if (R.id.starred_messages == id) {
            Toast.makeText(getContext(), "message", Toast.LENGTH_SHORT).show();
        } else if (R.id.payment == id) {
            Toast.makeText(getContext(), "payment", Toast.LENGTH_SHORT).show();
        } else if (R.id.settings == id) {
            Toast.makeText(getContext(), "Setting", Toast.LENGTH_SHORT).show();
        } else if(R.id.logout==id){
            FirebaseAuth.getInstance().signOut();
            Intent intent=new Intent(getContext(), Enter_Phone_NO.class);
            SharedPreferences preferences= requireContext().getSharedPreferences("login", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=preferences.edit();
            editor.putBoolean("flag",false);
            editor.apply();
            requireContext().startActivity(intent);
        }
        else {
            Toast.makeText(getContext(), "Back", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}