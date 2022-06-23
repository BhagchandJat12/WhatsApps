package com.example.whatsapps;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Db.class,exportSchema = false,version = 1)
public abstract class Controller extends RoomDatabase {

    private static final String DB_NAME="whats";
    private  static Controller instance;

    public static synchronized Controller getDb(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context, Controller.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }

    public  abstract Repository repository();

    public Db findUser(String number){
        return repository().findDb(number);

    }
}
