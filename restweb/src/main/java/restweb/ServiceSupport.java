package restweb;

import javax.servlet.http.HttpServletRequest;

public class ServiceSupport {
	
	/** URI 리소스 인덱스 번호를 int로 형변환 해줌.*/
	public static int pathInfo_toInt(HttpServletRequest req) {
		
		String  pathInfo = 	req.getPathInfo();
				pathInfo =  pathInfo.replace("/", "");
				
		return Integer.parseInt(pathInfo);
	}
}
