package com.example.whatsapps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SelectCountryAdapter extends RecyclerView.Adapter<SelectCountryAdapter.Modelview> {
    Context context;
    ArrayList<countryList> list;

    SelectCountryAdapter(Context context,ArrayList<countryList> list){
        this.context=context;
        this.list=list;
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
       /*  Intent intent=new Intent();
       int pos=list.indexOf(new countryList(R.drawable.ic_baseline_flag_24,intent.getStringExtra("country"),intent.getStringExtra("con_code")));
        if(pos==position){

            holder.code.setCompoundDrawables(null,null,null,context.getDrawable(R.drawable.ic_baseline_check_24));
        }

        holder.itemView.setOnClickListener(v->{
            Intent in=new Intent(context,Enter_Phone_NO.class);
            in.putExtra("name",holder.country.getText().toString());
            in.putExtra("code",holder.code.getText().toString());
        });
*/
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class Modelview extends RecyclerView.ViewHolder {
        AppCompatTextView country,code;

        public Modelview(@NonNull View view) {
            super(view);
            country=view.findViewById(R.id.name_country);
            code=view.findViewById(R.id.code);
        }
    }
}
