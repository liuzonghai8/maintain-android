package com.example.maintain.ui.learn;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.maintain.R;
import com.example.maintain.ui.learn.tools.ToolsFragment;

public class LearnPagerAdapter extends FragmentStatePagerAdapter {

//
//    @StringRes
//    private static final int[] TAB_TITLES = new int[]{R.string.tab_name_1, R.string.tab_name_2};

//    public LearnPagerAdapter(@NonNull FragmentManager fm, int behavior) {
//        super(fm, behavior);
//    }
    public LearnPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }
    @NonNull
    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new ToolsFragment();
        Bundle args = new Bundle();
        // Our object is just an integer :-P
        args.putInt(ToolsFragment.ARG_OBJECT, i + 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 10;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       return "OBJECT " + (position + 1);
    }

}
