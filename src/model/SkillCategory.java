package model;

import java.io.Serializable;

import controller.TwoDimArrayList;


/**
 * @author Richard
 *
 */
public class SkillCategory implements Serializable {
	private static final long serialVersionUID = 7552332635400913819L;
	private int skillCategory;
    private String categoryComment;
    private TwoDimArrayList<Skill> skills = new TwoDimArrayList<Skill>();

    public SkillCategory(int skillCategory) {
        this.skillCategory = skillCategory;
    }

    public int getSkillCategory() {
        return skillCategory;
    }

    public void setSkillCategory(int skillCategory) {
        this.skillCategory = skillCategory;
    }

    public String getCategoryComment() {
        return categoryComment;
    }

    public void setCategoryComment(String categoryComment) {
        this.categoryComment = categoryComment;
    }

    public TwoDimArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(TwoDimArrayList<Skill> skills) {
        this.skills = skills;
    }
}
