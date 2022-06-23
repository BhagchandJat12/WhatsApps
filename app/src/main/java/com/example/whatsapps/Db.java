package com.example.whatsapps;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "whatsapp")
public class Db {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    @NonNull
    private String name;

    @ColumnInfo(name = "phone_no")
    @NonNull
    private String number;

    @ColumnInfo(name = "status")
    private String status;

    @ColumnInfo(name = "image")
    private byte[] image;


    public Db(int id, @NonNull String name, @NonNull String number, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.number = number;
    }

    @Ignore
    Db(@NonNull String name, @NonNull String number, String status) {
        this.name = name;
        this.number = number;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @NonNull
    public String getNumber() {
        return number;
    }

    public void setNumber(@NonNull String number) {
        this.number = number;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @NonNull
    @Override
    public String toString() {
        return "Db{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", status='" + status + '\'' +
                '}';
    }
}
