package restweb.resource;

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
		add("최혜영", "my@naver.com", "경기도", "01023456789");
		add("김태지", "my@gmail.com", "서울", "01013456789");
		add("오준호", "my@exmail.com", "경기도", "0102316789");
		add("최준일", "my@daum.net", "강원도", "0108456789");
		add("한인용", "my@naver.com", "충청도", "01073476789");
		
		add("봉준호", "my@naver.com", "경상도", "01021446789");
		add("권경원", "my@naver.com", "경상도", "01023455789");
		add("윤진하", "my@naver.com", "서울", "01053456789");
		add("손동빈", "my@naver.com", "서울", "01023456789");
		add("설동수", "my@naver.com", "광주", "01023456789");
		
		add("하지현", "my@naver.com", "제주", "01021446789");
		add("복승은", "my@naver.com", "전라도", "01023455789");
		add("유원정", "my@naver.com", "서울", "01053456789");
		add("서달", "my@naver.com", "전라도", "01023456789");
		add("백한길", "my@naver.com", "대구", "01023456789");
	}
	
	/** 리스트에 인적사항 추가 */
	public void add(String name, String email, String address, String phone) {
		People people = new People(name, email, address, phone);
		System.out.println(people.toString());
		this.list.add(people);
	}
	
	/** ID 값으로 조회 */
	public People findAnId(int id) {
		People people = null;
		
		for(People p : list) {
			if(id == p.getId()) {
				people = p;
				break;
			}
		}
		
		return people;
	}
	
	/**인적사항 수정*/
	public void update(int id, String name, String email, String address, String phone) {
		People people = findAnId(id);
		people.setName(name);
		people.setEmail(email);
		people.setAddress(address);
		people.setTel(phone);
		System.out.println(people.toString());
		this.list.add(people);
	}
	
	/**요소 삭제*/
	public void del(int id) {
		list.remove(findAnId(id));
		System.out.println(list.size());
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
			data.put("id",	p.getId());
			data.put("name",p.getName());
			arr.add(data);
		}
		
		return arr;
	}
}
