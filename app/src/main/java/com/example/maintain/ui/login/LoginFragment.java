package com.example.maintain.ui.login;

import androidx.activity.OnBackPressedCallback;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.maintain.R;
import com.example.maintain.basic.BasicFragment;
import com.example.maintain.databinding.FragmentLoginBinding;
import com.example.maintain.ui.tool.CodeViewModel;
import com.google.android.material.snackbar.Snackbar;

public class LoginFragment extends BasicFragment {

    private LoginViewModel viewModel;
    private FragmentLoginBinding binding;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        //return inflater.inflate(R.layout.fragment_login, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(LoginViewModel.class);
        binding.setData(viewModel);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);
        //不可返回
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(),
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        viewModel.refuseAuthentication();
                        navController.popBackStack(R.id.main_Fragment, false);
                    }
                });
        //验证状态的观察，不同状态执行不同操作
        viewModel.authenticationState.observe(getViewLifecycleOwner(),
                new Observer<LoginViewModel.AuthenticationState>() {
                    @Override
                    public void onChanged(LoginViewModel.AuthenticationState authenticationState) {
                        switch (authenticationState) {
                            case AUTHENTICATED:
                                navController.popBackStack();
                                break;
                            case INVALID_AUTHENTICATION:
                                Snackbar.make(view,
                                        "电话号码或key 不正确",
                                        Snackbar.LENGTH_SHORT
                                ).show();
                                break;
                        }
                    }
                });

        //注册按钮 点击跳转注册页面
        binding.btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_login_Fragment_to_register_fragment);
            }
        });
        viewModel.username.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String str) {
                // Update the UI, in this case, a TextView.
                if (!viewModel.checkPhone()) {
                    binding.editPhone.setError("账号必须为11位的电话号码");
                }
            }
        });
    }

}
