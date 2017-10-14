package controller;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import javax.swing.JOptionPane;

import model.*;
import controller.TwoDimArrayList;

/**
 * Created by Richard on 10/05/2017.
 */
public class Controller {
	//private static TwoDimArrayList<String> skillList = new TwoDimArrayList<String>();
	

	
	public Controller() {
	}
	
	//public static TwoDimArrayList<String> getSkillList() {
	//	return skillList;
	//}

	
	public static void initialize() throws IOException {
		System.out.println("Running initialize()");
		Admin admin = new Admin("Admin","Admin" , "Password");
		Model.addAdmin(admin);
		checkFiles();
		deserializeSkillList();
		deserializeMembers();

		
		
		
		
		
	}
	
	public static void checkFiles() {
		System.out.println("Running Check Files");
		File serializedSkills = new File("SkillList.ser");
		File serializedMembers = new File("Member.ser");
		
		if((!serializedSkills.exists()) || (!serializedMembers.exists())) {
			try {
				System.out.println("one of these doesn't exists!");
				serializedSkills.createNewFile();
				serializedMembers.createNewFile();
				Model.prepopulate();
				serialize();
			}catch (IOException var5) {
				JOptionPane.showMessageDialog((Component)null, "Input/output Error- Contact System Admin", "Critical Error", 0);
				var5.printStackTrace();
				
				
				
			}
		}
		
		
		
	}
	
	public static void serialize() {
		System.out.println("Running serialize()");
		FileOutputStream file;
		ObjectOutputStream out;
		try {
			file = new FileOutputStream("SkillList.ser");
			out = new ObjectOutputStream(file);
			out.writeObject(Model.getSkillList());
			out.close();
			file.close();
		} catch (IOException var5) {
			var5.printStackTrace();
		}
	
	try {
		file = new FileOutputStream("Member.ser");
		out = new ObjectOutputStream(file);
		out.writeObject(Model.getAllMembers());
		out.close();
		file.close();
	} catch (IOException var5) {
		var5.printStackTrace();
	}
	
	
	
	
	}
	

	@SuppressWarnings("unchecked")
	public static void deserializeSkillList() throws IOException {
		System.out.println("Running deserializeSkillList");
		File serializedData = new File("SkillList.ser");
		FileInputStream fis = new FileInputStream(serializedData);
		ObjectInputStream ois = null;
		
		
		
	      try {
	            ois = new ObjectInputStream(fis);
	          ;
	        } catch (IOException var6) {
	            JOptionPane.showMessageDialog((Component)null, "Input/Output Error - Contact System Admin", "Critical Error", 0);
	            var6.printStackTrace();
	        }
	      
		try {
			Model.setSkillList((TwoDimArrayList<String>)ois.readObject());
		
		} catch (ClassNotFoundException var4) {
			JOptionPane.showMessageDialog((Component)null, "Input/Output Error - Contact System Admin", "Critical Error", 0);
			var4.printStackTrace();
		} catch (IOException var5) {
			JOptionPane.showMessageDialog((Component)null, "Input/Output Error - Contact System Admin", "Critical Error",0);
			var5.printStackTrace();
			
		}
	fis.close();
	
	}
	
	@SuppressWarnings("unchecked")
	public static void deserializeMembers() throws IOException {
		System.out.println("Running deserializeMembers");
		File serializedData = new File("Member.ser");
		FileInputStream fis = new FileInputStream(serializedData);
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(fis);
		} catch (IOException var6) {
			JOptionPane.showMessageDialog((Component)null, "Input/Output Error - Contact System Admin", "Critical Error", 0);
			var6.printStackTrace();
		}
		
		try {
			Model.setAllMembers((HashMap<Integer, Member>)ois.readObject());
			
		} catch (ClassNotFoundException var4) {
			JOptionPane.showMessageDialog((Component)null, "Input/Output Error - Contact System Admin", "Critical Error", 0);
			var4.printStackTrace();
		} catch (IOException var5) {
			JOptionPane.showMessageDialog((Component)null, "Input/Output Error - Contact System Admin", "Critical Error", 0);
			var5.printStackTrace();
			
		}
		
		fis.close();
	}
	
	
	







}
