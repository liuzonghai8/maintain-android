package com.example.maintain.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.maintain.R;

public class LoginActivity extends AppCompatActivity {

    EditText username;
    Button submit,butReg;
    RadioButton butRemember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initListener();
    }
    //登陆按钮
private void initListener(){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString().trim();
                if (TextUtils.isEmpty(user)){username.setError("账号不能为空");}
            }
        });
}
//注册按钮监听
    private void regListener(){

    }

    private void initView(){
        username= findViewById(R.id.edite_username);
        submit= findViewById(R.id.bt_submit);
        butReg=findViewById(R.id.bt_register);
        butRemember=findViewById(R.id.radioButton);
    }
}