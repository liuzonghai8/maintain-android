package com.example.maintain.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.example.maintain.R;
import com.example.maintain.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG_LOG = "Tag_log";

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
        binding.setUser(model);
        // Specify the current activity as the lifecycle owner.
        binding.setLifecycleOwner(this);
        initListener();


        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.getUsername().observe(this, nameObserver);

    }

    // Create the observer which updates the UI.
    final Observer<String> nameObserver = new Observer<String>() {
        @Override
        public void onChanged(@Nullable final String str) {
            // Update the UI, in this case, a TextView.
            //nameTextView.setText(newName);
           // String user = binding.editeUsername.getText().toString().trim();
            Log.d(TAG_LOG, "---user name observe- viewModel name---" + model.getUsername().getValue().length());
//            if (TextUtils.isEmpty(model.getUsername().getValue())) {
//                binding.editeUsername.setError("账号不能为空");
//            }
            if(model.getUsername().getValue().length()!=11){
                binding.editeUsername.setError("账号必须为11位电话号码");
            }
            Log.d(TAG_LOG, "---user name observe----" + str);
        }
    };

    //登陆按钮
    private void initListener() {
        binding.btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = binding.editeUsername.getText().toString().trim();
                if (TextUtils.isEmpty(user)) {
                    binding.editeUsername.setError("账号不能为空");
                }
                Log.d(TAG_LOG, "---observe----" + user);
            }
        });
    }

    //注册按钮监听
    private void regListener() {

    }

}