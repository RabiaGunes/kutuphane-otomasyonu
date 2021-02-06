package kutuphane;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class userManage extends MysqlCon {
		
	private user kullanici;
	

	public userManage() {
		
	}
	
	public userManage(user kullanici) {
		this.kullanici=kullanici;
	}
	
	void login() {
		
		
		String sql = "select * from uyeler where email=? and password=?";
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1,getKullanici().getEmail().toString());
			stmt.setString(2,getKullanici().getPassword().toString());
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				getKullanici().setEmail(rs.getString("email"));
				getKullanici().setName(rs.getString("name"));
				getKullanici().setId(rs.getInt("user_id"));
				getKullanici().setPassword(rs.getString("password"));
				getKullanici().setSurname(rs.getString("surname"));
				
				getKullanici().setIsAuth(true);
				
			}		
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "have a mistake");
		
		}
		
		
		
	}
	

	public user getKullanici() {
		return kullanici;
	}

	public void setKullanici(user kullanici) {
		this.kullanici = kullanici;
	}
	
	
}
