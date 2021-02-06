package kutuphane;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterPage extends JFrame {

	private JPanel contentPane;
	private JTextField nameText;
	private JPasswordField passwordField;
	private JTextField surnametextField;
	private JTextField emailtextField;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					RegisterPage frame = new RegisterPage();
					frame.setVisible(true);
					
			
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public RegisterPage() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 400, 550, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RegisterPage");
		lblNewLabel.setForeground(new Color(51, 0, 153));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(12, 13, 505, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(39, 101, 80, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBounds(39, 203, 110, 28);
		contentPane.add(lblPassword);
		
		nameText = new JTextField();
		nameText.setFont(new Font("Tahoma", Font.BOLD, 15));
		nameText.setBackground(SystemColor.inactiveCaptionBorder);
		nameText.setBounds(159, 102, 181, 22);
		contentPane.add(nameText);
		nameText.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 16));
		passwordField.setBackground(SystemColor.inactiveCaptionBorder);
		passwordField.setBounds(161, 207, 192, 22);
		contentPane.add(passwordField);
		
		JButton RegisterButon = new JButton("Register");
		RegisterButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MysqlCon con = new MysqlCon();
				con.con_db();
				
			
			 String name = nameText.getText();
			 String pass = passwordField.getText();
			 String email = emailtextField.getText();
			 String surname = surnametextField.getText();
			 
			 
			 workData kullanici = new workData();
			 kullanici.kullaniciEkle(name,pass,email,surname);
			LoginPage login = new LoginPage();
			login.setVisible(true);
			
			
			}
		});
		RegisterButon.setBackground(new Color(0, 153, 153));
		RegisterButon.setFont(new Font("Tahoma", Font.BOLD, 20));
		RegisterButon.setBounds(164, 356, 141, 47);
		contentPane.add(RegisterButon);
		
		JButton forgotPassClick = new JButton("I forgot my password!");
		forgotPassClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			}
		});
		forgotPassClick.setForeground(new Color(255, 0, 0));
		forgotPassClick.setBackground(SystemColor.inactiveCaptionBorder);
		forgotPassClick.setFont(new Font("Tahoma", Font.ITALIC, 20));
		forgotPassClick.setBounds(114, 505, 280, 35);
		contentPane.add(forgotPassClick);
		
		JLabel surnameLabel = new JLabel("surname :");
		surnameLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		surnameLabel.setBounds(39, 156, 110, 22);
		contentPane.add(surnameLabel);
		
		surnametextField = new JTextField();
		surnametextField.setFont(new Font("Tahoma", Font.BOLD, 15));
		surnametextField.setColumns(10);
		surnametextField.setBackground(SystemColor.inactiveCaptionBorder);
		surnametextField.setBounds(159, 158, 181, 22);
		contentPane.add(surnametextField);
		
		JLabel lblEmail = new JLabel("email :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmail.setBounds(39, 268, 80, 22);
		contentPane.add(lblEmail);
		
		emailtextField = new JTextField();
		emailtextField.setFont(new Font("Tahoma", Font.BOLD, 15));
		emailtextField.setColumns(10);
		emailtextField.setBackground(SystemColor.inactiveCaptionBorder);
		emailtextField.setBounds(159, 270, 181, 22);
		contentPane.add(emailtextField);
		
		JButton loginButon = new JButton("I have account for login");
		loginButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginPage login = new LoginPage();
				login.setVisible(true);
				
			}
		});
		loginButon.setFont(new Font("Tahoma", Font.BOLD, 15));
		loginButon.setBounds(114, 435, 280, 25);
		contentPane.add(loginButon);
	}
}
