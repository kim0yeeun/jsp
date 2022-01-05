package controller.member;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;

public class MemberNumberContoller {
	public void execute(HttpServletRequest request) {
		MemberDAO dao = new MemberDAO();
		String memberNum = dao.numberGenerate();
		System.out.println(memberNum);
	      request.setAttribute("memberNum", memberNum);
	}

}
