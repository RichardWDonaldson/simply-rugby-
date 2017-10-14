package model;

import java.io.Serializable;

/**
 * Created by Richard on 10/05/2017.
 */

/**
 * @author Richard
 *
 */
/**
 * @author Richard
 *
 */
public class Member implements Serializable {
	private static final long serialVersionUID = 370082071009586918L;
	private String memberID;
    private String firstName;
    private String surname;

	private String DOB;
    private String Address;
    private String postcode;
    private String sruID;
    private String telNo;
    private String mobNo;
    private String emaill;
  
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
     */
    public Member(String memberID, String firstName, String surname, String DOB, String address, String postcode, String sruID, String telNo, String mobNo, String emaill) {
        this.memberID = memberID;
        this.firstName = firstName;
        this.surname = surname;
        this.DOB = DOB;
        Address = address;
        this.postcode = postcode;
        this.sruID = sruID;
        this.telNo = telNo;
        this.mobNo = mobNo;
        this.emaill = emaill;
    }


	public Member(String firstName) {
		this.firstName = firstName;
	}


	public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public void setDOB(String DOB) {
    	this.DOB = DOB;
    }
    
    public String getDOB() {
    	return DOB;
    }
    
    

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getSruID() {
        return sruID;
    }

    public void setSruID(String sruID) {
        this.sruID = sruID;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    public String getEmaill() {
        return emaill;
    }

    public void setEmaill(String emaill) {
        this.emaill = emaill;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        
    	String s = firstName + " " + surname;

    	
    	
    	return s;
    }


	


	


	



}


