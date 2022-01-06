package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import model.DAO.MemberDAO;
import model.DTO.AuthInfo;
import model.DTO.MemberDTO;

public class MemberDiscriptController {
	public void execute (HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 로그인 사용자 아이디로 정보확인
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");  // 아래의 내용을 이렇게 바굼 -> memId를 바꿔줘여함 
		// String memId = (String)session.getAttribute("id"); // 로그인 세션
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.selectUser(authInfo.getUserId());
		request.setAttribute("memberDTO", dto);
	}
}
