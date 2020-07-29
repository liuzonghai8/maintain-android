package com.example.maintain.ui.login;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.maintain.R;
import com.example.maintain.utils.DateUtil;
import com.example.maintain.utils.EncryptUtil;
import com.example.maintain.utils.MobileInfoUtil;
import com.example.maintain.utils.PhoneUtils;
import com.example.maintain.utils.SharedData;

public class LoginViewModel extends AndroidViewModel {
    public enum AuthenticationState {
        UNAUTHENTICATED,        // Initial state, the user needs to authenticate
        AUTHENTICATED,          // The user has authenticated successfully
        INVALID_AUTHENTICATION  // Authentication failed
    }

    public final MutableLiveData<AuthenticationState> authenticationState =
            new MutableLiveData<>();
    public final MutableLiveData<String> username = new MutableLiveData<>();
    public final MutableLiveData<Boolean> valid = new MutableLiveData<>();

    public final String device = MobileInfoUtil.getIMEI(getApplication());
    private final SharedData sharedData = new SharedData(getApplication().getApplicationContext());

    public LoginViewModel(@NonNull Application application) {
        super(application);
        // In this example, the user is always unauthenticated when MainActivity is launched
//        authenticationState.setValue(AuthenticationState.UNAUTHENTICATED);
        authenticationState.setValue(AuthenticationState.AUTHENTICATED);
        username.setValue("");
        valid.setValue(true);
    }

    //认证 绑定login登陆按钮
    public void authenticate() {
        // Log.d("TAG_LOG","-----authenticate-- 认证开始---");
        // SharedData sd = new SharedData(getApplication());
        if (keyIsValidForUsername()) {
            //存储用户名至share
            sharedData.saveUserName(username.getValue());
            authenticationState.setValue(AuthenticationState.AUTHENTICATED);
        } else {
            sharedData.saveUserName("");
            authenticationState.setValue(AuthenticationState.INVALID_AUTHENTICATION);
        }
    }

    //拒绝
    public void refuseAuthentication() {
        authenticationState.setValue(AuthenticationState.UNAUTHENTICATED);
    }

    //认证电话号码和存储的key是否正确
    private boolean keyIsValidForUsername() {
        if (!DateUtil.compareDate(getApplication().getString(R.string.start_date), getApplication().getString(R.string.end_date))) {
            Log.d("TAG_LOG", "--------日期过期------");
            return false;
        }
        if (!compareKey()) {
            Log.d("TAG_LOG", "--------key核对不正确------");
            return false;
        }
        return true;
    }

    //比较Key
    public Boolean compareKey() {
        //计算key
     //   String result = EncryptUtil.calculateKey(username.getValue(), device);
        //  Log.d("TAG_LOG","-----calculate key-----"+result+username.getValue());
//        String key = sharedData.loadKey();
        String s = EncryptUtil.calculateKey("18978704599", "263ad18a19eba1dd");
//        String s = EncryptUtil.calculateKey("18812345678", "84029d1a22714ce9");
        Log.d("TAG_LOG", "-----测试s.-----" + s);
        //比较两个可以
        return EncryptUtil.calculateKey(username.getValue(), device).equals(sharedData.loadKey());
    }

    //检查账号是否是电话号码
    public boolean checkPhone() {
        String user = username.getValue();
        if (user!=null&&user.length() == 11 && PhoneUtils.checkChinaPhone(user)) {
            valid.setValue(true);
            return true;
        }
        valid.setValue(false);
        return false;
    }



}