package com.example.whatsapps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SelectCountryAdapter extends RecyclerView.Adapter<SelectCountryAdapter.Modelview> {
    Context context;
    ArrayList<countryList> list;
    String count,con_code;

    SelectCountryAdapter(Context context,ArrayList<countryList> list,String count,String con_code){
        this.context=context;
        this.list=list;
        this.count=count;
        this.con_code=con_code;
    }

    @NonNull
    @Override
    public Modelview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view=LayoutInflater.from(context).inflate(R.layout.country_list,parent,false);
        return new Modelview(view);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onBindViewHolder(@NonNull Modelview holder, int position) {
        holder.country.setText(list.get(position).name);
        holder.code.setText(list.get(position).code);

        int pos=-1;
        for(int i=0;i<list.size();i++){
            if(list.get(i).name.equals(count)){
                pos=i;
            }
        }


        if(pos!=position){
            holder.code.setCompoundDrawables(null,null,null,null);
        }

        holder.row.setOnClickListener(v->{
            Intent in=new Intent(context,Enter_Phone_NO.class);
            in.putExtra("name",holder.country.getText().toString());
            in.putExtra("code",holder.code.getText().toString().replace("+",""));
            context.startActivity(in);
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class Modelview extends RecyclerView.ViewHolder {
        AppCompatTextView country,code;
        LinearLayoutCompat row;
        public Modelview(@NonNull View view) {
            super(view);
            country=view.findViewById(R.id.name_country);
            code=view.findViewById(R.id.code);
            row=view.findViewById(R.id.row);
        }
    }
}
