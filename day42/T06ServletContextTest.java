package day42;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T06ServletContextTest extends HttpServlet {
/*
 	서블릿 컨텍스트 객체에 대하여...
 	
 	1. 서블릿 프로그램이 컨테이너와 정보를 주고받기 위한 메서드를 제공한다.
 	ex) 파일의 MIME TYPE 정보 가져오기, 요청정보 보내기(forward), 로깅작업 등.
 	
 	2. 웹애플리케이션당 1개씩 생성된다.
*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext ctx = req.getServletContext();
		
		System.out.println("서블릿컨텍스트의 기본 경로 : "
							+ ctx.getContextPath());
		System.out.println("서버 정보 : " + ctx.getServerInfo());
		System.out.println("서블릿 API의 메이저 버전정보 : "
							+ ctx.getMajorVersion());
		System.out.println("서블릿 API의 마이너 버전정보 : "
							+ ctx.getMinorVersion());
		System.out.println("리소스 경로 목록 : "
							+ ctx.getResourcePaths("/"));
		System.out.println("파일에 대한 MIME 타입정보 : "
							+ ctx.getMimeType("a.mp3"));
		System.out.println("파일시스템 상의 실제 경로 : "
							+ ctx.getRealPath("/"));
		
		// 속성값 설정(저장)
		ctx.setAttribute("attr1", "속성1");
		
		// 속성값 변경
		ctx.setAttribute("attr1", "속성11");
		
		// 속성값 가져오기
		System.out.println("attr1의 속성값 : "
							+ ctx.getAttribute("attr1"));
		
		// 속성값 지우기
		ctx.removeAttribute("att1");
		System.out.println("attr1의 속성값 : "
							+ ctx.getAttribute("attr1"));
		
		// 로깅 작업하기
		ctx.log("서블릿컨텍스트를 이용한 로깅 작업 중입니다.");
		
		// 포워딩(forward) 처리
		RequestDispatcher rd =
				ctx.getRequestDispatcher("/T05ServletSessionTest");
		rd.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
