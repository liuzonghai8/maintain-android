package com.example.maintain.ui.login;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maintain.R;
import com.example.maintain.databinding.FragmentLoginBinding;
import com.example.maintain.databinding.FragmentRegisterBinding;

public class RegisterFragment extends Fragment {

    private RegisterViewModel mViewModel;
    private FragmentRegisterBinding binding;

    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding= FragmentRegisterBinding.inflate(inflater, container, false);
        //return inflater.inflate(R.layout.fragment_login, container, false);
        mViewModel = new ViewModelProvider(requireActivity()).get(RegisterViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setData(mViewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel.flag.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean flag) {
                Log.d("TAG_LOG", "----flag----" + flag);
                if (flag) {
                    binding.butSave.setText("保存Key");
                } else {
                    binding.butSave.setText("清除Key");
                }
            }
        });

    }
}