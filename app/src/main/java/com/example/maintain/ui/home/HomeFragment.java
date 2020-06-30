package com.example.maintain.ui.home;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.maintain.R;
import com.example.maintain.data.AppDatabase;
import com.example.maintain.data.code.Code;
import com.example.maintain.data.code.CodeDao;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;

    AppDatabase database;
    CodeDao codeDao;
    Button butAdd,butClear;
    TextView text;

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
        database=AppDatabase.getDatabase(getContext());
     //   codeDao=database.getCodeDao();
//        mViewModel =new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        butAdd=view.findViewById(R.id.but_add);
        butClear=view.findViewById(R.id.but_clear);
        text=view.findViewById(R.id.text_code);

         butAdd.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });



    }
    void updateUI(){
        List<Code>  codes=codeDao.loadAllCode();
        StringBuilder str= new StringBuilder();
        for (int i=0;i<codes.size();i++){
            Code code =codes.get(i);
            str.append(code.getCodeName()).append("").append(code.getAnalysis());
        }
    }

}