package com.example.maintain.data;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.maintain.data.code.Code;
import com.example.maintain.data.code.CodeDao;

@Database(entities = {Code.class}, version = 1 ,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
     public abstract CodeDao getCodeDao();
     private static AppDatabase INSTANCE;

     public static synchronized AppDatabase getDatabase(Context context){
          if (INSTANCE==null){
               INSTANCE= Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"maintain_database")
//                       .allowMainThreadQueries()
                       // Migration is not part of this practical.
                       .fallbackToDestructiveMigration()
                       .build();
               Log.d("TAG_LOG","====database create=instance null=====");
          }
          Log.d("TAG_LOG","====database create======");
          return INSTANCE;
     }


}
