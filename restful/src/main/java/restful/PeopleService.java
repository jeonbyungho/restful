package restful;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/people")
public class PeopleService extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		People people = null;
		PrintWriter out = resp.getWriter();
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json;charset=UTF-8");
		resp.setCharacterEncoding("charset=UTF-8");
		
		String getID = req.getParameter("id");
		int id = Integer.parseInt(getID);
		
		System.out.println("😀doGet");
		System.out.println("method : " + req.getMethod());
		System.out.println("parseInt : " + id);
		
		for (People p : People.getList()) {
			if(p.getID() == id) {
				people = p;
				break;
			}
		}
		
		JSONObject obj = new JSONObject();
		obj.put("id", 		String.valueOf( people.getID() ));
		obj.put("name", 	String.valueOf( people.getName() ));
		obj.put("pwd", 		String.valueOf( people.getPwd() ));
		obj.put("email", 	String.valueOf( people.getEmail() ));
		obj.put("address", 	String.valueOf( people.getAddress() ));
		
		System.out.println(obj.toJSONString());
		out.print(obj.toJSONString());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String getName = req.getParameter("name");
		String getPassword = req.getParameter("pwd");
		String getEmail = req.getParameter("email");
		String getAddress = req.getParameter("address");
		String getPhone = req.getParameter("phone");
		
		System.out.println("method : " + req.getMethod());
		System.out.println("name : " + getName);
		System.out.println("pwd : " + getPassword);
		System.out.println("email : " + getEmail);
		System.out.println("address : " + getAddress);
		System.out.println("phone : " + getPhone);
		
		int password = Integer.parseInt(getPassword);
		int phone = Integer.parseInt(getPhone);
		
		System.out.println("password : " + password);
		System.out.println("phone : " + phone);
		
		People ple = new People(getName, password, getEmail, getAddress, phone);
		System.out.println(ple.toString());
	}
}
