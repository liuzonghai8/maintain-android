package com.example.maintain.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.maintain.R;
import com.example.maintain.databinding.ActivityLoginBinding;

public class RegisterActivity extends AppCompatActivity {
    private LoginViewModel model;
    //private ActivityLoginBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Get the ViewModel.
        model = new ViewModelProvider(this).get(LoginViewModel.class);
    }
}