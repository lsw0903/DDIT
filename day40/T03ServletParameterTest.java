package day40;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T03ServletParameterTest extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	/*
	 	요청객체로부터 요청파라미터 정보를 가져오는 방법
	 	
	 	- getParameter() : 파라미터값이 1개인 경우에 사용함.
	 	- getParameterValues() : 파라미터값이 여러개인 경우에 사용함. ex) 체크박스
	 	- getParameterNames() : 요청객체로 접근 가능한 모든 파라미터 이름 가져올때 사용.
	*/
		
		// POST방식으로 넘어오는 Body데이터를 읽어오기 전에 인코딩 정보를 
		// 설정해야 한다.(반드시 값을 읽어오기 전에 설정함.)
		req.setCharacterEncoding("UTF-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String hobby = req.getParameter("hobby");
		
		String rlgn = req.getParameter("rlgn");
		
		String[] foods = req.getParameterValues("food");
		
		/////////////////////////////////////////////////
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		out.print("<p>username : " + username + "</p>");
		out.print("<p>password : " + password + "</p>");
		out.print("<p>gender : " + gender + "</p>");
		out.print("<p>hobby : " + hobby + "</p>");
		out.print("<p>rlgn : " + rlgn + "</p>");
		
		if(foods != null){
			for(String food : foods) {
				out.print("<p>food : " + food + "</p>");
			}
		}
		
		out.print("<hr>");
		
		// 모든 파라미터 이름 정보 가져오기
		Enumeration<String> paramNames = req.getParameterNames();
		while(paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			out.print("<p>파라미터 이름 : " + paramName + "</p>");
			out.print("<p>파라미터 값 : " 
					+ req.getParameter(paramName) + "</p>");
		}
		
		out.print("</body></html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
		
	}
}