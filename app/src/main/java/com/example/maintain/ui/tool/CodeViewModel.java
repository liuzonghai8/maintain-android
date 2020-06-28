package com.example.maintain.ui.tool;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.maintain.data.AppDatabase;
import com.example.maintain.data.code.Code;
import com.example.maintain.data.code.CodeDao;

import java.util.ArrayList;
import java.util.List;

public class CodeViewModel extends ViewModel {

    public final MutableLiveData<String> keyWord=new MutableLiveData<>();
    public final MutableLiveData<List<Code>> listCodes=new MutableLiveData<>();

    //tabs select position
    public final MutableLiveData<Integer> tabSelect=new MutableLiveData<>();

    CodeDao codeDao;

    public CodeViewModel(@NonNull Application application) {
        tabSelect.setValue(0);
        keyWord.setValue("");
        listCodes.setValue(null);
        AppDatabase database=AppDatabase.getDatabase(application);
        codeDao=database.getCodeDao();
    }





    //获取数据
    /**
     *获取不同的数据
     * @param string  关键字
     * @param num   选择不同的tab 0 、1 、 2 、3
     */
    public void generateData(String string, int num) {
        Log.d("TAG_LOG", "--vm-generateData----"+string+" "+num);
        switch (num) {
            case 0:
                List<Code> codes=codeDao.loadAllCode();

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
