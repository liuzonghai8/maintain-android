package com.example.maintain.ui;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maintain.R;
import com.example.maintain.basic.BasicFragment;
import com.example.maintain.ui.login.LoginViewModel;

public class StartFragment extends BasicFragment {

    private LoginViewModel mViewModel;

    public static StartFragment newInstance() {
        return new StartFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        mViewModel= new ViewModelProvider(requireActivity()).get(LoginViewModel.class);
        mViewModel.authenticationState.observe(getViewLifecycleOwner(),
                new Observer<LoginViewModel.AuthenticationState>() {
                    @Override
                    public void onChanged(final LoginViewModel.AuthenticationState authenticationState) {

                                switch (authenticationState) {
                                    case AUTHENTICATED:
                                        Log.d(TAG_LOG,"---start to main fragment----");
                                        navController.navigate(R.id.action_startFragment_to_main_fragment);
                                        break;
                                    case UNAUTHENTICATED:
                                        navController.navigate(R.id.login_fragment);
                                        break;
                                }

                    }
                });


    }
}