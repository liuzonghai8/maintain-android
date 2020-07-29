package com.example.maintain.ui.learn;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maintain.R;
import com.example.maintain.databinding.FragmentLearnBinding;

import java.util.ArrayList;
import java.util.List;

public class LearnFragment extends Fragment {

    private FragmentLearnBinding binding;
    private LearnViewModel mViewModel;

    public static LearnFragment newInstance() {
        return new LearnFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding=FragmentLearnBinding.inflate(inflater,container,false);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LearnAdapter learnAdapter = new LearnAdapter();
        RecyclerView recycler = binding.recyclerView;
        recycler.setLayoutManager(new GridLayoutManager(requireContext(),3));
       recycler.setAdapter(learnAdapter);
        List<Learn> learns = new ArrayList<>();
        String[] arr={"常见问题","系统安装","测试工具","传感器","日志路径","日志说明","意见反馈","设置","key"};
        String[] imageArr={"ic_message_24","ic_settings_24","ic_key_24","ic_message_24","ic_settings_24","ic_key_24","ic_message_24","ic_settings_24","ic_key_24"};
        for(int i=0;i<arr.length;i++){
           Learn learn = new Learn();
            learn.setTitle(arr[i]);
            learn.setImage(imageArr[i]);
            learns.add(learn);
        }


        learnAdapter.setAllLearns(learns);
        learnAdapter.notifyDataSetChanged();
    }
}