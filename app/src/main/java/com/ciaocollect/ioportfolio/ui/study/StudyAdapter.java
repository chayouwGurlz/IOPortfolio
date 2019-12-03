package com.ciaocollect.ioportfolio.ui.study;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ciaocollect.ioportfolio.R;

import java.util.ArrayList;

public class StudyAdapter extends RecyclerView.Adapter<StudyAdapter.CardViewHolder> {
    private Context context;
    private ArrayList<Study> listStudy;

    public StudyAdapter(ArrayList<Study> list) {
        this.listStudy = list;
    }

    public ArrayList<Study> getListStudy() {
        return listStudy;
    }

    public void setListStudy(ArrayList<Study> listStudy) {
        this.listStudy = listStudy;
    }

    public StudyAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public StudyAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_study, viewGroup, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final StudyAdapter.CardViewHolder holder, int position) {
        Study s = getListStudy().get(position);
        holder.tvTitle.setText(s.getTitle());
        holder.tvDesc.setText(s.getDescription());
        holder.tvYear.setText(s.getYear());
    }

    @Override
    public int getItemCount() {
        return getListStudy().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDesc, tvYear;
        CardViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.study_title);
            tvDesc = itemView.findViewById(R.id.study_desc);
            tvYear = itemView.findViewById(R.id.study_year);
        }
    }
}
