package com.ciaocollect.ioportfolio.ui.study;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ciaocollect.ioportfolio.R;

import java.util.ArrayList;

public class StudyFragment extends Fragment {

    private StudyViewModel studyViewModel;
    private RecyclerView rvStudy;
    private ArrayList<Study> listStudy;
    private String[] dataTitle;
    private String[] dataDesc;
    private String[] dataYear;
    LinearLayoutManager linearLayoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        studyViewModel =
                ViewModelProviders.of(this).get(StudyViewModel.class);
        View root = inflater.inflate(R.layout.fragment_study, container, false);
        rvStudy = root.findViewById(R.id.study_scrollView);
        rvStudy.setHasFixedSize(true);

        dataTitle = getResources().getStringArray(R.array.study_title);
        dataDesc = getResources().getStringArray(R.array.study_description);
        dataYear = getResources().getStringArray(R.array.study_year);

        listStudy = new ArrayList<>();
        for (int i=0; i<dataTitle.length; i++){
            Study study = new Study();
            study.setTitle(dataTitle[i]);
            study.setDescription(dataDesc[i]);
            study.setYear(dataYear[i]);
            listStudy.add(study);
        }

        linearLayoutManager = new LinearLayoutManager(getContext());
        rvStudy.setLayoutManager(linearLayoutManager);
        StudyAdapter studyAdapter = new StudyAdapter(getContext());
        studyAdapter.setListStudy(listStudy);
        rvStudy.setAdapter(studyAdapter);
        /*final TextView textView = root.findViewById(R.id.text_home);
        studyViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }
}