package kutuphane;

import java.sql.*;  

	public class MysqlCon{  
		
	public static	Connection conn = null;
	public static   Statement stmt = null;
	public static   ResultSet rs = null;
	
	public static Connection con_db(){  
		
	
	try{  
		
		
		String url ="jdbc:mysql://localhost:3306/kutuphane?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";   
		
		String user = "root";
		String password = "1234";
		conn=DriverManager.getConnection(url,user,password);

		System.out.println("connected");
		
		
	
	}
	catch(Exception e){ 
		System.out.println(e);
		}
	
	return conn;
	
	}
	
	}
	  
	

