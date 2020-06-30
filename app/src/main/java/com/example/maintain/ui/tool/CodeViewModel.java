package com.example.maintain.ui.tool;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.maintain.data.AppDatabase;
import com.example.maintain.data.code.Code;
import com.example.maintain.data.code.CodeDao;
import com.example.maintain.data.code.CodeRepository;

import java.util.ArrayList;
import java.util.List;

public class CodeViewModel extends AndroidViewModel {

    public final MutableLiveData<String> keyWord=new MutableLiveData<>();
    public final MutableLiveData<List<Code>> listCodes=new MutableLiveData<>();
    //tabs select position
    public final MutableLiveData<Integer> tabSelect=new MutableLiveData<>();

    CodeRepository codeRepository;



    public CodeViewModel(@NonNull Application application) {
        super(application);
        tabSelect.setValue(0);
        keyWord.setValue("");
        listCodes.setValue(null);
        codeRepository=CodeRepository.getCodeRepository();
       // addCode();
    }


    void addCode(){
        Code code=new Code();
        code.setCodeName("0000");
        code.setAnalysis("正常");
        code.setAnalysis("not analysis");
        code.setDeviceType("YH");

        codeRepository.addCode(code);
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
        List<Code> codes = null;
        switch (num) {
            case 0:
                try {
                    codes=codeRepository.getAllCode();//codeRepository.getCodeWithNameAndType(types[num],string);
                    Log.d("TAG_LOG", "--codeViewModel-generateData----"+codes.toString());
                }catch (Exception e){
                     Log.d("TAG_LOG", "--codeViewModel-generateData Error---"+e.toString());
                }

               // Log.d("TAG_LOG", "--vm-generateData----"+codeRepository.getAllCode());
               listCodes.setValue(codes);
                break;
            case 1:

                break;

            default:

                listCodes.setValue(null);
                break;
        }
    }

}
