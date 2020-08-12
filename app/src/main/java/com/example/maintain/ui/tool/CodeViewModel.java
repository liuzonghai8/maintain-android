package com.example.maintain.ui.tool;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.maintain.data.code.Code;
import com.example.maintain.data.code.CodeRepository;
import com.example.maintain.utils.EncryptUtil;

import java.util.List;

public class CodeViewModel extends AndroidViewModel {

    //关键字keyword
    public final MutableLiveData<String> keyWord=new MutableLiveData<>();
    //tabs select position
    public final MutableLiveData<Integer> tabSelect=new MutableLiveData<>();
    //数据
    public LiveData<List<Code>> searchCodes=new MutableLiveData<>();

   private CodeRepository codeRepository;



    public CodeViewModel(@NonNull Application application) {
        super(application);
        //
        tabSelect.setValue(0);
        keyWord.setValue("");
       codeRepository=CodeRepository.getCodeRepository(application);
      // searchCodes=codeRepository.getSearchCodes("",keyWord.getValue());
    }

    public List<Code> getAllCodes() {
        Log.d("TAG_LOG", "--CodeViewModel-getAllCodes---tab: "+tabSelect.getValue()+" keyword: "+keyWord.getValue());

        if(TextUtils.isEmpty(keyWord.getValue())){
            return null;
        }
        return codeRepository.getSearchCodes(String.valueOf(tabSelect.getValue()),keyWord.getValue());
    }


}
