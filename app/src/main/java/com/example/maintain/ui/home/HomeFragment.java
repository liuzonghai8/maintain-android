package com.example.maintain.ui.home;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.maintain.R;
import com.example.maintain.data.AppDatabase;
import com.example.maintain.data.code.Code;
import com.example.maintain.data.code.CodeDao;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    Button butAdd,butClear;
    TextView textCode;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       mViewModel =new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        butAdd=view.findViewById(R.id.but_add);
        butClear=view.findViewById(R.id.but_clear);
        textCode =view.findViewById(R.id.text_code);

        //观察
       mViewModel.getAllCodes().observe(getViewLifecycleOwner(), new Observer<List<Code>>() {
            @Override
            public void onChanged(List<Code> codes) {
                StringBuilder str= new StringBuilder();
                for (int i=0;i<codes.size();i++){
                    Code code =codes.get(i);
                    str.append(" name: ").append(code.getCodeName()).append(" advise ").append(code.getAnalysis()).append("  ").append("\n");
                }
                textCode.setText(str);
            }
        });

         butAdd.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Code code = new Code();
                 code.setCodeName("0000");
                 code.setAnalysis("正常");
                 code.setAdvise("not analysis");
                 code.setDeviceType("YH");
//                 codeDao.saveCode(code);
                 //new InsertAsyncTask(codeDao).execute(code);
                 mViewModel.addCode(code);
             }
         });

         butClear.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
//                 codeDao.deleteAll();
                // new DeleteAllAsyncTask(codeDao).execute();
                 mViewModel.deleteAllCode();
             }
         });



    }



}