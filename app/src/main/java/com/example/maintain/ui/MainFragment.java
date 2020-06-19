package com.example.maintain.ui;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.maintain.R;
import com.example.maintain.ui.login.LoginViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainFragment extends Fragment {
    private LoginViewModel loginViewModel;
   // private MainPageViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }
    private String TAG_LOG="TAG_log";
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        final NavController navController2 = Navigation.findNavController(requireActivity(),R.id.nav_host_fragment);
        //navController.navigate(R.id.login_Fragment);
        BottomNavigationView navView = view.findViewById(R.id.bottom_nav);
        NavigationUI.setupWithNavController(navView, navController2);
        loginViewModel= new ViewModelProvider(requireActivity()).get(LoginViewModel.class);
        loginViewModel.authenticationState.observe(getViewLifecycleOwner(),
                new Observer<LoginViewModel.AuthenticationState>() {
                    @Override
                    public void onChanged(LoginViewModel.AuthenticationState authenticationState) {
                        switch (authenticationState) {
                            case AUTHENTICATED:
                                Log.d("TAG_LOG","-----main fragment----");
                                break;
                            case UNAUTHENTICATED:
                                navController.navigate(R.id.login_Fragment);
                                break;
                        }
                    }
                });
    }
}