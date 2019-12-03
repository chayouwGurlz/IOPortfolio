package com.ciaocollect.ioportfolio.ui.study;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ciaocollect.ioportfolio.R;

import java.util.ArrayList;

public class StudyViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Study>> studies = new MutableLiveData<>();
    LiveData<ArrayList<Study>> getListSkill() { return studies; }

    public StudyViewModel(Application context) {
        super(context);

        String[] studyTitle = context.getResources().getStringArray(R.array.study_title);
        String[] studyDesc = context.getResources().getStringArray(R.array.study_description);
        String[] studyYear = context.getResources().getStringArray(R.array.study_year);

        ArrayList<Study> listStudy = new ArrayList<>();
        for (int i=0; i<studyTitle.length; i++){
            Study study = new Study();
            study.setTitle(studyTitle[i]);
            study.setDescription(studyDesc[i]);
            study.setYear(studyYear[i]);
            listStudy.add(study);
        }
        studies.postValue(listStudy);
    }
}