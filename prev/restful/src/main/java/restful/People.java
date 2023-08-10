package restful;

import java.util.List;
import java.util.ArrayList;

public class People {
	private static List<People> peoples = new ArrayList<People>();
	
	public static List<People> getList() {
		return peoples;
	}
	
	private static int conunt = 0;
	
	private final int id;
	private String name;
	private int pwd;
	private String email;
	private String address;
	private int phone;
	
	public People(String name, int pwd, String email, String address, int phone) {
		this.id = ++conunt;
		
		this.name = name;
		this.pwd = pwd;
		this.email = email;
		this.address = address;
		this.phone = phone;
		
		peoples.add(this);
		System.out.println(peoples.size());
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPwd() {
		return pwd;
	}
	public void setPwd(int pwd) {
		this.pwd = pwd;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", pwd=" + pwd + ", email=" + email + ", address=" + address
				+ ", phone=" + phone + "]";
	}
}
