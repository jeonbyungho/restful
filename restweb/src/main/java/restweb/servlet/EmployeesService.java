package restweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import restweb.support.ServletSupporter;

@WebServlet(urlPatterns = {"/employees", "/employees/*"})
public class EmployeesService extends HttpServlet {
	
	private String method;		// 	HTTP 메서드 : GET
	private int pathinfo;		// 	/info
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.method = req.getMethod();
		this.pathinfo = ServletSupporter.pathinfo(req.getMethod());
		
		System.out.printf("◆ call \t: Employees.service()\n"
				+ "├─ %s Method \n"
				+ "├─ path : %d \n"
				, this.method, this.pathinfo);
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HTMLforward(req, resp);
		System.out.println("◆ GET \t: Employees");
	}
	
	private void HTMLforward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher
			reqDispatcher = req.getRequestDispatcher("/collection.html");
			reqDispatcher.forward(req, resp);
	}
}
