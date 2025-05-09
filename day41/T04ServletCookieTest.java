package day41;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T04ServletCookieTest extends HttpServlet {
/*
 	서블릿을 이용한 쿠키정보 처리하기
 	=> 웹브라우저는 애플리케이션을 위한 필요한 값을 쿠키를 통해 공유하여 상태를 유지한다.
 	
 	1. 구성요소?
 	- 이름
 	- 값
 	- 유효시간(초)
 	- 도메인 : ex) www.somehost.com, .somehost.com
 		 =>  쿠키의 도메인이 쿠키를 생성한 서버의 도메인을 벗어나면 브라우저는 쿠키를 생성(저장)하지 않는다.
 	- 경로 : 쿠키를 공유할 기준경로를 지정한다. => 지정하지 않으면 실행한 URL의 경로부분이 사용됨.
 	
 	2. 동작 방식
 	- 쿠키 생성단계 : 생성한 쿠키를 응답메시지의 헤더에 저장하여 브라우저에 전송한다.
 	- 쿠키 저장단계 : 브라우저는 응답메시지의 헤더에 포함된 쿠키를 쿠키저장소에 보관한다.
 	- 쿠키 전송단계 : 브라우저는 저장한 쿠키를 요청이 있을 때마다 웹서버에 전송한다.
 				  (삭제되기 전까지 계속...) 웹서버는 브라우저가 전송한 쿠키를 사용하여
 				  					  필요한 작업을 수행한다.
*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//setCookieExam(req, resp); // 쿠키설정 예제
		
		//readCookieExam(req, resp); // 쿠키읽기 예제
		
		deleteCookieExam(req, resp); // 쿠키삭제 예제
		
	}
	
	private void deleteCookieExam(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	/*
		사용중인 쿠키정보를 삭제하는 방법...
		
		1. 사용중인 쿠키정보를 이용하여 쿠키객체를 생성한다.
		2. 쿠키객체의 최대지속시간을 0으로 설정한다.
		3. 설정한 쿠키객체를 응답헤더에 추가하여 전송한다.
	*/
		
		// 현재 도메인에서 사용중인 쿠키정보 배열 가져오기
		Cookie[] cookies = req.getCookies();

		//////////////////////////////////////////////

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();
		String title = "쿠키정보 삭제 예제";

		out.print("<!DOCTYPE html><html><head><title>"
				+ title + "</title><head>"
				+ "<body>");
		
		if(cookies != null) {
			out.print("<h2>" + title + "</h2>");
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("userId")) {
					// 쿠키 제거하기
					cookie.setMaxAge(0);
					
					resp.addCookie(cookie);
					out.print("<b>삭제한 쿠키 : </b>"
							+ cookie.getName() + "<br>");
				}
				
				out.print("<b>name : </b>" 
						+ cookie.getName() + "<br>");
				out.print("<b>value : </b>" 
						+ URLDecoder.decode(cookie.getValue(), "UTF-8") + "<br>");
			}
		}else {
			out.print("<h2>쿠키정보가 없습니다.</h2>");
		}
		
		out.print("</body></html>");
		
	}

	private void readCookieExam(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// 현재 도메인에서 사용중인 쿠키정보 배열 가져오기
		Cookie[] cookies = req.getCookies();
		
		//////////////////////////////////////////////
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		String title = "쿠키정보 읽기 예제";
		
		out.print("<!DOCTYPE html><html><head><title>"
				+ title + "</title><head>"
				+ "<body>");
		
		if(cookies != null) {
			out.print("<h2>" + title + "</h2>");
			
			for(Cookie cookie : cookies) {
				out.print("<b>name : </b>" 
						+ cookie.getName() + "<br>");
				out.print("<b>value : </b>" 
						+ URLDecoder.decode(cookie.getValue(), "UTF-8") + "<br>");
				out.print("<b>domain : </b>" 
						+ cookie.getDomain() + "<br>");
				out.print("<b>path : </b>" 
						+ cookie.getPath() + "<br>");
				out.print("<b>MaxAge(초) : </b>" 
						+ cookie.getMaxAge() + "<br>");
				out.print("<hr>");
			}
		}else {
			out.print("<h2>쿠키 정보가 없습니다.</h2>");
		}
		out.print("</body></html>");
		
	}

	private void setCookieExam(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		// 쿠키 생성하기
		Cookie userId = new Cookie("userId", req.getParameter("userId"));
		
		// 쿠키값에 한글을 사용하는 경우를 대비해서 인코딩 처리를 해준다.
		Cookie name = new Cookie("name", URLEncoder
				.encode(req.getParameter("name"), "UTF-8"));
		
		// 쿠키 소멸시간 설정(초단위) => 지정하지 않으면 웹브라우저 종료할때 쿠키를 함께 삭제한다.
		userId.setMaxAge(60 * 60 * 24); // 1일
		userId.setHttpOnly(true); // 자바스크립트를 이용한 직접접근 방지
		
		name.setMaxAge(60 * 60 * 48);
		
		/////////////////////////////////////////////////////
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		// 응답헤더에 쿠키 추가하기
		resp.addCookie(userId);
		resp.addCookie(name);
		
		PrintWriter out = resp.getWriter();
		String title = "쿠키설정 예제";
		
		out.print("<!DOCTYPE html><html><head><title>" 
				+ title + "</title></head>"
				+ "<body>"
				+ "<h1 align=\"center\">" + title + "</h1>"
				+ "<ul>"
				+ "<li><b>ID</b> : "
				+ req.getParameter("userId") + "</li>"
				+ "<li><b>이름</b> : "
				+ req.getParameter("name") + "</li>"
				+ "</ul></body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}