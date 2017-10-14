 package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import model.Model;
import model.Player;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class UpdateSkill {

	private JFrame frame;
	private JPanel skillsPanel;
	private JRadioButton rdbtn1;
	private JRadioButton rdbtn2;
	private JRadioButton rdbtn3;
	private JRadioButton rdbtn4;
	private JRadioButton rdbtn5;
	private JTextArea taSkillComment;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextArea taCategoryComment;
	private JLabel lblNewLabel_2;
	private JTree treeSkill;
	private JButton btnSave;
	private JButton btnBack;
	 private String emptyCategoryMessage = "No Skills stored in this category";
	private Player selected;
	private boolean isPlayer;
	    private String selectedSkill;
	    private String selectedCategory;
	    private int level = 3;

	/**
	 * Launch the application.
	 * @param selected 
	 */
	public static void NewScreen(Player selected, boolean isPlayer) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					UpdateSkill window = new UpdateSkill(selected, isPlayer);
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
	public UpdateSkill(Player selected, boolean isPlayer) {
		this.selected = selected;
		this.isPlayer = isPlayer;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 647, 522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setBackground(new Color(150,204,255));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 315, 236, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 40, 0, 38, 33, 67, 44, 69, 69, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		treeSkill = new JTree();
		GridBagConstraints gbc_treeSkill = new GridBagConstraints();
		gbc_treeSkill.gridheight = 8;
		gbc_treeSkill.insets = new Insets(0, 0, 5, 5);
		gbc_treeSkill.fill = GridBagConstraints.BOTH;
		gbc_treeSkill.gridx = 1;
		gbc_treeSkill.gridy = 1;
		frame.getContentPane().add(treeSkill, gbc_treeSkill);
		System.out.println("TreeSelectionEvent"); 
		treeSkill.addTreeSelectionListener(new TreeSelectionListener() {
	          
			 public void valueChanged(TreeSelectionEvent arg0) {
	                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)treeSkill.getLastSelectedPathComponent();
	                System.out.println("selectedNode" + treeSkill.getLastSelectedPathComponent());
	                if(selectedNode != null && selectedNode.isLeaf()) {
	                	System.out.println("Selected Node Not Null and isLeaf"); 
	                	System.out.println("nodeSkill" + selectedNode.getUserObject());
	                	Object nodeSkill = selectedNode.getUserObject();
	                    if(nodeSkill.toString().equals(emptyCategoryMessage)) {
	                    	System.out.println("Node Skill has empty Category Message"); 
	                    	selectedSkill = null;
	                       selectedCategory = null;
	                       taCategoryComment.setText("");
	                    } else {
	                    	System.out.println("Selected Skill is " + nodeSkill.toString()); 
	                        selectedSkill = nodeSkill.toString();
	                        System.out.println("Selected Category is" + selectedNode.getParent().toString()); 
	                        selectedCategory = selectedNode.getParent().toString();
	                        int location = -1;

	                        for(int i = 0; i < Model.getSkillList().size(); ++i) {
	                            ArrayList<String> inner = (ArrayList<String>)Model.getSkillList().get(i);
	                            if(inner.get(0).equals(selectedCategory)) {
	                                location = i;
	                                break;
	                            }
	                        }

	                        try {
	                        	System.out.println("location is" + location);
	                        	System.out.println("selected Skill Location" + selected.getPlayerSkillCategories().get(location)); 
	                            if(selected.getPlayerSkillCategories().get(location) != null) {
	                            	System.out.println("selected.getPlayerSkillcategories is not null!"); 
	                            	taCategoryComment.setText((selected.getPlayerSkillCategories().get(location)).getCategoryComment());
	                            } else {
	                                taCategoryComment.setText("");
	                            }
	                        } catch (IndexOutOfBoundsException var7) {
	                           taCategoryComment.setText("");
	                        }

	                    }
	                } else {
	                    selectedSkill = null;
	                    selectedCategory = null;
	                  taCategoryComment.setText("");
	                }
	            }

				
	        });
		
		  treeSkill.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("All Skills") {
	        
			private static final long serialVersionUID = 5479282117742389512L;

				{
	                for(int i = 0; i < Model.getSkillList().size(); ++i) {
	                    ArrayList<String> inner = (ArrayList<String>)Model.getSkillList().get(i);
	                    DefaultMutableTreeNode node_1 = new DefaultMutableTreeNode(inner.get(0));
	                    if(inner.size() == 1) {
	                        node_1.add(new DefaultMutableTreeNode(emptyCategoryMessage));
	                    } else {
	                        for(int j = 1; j < inner.size(); ++j) {
	                            node_1.add(new DefaultMutableTreeNode(inner.get(j)));
	                        }
	                    }

	                    this.add(node_1);
	                }

	            }
	        }));
		
		
		
		
		
		
		
		
		
		lblNewLabel_2 = new JLabel("Score");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 1;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		skillsPanel = new JPanel();
		GridBagConstraints gbc_skillsPanel = new GridBagConstraints();
		gbc_skillsPanel.insets = new Insets(0, 0, 5, 5);
		gbc_skillsPanel.fill = GridBagConstraints.BOTH;
		gbc_skillsPanel.gridx = 2;
		gbc_skillsPanel.gridy = 2;
		frame.getContentPane().add(skillsPanel, gbc_skillsPanel);
		skillsPanel.setLayout(new GridLayout(1, 0, 0, 0));
		ButtonGroup skillsButton = new ButtonGroup();
		rdbtn1 = new JRadioButton("1");
		skillsPanel.add(rdbtn1);
		skillsButton.add(rdbtn1);
		rdbtn1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent arg0) {
                if(rdbtn1.isSelected()) {
                    UpdateSkill.this.level = 1;
                }

            }
        });
		
		rdbtn2 = new JRadioButton("2");
		skillsPanel.add(rdbtn2);
		skillsButton.add(rdbtn2);
		rdbtn2.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent arg0) {
                if(rdbtn2.isSelected()) {
                   level = 2;
                }

            }
        });
		
		rdbtn3 = new JRadioButton("3");
		skillsPanel.add(rdbtn3);
		skillsButton.add(rdbtn3);
		rdbtn3.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent arg0) {
                if(rdbtn3.isSelected()) {
                   level = 3;
                }

            }
        });
		rdbtn4 = new JRadioButton("4");
		skillsPanel.add(rdbtn4);
		skillsButton.add(rdbtn4);
		rdbtn4.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent arg0) {
                if(rdbtn4.isSelected()) {
                    level = 4;
                }

            }
        });
		rdbtn5 = new JRadioButton("5");
		skillsPanel.add(rdbtn5);
		skillsButton.add(rdbtn5);
		rdbtn5.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent arg0) {
                if(rdbtn5.isSelected()) {
                    level = 5;
                }

            }
        });
		
		
		
		
		
		lblNewLabel = new JLabel("Skill Comment");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 5;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		taSkillComment = new JTextArea();
		GridBagConstraints gbc_taSkillComment = new GridBagConstraints();
		gbc_taSkillComment.insets = new Insets(0, 0, 5, 5);
		gbc_taSkillComment.fill = GridBagConstraints.BOTH;
		gbc_taSkillComment.gridx = 2;
		gbc_taSkillComment.gridy = 6;
		frame.getContentPane().add(taSkillComment, gbc_taSkillComment);
		
		lblNewLabel_1 = new JLabel("Category Comment");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 7;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		taCategoryComment = new JTextArea();
		GridBagConstraints gbc_taCategoryComment = new GridBagConstraints();
		gbc_taCategoryComment.insets = new Insets(0, 0, 5, 5);
		gbc_taCategoryComment.fill = GridBagConstraints.BOTH;
		gbc_taCategoryComment.gridx = 2;
		gbc_taCategoryComment.gridy = 8;
		frame.getContentPane().add(taCategoryComment, gbc_taCategoryComment);
		
		btnSave = new JButton("Save");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.gridx = 1;
		gbc_btnSave.gridy = 9;
		frame.getContentPane().add(btnSave, gbc_btnSave);
		 btnSave.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	                if(selectedSkill != null) {
	                    String comment = taSkillComment.getText();
	                    String catComment = taCategoryComment.getText();
	                    Model.addPlayerSkill(selected, selectedCategory, selectedSkill,level, comment, catComment);
	                    new ViewPlayerSkills(selected, isPlayer);
	                    ViewPlayerSkills.NewScreen(selected, isPlayer);
	                    UpdateSkill.this.frame.dispose();
	                } else {
	                    JOptionPane.showMessageDialog((Component)null, "Please select the skill you wish to add.", "No Skill Selected", 0);
	                }

	            }
	        });
		
		
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPlayerSkills.NewScreen(selected, isPlayer);
				UpdateSkill.this.frame.dispose();
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 2;
		gbc_btnBack.gridy = 9;
		frame.getContentPane().add(btnBack, gbc_btnBack);
	}

}


