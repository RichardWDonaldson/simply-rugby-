package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import model.Player;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPlayerDetails {

	private JFrame frame;

	/**
	 * Launch the application.
	 * @param selected 
	 */
	public static void newScreen(Player selected, boolean isPlayer) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Player currentMember = selected;
					System.out.println(currentMember);
					ViewPlayerDetails window = new ViewPlayerDetails(currentMember, isPlayer);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	
	}

	/**
	 * Create the application.
	 * @param currentMember 
	 */
	public ViewPlayerDetails(Player currentMember, boolean isPlayer) {

		initialize(currentMember, isPlayer);
	}
	
	

	

	/**
	 * Initialize the contents of the frame.
	 * @param currentMember 
	 */
	private void initialize(Player currentMember, boolean isPlayer) {
		String ID = currentMember.getMemberID().toString();
		String Name = currentMember.getFirstName().toString() + " " + currentMember.getSurname().toString();
		String Address = currentMember.getAddress().toString();
		String Postcode = currentMember.getPostcode().toString();
		String TelNo = currentMember.getTelNo().toString();
		String MobNo = currentMember.getMobNo().toString();
		String SRU = currentMember.getSruID().toString();
		String Position = currentMember.getPosition().toString();
		String DOB = currentMember.getDOB().toString();
		String NextOfKin = currentMember.getNextOfKin();
		String NextOfKinTelNo = currentMember.getNextOfKinTelNo().toString();
		String Doctor = currentMember.getDoctor().toString();
		String DoctorTelNo = currentMember.getDoctorTelNo().toString();
		String HealthIssues = currentMember.getHealthIssues().toString();
		
		
		
		
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.setBounds(100, 100, 681, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setBackground(new Color(150,204,255));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblPlayerProfile = new JLabel("Player Profile");
		lblPlayerProfile.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblPlayerProfile = new GridBagConstraints();
		gbc_lblPlayerProfile.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayerProfile.gridx = 4;
		gbc_lblPlayerProfile.gridy = 0;
		frame.getContentPane().add(lblPlayerProfile, gbc_lblPlayerProfile);
		
		JLabel lblNewLabel = new JLabel("Member ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lbMemberID = new JLabel(ID);
		lbMemberID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lbMemberID = new GridBagConstraints();
		gbc_lbMemberID.insets = new Insets(0, 0, 5, 5);
		gbc_lbMemberID.gridx = 2;
		gbc_lbMemberID.gridy = 1; 
		frame.getContentPane().add(lbMemberID, gbc_lbMemberID);
		
		JLabel lblSruId = new JLabel("SRU ID");
		lblSruId.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblSruId = new GridBagConstraints();
		gbc_lblSruId.insets = new Insets(0, 0, 5, 5);
		gbc_lblSruId.gridx = 5;
		gbc_lblSruId.gridy = 1;
		frame.getContentPane().add(lblSruId, gbc_lblSruId);
		
		JLabel lbSRU = new JLabel(SRU);
		GridBagConstraints gbc_lbSRU = new GridBagConstraints();
		gbc_lbSRU.insets = new Insets(0, 0, 5, 5);
		gbc_lbSRU.gridx = 6;
		gbc_lbSRU.gridy = 1;
		frame.getContentPane().add(lbSRU, gbc_lbSRU);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lbName = new JLabel(Name);
		lbName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lbName = new GridBagConstraints();
		gbc_lbName.insets = new Insets(0, 0, 5, 5);
		gbc_lbName.gridx = 2;
		gbc_lbName.gridy = 2;
		frame.getContentPane().add(lbName, gbc_lbName);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblDob = new GridBagConstraints();
		gbc_lblDob.insets = new Insets(0, 0, 5, 5);
		gbc_lblDob.gridx = 5;
		gbc_lblDob.gridy = 2;
		frame.getContentPane().add(lblDob, gbc_lblDob);
		
		JLabel lbDob = new JLabel(DOB);
		GridBagConstraints gbc_lbDob = new GridBagConstraints();
		gbc_lbDob.insets = new Insets(0, 0, 5, 5);
		gbc_lbDob.gridx = 6;
		gbc_lbDob.gridy = 2;
		frame.getContentPane().add(lbDob, gbc_lbDob);
		
		JLabel lblNewLabel_2 = new JLabel("Position");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lbPosition = new JLabel(Position);
		lbPosition.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lbPosition = new GridBagConstraints();
		gbc_lbPosition.insets = new Insets(0, 0, 5, 5);
		gbc_lbPosition.gridx = 2;
		gbc_lbPosition.gridy = 3;
		frame.getContentPane().add(lbPosition, gbc_lbPosition);
		
		JSeparator separator = new JSeparator();
	
		separator.setForeground(Color.BLACK);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 6;
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 4;
		frame.getContentPane().add(separator, gbc_separator);
		
		JLabel lblContactDetails = new JLabel("Contact Details");
		lblContactDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblContactDetails = new GridBagConstraints();
		gbc_lblContactDetails.insets = new Insets(0, 0, 5, 5);
		gbc_lblContactDetails.gridx = 1;
		gbc_lblContactDetails.gridy = 5;
		frame.getContentPane().add(lblContactDetails, gbc_lblContactDetails);
		
		JLabel lblNewLabel_6 = new JLabel("Address");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 6;
		frame.getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JLabel lbAddress = new JLabel(Address);
		GridBagConstraints gbc_lbAddress = new GridBagConstraints();
		gbc_lbAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lbAddress.gridx = 2;
		gbc_lbAddress.gridy = 6;
		frame.getContentPane().add(lbAddress, gbc_lbAddress);
		
		JLabel lblNextOfKin = new JLabel("Next of Kin");
		lblNextOfKin.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNextOfKin = new GridBagConstraints();
		gbc_lblNextOfKin.insets = new Insets(0, 0, 5, 5);
		gbc_lblNextOfKin.gridx = 5;
		gbc_lblNextOfKin.gridy = 6;
		frame.getContentPane().add(lblNextOfKin, gbc_lblNextOfKin);
		
		JLabel lbNextOfKin = new JLabel(NextOfKin);
		GridBagConstraints gbc_lbNextOfKin = new GridBagConstraints();
		gbc_lbNextOfKin.insets = new Insets(0, 0, 5, 5);
		gbc_lbNextOfKin.gridx = 6;
		gbc_lbNextOfKin.gridy = 6;
		frame.getContentPane().add(lbNextOfKin, gbc_lbNextOfKin);
		
		JLabel lblPostcode = new JLabel("Postcode");
		lblPostcode.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblPostcode = new GridBagConstraints();
		gbc_lblPostcode.insets = new Insets(0, 0, 5, 5);
		gbc_lblPostcode.gridx = 1;
		gbc_lblPostcode.gridy = 7;
		frame.getContentPane().add(lblPostcode, gbc_lblPostcode);
		
		JLabel lbPostcode = new JLabel(Postcode);
		GridBagConstraints gbc_lbPostcode = new GridBagConstraints();
		gbc_lbPostcode.insets = new Insets(0, 0, 5, 5);
		gbc_lbPostcode.gridx = 2;
		gbc_lbPostcode.gridy = 7;
		frame.getContentPane().add(lbPostcode, gbc_lbPostcode);
		
		JLabel lblTelNo_1 = new JLabel("Tel No");
		lblTelNo_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblTelNo_1 = new GridBagConstraints();
		gbc_lblTelNo_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelNo_1.gridx = 5;
		gbc_lblTelNo_1.gridy = 7;
		frame.getContentPane().add(lblTelNo_1, gbc_lblTelNo_1);
		
		JLabel lbNextOfKinTelNo = new JLabel(NextOfKinTelNo);
		GridBagConstraints gbc_lbNextOfKinTelNo = new GridBagConstraints();
		gbc_lbNextOfKinTelNo.insets = new Insets(0, 0, 5, 5);
		gbc_lbNextOfKinTelNo.gridx = 6;
		gbc_lbNextOfKinTelNo.gridy = 7;
		frame.getContentPane().add(lbNextOfKinTelNo, gbc_lbNextOfKinTelNo);
		
		JLabel lblTelNo = new JLabel("Tel No");
		lblTelNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblTelNo = new GridBagConstraints();
		gbc_lblTelNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelNo.gridx = 1;
		gbc_lblTelNo.gridy = 8;
		frame.getContentPane().add(lblTelNo, gbc_lblTelNo);
		
		JLabel lbTelNo = new JLabel(TelNo);
		GridBagConstraints gbc_lbTelNo = new GridBagConstraints();
		gbc_lbTelNo.insets = new Insets(0, 0, 5, 5);
		gbc_lbTelNo.gridx = 2;
		gbc_lbTelNo.gridy = 8;
		frame.getContentPane().add(lbTelNo, gbc_lbTelNo);
		
		JLabel lblMobNo = new JLabel("Mob No");
		lblMobNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblMobNo = new GridBagConstraints();
		gbc_lblMobNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblMobNo.gridx = 1;
		gbc_lblMobNo.gridy = 9;
		frame.getContentPane().add(lblMobNo, gbc_lblMobNo);
		
		JLabel lbMobNo = new JLabel(MobNo);
		GridBagConstraints gbc_lbMobNo = new GridBagConstraints();
		gbc_lbMobNo.insets = new Insets(0, 0, 5, 5);
		gbc_lbMobNo.gridx = 2;
		gbc_lbMobNo.gridy = 9;
		frame.getContentPane().add(lbMobNo, gbc_lbMobNo);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.gridwidth = 6;
		gbc_separator_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 1;
		gbc_separator_1.gridy = 10;
		frame.getContentPane().add(separator_1, gbc_separator_1);
		
		JLabel lblHealthDetails = new JLabel("Health Details");
		lblHealthDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblHealthDetails = new GridBagConstraints();
		gbc_lblHealthDetails.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealthDetails.gridx = 1;
		gbc_lblHealthDetails.gridy = 11;
		frame.getContentPane().add(lblHealthDetails, gbc_lblHealthDetails);
		
		JLabel lblHealthIssues = new JLabel("HEALTH ISSUES");
		lblHealthIssues.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHealthIssues.setForeground(Color.RED);
		GridBagConstraints gbc_lblHealthIssues = new GridBagConstraints();
		gbc_lblHealthIssues.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealthIssues.gridx = 5;
		gbc_lblHealthIssues.gridy = 11;
		frame.getContentPane().add(lblHealthIssues, gbc_lblHealthIssues);
		
		JLabel lbHealthIssues = new JLabel(HealthIssues);
		lbHealthIssues.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbHealthIssues.setForeground(Color.RED);
		GridBagConstraints gbc_lbHealthIssues = new GridBagConstraints();
		gbc_lbHealthIssues.insets = new Insets(0, 0, 5, 5);
		gbc_lbHealthIssues.gridx = 6;
		gbc_lbHealthIssues.gridy = 11;
		frame.getContentPane().add(lbHealthIssues, gbc_lbHealthIssues);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblDoctor = new GridBagConstraints();
		gbc_lblDoctor.insets = new Insets(0, 0, 5, 5);
		gbc_lblDoctor.gridx = 1;
		gbc_lblDoctor.gridy = 12;
		frame.getContentPane().add(lblDoctor, gbc_lblDoctor);
		
		JLabel lbDoctor = new JLabel(Doctor);
		GridBagConstraints gbc_lbDoctor = new GridBagConstraints();
		gbc_lbDoctor.insets = new Insets(0, 0, 5, 5);
		gbc_lbDoctor.gridx = 2;
		gbc_lbDoctor.gridy = 12;
		frame.getContentPane().add(lbDoctor, gbc_lbDoctor);
		
		JLabel lblTelNo_2 = new JLabel("Tel No");
		lblTelNo_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblTelNo_2 = new GridBagConstraints();
		gbc_lblTelNo_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelNo_2.gridx = 1;
		gbc_lblTelNo_2.gridy = 13;
		frame.getContentPane().add(lblTelNo_2, gbc_lblTelNo_2);
		
		JLabel lbDocTelNo = new JLabel(DoctorTelNo);
		GridBagConstraints gbc_lbDocTelNo = new GridBagConstraints();
		gbc_lbDocTelNo.insets = new Insets(0, 0, 5, 5);
		gbc_lbDocTelNo.gridx = 2;
		gbc_lbDocTelNo.gridy = 13;
		frame.getContentPane().add(lbDocTelNo, gbc_lbDocTelNo);
		
		JButton btnNewButton = new JButton("View Player Skills");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPlayerSkills.NewScreen(currentMember, isPlayer);
				ViewPlayerDetails.this.frame.dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 14;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPlayerList.NewScreen(isPlayer);
				ViewPlayerDetails.this.frame.dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 15;
		frame.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
	}

}
