package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.GridBagConstraints;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.util.ArrayList;
import model.Member;
import model.Model;
import model.Player;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPlayerList {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void NewScreen(boolean isPlayer) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPlayerList window = new ViewPlayerList(isPlayer);
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
	public ViewPlayerList(boolean isPlayer) {
		initialize(isPlayer);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(boolean isPlayer) {
		frame = new JFrame();
		frame.setBounds(100, 100, 549, 626);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setBackground(new Color(150,204,255));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 259, 294, 0, 294, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 38, 86, 386, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		ArrayList<Member> membersList = new ArrayList<Member>(Model.allMembers.values());
		
		for (int i = 0; i < membersList.size(); i++) {
  
		}
		
		JList<?> list = new JList<Object>(membersList.toArray());
		list.setValueIsAdjusting(true);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 4;
		gbc_list.gridwidth = 3;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 1;
		frame.getContentPane().add(new JScrollPane(list), gbc_list);
		
		JButton btnNewButton_1 = new JButton("View Skills");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				try {
					
					Player selected = (Player) list.getSelectedValue();
					if(selected != null) {
					ViewPlayerSkills.NewScreen(selected, isPlayer);
					ViewPlayerList.this.frame.dispose();
					} 
					else {
						JOptionPane.showMessageDialog((Component)null, "A Player has not been selected. Please try again", "Incorrect choice", 0);
					}
					
					
				} catch (NullPointerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
			
			}
		});
		
		
		
		
		
		
		
		
		JButton btnNewButton = new JButton("View Player Information");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Player selected = (Player) list.getSelectedValue();
				if(selected != null) {
				ViewPlayerDetails.newScreen(selected, isPlayer);
				ViewPlayerList.this.frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog((Component)null, "A Player has not been selected. Please try again", "Incorrect choice", 0);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 1;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 2;
		frame.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMenu.NewScreen();
				ViewPlayerList.this.frame.dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.BELOW_BASELINE;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 4;
		gbc_btnNewButton_2.gridy = 3;
		frame.getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);

	}

}
