package com.ciaocollect.ioportfolio.ui.skill;

import java.util.ArrayList;
import java.util.List;

public class Skill {
    private String name;
    private String description;

    public Skill(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static List<Skill> prepareSkill(String[] name, String[] description){
        List<Skill> skills = new ArrayList<>(name.length);

        for(int i=0; i<name.length; i++){
            Skill skill = new Skill(name[i], description[i]);
            skills.add(skill);
        }
        return skills;
    }
}
