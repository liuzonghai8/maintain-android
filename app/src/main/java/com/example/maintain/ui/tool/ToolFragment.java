package com.example.maintain.ui.tool;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maintain.R;
import com.example.maintain.basic.BasicFragment;
import com.example.maintain.databinding.FragmentCodeBinding;
import com.example.maintain.databinding.FragmentToolBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ToolFragment extends BasicFragment {
    ToolAdapter toolAdapter;
    FragmentToolBinding binding;
    private  String[]  tabsTitle={"YH","3260","ATM响应码","ATM响应码"};

    public static ToolFragment newInstance() {
        return new ToolFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding= FragmentToolBinding.inflate(inflater, container, false);
        toolAdapter = new ToolAdapter(this);
        TabLayout tabs= binding.tabs;
        ViewPager2 pager=binding.pager;
        pager.setAdapter(toolAdapter);

        //设置标题
        new TabLayoutMediator(tabs, pager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                //在界面创建的时候设置title
                tab.setText(tabsTitle[position]);
            }
        }).attach();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}