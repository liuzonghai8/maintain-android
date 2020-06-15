package com.example.maintain.ui.tool;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maintain.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ToolFragment extends Fragment {
    ToolAdapter toolAdapter;
    ViewPager2 viewPager;
    private ToolViewModel mViewModel;
    private  String[]  tabsTitle={"YH","3260","ATM响应码","ATM响应码"};

    public static ToolFragment newInstance() {
        return new ToolFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tool, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ToolViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolAdapter = new ToolAdapter(this);
        viewPager = view.findViewById(R.id.pager);
        viewPager.setAdapter(toolAdapter);

        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        //tab 也标题
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(tabsTitle[position]);
            }
        }).attach();
    }
}