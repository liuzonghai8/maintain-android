package com.example.maintain.ui.me;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.maintain.utils.EncryptUtil;

public class KeyViewModel extends ViewModel {
    public String xs="visible";

    public final MutableLiveData<String> visible=new MutableLiveData<>();
    public final MutableLiveData<String> inVisible=new MutableLiveData<>();
    public final MutableLiveData<String> phone=new MutableLiveData<>();
    public final MutableLiveData<String> deviceId=new MutableLiveData<>();
    public final MutableLiveData<String> key=new MutableLiveData<>();
    public final MutableLiveData<Boolean> valid = new MutableLiveData<>();


    public KeyViewModel() {
        phone.setValue("");
        deviceId.setValue("");
        key.setValue("");
        valid.setValue(false);
        visible.setValue("visible");
        inVisible.setValue("invisible");
    }

   public String compareKey(){
        return EncryptUtil.calculateKey(phone.getValue(),deviceId.getValue());
   }

   public void myKey(){
       key.setValue(compareKey());
   }
}