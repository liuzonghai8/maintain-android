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

    List<Code> allCodes = new ArrayList<Code>();

    public void setAllCodes(List<Code> allCodes) {
        this.allCodes = allCodes;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View viewItem =layoutInflater.inflate(R.layout.cell_code,parent,false);
        return new MyHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Code code = allCodes.get(position);
        holder.textViewId.setText(String.valueOf(code.getId()));
        holder.textViewCode.setText("故障码"+code.getCodeName());
        holder.textViewAdvise.setText("建  议："+code.getAdvise());
        holder.textViewAnalysis.setText("解  析"+code.getAnalysis());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView textViewId, textViewCode, textViewAnalysis, textViewAdvise;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.text_id);
            textViewCode = itemView.findViewById(R.id.text_code);
            textViewAnalysis = itemView.findViewById(R.id.text_analysis);
            textViewAdvise = itemView.findViewById(R.id.text_advise);
            ;
        }
    }
}
