package controller.member;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberDiscriptController {
	public void execute (HttpServletRequest request) {
		// 로그인 사용자 아이디로 정보확인
		String memId = "ㅇㅇ"; // 임의의 사용자 아이디를 사용. (나즁애 ㄱ호르인)
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.selectUser(memId);
		request.setAttribute("memberDTO", dto);
	}
}
