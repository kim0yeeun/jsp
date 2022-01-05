package controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DTO.MemberDTO;

import model.DAO.MemberDAO;

public class MemberPassModifyController {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memId = "ㅇㅇ";
		String memPw = request.getParameter("memPw");
		String newMemPw = request.getParameter("newMemPw");
		
		// 패스워드가 일치하는지 확인하고 바꾸자
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.selectUser(memId);
		if (!memPw.equals(dto.getMemPw())) { // 일치하지않으면
			request.setAttribute("msg", "비밀번호가 일치하지 않습니다. ");
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/myPage/memberPassCon.jsp");
			dispatcher.forward(request, response); // 예외를 위에 잡아줌 
		}else { // 일치하면 비밀번호를 변경하자
			dao.memberPassUpdate(memId,newMemPw); // id랑 새로운 비밀번호 전달 
			
			// 비밀번호 변경 후 메인 페이지로 보냄
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/"); 
 		}
	}
}
