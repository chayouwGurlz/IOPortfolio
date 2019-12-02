package com.ciaocollect.ioportfolio.ui.skill;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ciaocollect.ioportfolio.R;

import java.util.ArrayList;

public class SkillViewModel extends AndroidViewModel {
    ArrayList<Skill> skills = new ArrayList<>();
    private MutableLiveData<ArrayList<Skill>> listSkill = new MutableLiveData<>();
    public LiveData<ArrayList<Skill>> getListSkill() { return listSkill; }
    private String[] name;
    private String[] description;

    public SkillViewModel(Application context) {
        super(context);

        name = context.getResources().getStringArray(R.array.skill_title);
        description = context.getResources().getStringArray(R.array.skill_description);

        for(int i=0; i<name.length; i++){
            Skill skill = new Skill(name[i], description[i]);
            skills.add(skill);
        }
        listSkill.postValue(skills);
    }
}
