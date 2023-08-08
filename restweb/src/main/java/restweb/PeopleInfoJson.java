package restweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/people/info/*")
public class PeopleInfoJson extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("◆ Servlet People Json: Service()");
		super.service(req, resp);
	}
	
	/** URI 리소스 인덱스 int타입으로 변환*/
	private int pathInfo_toInt(HttpServletRequest req) {
		
		String  pathInfo = 	req.getPathInfo();
				pathInfo =  pathInfo.replace("/", "");
				
		return Integer.parseInt(pathInfo);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("◆ Servlet People Json : doGet()");
		
		// 🐎 HTTP 메서드.
		String method = req.getMethod();
		// 🔖 리소스의 인덱스 번호.
		int pathInfo = pathInfo_toInt(req);
		
		System.out.printf("- Method : %s \n", method);
		System.out.printf("- Path info : %d \n", pathInfo);
		
		// 📨 응답 헤더 Content-Type 설정 : 전송 데이터의 형태와 인코딩을 지정.
		resp.setContentType("application/json;charset=utf-8");
		
		// 📨 응답 메시지 body 출력 객체 할당.
		PrintWriter out = resp.getWriter();
		
		// 임시 구현
		JSONObject json = new JSONObject();
		json.put("id", pathInfo);
		json.put("name", "kim");
		out.print(json.toJSONString());
		
		System.out.printf("- json : %s \n", json.toJSONString());
	}

}
