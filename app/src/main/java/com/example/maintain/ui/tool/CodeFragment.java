package com.example.maintain.ui.tool;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maintain.basic.BasicFragment;
import com.example.maintain.data.code.Code;
import com.example.maintain.databinding.FragmentCodeBinding;

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
        codeAdapter= new CodeAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerView.setAdapter(codeAdapter);
//        codeAdapter.setAllCodes(model.listCodes());
        //有变更时更新数据


        //codeAdapter.notifyDataSetChanged();
        //监听父Fragment tab select changed
        model.tabSelect.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
               model.keyWord.setValue("");
            }
        });


//        // 输入变化
        model.keyWord.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                //根据关键字查找数据
                Log.d(TAG_LOG,"---CodeFragment   model.keyWord.observe--输入变化更新数据--");
                //设置数据
                codeAdapter.setAllCodes(model.getAllCodes());
                codeAdapter.notifyDataSetChanged();
                Log.d(TAG_LOG,"---CodeFragment  model.getAllCodes().observe--数据变化更新视图--");
            }
        });


    }


}