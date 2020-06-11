package com.example.maintain.utils;


import android.os.Handler;

public class ThreadUtils {
    /** 主线程hander */
    public static Handler mHandler=new Handler() ;

    /** 子线程执行task */
    public static void runInThread(Runnable task){
        new Thread(task).start();
    }

    /** UI线程执行task */
    public static void runInUIThread(Runnable task){
        mHandler.post(task);
    }
}
