package com.example.maintain.ui.learn;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maintain.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.maintain.R.id.frame_main;

public class LearnAdapter extends RecyclerView.Adapter<LearnAdapter.LearnItemHolder> {

    private List<Learn> allLearns= new ArrayList<>();
    private NavController navController;

    public void setAllLearns( List<Learn> allLearns) {
        this.allLearns= allLearns;
    }

    /**
     * //inflates a View item and returns a new ViewHolder that contains it.
     * // This method is called when the RecyclerView needs a new ViewHolder to represent an item.
     */
    @NonNull
    @Override
    public LearnItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        navController=Navigation.findNavController(parent);
        Log.d("TAG_LOG","====LearnAdapter=navController==========="+navController);
        //使用哪个页面layout
        View viewItem =layoutInflater.inflate(R.layout.cell_learn,parent,false);
        return new LearnItemHolder(viewItem);
    }

    /**
     * 绑定页面UI
     * sets the contents of a View item at a given position in the RecyclerView.
     *     This is called by the RecyclerView, for example, when a new View item scrolls onto the screen.
     */
     @Override
    public void onBindViewHolder(@NonNull LearnItemHolder holder, final int position) {

      //界面关联
       Learn learn= allLearns.get(position);
         Context context = holder.itemView.getContext();
         if(learn.getImage()!=null){
             int identifier = context.getResources().getIdentifier(learn.getImage(), "drawable", context.getApplicationInfo().packageName);
             holder.imageView.setImageResource(identifier);
             holder.textTitle.setText(learn.getTitle());
         }

         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                // final NavController controller = Navigation.findNavController(v);
                 Log.d("TAG_LOG","++++=====position==========="+position);
                 switch (position){
                     case 0:
                         navController.navigate(R.id.action_navigation_learn_to_commonProblemFragment);
                         break;
//                     case 1:
//                         controller.navigate(R.id.action_navigation_me_to_settingFragment);
//                         break;
//                     case 2:
//                         controller.navigate(R.id.action_navigation_me_to_keyFragment);
//                         break;
                     default:
                         break;
                 }
             }
         });
    }

    /**
     * 返回数量
     *  returns the total number of items in the data set held by the adapter.
     */
    @Override
    public int getItemCount() {
        return allLearns!=null?allLearns.size():0;
    }

  static  class LearnItemHolder extends RecyclerView.ViewHolder {

      ImageView imageView;
      TextView textTitle;
        public LearnItemHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.text_title);
            imageView = itemView.findViewById(R.id.image_title);
        }
    }
}
