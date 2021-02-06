package kutuphane;

public class user {

	private String name;
	private String surname;
	private String email;
	private String password;
	private int id;
	private boolean isAuth = false;
	


	public user(){
		
		
	}
	
	public user(String name , String password , String surname, String email , int id) {
	
		this.name=name;
		this.password=password;
		this.email=email;
		this.id=id;
		this.surname=surname;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public boolean getIsAuth() {
		return isAuth;
	}

	public void setIsAuth(boolean isAuth) {
		this.isAuth = isAuth;
	}
	
	
}
