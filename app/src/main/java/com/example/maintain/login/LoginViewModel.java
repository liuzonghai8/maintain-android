package com.example.maintain.login;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.maintain.utils.EncryptUtil;
import com.example.maintain.utils.MobileInfoUtil;
import com.example.maintain.utils.PhoneUtils;

public class LoginViewModel extends AndroidViewModel {
    private static final String TAG_LOG = "Tag_log";
    private MutableLiveData<String> username;
    private MutableLiveData<Boolean> valid;

    public final String device=MobileInfoUtil.getIMEI(getApplication());

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }


    //检查账号是否合法
    public boolean checkPhone() {
        getKey();
        String user = username.getValue();
        if (user.length() == 11 && PhoneUtils.checkChinaPhone(user)) {
            valid.setValue(true);
            return true;
        }
        valid.setValue(false);
        return false;
    }

    //加密
    private String getKey() {
        String result = EncryptUtil.calculateKey(username.getValue(), device);
//        Log.d("TAG_LOG", "-----device.getValue()--" + device);
//        Log.d("TAG_LOG", "-----username.getValue()--" + username.getValue());
//        Log.d("TAG_LOG", "----md5-calculateKey--" + result);
        return result;
    }


    public MutableLiveData<Boolean> getValid() {
        if (valid == null) {
            valid = new MutableLiveData<Boolean>();
            valid.setValue(false);
        }
        return valid;
    }

    public MutableLiveData<String> getUsername() {
        if (username == null) {
            username = new MutableLiveData<String>();
        }
        return username;
    }

    public void setUsername(MutableLiveData<String> username) {
        this.username = username;
    }

}
