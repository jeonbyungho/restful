package servlet.json;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import resource.*;
import support.ServiceSupport;

@WebServlet("/people/list/*")
public class ResponseToList extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("◆ /people/list/* : Service()");
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("◆ /people/list/* : Get()");
		
		// 🐎 HTTP 메서드.
		String method = req.getMethod();
		// 🔖 리소스의 인덱스 번호.
		int pathInfo = ServiceSupport.pathInfo_toInt(req);
		
		System.out.printf("- Method : %s \n", method);
		System.out.printf("- Path info : %d \n", pathInfo);
		
		// 저장소 할당
		PeopleList plist = PeopleList.get();
		
		// 📨 응답 헤더 Content-Type 설정 : 전송 데이터의 형태와 인코딩을 지정.
		resp.setContentType("application/json;charset=utf-8");
		
		// 📨 응답 메시지 body 출력 객체 할당.
		PrintWriter out = resp.getWriter();
		
		// 📜 json 형태로 출력하기
		JSONArray json = plist.toPeopleListJson(pathInfo);
		out.print(json.toJSONString());
		
		System.out.printf("- json : %s \n", json.toJSONString());
	}

}
