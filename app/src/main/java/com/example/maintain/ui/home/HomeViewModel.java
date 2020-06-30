package com.example.maintain.ui.home;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.maintain.data.AppDatabase;
import com.example.maintain.data.code.Code;
import com.example.maintain.data.code.CodeDao;
import com.example.maintain.data.code.CodeRepository;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel
    CodeRepository codeRepository;
//  LiveData<List<Code>> allCodes;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        codeRepository=CodeRepository.getCodeRepository(application);
    }

    public LiveData<List<Code>> getAllCodes() {
        return codeRepository.getAllCodes();
    }

    void addCode(Code...codes){
        codeRepository.addCode(codes);
    }

    void deleteAllCode(){
        codeRepository.deleteAllCode();
    }




}