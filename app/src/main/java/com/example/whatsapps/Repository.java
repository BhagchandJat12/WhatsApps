package com.example.whatsapps;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Repository  {

      @Query(value = "select * from  whatsapp")
      List<Db> findAll();

      @Query(value="select * from whatsapp where  phone_no=:phone_no")
      Db findDb(String phone_no);

      @Insert
      void insertDb(Db db);

      @Query("update whatsapp set name= :name where id= :id")
      void updatedata(int id, String name);

}
