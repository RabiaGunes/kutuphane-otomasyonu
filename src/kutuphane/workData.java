package kutuphane;

import java.sql.*;
import java.time.LocalDate;

import javax.swing.JOptionPane;

public class workData extends MysqlCon {

	public workData() {
		
	}
	
	
	
	void kullaniciEkle(String name, String pass , String email, String surname) {
		
		String sql = "INSERT INTO uyeler(name , surname , email , password) values(?,?,?,?) ";
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1,name);
			stmt.setString(2,surname);
			stmt.setString(3,email);
			stmt.setString(4,pass);
			
			stmt.execute();
			stmt.close();
			
			System.out.println("basarili");
			
		} catch (SQLException e) {
			
			 JOptionPane.showMessageDialog(null, "This account already has a user");
			
		}
		
		
		
	}
	
		
	public ResultSet kullaniciArsivGetir(userManage manage) {
		
		String sql = "SELECT * FROM uye_arsiv WHERE uye_id=? ";
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1,manage.getKullanici().getId());
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				return rs;
			}else {
				return null;
			}
	
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		
		
		
	}
	
	
	void kitapEkle(userManage manage, String book_name , String date , String delivery_date) {
			
		String sql = "INSERT INTO uye_arsiv(book_name,uye_id,book_date,delivery_date) VALUES(?,?,?,?)";
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, book_name);
			stmt.setInt(2, manage.getKullanici().getId());
			stmt.setString(3, date);
			stmt.setString(4,delivery_date);
			
			
			stmt.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public ResultSet kitaplariGetir() {
		
		String sql ="SELECT * FROM books";
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
				
			if(rs.next()) {
				return rs;
			}else {
				return null;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	
	}
	
	
		
		
	}
	
