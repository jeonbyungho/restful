package restweb.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.simple.JSONObject;

import restweb.resource.*;
import restweb.support.*;

@WebServlet(urlPatterns = {"/profile", "/profile/*"})
public class ProfileService extends HttpServlet {
	
	private String method;		// 	HTTP 메서드 : GET
	private int pathinfo;		// 	/info
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.method = req.getMethod();
		this.pathinfo = ServletSupporter.pathinfo(req.getPathInfo());
		
		System.out.printf("◆ call \t: Profile.service()\n"
				+ "├─ %s Method \n"
				+ "├─ path : %d \n"
				, this.method, this.pathinfo);
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("format");
		parameter = parameter == null ? "" : parameter;
		System.out.printf("◆ GET \t: Profile, Format : %s\n", parameter);
		if(parameter.equals("json")) {
			doGet_Profile(req, resp);
			return;
		}
		HTMLforward(req, resp);
	}
	
	private void doGet_Profile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.printf("◆ GET \t: Profile Response \n");
		
		PeopleList peopleList = PeopleList.get();
		People people = peopleList.findAnId(this.pathinfo);
		
		// 응답 헤더 Content-Type 설정 : 전송 데이터의 형태와 인코딩을 지정.
		resp.setContentType("application/json;charset=utf-8");
		
		// 응답 메시지 body 출력 객체 할당.
		PrintWriter out = resp.getWriter();
		
		// 📜 json 형태로 출력하기
		JSONObject json = people.toJson();
		out.print(json.toJSONString());
		
		System.out.printf("- json : %s \n", json.toJSONString());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("◆ POST \t: Create Profile");
		
		// Request UTF-8 인코딩으로 지정한다.
		req.setCharacterEncoding("UTF-8");
		
		// Response Content-Type 설정
		resp.setContentType("application/json;charset=utf-8");
		
		// *.json 형태로 읽어온다.
		JSONParser jparser = ServletSupporter.reqToJSONParser(req);
		
		// 입력 받은 메시지로 직원을 추가한다.
		PeopleList peopleList = PeopleList.get();
		try {
			LinkedHashMap<String, Object> map = jparser.parseObject();
			
			String reqName 		= map.get("name").toString();
			String reqEmail  	= map.get("email").toString();
			String reqAddress  	= map.get("address").toString();
			String reqTel  		= map.get("tel").toString();
			
			peopleList.add(reqName, reqEmail, reqAddress, reqTel);
		} catch (ParseException e){
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("◆ PUT \t: Update Profile");
		
		// Request UTF-8 인코딩으로 지정한다.
		req.setCharacterEncoding("UTF-8");
		
		// Response Content-Type 설정
		resp.setContentType("application/json;charset=utf-8");
		
		// *.json 형태로 읽어온다.
		JSONParser jparser = ServletSupporter.reqToJSONParser(req);
		
		// 입력 받은 메시지로 직원 정보를 수정한다.
		PeopleList peopleList = PeopleList.get();
		try {
			LinkedHashMap<String, Object> map = jparser.parseObject();
			
			String reqid 		= map.get("id").toString();
			String reqName 		= map.get("name").toString();
			String reqEmail  	= map.get("email").toString();
			String reqAddress  	= map.get("address").toString();
			String reqTel  		= map.get("tel").toString();
			
			int id = Integer.parseInt(reqid);
			
			peopleList.update(id, reqName, reqEmail, reqAddress, reqTel);
		} catch (ParseException e){
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("◆ DELECT \t: Remove Profile");
		
		// Request UTF-8 인코딩으로 지정한다.
		req.setCharacterEncoding("UTF-8");
		
		// Response Content-Type 설정
		resp.setContentType("application/json;charset=utf-8");
		
		PeopleList peopleList = PeopleList.get();
		peopleList.del(pathinfo);
		
	}
	
	
	private void HTMLforward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher
			reqDispatcher = req.getRequestDispatcher("/element.html");
			reqDispatcher.forward(req, resp);
	}
}
