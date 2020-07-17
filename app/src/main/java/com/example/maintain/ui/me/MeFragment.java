package com.example.maintain.ui.me;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.maintain.databinding.FragmentMeBinding;

import java.util.ArrayList;
import java.util.List;

public class MeFragment extends Fragment {

    private FragmentMeBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding=FragmentMeBinding.inflate(inflater,container,false);
        binding.setLifecycleOwner(this);
        return  binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MeAdapter meAdapter=new MeAdapter();
        binding.recyclerMe.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerMe.setAdapter(meAdapter);
        List<Me> meList=new ArrayList<>();
        String[] arr={"意见反馈","设置","key"};
        String[] imageArr={"ic_message_24","ic_settings_24","ic_key_24"};
        for(int i=0;i<3;i++){
            Me me = new Me();
            me.setTitle(arr[i]);
            me.setImage(imageArr[i]);
            meList.add(me);
        }

        meAdapter.setAllMes(meList);
        meAdapter.notifyDataSetChanged();


    }
}