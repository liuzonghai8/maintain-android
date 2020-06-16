package com.example.maintain.ui.tool;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.maintain.R;
import com.example.maintain.databinding.FragmentCodeBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CodeFragment#} factory method to
 * create an instance of this fragment.
 */
public class CodeFragment extends Fragment {
    public static final String TAB_SELECT = "tab_select:";
    CodeAdapter codeAdapter;
    private CodeViewModel model;
    private FragmentCodeBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       binding= DataBindingUtil.inflate(inflater, R.layout.fragment_code, container, false);
        model= new ViewModelProvider(requireActivity()).get(CodeViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setData(model);
        View view =binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Bundle args = getArguments();
        codeAdapter= new CodeAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerView.setAdapter(codeAdapter);
        codeAdapter.setAllCodes(model.getListCodes().getValue());
        //有变更时更新数据
      //  codeAdapter.notifyDataSetChanged();

        Log.d("TAG_LOG","---args----"+args);
        model.getKeyWord().observe(requireActivity(), new Observer<String>() {
            @Override
            public void onChanged(String key) {
                Log.d("TAG_LOG", "-----model--message-----"+key);
                model.generateData(key,args.getInt(TAB_SELECT));
                //有变更时更新数据
                codeAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}