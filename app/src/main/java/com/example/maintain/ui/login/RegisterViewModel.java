package com.example.maintain.ui.login;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.maintain.utils.MobileInfoUtil;
import com.example.maintain.utils.SharedData;

public class RegisterViewModel extends AndroidViewModel {
    public final MutableLiveData<String> userKey = new MutableLiveData<>();
    public final MutableLiveData<Boolean> flag = new MutableLiveData<>();
    public final String device = MobileInfoUtil.getIMEI(getApplication());
    private final SharedData sharedData = new SharedData(getApplication().getApplicationContext());

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        userKey.setValue("");
        String result = sharedData.loadKey();
        if (TextUtils.isEmpty(result)) {
            // Log.d("TAG_LOG", "---getFlag--- getkey---:" + getKey().toString());
            flag.setValue(true);
            // Log.d("TAG_LOG", "---getFlag--- getkey---false-");
        } else {
            flag.setValue(false);
        }
    }

    // 永久保存key
    public void saveKey() {

        if (flag.getValue()) {
            sharedData.saveUserKey(userKey.getValue());
            Log.d("TAG_LOG", "-----userKey.getValue().-----" + userKey.getValue());
            flag.setValue(false);
            userKey.setValue("已经存储有key，返回登录界面登录");
        } else {
            sharedData.saveUserKey("");
            userKey.setValue("");
            flag.setValue(true);
        }
    }




}