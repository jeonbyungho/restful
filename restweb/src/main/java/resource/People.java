package resource;

import java.util.List;

import org.json.simple.JSONObject;

import java.util.ArrayList;

public class People {
	
	private static int 	_conunt = 0;
	
	private final int 	id;
	private String 		name;
	private String 		pwd;
	private String 		email;
	private String 		address;
	private String 		phone;
	
	public People(String name, String pwd, String email, String address, String phone) {
		this.id = ++_conunt;
		
		this.name 	 = name;
		this.pwd 	 = pwd;
		this.email 	 = email;
		this.address = address;
		this.phone 	 = phone;
		
	}
	
	public int getID() { 
		return id;
	}

	public String getName() { 
		return name;
	}

	public String getPwd() { 
		return pwd;
	}

	public String getEmail() { 
		return email;
	}

	public String getAddress() { 
		return address;
	}

	public String getPhone() { 
		return phone;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", pwd=" + pwd + ", email=" + email + ", address=" + address
				+ ", phone=" + phone + "]";
	}
	
	public JSONObject toJson() {
		JSONObject people = new JSONObject();
		
		people.put("id"		, String.valueOf(this.id));
		people.put("name"	, this.name);
		people.put("pwd"	, this.pwd);
		people.put("email"	, this.email);
		people.put("address", this.address);
		people.put("phone"	, this.phone);
		
		return people;
	}
}
