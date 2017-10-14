package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Admin;
import model.Model;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

/**
 * @author Richard
 *
 */
public class AdminMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenu window = new AdminMenu();
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
	public AdminMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * 
	 */
	/**
	 * 
	 */
	/**
	 * 
	 */
	/**
	 * 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		this.frame.getContentPane().setBackground(new Color(150,204,255));
		frame.setBounds(100, 100, 253, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{19, 199, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 194, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblAdminMenu = new JLabel("Admin Menu");
		GridBagConstraints gbc_lblAdminMenu = new GridBagConstraints();
		gbc_lblAdminMenu.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdminMenu.gridx = 1;
		gbc_lblAdminMenu.gridy = 0;
		frame.getContentPane().add(lblAdminMenu, gbc_lblAdminMenu);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		frame.getContentPane().add(panel, gbc_panel);
		panel.setBackground(new Color(150,204,255));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{192, 0};
		gbl_panel.rowHeights = new int[]{55, 51, 55, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		//view players button
		JButton btnViewPlayers = new JButton("View Players");
		GridBagConstraints gbc_btnViewPlayers = new GridBagConstraints();
		gbc_btnViewPlayers.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnViewPlayers.insets = new Insets(0, 0, 5, 0);
		gbc_btnViewPlayers.gridx = 0;
		gbc_btnViewPlayers.gridy = 0;
		panel.add(btnViewPlayers, gbc_btnViewPlayers);

		//skills button
		JButton btnAddSkill = new JButton("Add Skill/Category");
		GridBagConstraints gbc_btnAddSkill = new GridBagConstraints();
		gbc_btnAddSkill.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddSkill.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddSkill.gridx = 0;
		gbc_btnAddSkill.gridy = 1;
		panel.add(btnAddSkill, gbc_btnAddSkill);
		//edit skills button
		JButton btnEditSkill = new JButton("Edit Skill/Category");
		GridBagConstraints gbc_btnEditSkill = new GridBagConstraints();
		gbc_btnEditSkill.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEditSkill.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditSkill.gridx = 0;
		gbc_btnEditSkill.gridy = 2;
		panel.add(btnEditSkill, gbc_btnEditSkill);
		
		
		//logout button
		JButton btnLogout = new JButton("Logout");
		GridBagConstraints gbc_btnLogout = new GridBagConstraints();
		gbc_btnLogout.gridx = 0;
		gbc_btnLogout.gridy = 4;
		panel.add(btnLogout, gbc_btnLogout);
		
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Model.setCurrentAdmin((Admin)null);
                controller.Controller.serialize();
                Login.NewScreen();
                AdminMenu.this.frame.dispose();
			;
			
			
			}
		});
		btnEditSkill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog((Component)null, "This option is not available in this prototype", "Prototype", 0);
				
			}
		});
		btnAddSkill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				JOptionPane.showMessageDialog((Component)null, "This option is not available in this prototype", "Prototype", 0);
			
			}
		});
		
		btnViewPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			boolean isPlayer = false;
			ViewPlayerList.NewScreen(isPlayer);
			AdminMenu.this.frame.dispose();
			
			
			}
		});
	}

}
