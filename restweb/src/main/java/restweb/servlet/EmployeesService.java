package restweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import restweb.resource.PeopleList;
import restweb.support.ServletSupporter;

@WebServlet(urlPatterns = {"/employees", "/employees/*"})
public class EmployeesService extends HttpServlet {
	
	private String method;		// 	HTTP 메서드 : GET
	private int pathinfo;		// 	/info
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.method = req.getMethod();
		this.pathinfo = ServletSupporter.pathinfo(req.getPathInfo());
		this.pathinfo = (this.pathinfo > 0) ? this.pathinfo : 1;
		
		System.out.printf("◆ call \t: Employees.service()\n"
				+ "├─ %s Method \n"
				+ "├─ path : %d \n"
				, this.method, this.pathinfo);
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Query String에서 format의 값을 불러온다.
		String parameter = req.getParameter("format");
		parameter = (parameter == null) ? "" : parameter;	// null인 경우, ""로 대입.
		System.out.printf("◆ GET \t: Employees, Format : %s\n", parameter);
		// fromat이 json이라면 json으로 응답.
		if(parameter.equals("json")) {
			doGet_List(req, resp);
			return;
		}
		// 아닐 경우, html으로 응답.
		HTMLforward(req, resp);
	}
	
	private void doGet_List(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.printf("◆ GET \t: Employees Response \n");
		
		PeopleList peopleList = PeopleList.get();
		
		// 응답 헤더 Content-Type 설정 : 전송 데이터의 형태와 인코딩을 지정.
		resp.setContentType("application/json;charset=utf-8");
		
		// 응답 메시지 body 출력 객체 할당.
		PrintWriter out = resp.getWriter();
		
		// 📜 json 형태로 출력하기
//		JSONArray json = null; 
		JSONArray people_json = peopleList.toPeopleListJson(this.pathinfo);
		
		
		JSONObject json = new JSONObject();
		json.put("page", peopleList.getListCount());
		json.put("list", people_json);
		
		out.print(json.toJSONString());
		
		System.out.printf("- json : %s \n", people_json.toJSONString());
	}
	
	private void HTMLforward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher
			reqDispatcher = req.getRequestDispatcher("/collection.html");
			reqDispatcher.forward(req, resp);
	}
}
