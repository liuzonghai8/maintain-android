package com.example.maintain.login;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.maintain.R;
import com.example.maintain.utils.EncryptUtil;
import com.example.maintain.utils.MobileInfoUtil;
import com.example.maintain.utils.PhoneUtils;
import com.example.maintain.utils.SharedData;

public class LoginViewModel extends AndroidViewModel {
    private static final String TAG_LOG = "Tag_log";
    private MutableLiveData<String> username;
    private MutableLiveData<Boolean> valid;
    //edit_key
    private MutableLiveData<String> userKey;
    public MutableLiveData<Boolean> flag;
    //key
    private final String keyName = getApplication().getString(R.string.shared_key);
    //file
    private final String fileName = getApplication().getString(R.string.shared_file_name);
    //device NO.
    public final String device = MobileInfoUtil.getIMEI(getApplication());
    private Context content = getApplication();


    public LoginViewModel(@NonNull Application application) {
        super(application);
        Log.d("TAG_LOG", "-----LoginViewModel.创建-----" );
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
//        Context content = getApplication();
        SharedData sd = new SharedData(content);
        if (flag.getValue()) {
            sd.save(fileName, keyName, userKey.getValue());
            flag.setValue(false);
            userKey.setValue("已经存储有key，返回登录界面登录");
        } else {
            sd.save(fileName, keyName, "");
            userKey.setValue("");
            flag.setValue(true);
        }
    }

    public String getKey() {
        //从文件中读取key
        SharedData sd = new SharedData(content);
        return sd.load(fileName, keyName);
    }

    //比较Key
    public Boolean compareKey() {
        //计算key
        String result = EncryptUtil.calculateKey(username.getValue(), device);
        // Log.d("TAG_LOG","-----calculate key-----"+result);
        String key = getKey();
        String s = EncryptUtil.calculateKey("18812345678", "fe4b1f218dfc9520");
        Log.d("TAG_LOG", "-----测试s.-----" + s);
        //比较两个可以
        return EncryptUtil.calculateKey(username.getValue(), device).equals(getKey());
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

    public MutableLiveData<Boolean> getFlag() {
        if (flag == null) {
            flag = new MutableLiveData<Boolean>();
            flag.setValue(false);
           // Log.d("TAG_LOG", "---getFlag --初始化 ---false-");
        }
        if (getKey() == "" || getKey() == null) {
           // Log.d("TAG_LOG", "---getFlag--- getkey---:" + getKey().toString());
            flag.setValue(true);
           // Log.d("TAG_LOG", "---getFlag--- getkey---false-");
        }
        return flag;
    }
}
