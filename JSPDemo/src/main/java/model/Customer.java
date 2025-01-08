package model;

public class Customer {
	private String name;
	private String phone;
	private String email;
	private String city;
	private String gender;
	private String username;
	private String password;
	//constructors
	//getters setters
	//tostring
	public Customer() {
		// TODO Auto-generated constructor stub
		
	}	
	public Customer(String name, String phone, String email, String city, String gender,String username,String password) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.city = city;
		this.gender = gender;
		this.username = username;
		this.password = password;
	}
	public Customer(String name, String phone, String email, String city, String gender,String username) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.city = city;
		this.gender = gender;
		this.username = username;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", phone=" + phone + ", email=" + email + ", city=" + city + ", gender="
				+ gender + ", username="+ username +"]";
	}
	
	
	
}
