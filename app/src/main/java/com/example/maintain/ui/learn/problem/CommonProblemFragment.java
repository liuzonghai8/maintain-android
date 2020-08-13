package com.example.maintain.ui.learn.problem;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maintain.R;
import com.example.maintain.basic.BasicFragment;
import com.example.maintain.databinding.FragmentCodeBinding;
import com.example.maintain.databinding.FragmentCommonProblemBinding;
import com.example.maintain.databinding.FragmentCommonProblemBindingImpl;
import com.example.maintain.ui.tool.CodeAdapter;
import com.example.maintain.ui.tool.CodeViewModel;

public class CommonProblemFragment extends BasicFragment {

    private CommonProblemViewModel model;
    private FragmentCommonProblemBinding binding;
    ProblemAdapter problemAdapter;

    public static CommonProblemFragment newInstance() {
        return new CommonProblemFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding= FragmentCommonProblemBinding.inflate(inflater, container, false);
        model= new ViewModelProvider(requireActivity()).get(CommonProblemViewModel.class);
        binding.setData(model);
        binding.setLifecycleOwner(this);
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        problemAdapter= new ProblemAdapter();
        binding.recyler.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyler.setAdapter(problemAdapter);
//        codeAdapter.setAllCodes(model.listCodes());
        //有变更时更新数据


//        // 输入变化
        model.keyWord.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                //根据关键字查找数据
                Log.d(TAG_LOG,"---CodeFragment   model.keyWord.observe--输入变化更新数据--");
                //设置数据
                problemAdapter.setAllProblems(model.searchProblems.getValue());
                problemAdapter.notifyDataSetChanged();
                Log.d(TAG_LOG,"---CodeFragment  model.getAllCodes().observe--数据变化更新视图--");
            }
        });
    }
}