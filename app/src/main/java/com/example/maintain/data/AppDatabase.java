package com.example.maintain.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.maintain.data.code.Code;

@Database(entities = {Code.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

}
