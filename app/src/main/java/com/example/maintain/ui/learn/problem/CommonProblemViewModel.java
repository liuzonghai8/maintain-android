package com.example.maintain.ui.learn.problem;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.maintain.data.code.Code;
import com.example.maintain.data.code.CodeRepository;
import com.example.maintain.data.problem.Problem;
import com.example.maintain.data.problem.ProblemRepository;

import java.util.List;

public class CommonProblemViewModel extends AndroidViewModel {
    //关键字keyword
    public final MutableLiveData<String> keyWord=new MutableLiveData<>();

    //数据
    public LiveData<List<Problem>> searchProblems=new MutableLiveData<>();

    private ProblemRepository problemRepository;

    public CommonProblemViewModel(@NonNull Application application) {
        super(application);
        keyWord.setValue("");
        problemRepository=ProblemRepository.getProblemRepository(application);
        searchProblems=problemRepository.getAllProblems();
    }
}