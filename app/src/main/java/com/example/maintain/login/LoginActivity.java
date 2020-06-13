package com.example.maintain.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.maintain.MainActivity;
import com.example.maintain.R;
import com.example.maintain.databinding.ActivityLoginBinding;
import com.example.maintain.utils.DateUtil;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG_LOG = "TAG_LOG";
    private String message = "账号必须为11位的电话号码";
    private LoginViewModel model;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //布局视图绑定
        // Inflate view and obtain an instance of the binding class.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        // Get the ViewModel.
        model = new ViewModelProvider(this).get(LoginViewModel.class);
        //布局的数据跟viewModel 关联
        binding.setData(model);
        // Specify the current activity as the lifecycle owner.
        binding.setLifecycleOwner(this);
        //确认键
        submitListener();
        //注册键
        regListener();



        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.getUsername().observe(this, nameObserver);

    }

    // Create the observer which updates the UI.
    final Observer<String> nameObserver = new Observer<String>() {
        @Override
        public void onChanged(@Nullable final String str) {
            // Update the UI, in this case, a TextView.

            if (!model.checkPhone()) {
                binding.editeUsername.setError(message);
            }
        }
    };

    //登陆按钮
    private void submitListener() {
        binding.btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1、判断日期是否过期
                if(!DateUtil.compareDate(getString(R.string.start_datte),getString(R.string.end_date))){
                    Toast.makeText(LoginActivity.this, R.string.toast_login_failed_date, Toast.LENGTH_LONG).show();
                    return;
                }
                //2、先检查 计算的key 是否等于存储的key
                if (!model.compareKey()) {
                    Toast.makeText(LoginActivity.this, R.string.toast_login_failed, Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    //注册按钮监听
    private void regListener() {
        binding.btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(intent, 0X25);
            }
        });

    }

}