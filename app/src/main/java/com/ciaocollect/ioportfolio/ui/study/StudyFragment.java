package com.ciaocollect.ioportfolio.ui.study;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ciaocollect.ioportfolio.R;

public class StudyFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        StudyViewModel studyViewModel = ViewModelProviders.of(this).get(StudyViewModel.class);
        View root = inflater.inflate(R.layout.fragment_study, container, false);

        RecyclerView rvStudy;
        rvStudy = root.findViewById(R.id.study_scrollView);
        rvStudy.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager;
        linearLayoutManager = new LinearLayoutManager(getContext());
        rvStudy.setLayoutManager(linearLayoutManager);
        StudyAdapter studyAdapter = new StudyAdapter(getContext());

        studyViewModel.getListSkill().observe(this, studies -> {
            studyAdapter.setListStudy(studies);
            rvStudy.setAdapter(studyAdapter);
        });

        return root;
    }
}