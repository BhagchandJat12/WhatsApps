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

public class ChatViewAdapter extends RecyclerView.Adapter<ChatViewAdapter.ModelView> {
  final  Context context;
  final  ArrayList<ChatProfile> list;

    public ChatViewAdapter(Context context, ArrayList<ChatProfile> list){
        this.context=context;
        this.list=list;
    }
    @NonNull
    @Override
    public ModelView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(context).inflate(R.layout.chat_view, parent,false);
        return new ModelView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelView holder, int position) {
             holder.profile.setImageResource(list.get(position).image);
             holder.name.setText(list.get(position).name);
             holder.status.setText(list.get(position).status);
        holder.time.setText(list.get(position).time);

        for (ChatProfile chatProfile:
             list) {
            if(!chatProfile.getTime().equals("0")){
                holder.unseen_message.setVisibility(View.VISIBLE);
                holder.unseen_message.setText(list.get(position).unseen_message);
            }

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ModelView extends RecyclerView.ViewHolder {
        final ShapeableImageView profile;
        final AppCompatTextView name;
        final AppCompatTextView status;
        final AppCompatTextView time;
        final AppCompatTextView unseen_message;

        public ModelView(@NonNull View itemView) {
            super(itemView);
            profile=itemView.findViewById(R.id.profile_picture);
            name=itemView.findViewById(R.id.name);
            status=itemView.findViewById(R.id.status);
            time=itemView.findViewById(R.id.time);
            unseen_message=itemView.findViewById(R.id.unseen_message);
        }
    }
}
