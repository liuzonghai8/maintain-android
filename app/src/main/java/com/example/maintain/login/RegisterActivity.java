package com.example.maintain.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.maintain.R;
import com.example.maintain.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    private LoginViewModel model;
    private ActivityRegisterBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_register);
        // Get the ViewModel.
        model = new ViewModelProvider(this).get(LoginViewModel.class);
        Log.d("TAG_LOG","---model.getFlag().getValue()--"+model.getFlag().getValue());
        binding.setData(model);
        binding.setLifecycleOwner(this);
        //butListener();

        model.getFlag().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean flag) {
                Log.d("TAG_LOG","---flag-observe--"+flag);
                if(flag){
                    binding.butSave.setText("保存Key");
//                   binding.eidtKey.setEdi
                }else {
                    binding.butSave.setText("清除Key");
                }
            }
        });
    }



//    //buttom按键
//    private void butListener(){
//        binding.butSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                binding.butSave.setText("save");
//            }
//        });
//    }


}