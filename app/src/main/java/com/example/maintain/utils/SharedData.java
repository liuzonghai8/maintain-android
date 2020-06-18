package com.example.maintain.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

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
    //保存用户
    public void saveUserName(String username){
       String user = context.getString(R.string.login_user_name);
        //file
        String fileName =context.getString(R.string.shared_file_name);
        save(fileName,user,username);
    }
    //保存验证的key
    public void saveUserKey(String key){
        //key
      String keyName = context.getString(R.string.shared_key);
        //file
        String fileName =context.getString(R.string.shared_file_name);
        save(fileName,keyName,key);
        Log.d("TAG_LOG", "-----saveUserKey-----" + key);
    }
    //获取key文件
    public String loadKey() {
        //从文件中读取key
        //key
        String keyName = context.getString(R.string.shared_key);
        //file
        String fileName =context.getString(R.string.shared_file_name);
        return load(fileName, keyName);
    }
}
