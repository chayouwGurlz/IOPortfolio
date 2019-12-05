package com.ciaocollect.ioportfolio.ui.study;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

    private ArrayList<Study> getListStudy() {
        return listStudy;
    }

    void setListStudy(ArrayList<Study> listStudy) {
        this.listStudy = listStudy;
    }

    StudyAdapter(Context context) {
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
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(s.getLink()));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return getListStudy().size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDesc, tvYear;
        CardViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.study_title);
            tvDesc = itemView.findViewById(R.id.study_desc);
            tvYear = itemView.findViewById(R.id.study_year);
        }
    }
}
