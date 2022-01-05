package controller.member;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberMyUpdateController {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 한글이 깨지는것 방지
		try {
			request.setCharacterEncoding("utf-8");
		} catch (Exception e) {e.printStackTrace();}
		
		String memId = "ㅇㅇ"; // 임의의 사용자 아이디
		String memPw = request.getParameter("memPw");
		String memName = request.getParameter("memName");
		String memPhone1 = request.getParameter("memPhone1");
		String memPhone2 = request.getParameter("memPhone2");
		String memAddr = request.getParameter("memAddr");
		String memEmail = request.getParameter("memEmail");
		String memGender = request.getParameter("memGender");
		
		String memBirth = request.getParameter("memBirth");
		// Birth를 timestamp로  바꾸자
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(memBirth);
		} catch (Exception e) {e.printStackTrace();}
		Timestamp birth = new Timestamp(date.getTime());
		
		MemberDAO dao = new MemberDAO();
		// 입력한 비밀번호와 DB에 있는 비밀번호가 서로 일치하는지 확인 
		// 일치하지 않으면 alert 창을 출력한다. 
		MemberDTO dto = dao.selectUser(memId); // 아이디를 이용해서 갖고옴 
		if (!dto.getMemPw().equals(memPw)) { // alert
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (Exception e) {}
			out.print("<script>");
			out.print("alert('비밀번호가 일치하지 않습니다.');");
			out.print("location.href = 'memberInfoModify.mem'");
			out.print("</script>");
			out.close();
		}else { // 일치한다면
			dto.setMemBirth(birth);
			dto.setMemAddr(memAddr);
			dto.setMemEmail(memEmail);
			dto.setMemGender(memGender);
			dto.setMemId(memId);
			dto.setMemName(memName);
			dto.setMemPhone1(memPhone1);
			dto.setMemPhone2(memPhone2);
			dao.memberMyUpdate(dto); // 다오에 수정한 정보 업데이트 
			try {
				// 페이지 이동 
				response.sendRedirect("memberDiscript.mem");
			} catch (Exception e) {e.printStackTrace();}
		}
		
	}

}
