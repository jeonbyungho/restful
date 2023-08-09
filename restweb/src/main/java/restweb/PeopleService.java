package restweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

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
		
		// 🐎 HTTP 메서드.
		String method = req.getMethod();
		
		System.out.printf("- Method : %s \n", method);
		
		req.setCharacterEncoding("UTF-8");
		// 📨 응답 헤더 Content-Type 설정 : 전송 데이터의 형태와 인코딩을 지정.
		resp.setContentType("application/json;charset=utf-8");
		
		// 📨 응답 메시지 body 출력 객체 할당.
		PrintWriter out = resp.getWriter();
		
		// 임시 구현
		JSONObject json = new JSONObject();
		json.put("응답", 21);
		out.print(json.toJSONString());
		
		System.out.printf("- json : %s \n", json.toJSONString());
	}
}
