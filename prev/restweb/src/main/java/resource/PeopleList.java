package resource;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
		this.add("김희자", "1234", "my@exmail.com", "서울 강남", "01078784545","잘 부탁드립니다.");
		this.add("복재규", "1234", "you@exmail.com", "광주", "01078784545","잘 부탁드립니다.");
		this.add("정남준", "1234", "the@exmail.com", "경기", "01078784545","잘 부탁드립니다.");
		this.add("남궁대식", "1234", "me@exmail.com", "부산", "01078784545","잘 부탁드립니다.");
		this.add("하광석", "1234", "the@exmail.com", "충남", "01078784545","잘 부탁드립니다.");
		this.add("강현", "1234", "mi@exmail.com", "서울", "01078784545","잘 부탁드립니다.");
		this.add("유명진", "1234", "to@exmail.com", "강원", "01078784545","잘 부탁드립니다.");
		this.add("양우영", "1234", "see@exmail.com", "충북", "01078784545","잘 부탁드립니다.");
		this.add("한은미", "1234", "some@exmail.com", "경북", "01078784545","잘 부탁드립니다.");
		this.add("유지은", "1234", "add@exmail.com", "경남", "01078784545","잘 부탁드립니다.");
		this.add("정지", "1234", "this@exmail.com", "경남", "01078784545","잘 부탁드립니다.");
		this.add("백윤자", "1234", "super@exmail.com", "서울", "01078784545","잘 부탁드립니다.");
		this.add("추영호", "1234", "put@exmail.com", "경기", "01078784545","잘 부탁드립니다.");
		this.add("하남순", "1234", "get@exmail.com", "서울", "01078784545","잘 부탁드립니다.");
		this.add("오석준", "1234", "post@exmail.com", "경남", "01078784545","잘 부탁드립니다.");
		this.add("백재용", "1234", "ex@exmail.com", "강원", "01078784545","잘 부탁드립니다.");
		this.add("오미연", "1234", "bin@exmail.com", "강원", "01078784545","잘 부탁드립니다.");
		this.add("권원웅", "1234", "eye@exmail.com", "경기", "01078784545","잘 부탁드립니다.");
		this.add("양범수", "1234", "org@exmail.com", "서울", "01078784545","잘 부탁드립니다.");
		this.add("배경아", "1234", "ko@exmail.com", "경남", "01078784545","잘 부탁드립니다.");
		this.add("류희은", "1234", "coco@exmail.com", "경남", "01078784545","잘 부탁드립니다.");
		this.add("표규철", "1234", "key@exmail.com", "서울", "01078784545","잘 부탁드립니다.");
		this.add("황보성", "1234", "pass@exmail.com", "경기", "01078784545","잘 부탁드립니다.");
		this.add("양여진", "1234", "card@exmail.com", "서울", "01078784545","잘 부탁드립니다.");
	}
	
	/** 리스트에 인적사항 추가 */
	public void add(String name, String pwd, String email, String address, String phone, String bio) {
		People people = new People(name, pwd, email, address, phone, bio);
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
	
	/**목록 개수 세기*/
	public int getListCount() {
		int size = list.size();
		if(size < 1) return 0;
		return size / 10 + 1;
	}
	
	/**해당 페이지 목록*/
	public JSONArray toPeopleListJson(int page) {
		int start = list.size() - (page - 1) * 10 - 1;
		int end = list.size() - 10 * page;
		end = end >= 0 ? end : 0;
		
		System.out.printf("ID목록 : %d ~ %d\n",start, end);
		
		JSONArray arr = new JSONArray();
		for(int i = start; i >= end; i--) {
			People p = list.get(i);
			JSONObject data = new JSONObject();
			data.put("id",	p.getID());
			data.put("name",p.getName());
			arr.add(data);
		}
		
		return arr;
	}
}
