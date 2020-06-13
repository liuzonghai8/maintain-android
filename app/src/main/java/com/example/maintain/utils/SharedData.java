package com.example.maintain.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.maintain.R;

public class SharedData {
    private Context context;


    public SharedData(Context context) {
        this.context = context;
    }

    //保存数据
    public void save(String fileName,String keyName,String key){
        SharedPreferences sharedPref =context.getSharedPreferences(
                fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPref.edit();
        editor.putString(keyName,key);
        editor.apply();
    }
    //加载数据
    public String load(String fileName,String keyName){
        SharedPreferences sharedPref =context.getSharedPreferences(
                fileName, Context.MODE_PRIVATE);
        return sharedPref.getString(keyName,"");
    }
}
