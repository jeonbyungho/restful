package restweb.support;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.json.JSONParser;

public class ServletSupporter {
	
	/**
	 * uri의 경로 정보(\/info)를 int형으로 전환 시켜주는 메서드.
	 */
	public static int pathinfo(String pathinfo) {
		int info;
		
		if(pathinfo == null) {
			return 0;
		}
		
		try {
			pathinfo = pathinfo.substring(1);
			info = Integer.parseInt(pathinfo);
		} catch (NumberFormatException e) {
			info = 0;
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			info = 0;
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			info = 0;
			System.out.println(e.getMessage());
		}
		
		return info;
	}
	
	/** Req*/
	public static JSONParser reqToJSONParser(HttpServletRequest req) throws ServletException, IOException{
		JSONParser jparser = null;
		// Request body을 입력 받는다.
		BufferedReader reader = req.getReader();
		
		// 요청 받은 json을 처리한다.
		StringBuffer msgBuffer = new StringBuffer();
		
		/*
		 *  한 줄씩 문자열 버퍼에 값을 저장하고,
		 *  더 이상 읽어올 메시지가 없다면, while이 끝난다.
		 *  ready() : body에서 더 이상 읽어올 수 있는 데이터가 있는지, 계속 체크한다.
		 */
		while(reader.ready()) {
			String str = reader.readLine();
			msgBuffer.append(str);
		}
		String msg = msgBuffer.toString(); // 버퍼에 저장된 문자열
		msgBuffer.setLength(0); // 할 일이 끝난 버퍼를 비우기
		
		jparser = new JSONParser(msg);
		return jparser;
	}
}
