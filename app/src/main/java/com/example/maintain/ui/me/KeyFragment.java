package com.example.maintain.ui.me;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maintain.R;
import com.example.maintain.databinding.FragmentKeyBinding;
import com.example.maintain.databinding.FragmentMeBinding;

public class KeyFragment extends Fragment {


    private FragmentKeyBinding binding;
    private KeyViewModel mViewModel;

    public static KeyFragment newInstance() {
        return new KeyFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding =FragmentKeyBinding.inflate(inflater,container,false);
        mViewModel=new ViewModelProvider(requireActivity()).get(KeyViewModel.class);
        binding.setData(mViewModel);
        binding.setLifecycleOwner(this);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

      mViewModel.deviceId.observe(getViewLifecycleOwner(), new Observer<String>() {
          @Override
          public void onChanged(String s) {
              mViewModel.myKey();
          }
      });

      mViewModel.phone.observe(getViewLifecycleOwner(), new Observer<String>() {
          @Override
          public void onChanged(String s) {
              mViewModel.myKey();
          }
      });
    }
}