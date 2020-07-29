package com.example.maintain.ui.me;

import android.app.Application;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.maintain.utils.EncryptUtil;
import com.example.maintain.utils.SharedData;

public class KeyViewModel extends AndroidViewModel {

    public final MutableLiveData<String> phone=new MutableLiveData<>();
    public final MutableLiveData<String> deviceId=new MutableLiveData<>();
    public final MutableLiveData<String> key=new MutableLiveData<>();
    public final MutableLiveData<Boolean> valid = new MutableLiveData<>();

    private final SharedData sharedData = new SharedData(getApplication().getApplicationContext());

    public KeyViewModel(@NonNull Application application) {
        super(application);
        phone.setValue("");
        deviceId.setValue("");
        key.setValue("");
        if(sharedData.loadUserName().equals("18978704599")){
            valid.setValue(true);
        }else
        {
            valid.setValue(false);
        }


    }

   public String compareKey(){
        return EncryptUtil.calculateKey(phone.getValue(),deviceId.getValue());
   }

   public void myKey(){
       key.setValue(compareKey());
   }

   //获取存储用户名（手机号）

}