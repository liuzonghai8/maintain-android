package com.example.maintain.ui.tool;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.maintain.data.code.Code;
import com.example.maintain.data.code.CodeRepository;

import java.util.List;

public class CodeViewModel extends AndroidViewModel {

    //关键字keyword
    public final MutableLiveData<String> keyWord=new MutableLiveData<>();
    //tabs select position
    public final MutableLiveData<Integer> tabSelect=new MutableLiveData<>();
    //数据
    public LiveData<List<Code>> searchCodes=new MutableLiveData<>();

   private CodeRepository codeRepository;
  private   String[] types={"YH6040W","NDT3260","ATM&CRS","ITM"};



    public CodeViewModel(@NonNull Application application) {
        super(application);
        tabSelect.setValue(0);
        keyWord.setValue("");
       codeRepository=CodeRepository.getCodeRepository(application);
      // searchCodes=codeRepository.getSearchCodes("",keyWord.getValue());
    }

    public List<Code> getAllCodes() {
        Log.d("TAG_LOG", "--CodeViewModel-getAllCodes---tab:-"+tabSelect.getValue()+" keyword: "+keyWord.getValue());
        return codeRepository.getSearchCodes(types[tabSelect.getValue()],keyWord.getValue());
    }

//    public LiveData<List<Code>> getSearchCodes(String type,String search) {
//        return codeRepository.getSearchCodes(type,search);//.getAllCodes();
//    }


}
