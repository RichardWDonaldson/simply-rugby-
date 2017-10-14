package model;

import java.io.Serializable;

/**
 * Created by Richard on 10/05/2017.
 */
/**
 * @author Richard
 *
 */
public class Skill implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1104967066738222798L;

	private int skillID;
    private int skill;
    private int skillLevel;
    private String skillComment;
    private String dateAchieved;
   
    /**
     * @param skillID
     * @param skill
     * @param skillLevel
     * @param skillComment
     * @param dateAchieved
     */
    public Skill(int skillID, int skill, int skillLevel, String skillComment, String dateAchieved) {
        this.skillID = skillID;
        this.skill = skill;
        this.skillLevel = skillLevel;
        this.skillComment = skillComment;
        this.dateAchieved = dateAchieved;
    }

    public int getSkillID() {
        return skillID;
    }

    public void setSkillID(int skillID) {
        this.skillID = skillID;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public String getSkillComment() {
        return skillComment;
    }

    public void setSkillComment(String skillComment) {
        this.skillComment = skillComment;
    }

    public String getDateAchieved() {
        return dateAchieved;
    }

    public void setDateAchieved(String dateAchieved) {
        this.dateAchieved = dateAchieved;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Skill{" +
                "skillID=" + skillID +
                ", skill=" + skill +
                ", skillLevel=" + skillLevel +
                ", skillComment='" + skillComment + '\'' +
                ", dateAchieved='" + dateAchieved + '\'' +
                '}';
    }
}
