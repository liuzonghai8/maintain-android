package com.example.maintain.ui.tool;

import android.app.TaskStackBuilder;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
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
import android.widget.TabHost;
import android.widget.TextView;

import com.example.maintain.R;
import com.example.maintain.basic.BasicFragment;
import com.example.maintain.databinding.FragmentCodeBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CodeFragment#} factory method to
 * create an instance of this fragment.
 */
public class CodeFragment extends BasicFragment {
    public static final String TAB_SELECT = "tab_select:";
    CodeAdapter codeAdapter;
    private CodeViewModel model;
    private FragmentCodeBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
                // We use a String here, but any type that can be put in a Bundle is supported
                //    result = bundle.getString("bundleKey");
//                args=bundle;
                int tab_select_tool = bundle.getInt("TAB_SELECT_Tool");
//                tabSelect = tab_select_tool;
                // Do something with the result...
                Log.d(TAG_LOG,"---CodeFragment onFragmentResult----"+tab_select_tool);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      // binding= DataBindingUtil.inflate(inflater, R.layout.fragment_code, container, false);
       binding= FragmentCodeBinding.inflate(inflater, container, false);
        model= new ViewModelProvider(requireActivity()).get(CodeViewModel.class);
        binding.setData(model);
        binding.setLifecycleOwner(this);
        return  binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        final Bundle args = getArguments();
//        Log.d(TAG_LOG,"--CodeFragment -args----"+args);
        codeAdapter= new CodeAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerView.setAdapter(codeAdapter);
        codeAdapter.setAllCodes(model.getListCodes().getValue());
        //有变更时更新数据
        //codeAdapter.notifyDataSetChanged();
        //监听父Fragment的改变
        final Bundle args;
        int tabSelect=0;


        //keyword 监控
        subscribeKey(tabSelect);
        //列表数据的监控
        subscribeUi();

    }

    private void subscribeUi(){
        model.getListCodes().observe(getViewLifecycleOwner(), new Observer<List<Code2>>() {
            @Override
            public void onChanged(List<Code2> code2s) {
                //设置数据
                codeAdapter.setAllCodes(model.getListCodes().getValue());
                codeAdapter.notifyDataSetChanged();
            }
        });
    }

    private void subscribeKey(final int num){
        model.getKeyWord().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String key) {
                Log.d(TAG_LOG,"---CodeFragment--model.getKeyWord().observe key-----"+key);
                Log.d(TAG_LOG,"---CodeFragment--model.getKeyWord().observe -----"+num);
                //根据关键字查找数据
                model.generateData(key,num);
            }
        });
    }
}