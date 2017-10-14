package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;

import model.Model;
import model.Player;
import model.Skill;
import model.SkillCategory;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.TwoDimArrayList;

import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPlayerSkills {

	private JFrame frame;
	private Player selected;
	private boolean isPlayer;
	private JTable table_1;
	

	/**
	 * Launch the application.
	 * @param selected 
	 */
	public static void NewScreen(Player selected, boolean isPlayer) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					model.Player currentMember = (Player) selected;
					
					System.out.println(currentMember);
					ViewPlayerSkills window = new ViewPlayerSkills(selected, isPlayer);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewPlayerSkills(Player selected, boolean isPlayer) {
		this.selected = selected;
		this.isPlayer = isPlayer;
		this.initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		this.frame.getContentPane().setBackground(new Color(150,204,255));
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel_1 = new JLabel("Player Skills");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lbPlayerName = new JLabel("New label");
		GridBagConstraints gbc_lbPlayerName = new GridBagConstraints();
		gbc_lbPlayerName.insets = new Insets(0, 0, 5, 5);
		gbc_lbPlayerName.gridx = 0;
		gbc_lbPlayerName.gridy = 1;
		frame.getContentPane().add(lbPlayerName, gbc_lbPlayerName);
		
		JButton btnUpdateSkills = new JButton("Update Skills");
		btnUpdateSkills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(!isPlayer) {
				UpdateSkill.NewScreen(selected, isPlayer);
				ViewPlayerSkills.this.frame.dispose();
				} else {
					JOptionPane.showMessageDialog((Component)null, "You are not authorised to perform this action", "Access Denied", 0);
				}
			}
		});
		GridBagConstraints gbc_btnUpdateSkills = new GridBagConstraints();
		gbc_btnUpdateSkills.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdateSkills.gridx = 0;
		gbc_btnUpdateSkills.gridy = 2;
		frame.getContentPane().add(btnUpdateSkills, gbc_btnUpdateSkills);
		
		JButton btnViewPlayerDetails = new JButton("View Player Details");
		btnViewPlayerDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPlayerDetails.newScreen(selected, isPlayer);
				ViewPlayerSkills.this.frame.dispose();
			}
		});
		GridBagConstraints gbc_btnViewPlayerDetails = new GridBagConstraints();
		gbc_btnViewPlayerDetails.insets = new Insets(0, 0, 5, 5);
		gbc_btnViewPlayerDetails.gridx = 1;
		gbc_btnViewPlayerDetails.gridy = 2;
		frame.getContentPane().add(btnViewPlayerDetails, gbc_btnViewPlayerDetails);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewPlayerList.NewScreen(isPlayer);
				ViewPlayerSkills.this.frame.dispose();
				
				
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnBack.gridx = 2;
		gbc_btnBack.gridy = 2;
		frame.getContentPane().add(btnBack, gbc_btnBack);
		
		DefaultTableModel modelCurrent = new DefaultTableModel();
		modelCurrent.addColumn("Category");
		modelCurrent.addColumn("Category Comment");
		modelCurrent.addColumn("Skill");
		modelCurrent.addColumn("Level");
		modelCurrent.addColumn("Comment");
		modelCurrent.addColumn("Date");

		
		
		table_1 = new JTable(modelCurrent);
		
		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.gridwidth = 3;
		gbc_table_1.insets = new Insets(0, 0, 0, 5);
		gbc_table_1.fill = GridBagConstraints.BOTH;
		gbc_table_1.gridx = 0;
		gbc_table_1.gridy = 3;
		frame.getContentPane().add(new JScrollPane(table_1), gbc_table_1);
		
		
		
		
		table_1 = new JTable(modelCurrent) {
		GridBagConstraints gbc_table = new GridBagConstraints();
		{
		gbc_table.gridwidth = 3;
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 3;
	
		};
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) { 
			return false; }
		};
		int level = 0;
		String comment = "";
		String date = "";
		boolean firstInCategory = true;
		
		for(int i = 0; i < selected.getPlayerSkillCategories().size(); i++) {
			firstInCategory = true;
			if(selected.getPlayerSkillCategories().get(i) != null) {
				ArrayList<String> innerCategory = (ArrayList<String>)Model.getSkillList().get(i);
                String category = innerCategory.get(0);
                System.out.println("category = " + innerCategory.get(0));
                String categoryComment = ((SkillCategory)selected.getPlayerSkillCategories().get(i)).getCategoryComment();
               System.out.println("categoryComment" + categoryComment);
                TwoDimArrayList<Skill> skills = ((SkillCategory)selected.getPlayerSkillCategories().get(i)).getSkills();
                System.out.println("TwoDimArrayListSkill" + skills);
                for(int j = 0; j < skills.size(); ++j) {
                    String skill = null;
                    if(skills.get(j) != null) {
                       System.out.println("skills.get() is not null");
                       System.out.println("skills.get is" + skills.get(j));
                    	ArrayList<Skill> innerSkill = skills.get(j);
                        
                        if(innerSkill.size() > 0) {
                            Skill currentSkill = innerSkill.get(innerSkill.size() - 1);
                            System.out.println("current Skill is" + currentSkill);
                            skill = innerCategory.get(currentSkill.getSkill());
                            System.out.println("Skill is" + skill);
                            level = currentSkill.getSkillLevel();
                            System.out.println("level is" + level);
                            comment = currentSkill.getSkillComment();
                            System.out.println("comment is" + comment);
                            date = currentSkill.getDateAchieved();
                            System.out.println("date is " + date);
                        }

                        if(skill != null) {
                        	System.out.println("skill is not null");
                            if(!firstInCategory) {
                                System.out.println("Skill is not firstInCategory");
                            	category = "";
                                categoryComment = "";
                            }

                            firstInCategory = false;
                            modelCurrent.addRow(new Object[]{category, categoryComment, skill, Integer.valueOf(level), comment, date});
                        }
                    }
                }
            
			}
		}
	
	}

}
