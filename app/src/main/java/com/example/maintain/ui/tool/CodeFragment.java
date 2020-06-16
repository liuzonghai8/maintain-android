package com.example.maintain.ui.tool;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.maintain.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CodeFragment#} factory method to
 * create an instance of this fragment.
 */
public class CodeFragment extends Fragment {
    public static final String ARG_OBJECT = "ARGS:";
    CodeAdapter codeAdapter;
    RecyclerView recyclerView;

    private List<Code> codes=new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_code, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle args = getArguments();
        Log.d("TAG_LOG","---args----"+args);
        switch (args.getInt(ARG_OBJECT)){
            case 1:
                for(int i=0;i<100;i++){
                    Code code=new Code(i,"YH0"+i,"YH正常"+i,"not个梵蒂冈刚电饭锅电饭锅电饭锅发鬼地方个地方官的非官方个地方官复古风格森岛帆高发鬼地方个梵蒂冈复古风格是大风刮过 advise"+i);
                    codes.add(code);}
            case 2:
                for(int i=0;i<100;i++){
                    Code code=new Code(i,"HCM000"+i,"HCM正常"+i,"not advise"+i);
                    codes.add(code);}
            default:
                for(int i=0;i<100;i++){
                    Code code=new Code(i,"其它 000"+i,"其它 正常"+i,"not advise"+i);
                    codes.add(code);}
        }
        recyclerView=view.findViewById(R.id.recyclerView);
        codeAdapter= new CodeAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(codeAdapter);
        codeAdapter.setAllCodes(codes);
        //有变更时更新数据
        codeAdapter.notifyDataSetChanged();



    }
}