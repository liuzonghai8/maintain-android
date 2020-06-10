package com.example.maintain.ui.learn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.example.maintain.R;

public class LearnFragment extends Fragment {

    private LearnViewModel model;
    ViewPager viewPager;
    LearnPagerAdapter learnPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable  ViewGroup container,@Nullable Bundle savedInstanceState) {
        model =new ViewModelProvider(requireActivity()).get(LearnViewModel.class);
       return inflater.inflate(R.layout.fragment_learn, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        learnPagerAdapter = new LearnPagerAdapter(getChildFragmentManager());
//        viewPager = view.findViewById(R.id.viewPage2);
//        viewPager.setAdapter(learnPagerAdapter);
    }
}