package servlet.page;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.simple.JSONObject;

import resource.PeopleList;

@WebServlet("/people")
public class PeopleService extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("◆ /people : Service()");
		super.service(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("◆ /people : Post()");
		
		PeopleList plist = PeopleList.get();
		
		// 🐎 HTTP 메서드.
		String method = req.getMethod();
		
		System.out.printf("- Method : %s \n", method);
		
		// 📢 요청 메시지 인코딩 지정.
		req.setCharacterEncoding("UTF-8");
		// 📢 요청 메시지 body 읽기 객체 할당.
		BufferedReader reader = req.getReader();
		reader.ready();
		
		// 🔍 .json 읽어오기
		StringBuffer
			msgBuffer = new StringBuffer();
		
		while(reader.ready()) {
			String str = reader.readLine();
			msgBuffer.append(str);
		}
		
		String msg = msgBuffer.toString();
		System.out.printf("▶ req.json : %s\n", msg);
		
		msgBuffer.setLength(0);
		
		JSONParser jparser = new JSONParser(msg);
		try {
			LinkedHashMap<String, Object> map = jparser.parseObject();
			String reqName = null;
			String reqPwd = null;
			String reqEmail = null;
			String reqAddress = null;
			String reqTel = null;
			String reqBio = null;
			for(String key : map.keySet()) {
				System.out.println(key + " : " + map.get(key));
				reqName = map.get("name").toString();
				reqPwd = map.get("pwd").toString();
				reqEmail = map.get("email").toString();
				reqAddress = map.get("address").toString();
				reqTel = map.get("tel").toString();
				reqBio = map.get("bio").toString();
			}
			plist.add(reqName, reqPwd, reqEmail, reqAddress, reqTel, reqBio);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		// 📨 응답 메시지 Content-Type 설정 : 전송 데이터의 형태와 인코딩을 지정.
		resp.setContentType("application/json;charset=utf-8");
		
	}
}
