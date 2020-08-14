package com.example.maintain.ui.learn.problem;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maintain.basic.BasicFragment;
import com.example.maintain.data.problem.Problem;
import com.example.maintain.databinding.FragmentCommonProblemBinding;

import java.util.ArrayList;
import java.util.List;

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
//        List<Problem> problems = new ArrayList<>();

        //test
//        for (int i=0;i<10;i++){
//            Problem problem = new Problem();
//            problem.setAdvise(i+"advise");
//            problem.setId(i);
//            problem.setProblemName("name+"+i);
//            problem.setProblemType(i);
//            problems.add(problem);
//        }
//
//        problemAdapter.setAllProblems(problems);
//        problemAdapter.notifyDataSetChanged();
        //有变更时更新数据


//        // 输入变化
        model.keyWord.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                //根据关键字查找数据
                Log.d(TAG_LOG,"---problemFragment   model.keyWord.observe--输入变化更新数据--");
                //设置数据
                problemAdapter.setAllProblems(model.getProblems());
                problemAdapter.notifyDataSetChanged();
                Log.d(TAG_LOG,"---problemFragment  model.getAllCodes().observe--数据变化更新视图--");
            }
        });
    }
}