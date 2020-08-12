package com.example.maintain.ui.me;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maintain.R;
import com.example.maintain.databinding.CellMeBinding;

import java.util.ArrayList;
import java.util.List;

import static com.example.maintain.R.id.frame_main;

//RecyclerView.Adapter<MeAdapter.MeItemHolder>
//<MeAdapter.MeItemHolder>?
class MeAdapter extends RecyclerView.Adapter<MeAdapter.MeItemHolder>  {

//class MeAdapter extends ListAdapter<Me,MeAdapter.MeItemHolder> {
    List<Me> allMes = new ArrayList<>();
//
//    protected MeAdapter(@NonNull DiffUtil.ItemCallback<Me> diffCallback) {
//        super(diffCallback);
//    }

    public void setAllMes(List<Me> allMes) {
        this.allMes = allMes;
    }

    @NonNull
    @Override
    public MeAdapter.MeItemHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());

        //使用哪个页面layout
        View viewItem =layoutInflater.inflate(R.layout.cell_me,parent,false);
        return new MeAdapter.MeItemHolder(viewItem);

    }

    @Override
    public void onBindViewHolder(@NonNull final MeAdapter.MeItemHolder holder, final int position) {
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
                //主导航
               final NavController mainNavController = Navigation.findNavController(v);
              // final NavController mainNav = Navigation.findNavController(v.getRootView());
              //  Log.d("TAG_LOG","++++=====position===v.getRootView()========"+v.getRootView()+"  -  -mainNav: ---- "+mainNav+" ==== mainNavController===="+mainNavController);
                switch (position){
                    case 0:
                        mainNavController.navigate(R.id.action_navigation_me_to_feedBackFragment);
                        break;
                    case 1:
                        mainNavController.navigate(R.id.action_navigation_me_to_settingFragment);
                        break;
                    case 2:
//                        mainNav.navigate(R.id.action_navigation_me_to_aboutFragment);
                        mainNavController.navigate(R.id.action_navigation_me_to_keyFragment);
                        break;
                    default:
                        break;
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return allMes!=null?allMes.size():0;
    }

    //内部类
    static  class MeItemHolder extends RecyclerView.ViewHolder {
        private CellMeBinding cellMeBinding;

        ImageView imageView;
        TextView textTitle;
        public MeItemHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.text_title);
            imageView = itemView.findViewById(R.id.image_title);
        }
    }
}
