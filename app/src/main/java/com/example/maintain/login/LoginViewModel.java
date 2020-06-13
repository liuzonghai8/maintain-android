package com.example.maintain.login;

import android.app.Application;
import android.content.ContentProvider;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.maintain.R;
import com.example.maintain.utils.EncryptUtil;
import com.example.maintain.utils.MobileInfoUtil;
import com.example.maintain.utils.PhoneUtils;
import com.example.maintain.utils.SharedData;

public class LoginViewModel extends AndroidViewModel {
    private static final String TAG_LOG = "Tag_log";
    private MutableLiveData<String> username;
    private MutableLiveData<Boolean> valid;
    private MutableLiveData<String> userKey;
    //    private MutableLiveData
     //key
    private final String keyName = getApplication().getString(R.string.shared_key);
    //file
    private final String fileName = getApplication().getString(R.string.shared_file_name);
    //device NO.
    public final String device = MobileInfoUtil.getIMEI(getApplication());

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }


    //检查账号是否合法
    public boolean checkPhone() {
        String user = username.getValue();
        if (user.length() == 11 && PhoneUtils.checkChinaPhone(user)) {
            valid.setValue(true);
            return true;
        }
        valid.setValue(false);
        return false;
    }

    // 永久保存key
    public void saveKey() {
        Context content = getApplication();
         SharedData sd = new SharedData(content);
         sd.save(fileName,keyName,userKey.getValue());
        Log.d("TAG_LOG", "---saveKey--ok--");
    }

    //比较Key
    public Boolean compareKey() {
        //从文件中读取key
        Context content = getApplication();
        SharedData sd = new SharedData(content);
        String key = sd.load(fileName,keyName);
        //Log.d("TAG_LOG","-----load key-----"+key);
        //计算key
        String result = EncryptUtil.calculateKey(username.getValue(), device);
       // Log.d("TAG_LOG","-----calculate key-----"+result);

      //  String s = EncryptUtil.calculateKey("18812345678", "f3a2d2abfa17862f");
     //   Log.d("TAG_LOG","-----测试s.-----"+s);
        //比较两个可以
        return result.equals(key);
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

    public MutableLiveData<String> getUserKey() {
        if (userKey == null) {
            userKey = new MutableLiveData<String>();
        }
        return userKey;
    }

    public void setUsername(MutableLiveData<String> username) {
        this.username = username;
    }

    public void setUserKey(MutableLiveData<String> userKey) {
        this.userKey = userKey;
    }

}
