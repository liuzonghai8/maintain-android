package com.example.maintain.utils;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {
private static final String MD5="MD5";
    private static final String SHA256="SHA-256";
    private static final String SHA512="SHA-512";
    /**
     * 计算64位的Key
     * @param phone
     * @param deviceID
     * @return
     */
    public static String calculateKey(String phone,String deviceID){
        String params="liu-zong-hai";
        StringBuilder sb = new StringBuilder();
        sb.append(phone).append(deviceID).append(params);
        //MD5
        String md5= getSHA(sb.toString(),MD5);
         sb = new StringBuilder();
         sb.append(deviceID).append(md5).append(phone);
          //sha256
        String sha= getSHA(sb.toString(),SHA256);
        sb = new StringBuilder();
        sb.append(md5).append(sha).append(phone);
        //sha512
        String key= getSHA(sb.toString(),SHA512);
        Log.d("TAG_LOG","----md5-getSHA-512--key---"+key);

        return key;
    }

    /**
     * 将byte转为16进制
     * @param bytes
     * @return
     */
    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

//"SHA-256"
    private static String getSHA(String str, String type) {
        MessageDigest md;
        String result = "";
        try {
            md = MessageDigest.getInstance(type);
            md.update(str.getBytes("UTF-8"));
            result = byte2Hex(md.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }


}
