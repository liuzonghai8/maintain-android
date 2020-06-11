package com.example.maintain.login;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    private static final String TAG_LOG = "Tag_log";
private MutableLiveData<String> username;

    public LoginViewModel() {
       Log.d(TAG_LOG,"----LoginViewModel--create---");
    }

    public void setUsername(MutableLiveData<String> username) {
        this.username = username;
    }

    public MutableLiveData<String> getUsername() {
        if(username ==null){
            username =new MutableLiveData<String>();
        }
        return username;
    }

}
