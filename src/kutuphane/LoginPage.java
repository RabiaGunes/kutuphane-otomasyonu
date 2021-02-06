package kutuphane;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField emailText;
	private JPasswordField passwordText;
	
	userManage manage = new userManage();
	Connection con;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("    Login Page");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 0, 134, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("  email :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(308, 127, 97, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("  password :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPassword.setBounds(309, 217, 116, 32);
		contentPane.add(lblPassword);
		
		emailText = new JTextField();
		emailText.setFont(new Font("Tahoma", Font.BOLD, 17));
		emailText.setBounds(452, 137, 163, 22);
		contentPane.add(emailText);
		emailText.setColumns(10);
		
		passwordText = new JPasswordField();
		passwordText.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordText.setBounds(452, 223, 163, 22);
		contentPane.add(passwordText);
		
		JButton LoginButon = new JButton("Login");
		LoginButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				((MysqlCon) con).con_db();
				
				String email = emailText.getText().toString();
				String pass = passwordText.getText().toString();
				
				user user = new user();
				
				user.setEmail(email);
				user.setPassword(pass);
				
				manage.setKullanici(user);
				manage.login();
				
				if(manage.getKullanici().getIsAuth()) {
					HomePage home = new HomePage(manage);
					home.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"please create account");
				}
				
			}
		});
		LoginButon.setBackground(new Color(0, 206, 209));
		LoginButon.setForeground(new Color(255, 255, 255));
		LoginButon.setFont(new Font("Tahoma", Font.BOLD, 17));
		LoginButon.setBounds(410, 351, 116, 32);
		contentPane.add(LoginButon);
		
		JLabel backLable = new JLabel("");
		backLable.setBounds(31, 85, 216, 257);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/loginImage.jpg"));
		backLable.setIcon(img);
		contentPane.add(backLable);
	}
}
