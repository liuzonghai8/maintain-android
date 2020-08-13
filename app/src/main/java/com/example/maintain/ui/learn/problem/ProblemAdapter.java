package com.example.maintain.ui.learn.problem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maintain.R;
import com.example.maintain.data.code.Code;
import com.example.maintain.data.problem.Problem;

import java.util.ArrayList;
import java.util.List;

public class ProblemAdapter extends RecyclerView.Adapter<ProblemAdapter.ProblemItemHolder> {

  private   List<Problem> allProblems = new ArrayList<>();

    public void setAllProblems(List<Problem> allProblems) {
        this.allProblems = allProblems;
    }

    /**
     * //inflates a View item and returns a new ViewHolder that contains it.
     * // This method is called when the RecyclerView needs a new ViewHolder to represent an item.
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ProblemItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        //使用哪个页面layout
        View viewItem =layoutInflater.inflate(R.layout.cell_problem,parent,false);
        return new ProblemItemHolder(viewItem);
    }

    /**
     * 绑定页面UI
     * sets the contents of a View item at a given position in the RecyclerView.
     *     This is called by the RecyclerView, for example, when a new View item scrolls onto the screen.
     */
     @Override
    public void onBindViewHolder(@NonNull ProblemItemHolder holder, int position) {
        Problem problem  = allProblems.get(position);
        holder.textViewId.setText(String.valueOf(position));
        holder.textViewProblem.setText("问题: "+problem.getProblemName());
        holder.textViewAdvise.setText("建议："+problem.getAdvise());
        holder.textViewType.setText("类型: "+problem.getProblemType());
    }

    /**
     * 返回数量
     *  returns the total number of items in the data set held by the adapter.
     */
    @Override
    public int getItemCount() {
        return allProblems!=null?allProblems.size():0;
    }

  static  class ProblemItemHolder extends RecyclerView.ViewHolder {

        TextView textViewId, textViewProblem, textViewType, textViewAdvise;
        public ProblemItemHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.text_id);
            textViewProblem = itemView.findViewById(R.id.text_ploblem);
            textViewType = itemView.findViewById(R.id.text_type);
            textViewAdvise = itemView.findViewById(R.id.text_advise);
        }
    }
}
