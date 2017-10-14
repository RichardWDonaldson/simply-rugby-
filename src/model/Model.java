package model;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import controller.TwoDimArrayList;

/**
 * @author Richard
 *
 */
public class Model {
	private static TwoDimArrayList<String> skillList = new TwoDimArrayList<String>();
	public static Map<Integer, Member> allMembers = new HashMap<Integer, Member>();
	public static ArrayList<Admin> admins = new ArrayList<Admin>();
	private static Admin currentAdmin;
	
	
	public static void addAdmin(Admin admin) {
		admins.add(admin);
	}
	
	
	public static Map<Integer, Member> getAllMembers() {
		return allMembers;
	}


	public static void setAllMembers(Map<Integer, Member> allMembers) {
		Model.allMembers = allMembers;
	}


	public static ArrayList<Admin> getAdmins() {
		return admins;
	}


	public static void setAdmins(ArrayList<Admin> admins) {
		Model.admins = admins;
	}


	public static Admin getCurrentAdmin() {
		return currentAdmin;
	}


	public static void setCurrentAdmin(Admin currentAdmin) {
		Model.currentAdmin = currentAdmin;
	}
	
	
	public static TwoDimArrayList<String> getSkillList() {
		return skillList;
	}
	
	
	


	/**
	 * @throws IOException
	 */
	public static void prepopulate() throws IOException {
		System.out.println("Running Prepopulation");
		//int memberID, String firstName, String surname, String address, String postcode, String sruID, String telNo, String mobNo, String emaill  String nextOfKin, String nextOfKinTelNo, String doctor, String doctorTelNo, String healthIssues, int squadID, String position
		Member member1 = new Player("1", "Richard", "Donaldson","13/08/1996", "123 Fake St", "KY12 R5T", "A10", "012345679", "0798765432", "email@email.com", "Lorraine", "0123456789", "Dr Strangeglove", "0123456789", "None", 1, "Prop");
		Member member2 = new Player("2", "Keir", "Bell","12/04/1234", "124 Asdaland", "KY12 TES", "CO1", "123456789", "0134687545", "notemail@email.com", "Bob", "686453458", "Dr. Drake", "1234560987", "None", 1, "Scrum Half");
		Member member3 = new Player("3", "Liam", "Neeson","31/12/1996", "Taken Place", "KY11 FBI", "BADA55", "123469485", "4930583", "liamNeeson@doNotMess.com", "Dad", "59305875", "Dr. Dre", "1235463", "None", 2, "Hooker");
		allMembers.put(Integer.valueOf(member1.getMemberID()), member1);
		allMembers.put(Integer.valueOf(member2.getMemberID()), member2);
		allMembers.put(Integer.valueOf(member3.getMemberID()), member3);
		
		//admins.add(admin1);
		 getSkillList().addToInnerArray(0, "Passing");
	     getSkillList().addToInnerArray(0, 1, "Standard");
	     getSkillList().addToInnerArray(0, 2, "Spin");
	     getSkillList().addToInnerArray(0, 3, "Pop");
	     getSkillList().addToInnerArray(1, "Tackling");
	     getSkillList().addToInnerArray(1, 1, "Front");
	     getSkillList().addToInnerArray(1, 2, "Rear");
	     getSkillList().addToInnerArray(1, 3, "Side");
	     getSkillList().addToInnerArray(1, 4, "Scrabble");
	     getSkillList().addToInnerArray(2, 0, "Kicking");
	     getSkillList().addToInnerArray(2, 1, "Drop");
	     getSkillList().addToInnerArray(2, 2, "Punt");
	     getSkillList().addToInnerArray(2, 3, "Grubber");
	     getSkillList().addToInnerArray(2, 4, "Goal");
		
	}


	/**
	 * @param username
	 * @param password
	 * @return
	 */
	public static Admin validateAdminLogin(String username, String password) {
	System.out.println(username);
	System.out.println(password);
		System.out.println(Admin.getUsername());
		System.out.println(Admin.getPassword());
		System.out.println(admins);
		System.out.println(allMembers);

		
		
		if((username != null) && (password != null)) {	
			for (Admin admin: admins) {
			if(username.equals(Admin.getUsername())) {
				String storedPass = Admin.getPassword();
				if(storedPass.equals(password)) {
					return admin;
				}
				
				return null;
			}
		}
		}
		return null;
	}


	/**
	 * @param skillList
	 */
	public static void setSkillList(TwoDimArrayList<String> skillList) {
		Model.skillList = skillList;
	}
	
	/**
	 * @param category
	 * @return
	 */
	public static ArrayList<String> findCategory(String category) {
        boolean hasFoundCategory = false;
        ArrayList<String> inner = null;

        for(int count = 0; !hasFoundCategory; ++count) {
            inner = skillList.get(count);
            if(inner.get(0).equals(category)) {
                hasFoundCategory = true;
            }
        }

        return inner;
    }


	
	/**
	 * @param player
	 * @param category
	 * @param skill
	 * @param level
	 * @param comment
	 * @param catComment
	 * 
	 */
	public static void addPlayerSkill(Player player, String category, String skill, int level, String comment, String catComment) {
        ArrayList<String> inner = findCategory(category);
        int categoryLocation = skillList.indexOf(inner);

        int skillLocation;
        for(skillLocation = 0; !inner.get(skillLocation).equals(skill); ++skillLocation) {
            ;
        }

        try {
            if(player.getPlayerSkillCategories().get(categoryLocation) == null) {
                player.getPlayerSkillCategories().set(categoryLocation, new SkillCategory(categoryLocation));
            }
        } catch (IndexOutOfBoundsException var14) {
            while(player.getPlayerSkillCategories().size() < categoryLocation) {
                player.getPlayerSkillCategories().add((SkillCategory)null);
            }

            player.getPlayerSkillCategories().add(categoryLocation, new SkillCategory(categoryLocation));
        }

        ((SkillCategory)player.getPlayerSkillCategories().get(categoryLocation)).setCategoryComment(catComment);
        int innerSize;
        try {
            TwoDimArrayList<Skill> playerSkills = ((SkillCategory)player.getPlayerSkillCategories().get(categoryLocation)).getSkills();

            for(innerSize = playerSkills.get(skillLocation - 1).size(); playerSkills.get(skillLocation - 1).get(innerSize - 1) == null; --innerSize) {
                ;
            }
        } catch (IndexOutOfBoundsException var13) {
            innerSize = 0;
        }

        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        String date = df.format(new Date()).toString();
        Skill addedSkill = new Skill(innerSize, skillLocation ,level, comment, date);
        ((SkillCategory)player.getPlayerSkillCategories().get(categoryLocation)).getSkills().addToInnerArray(skillLocation - 1, innerSize, addedSkill);
    }
	
	
	
	
	
	
	
	
	
	
}
