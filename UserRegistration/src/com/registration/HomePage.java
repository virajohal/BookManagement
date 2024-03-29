package com.registration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class HomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUserRegistration;
	private JTextField textName;
	private JTextField textAge;
	private JTextField textMobile;
	private JTextField textEmail;
	private JTextField textUser;
	private JPasswordField textPassword;
	
	private  JRadioButton rdbtnMale;
	private	 JRadioButton rdbtnFemale;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePage() {
		setFont(new Font("Dialog", Font.BOLD, 14));
		setBackground(new Color(128, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\vrjoh\\OneDrive\\Desktop\\user-icon.jpg"));
		setTitle("Registration Page ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 947, 544);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name  :");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(57, 36, 90, 13);
		contentPane.add(lblName);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGender.setBounds(57, 159, 90, 13);
		contentPane.add(lblGender);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAge.setBounds(57, 205, 90, 13);
		contentPane.add(lblAge);
		
		JLabel lblMobile = new JLabel("Mobile No");
		lblMobile.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMobile.setBounds(57, 246, 480, 13);
		contentPane.add(lblMobile);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(57, 302, 90, 13);
		contentPane.add(lblEmail);
		
		JLabel lblUser = new JLabel("User Name");
		lblUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUser.setBounds(57, 343, 90, 13);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(57, 405, 90, 13);
		contentPane.add(lblPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","root");
					String query="insert into Registration values(?,?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1,textName.getText());
				//	ps.setString(2,textAddress.getText());
					
					if(rdbtnMale.isSelected())
						ps.setString(2,rdbtnMale.getText());
					else
						
						ps.setString(2,rdbtnFemale.getText());
					ps.setInt(3,Integer.parseInt(textAge.getText()));
					ps.setString(4,textMobile.getText());
					ps.setString(5,textEmail.getText());
					ps.setString(6,textUser.getText());
				
					ps.setString(7,textPassword.getText());
					int i=ps.executeUpdate();
					JOptionPane.showMessageDialog(btnRegister, i+ "Record Added Successfully ,...!!!");
					ps.close();
					con.close();
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnRegister.setBounds(161, 448, 85, 21);
		contentPane.add(btnRegister);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textName.setText("");
		//		textAddress.setText("");
				textAge.setText("");
				textMobile.setText("");
				textEmail.setText("");
				textUser.setText("");
				textPassword.setText("");
				buttonGroup.clearSelection();
				
			}
		});
		btnNewButton_1.setBounds(496, 448, 85, 21);
		contentPane.add(btnNewButton_1);
		
		txtUserRegistration = new JTextField();
		txtUserRegistration.setForeground(new Color(255, 255, 255));
		txtUserRegistration.setBackground(new Color(64, 0, 64));
		txtUserRegistration.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtUserRegistration.setText("User Registration");
		txtUserRegistration.setBounds(337, 10, 129, 19);
		contentPane.add(txtUserRegistration);
		txtUserRegistration.setColumns(10);
		
		textName = new JTextField();
		textName.setBounds(241, 34, 296, 19);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textAge = new JTextField();
		textAge.setBounds(252, 203, 285, 19);
		contentPane.add(textAge);
		textAge.setColumns(10);
		
		textMobile = new JTextField();
		textMobile.setBounds(252, 240, 285, 19);
		contentPane.add(textMobile);
		textMobile.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(252, 300, 285, 19);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		textUser = new JTextField();
		textUser.setBounds(252, 341, 285, 19);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		 rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setBackground(new Color(255, 0, 255));
		rdbtnMale.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnMale.setBounds(279, 155, 103, 21);
		contentPane.add(rdbtnMale);
		
		 rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setBackground(new Color(255, 0, 255));
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnFemale.setBounds(424, 155, 103, 21);
		contentPane.add(rdbtnFemale);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(252, 403, 285, 19);
		contentPane.add(textPassword);
	}
}
