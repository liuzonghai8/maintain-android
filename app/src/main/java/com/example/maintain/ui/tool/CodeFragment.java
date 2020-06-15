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
        Code code=new Code(0,"0000","正常","not advise");
        codes.add(code);

        recyclerView=view.findViewById(R.id.recyclerView);
        codeAdapter= new CodeAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(codeAdapter);
        codeAdapter.setAllCodes(codes);
        codeAdapter.notifyDataSetChanged();

         Bundle args = getArguments();
        Log.d("TAG_LOG","---args----"+args);

    }
}