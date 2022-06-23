package com.example.whatsapps;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class StatusViewAdapter extends RecyclerView.Adapter<StatusViewAdapter.ModelView> {
    final Context context;
    final ArrayList<StatusProfile> list;

    public StatusViewAdapter(Context context, ArrayList<StatusProfile> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ModelView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.status_view, parent);

        return new ModelView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelView holder, int position) {
        holder.imageView.setImageResource(list.get(position).image);
        holder.name.setText(list.get(position).name);
        holder.status.setText(list.get(position).status);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class ModelView extends RecyclerView.ViewHolder {
        final ShapeableImageView imageView;
        final AppCompatTextView name;
        final AppCompatTextView status;

        public ModelView(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.profile_picture);
            name = itemView.findViewById(R.id.name);
            status = itemView.findViewById(R.id.status);
        }
    }
}