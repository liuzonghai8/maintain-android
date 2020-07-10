package com.example.maintain.ui.me;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maintain.R;
import com.example.maintain.ui.tool.CodeAdapter;

import java.util.ArrayList;
import java.util.List;


class MeAdapter extends RecyclerView.Adapter<MeAdapter.MeItemHolder> {
    List<Me> allMes = new ArrayList<>();

    public void setAllMes(List<Me> allMes) {
        this.allMes = allMes;
    }

    @NonNull
    @Override
    public MeItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        //使用哪个页面layout
        View viewItem =layoutInflater.inflate(R.layout.cell_me,parent,false);
        return new MeAdapter.MeItemHolder(viewItem);

    }

    @Override
    public void onBindViewHolder(@NonNull MeItemHolder holder, int position) {
     // 绑定页面UI
        Me me = allMes.get(position);
        Context context = holder.itemView.getContext();
        if(me!=null){
            int identifier = context.getResources().getIdentifier(me.getImage(), "drawable", context.getApplicationInfo().packageName);
            holder.imageView.setImageResource(identifier);
            holder.textTitle.setText(me.getTitle());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG_LOG","=====onClick======"+v.toString());
                //主导航
//                 NavController mainNavController = Navigation.findNavController(,R.id.nav_main);

            }
        });



    }

    @Override
    public int getItemCount() {
        return allMes!=null?allMes.size():0;
    }

    //内部类
    static  class MeItemHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textTitle;
        public MeItemHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.text_title);
            imageView = itemView.findViewById(R.id.image_title);
        }
    }
}
