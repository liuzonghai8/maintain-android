package com.example.maintain.ui.tool;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class CodeViewModel extends ViewModel {
    public CodeViewModel() {
    }

    private MutableLiveData<String> keyWord;
    private MutableLiveData<List<Code2>> listCodes;

    public MutableLiveData<List<Code2>> getListCodes() {
        if (listCodes == null) {
            listCodes = new MutableLiveData<List<Code2>>();
        }
        return listCodes;
    }

    public MutableLiveData<String> getKeyWord() {
        if (keyWord == null) {
            keyWord = new MutableLiveData<String>();
        }
        Log.d("TAG_LOG", "--vm-getKeyWord----");
        return keyWord;
    }

//    public void setKeyWord(MutableLiveData<String> keyWord) {
//        Log.d("TAG_LOG", "--vm-setKeyWord----");
//        this.keyWord = keyWord;
//    }

    public void generateData(String string, int num) {
        Log.d("TAG_LOG", "--vm-generateData----"+string+" "+num);
        switch (num) {
            case 1:
                List<Code2> codes1 = new ArrayList<>();
                for (int i = 0; i < 100; i++) {
                    Code2 code = new Code2(i, "YH0" + i, "YH正常" + i, "not个梵蒂冈刚电饭锅电饭锅电饭锅发鬼地方个地方官的非官方个地方官复古风格森岛帆高发鬼地方个梵蒂冈复古风格是大风刮过 advise" + i);
                    codes1.add(code);
                }
                listCodes.setValue(codes1);
                break;
            case 2:
                List<Code2> codes2 = new ArrayList<>();
                for (int i = 0; i < 100; i++) {
                    Code2 code = new Code2(i, "HCM000" + i, "HCM正常" + i, "not advise" + i);
                    codes2.add(code);
                }
                listCodes.setValue(codes2);
                break;
            default:
                List<Code2> codes3 = new ArrayList<>();
                for (int i = 0; i < 100; i++) {
                    Code2 code = new Code2(i, "其它 000" + i, "其它 正常" + i, "not advise" + i);
                    codes3.add(code);
                }
                listCodes.setValue(codes3);
                break;
        }
    }

}
