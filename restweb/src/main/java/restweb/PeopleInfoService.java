package restweb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/people/*")
public class PeopleInfoService extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("◆ Servlet People Info : Service()");
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
		System.out.println("◆ Servlet People Info : doGet()");
		
		// 🐎 HTTP 메서드.
		String method = req.getMethod();
		// 🔖 리소스의 인덱스 번호.
		int pathInfo = pathInfo_toInt(req);
		
		System.out.printf("- Method: %s \n", method);
		System.out.printf("- Path info: %d \n", pathInfo);
		
		RequestDispatcher reqdis = req.getRequestDispatcher("/people-page.html");
		reqdis.forward(req, resp);
	}
}
