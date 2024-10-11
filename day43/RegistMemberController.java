package day43;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/member/insert.do")
public class RegistMemberController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/member/insertForm.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//req.setCharacterEncoding("UTF-8");
		
		String memId = req.getParameter("memId");
		String memName = req.getParameter("memName");
		String memTel = req.getParameter("memTel");
		String memAddr = req.getParameter("memAddr");
		
		IMemberService memService = MemberServiceImpl.getInstance();
		
		MemberVO mv = new MemberVO(memId, memName, memTel, memAddr);
		
		int cnt = memService.registMember(mv);
		
		String msg = "";
		
		if(cnt > 0) {
			// 회원등록 성공
			msg = "SUCCESS";
		}else {
			// 회원등록 실패!
			msg = "FAIL";
		}
		
		req.getSession().setAttribute("msg", msg);
		
		////////////////////////////////
		// 회원목록 조회화면으로 이동하기
		//req.getRequestDispatcher("/member/list.do").forward(req, resp);
		
		resp.sendRedirect(req.getContextPath() + "/member/list.do");
		
	}
}