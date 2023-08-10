package restweb.resource;

import org.json.simple.JSONObject;

public class People {
	
	private static int 	_conunt = 0;
	
	private final int 	id;
	private String 		name;
	private String 		email;
	private String 		address;
	private String 		tel;
	
	public People(String name, String email, String address, String tel) {
		this.id = ++_conunt;
		
		this.name 	 = name;
		this.email 	 = email;
		this.address = address;
		this.tel 	 = tel;
		
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getTel() {
		return tel;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", tel=" + tel
				+ "]";
	}
	
	public JSONObject toJson() {
		JSONObject people = new JSONObject();
		
		people.put("id"		, String.valueOf(this.id));
		people.put("name"	, this.name);
		people.put("email"	, this.email);
		people.put("address", this.address);
		people.put("tel"	, this.tel);
		
		return people;
	}
}
