package com.ciaocollect.ioportfolio.ui.skill;

public class Skill {
    private String name;
    private String description;

    Skill(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    String getDescription() {
        return description;
    }
}
