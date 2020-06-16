package com.example.maintain.ui.tool;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maintain.R;

import java.util.ArrayList;
import java.util.List;

public class CodeAdapter extends RecyclerView.Adapter<CodeAdapter.MyHolder> {

    List<Code> allCodes = new ArrayList<>();

    public void setAllCodes(List<Code> allCodes) {
        this.allCodes = allCodes;
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
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View viewItem =layoutInflater.inflate(R.layout.cell_code_card,parent,false);
        return new MyHolder(viewItem);
    }

    /**
     * sets the contents of a View item at a given position in the RecyclerView.
     *     This is called by the RecyclerView, for example, when a new View item scrolls onto the screen.
     */
     @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Code code = allCodes.get(position);
        holder.textViewId.setText(String.valueOf(position));
        holder.textViewCode.setText("故障码: "+code.getCodeName());
        holder.textViewAdvise.setText("建  议："+code.getAdvise());
        holder.textViewAnalysis.setText("解  析: "+code.getAnalysis());
    }

    /**
     *  returns the total number of items in the data set held by the adapter.
     */
    @Override
    public int getItemCount() {
        return allCodes.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView textViewId, textViewCode, textViewAnalysis, textViewAdvise;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.text_id);
            textViewCode = itemView.findViewById(R.id.text_code);
            textViewAnalysis = itemView.findViewById(R.id.text_analysis);
            textViewAdvise = itemView.findViewById(R.id.text_advise);
            //this.codeAdapter = codeAdapter;
        }
    }
}
