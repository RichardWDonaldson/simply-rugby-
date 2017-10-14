package model;

import java.io.Serializable;

/**
 * Created by Richard on 10/05/2017.
 */
/**
 * @author Richard
 *
 */
public class Admin extends Member implements Serializable {

	private static final long serialVersionUID = 7317335681345467035L;
private int AdminID;
private static String username;
private static String password;
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
 * @param adminID
 * @param username
 * @param password
 * @param squadID
 */
public Admin(String memberID, String firstName, String surname, String DOB, String address, String postcode, String sruID, String telNo, String mobNo, String emaill, int adminID, String username, String password, int squadID) {
        super(memberID, firstName, surname, DOB, address, postcode, sruID, telNo, mobNo, emaill);
        AdminID = adminID;
        Admin.username = username;
        Admin.password = password;
    }
    
    /**
     * @param firstName
     * @param username
     * @param password
     */
    public Admin(String firstName, String username, String password) {
    	super(firstName);
    	Admin.username = username;
    	Admin.password = password;
    }
    
    
    
    
    

    public int getAdminID() {
        return AdminID;
    }

    public void setAdminID(int adminID) {
        AdminID = adminID;
    }

    public static String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        Admin.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        Admin.password = password;
    }



    @Override
    public String toString() {
        return "Admin{" +
                "AdminID=" + AdminID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
