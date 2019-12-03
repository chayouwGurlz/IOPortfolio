package com.ciaocollect.ioportfolio.ui.skill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ciaocollect.ioportfolio.R;

import java.util.ArrayList;
import java.util.List;

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.SkillVH> {
    private List<Skill> skill;

    SkillAdapter(Context context, ArrayList<Skill> skills) {
        skill = skills;
    }

    @NonNull
    @Override
    public SkillAdapter.SkillVH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_skill, parent, false);
        return new SkillAdapter.SkillVH(view);
    }

    @Override
    public void onBindViewHolder(SkillVH holder, int position) {
        Skill skills = skill.get(position);
        holder.mName.setText(skills.getName());
        holder.mDescription.setText(skills.getDescription());
    }

    @Override
    public int getItemCount() {
        return skill == null ? 0:skill.size();
    }

    static class SkillVH extends RecyclerView.ViewHolder{
        private TextView mName;
        private TextView mDescription;

        SkillVH(View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.skill_subhead);
            mDescription = itemView.findViewById(R.id.skill_desc);
        }
    }
}
