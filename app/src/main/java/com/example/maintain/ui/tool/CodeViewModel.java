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

    public final MutableLiveData<String> keyWord=new MutableLiveData<>();
    public final MutableLiveData<List<Code>> listCodes=new MutableLiveData<>();
    //tabs select position
    public final MutableLiveData<Integer> tabSelect=new MutableLiveData<>();

   private CodeRepository codeRepository;

    public LiveData<List<Code>> getAllCodes() {
        return codeRepository.getAllCodes();
    }


    public CodeViewModel(@NonNull Application application) {
        super(application);
        tabSelect.setValue(0);
        keyWord.setValue("");
        listCodes.setValue(null);
       codeRepository=CodeRepository.getCodeRepository(application);
    }


    //获取数据
    /**
     *获取不同的数据
     * @param string  关键字
     * @param num   选择不同的tab 0 、1 、 2 、3
     */
    public void generateData(String string, int num) {
//        Log.d("TAG_LOG", "--vm-generateData----"+string+" "+num);
        String[] types={"YH","HCM"};
     LiveData<List<Code>> codes = null;
        switch (num) {
            case 0:
                try {
                    codes=codeRepository.getAllCodes();//codeRepository.getCodeWithNameAndType(types[num],string);
                    Log.d("TAG_LOG", "--codeViewModel-generateData----"+codes.toString());
                }catch (Exception e){
                     Log.d("TAG_LOG", "--codeViewModel-generateData Error---"+e.toString());
                }

               // Log.d("TAG_LOG", "--vm-generateData----"+codeRepository.getAllCode());
               listCodes.setValue(codes.getValue());
                break;
            case 1:

                break;

            default:

                listCodes.setValue(null);
                break;
        }
    }


}
