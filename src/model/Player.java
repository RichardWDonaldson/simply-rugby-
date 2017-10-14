package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Richard on 10/05/2017.
 */
public class Player extends Member implements Serializable {

	private static final long serialVersionUID = -8476193809213813490L;
	private String nextOfKin;
    private String nextOfKinTelNo;
    private String doctor;
    private String doctorTelNo;
    private String healthIssues;
    private static int squadID;
    private String position;
    private ArrayList<SkillCategory> playerSkillCategories = new ArrayList<SkillCategory>();

    /**
     * @param memberID
     * @param firstName
     * @param surname
     * @param DOB
     * @param address
     * @param postcode
     * @param sruID
     * @param telNo
     * @param mobNo
     * @param emaill
     * @param nextOfKin
     * @param nextOfKinTelNo
     * @param doctor
     * @param doctorTelNo
     * @param healthIssues
     * @param squadID
     * @param position
     */
    public Player(String memberID, String firstName, String surname, String DOB, String address, String postcode, String sruID, String telNo, String mobNo, String emaill, String nextOfKin, String nextOfKinTelNo, String doctor, String doctorTelNo, String healthIssues, int squadID, String position) {
        super(memberID, firstName, surname, DOB, address, postcode, sruID, telNo, mobNo, emaill);
        this.nextOfKin = nextOfKin;
        this.nextOfKinTelNo = nextOfKinTelNo;
        this.doctor = doctor;
        this.doctorTelNo = doctorTelNo;
        this.healthIssues = healthIssues;
        Player.squadID = squadID;
        this.position = position;
    }

    public String getNextOfKin() {
        return nextOfKin;
    }

    public void setNextOfKin(String nextOfKin) {
        this.nextOfKin = nextOfKin;
    }

    public String getNextOfKinTelNo() {
        return nextOfKinTelNo;
    }

    public void setNextOfKinTelNo(String nextOfKinTelNo) {
        this.nextOfKinTelNo = nextOfKinTelNo;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDoctorTelNo() {
        return doctorTelNo;
    }

    public void setDoctorTelNo(String doctorTelNo) {
        this.doctorTelNo = doctorTelNo;
    }

    public String getHealthIssues() {
        return healthIssues;
    }

    public void setHealthIssues(String healthIssues) {
        this.healthIssues = healthIssues;
    }

    public static int getSquadID() {
        return squadID;
    }

    public void setSquadID(int squadID) {
        Player.squadID = squadID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    /* (non-Javadoc)
     * @see model.Member#toString()
     */
    @Override
    public String toString() {
      
    	
    	
    	
    	String s = super.toString();
 
    	
    	return s;
    }
    
    
  
    

	public ArrayList<SkillCategory> getPlayerSkillCategories() {
		return playerSkillCategories;
	}

	public void setPlayerSkillCategories(ArrayList<SkillCategory> playerSkillCategories) {
		this.playerSkillCategories = playerSkillCategories;
	}
}
