package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import controller.*;
import model.*;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
public class Login {

	private JFrame frame;
	private JTextField txtPassword;
	private JTextField txtUsername;
	private JLabel lbUsername;
	private JLabel lbPassword;
	private JLabel lbTitle;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
					Controller.initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
					Controller.initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
		
			});
		
	}
	

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 369, 284);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setBackground(new Color(150,204,255));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 316, 0};
		gridBagLayout.rowHeights = new int[]{59, 140, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		lbTitle = new JLabel("SIMPLY RUGBY");
		lbTitle.setFont(new Font("Serif", Font.BOLD, 21));
		GridBagConstraints gbc_lbTitle = new GridBagConstraints();
		gbc_lbTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lbTitle.gridx = 1;
		gbc_lbTitle.gridy = 0;
		frame.getContentPane().add(lbTitle, gbc_lbTitle);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		panel.setBackground(new Color(150,204,255));
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 239, 0};
		gbl_panel.rowHeights = new int[]{0, 3, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lbUsername = new JLabel("Username");
		GridBagConstraints gbc_lbUsername = new GridBagConstraints();
		gbc_lbUsername.anchor = GridBagConstraints.EAST;
		gbc_lbUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lbUsername.gridx = 0;
		gbc_lbUsername.gridy = 0;
		panel.add(lbUsername, gbc_lbUsername);
		
		txtUsername = new JTextField();
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsername.insets = new Insets(0, 0, 5, 0);
		gbc_txtUsername.gridx = 1;
		gbc_txtUsername.gridy = 0;
		panel.add(txtUsername, gbc_txtUsername);
		txtUsername.setColumns(10);
		
		lbPassword = new JLabel("Password");
		GridBagConstraints gbc_lbPassword = new GridBagConstraints();
		gbc_lbPassword.anchor = GridBagConstraints.EAST;
		gbc_lbPassword.insets = new Insets(0, 0, 0, 5);
		gbc_lbPassword.gridx = 0;
		gbc_lbPassword.gridy = 2;
		panel.add(lbPassword, gbc_lbPassword);
		
		txtPassword = new JTextField();
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.fill = GridBagConstraints.BOTH;
		gbc_txtPassword.gridx = 1;
		gbc_txtPassword.gridy = 2;
		panel.add(txtPassword, gbc_txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		
		
		
		btnLogin.addActionListener(new ActionListener() {
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent arg0) {
		
			if((!Login.this.txtUsername.getText().isEmpty()) && (!Login.this.txtPassword.getText().isEmpty())) {
				System.out.println(txtUsername.getText());
				System.out.println(txtPassword.getText());
					Admin currentAdmin = Model.validateAdminLogin(Login.this.txtUsername.getText(), Login.this.txtPassword.getText());
					
					if(currentAdmin != null) {
						Model.setCurrentAdmin(currentAdmin);
						System.out.println("Running Admin Menu");
						
						AdminMenu.NewScreen();
						Login.this.frame.dispose();
					} else if((Login.this.txtUsername.getText().equals("Player")) && (Login.this.txtPassword.getText().equals("Password")) ) {
						boolean isPlayer = true;
						ViewPlayerList.NewScreen(isPlayer);
					}
					
					else {
						JOptionPane.showMessageDialog((Component)null, "The Login detailed entered were invalid, please try again", "Incorrect Login", 0);
				}
					
					
				} else {
				JOptionPane.showMessageDialog((Component)null, "Please enter your username and password", "Details not entered", 0);
			}
		}
		
	});
		btnLogin.setMnemonic('b');
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.gridx = 1;
		gbc_btnLogin.gridy = 2;
		frame.getContentPane().add(btnLogin, gbc_btnLogin);
		 
	}

}
