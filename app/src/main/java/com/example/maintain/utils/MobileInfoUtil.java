package com.example.maintain.utils;

import android.content.Context;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;

public class MobileInfoUtil {
    /**
     * 获取手机IMEI
     *
     * @param context
     * @return
     */
    public static final String getIMEI(Context context) {
         return Secure.getString(context.getContentResolver(), Secure.ANDROID_ID);

    }



}

