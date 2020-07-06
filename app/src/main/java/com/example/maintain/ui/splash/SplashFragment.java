package com.example.maintain.ui.splash;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maintain.R;
import com.example.maintain.basic.BasicFragment;
import com.example.maintain.ui.login.LoginViewModel;
import com.example.maintain.utils.ThreadUtils;

public class SplashFragment extends BasicFragment {

    private LoginViewModel model;

    public static SplashFragment newInstance() {
        return new SplashFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        final NavController navController = Navigation.findNavController(view);
//        model= new ViewModelProvider(requireActivity()).get(LoginViewModel.class);
//        model.authenticationState.observe(getViewLifecycleOwner(),
//                new Observer<LoginViewModel.AuthenticationState>() {
//                    @Override
//                    public void onChanged(final LoginViewModel.AuthenticationState authenticationState) {
//                        //停留3秒进入登陆界面
//                        ThreadUtils.runInThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                //停留3秒
//                                SystemClock.sleep(3000);
//                                switch (authenticationState) {
//                                    case AUTHENTICATED:
//                                        navController.navigate(R.id.main_Fragment);
//                                        Log.d(TAG_LOG,"-----main fragment----");
//                                        break;
//                                    case UNAUTHENTICATED:
//                                        navController.navigate(R.id.login_Fragment);
//                                        break;
//                                }
//
//                            }
//                        });
//
//                    }
//                });

    }
}