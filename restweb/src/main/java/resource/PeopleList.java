package resource;

import java.util.ArrayList;
import java.util.List;

public class PeopleList {
	
	// 🫙싱글톤
	private static PeopleList _current = null;
	
	public static PeopleList get() {
		if(_current == null) _current = new PeopleList();
		return _current;
	}
	
	private List<People> list;
	
	private PeopleList() {
		list = new ArrayList<People>();
		
		this.add("홍길동", "a1234", "gildoing@exmail.com", "서울", "01023456789");
		this.add("김철수", "b5678", "kim@exmail.com", "서울", "010987654321");
		this.add("영희", "abc12", "eng@tempmail.com", "경기", "01045697812");
		this.add("영희1", "abc12", "eng@tempmail.com", "경기", "01045697812");
		this.add("영희2", "abc12", "eng@tempmail.com", "경기", "01045697812");
		this.add("영희3", "abc12", "eng@tempmail.com", "경기", "01045697812");
		this.add("영희4", "abc12", "eng@tempmail.com", "경기", "01045697812");
		this.add("영희5", "abc12", "eng@tempmail.com", "경기", "01045697812");
		this.add("영희6", "abc12", "eng@tempmail.com", "경기", "01045697812");
		this.add("영희7", "abc12", "eng@tempmail.com", "경기", "01045697812");
		this.add("영희8", "abc12", "eng@tempmail.com", "경기", "01045697812");
	}
	
	/** 리스트에 인적사항 추가 */
	public void add(String name, String pwd, String email, String address, String phone) {
		People people = new People(name, pwd, email, address, phone);
		System.out.println(people.toString());
		this.list.add(people);
	}
	
	/** ID 값으로 조회 */
	public People findAnId(int id) {
		People people = null;
		
		for(People p : list) {
			if(id == p.getID()) {
				people = p;
				break;
			}
		}
		
		return people;
	}
}
