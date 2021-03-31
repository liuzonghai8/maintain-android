package com.example.maintain.utils;


import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss
    static SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    //获取当前时间j,
   public static Boolean compareDate(String startDate,String endDate){
       Date date = new Date(System.currentTimeMillis());
       //获取今天日期
       String toDay=  format.format(date);
      // Log.d("TAG_LOG","====enDate==="+endDate+"===endDate.compareTo(toDay) ==="+endDate.compareTo(toDay));
      // Log.d("TAG_LOG","====startDate==="+startDate+"===startDate.compareTo(toDay) ==="+startDate.compareTo(toDay));

       return (endDate.compareTo(toDay)>0&&startDate.compareTo(toDay)<0)?true:false;
   }




}
