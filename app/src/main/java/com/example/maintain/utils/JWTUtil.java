package com.example.maintain.utils;

import android.util.Log;

import com.auth0.jwt.algorithms.Algorithm;

public class JWTUtil {

    public static String calculateKey(String phone,String deviceID){
        String params="liu-zong-hai";
        StringBuilder sb = new StringBuilder();
        sb.append(phone).append(deviceID).append(params);

//        Algorithm

        return null;
    }

}
