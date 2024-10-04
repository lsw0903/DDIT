package day40;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T02ServletTest extends HttpServlet {
/*
	서블릿 동작 방식에 대하여...
	
	1. 사용자(클라이언트)가 URL을 클릭하면 HTTP Request를 서블릿 컨테이너로 전송(요청)한다.
	
	2. 컨테이너는 web.xml에 정의된 URL패턴을 확인하여 어느 서블릿을 통해 처리해야 할지를 검색한다.
	   (로딩이 안된 경우에는 로딩됨. 로딩시 init() 호출된다.)
	
	3. 서블릿 컨테이너는 요청을 처리할 개별 스레드 객체를 생성하여 해당 서블릿 객체의 
	   service() 메서드를 호출한다.
	   (HttpServletRequest 및 HttpServletReponse 객체를 생성하여 넘겨준다.)
	   
	4. service() 메서드는 메서드타입을 체크하여 적절한 메서드를 호출한다.
	   (doget, doPost, doPut, doDelte 등)
	   
	5. 요청 처리가 완료되면 HttpServletRequest 및 HttpServletReponse 객체는 소멸된다.
	
	6. 컨테이너로부터 서블릿이 제거되는 경우에 destroy() 메서드가 호출된다.
*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청객체의 주요 메서드 살펴보기
		
		System.out.println("getCharacterEncoding() : "
				+ req.getCharacterEncoding());
		System.out.println("getCharacterLength() : "
				+ req.getContentLength());
		System.out.println("getContentType() : "
				+ req.getContentType());
		System.out.println("getQueryString() : "
				+ req.getQueryString());
		System.out.println("getProtocol() : "
				+ req.getProtocol());
		System.out.println("getMethod() : "
				+ req.getMethod());
		System.out.println("getRequestURI() : "
				+ req.getRequestURI());
		System.out.println("getHeaderNames() : "
				+ req.getHeaderNames());
		System.out.println("getRemoteAddr() : "
				+ req.getRemoteAddr());
		System.out.println("getRemotePort() : "
				+ req.getRemotePort());
		
		/////////////////////////////////////////
		
		// 요청객체에 정보 저장하기
		req.setAttribute("tel", "5555-5555");
		req.setAttribute("addr", "대전시 중구 오류동");
		
		// 요청객체에 저장된 정보 꺼내기
		System.out.println("tel => " + req.getAttribute("tel"));
		System.out.println("addr => " + req.getAttribute("addr"));
		
		/////////////////////////////////////////
		
		// 응답 메시지 생성하기(응답객체 이용)
		
		// 응답메시지 인코딩 설정(Content-Type의 ;charset=UTF-8 과 동일)
		resp.setCharacterEncoding("UTF-8");
		//resp.setHeader("Content-Type", "text/plain;charset=UTF-8");
		
		// 응답메시지 컨텐트 타입 설정
		resp.setContentType("text/plain");
		
		// Body 내용 작성을 위한 객체 생성하기
		PrintWriter out = resp.getWriter();
		
		out.println("queryString => " + req.getQueryString());
		out.println("서블릿 경로 : " + req.getServletPath());
		out.println("컨텍스트 경로 : " + req.getContextPath());
	}
}