package controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;
import model.DTO.AuthInfo;
import model.DTO.MemberDTO;

public class MemberDropController {
	public void execute (HttpServletRequest request, HttpServletResponse response) {
	
		HttpSession session = request.getSession();
	
		// memid 를 바꾸 ㄹ필요 없움
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String memId = authInfo.getUserId() ;// 로그인 세션
		String memPw = request.getParameter("memPw");
		
		// 멤버 다오를 이용해서 회원의 정보를 가져오자 
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.selectUser(memId);
		
		if (!memPw.equals(dto.getMemPw())) {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (Exception e) {e.printStackTrace();}
			out.print("<script>");
			out.print("alert('비밀번호가 틀립니다.');");
			out.print("location.href = 'memberDrop.mem'"); // 비밀번호가 틀리면 memdrop으로 이동
			out.print("</script>");
			out.close();
			}else {
				dao.MemberDelete(dto.getMemNum());
				String contextPath = request.getContextPath();
				try {
					session.invalidate(); //회원탈퇴하면 세션이 필요 없으니까 날린후에 
					response.sendRedirect(  contextPath + "/"); // 메인으로 간다 
				} catch (Exception e) {e.printStackTrace(); }
				
			}
	}

}
