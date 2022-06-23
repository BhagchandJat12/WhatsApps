package com.example.whatsapps;

public class ChatProfile {
    final int image;
    final String name;
    final String status;
    final String time;
    final String unseen_message;

    public ChatProfile(int image, String name, String status, String time, String unseen_message) {
        this.image = image;
        this.name = name;
        this.status = status;
        this.time = time;
        this.unseen_message = unseen_message;
    }

    String getTime(){
        return  time;
    }

}
