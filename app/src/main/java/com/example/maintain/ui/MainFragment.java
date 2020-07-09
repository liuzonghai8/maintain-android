package com.example.maintain.ui;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maintain.R;
import com.example.maintain.basic.BasicFragment;
import com.example.maintain.ui.login.LoginViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainFragment extends BasicFragment {
    private LoginViewModel loginViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        final NavController bottomNavController = Navigation.findNavController(requireActivity(),R.id.nav_bottomView);
        BottomNavigationView navView = view.findViewById(R.id.bottom_nav);
        NavigationUI.setupWithNavController(navView, bottomNavController);
        //绑定model
        LoginViewModel model= new ViewModelProvider(requireActivity()).get(LoginViewModel.class);
        //主导航
        final NavController mainNavController = Navigation.findNavController(requireActivity(),R.id.nav_main);
        model.authenticationState.observe(getViewLifecycleOwner(),
                new Observer<LoginViewModel.AuthenticationState>() {
                    @Override
                    public void onChanged(final LoginViewModel.AuthenticationState authenticationState) {
                        //停留3秒进入登陆界面

                                switch (authenticationState) {
                                    case AUTHENTICATED:
                                      //  navController.navigate(R.id.main_Fragment);
                                        Log.d(TAG_LOG,"-----main fragment----");
                                        break;
                                    case UNAUTHENTICATED:
                                        mainNavController.navigate(R.id.login_Fragment);
                                        break;
                                }

                            }
                        });

                    }
}