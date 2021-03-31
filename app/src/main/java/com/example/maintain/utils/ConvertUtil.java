package com.example.maintain.utils;

import android.content.Context;
import android.util.Log;

import androidx.work.ListenableWorker;

import com.example.maintain.data.AppDatabase;
import com.example.maintain.data.code.Code;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.util.List;

public class ConvertUtil {

    public static String JsonConvertToString(Context context, String fileName){
        try {
            //需要转换放到一个方法中
            InputStream open  = context.getApplicationContext().getAssets().open(fileName);
            int size = open.available();
            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            open.read(buffer);
            open.close();
            // Convert the buffer into a string.
            String str = new String(buffer, "utf-8");
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
