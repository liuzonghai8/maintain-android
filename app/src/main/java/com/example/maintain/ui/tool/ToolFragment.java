package com.example.maintain.ui.tool;

import androidx.lifecycle.ViewModel;
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
import android.widget.Toast;

import com.example.maintain.R;
import com.example.maintain.basic.BasicFragment;
import com.example.maintain.databinding.FragmentCodeBinding;
import com.example.maintain.databinding.FragmentToolBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ToolFragment extends BasicFragment {
    private ToolAdapter toolAdapter;
    private FragmentToolBinding binding;
    private String[] tabsTitle = {"YH", "3260", "ATM响应码", "ATM响应码"};
    public static final String TAB_SELECT_Tool = "TAB_SELECT_Tool";

    public static ToolFragment newInstance() {
        return new ToolFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentToolBinding.inflate(inflater, container, false);
        toolAdapter = new ToolAdapter(this);
        final TabLayout tabs = binding.tabs;
        final ViewPager2 pager = binding.pager;
        pager.setAdapter(toolAdapter);

        //设置标题 TabLayout传递
        new TabLayoutMediator(tabs, pager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                //在界面创建的时候设置title
                tab.setText(tabsTitle[position]);
                Log.d(TAG_LOG, "=====key =====");
            }
        }).attach();

        //选项卡选择监听
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d(TAG_LOG,"===tab selected===="+tab.getPosition());
                Bundle tabPosition = new Bundle();
                // Our object is just an integer :-P
                tabPosition.putInt(ToolFragment.TAB_SELECT_Tool, tab.getPosition());
                getParentFragmentManager().setFragmentResult("requestKey",tabPosition);
                Log.d(TAG_LOG,"===tab selected= tabPosition==="+tabPosition);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Log.d(TAG_LOG,"===tab unselected====");
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.d(TAG_LOG,"===tab Reselected====");
            }
        });



        return binding.getRoot();

    }



}