package com.example.whatsapps;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "otp")

public class SendOtp {

            @ColumnInfo(name = "id")
            @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "phone_no")
   private Number num;

    @NonNull
    @ColumnInfo(name = "otp")
    private  String otp;

    public SendOtp(int id, @NonNull Number num, @NonNull String otp) {
        this.id = id;
        this.num = num;
        this.otp = otp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public Number getNum() {
        return num;
    }

    public void setNum(@NonNull Number num) {
        this.num = num;
    }

    @NonNull
    public String getOtp() {
        return otp;
    }

    public void setOtp(@NonNull String otp) {
        this.otp = otp;
    }

    @NonNull
    @Override
    public String toString() {
        return "SendOtp{" +
                "id=" + id +
                ", num=" + num +
                ", otp='" + otp + '\'' +
                '}';
    }
}
