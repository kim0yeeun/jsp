package controller.member;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberWriteController {
	public void execute(HttpServletRequest request) {
		String memNum = request.getParameter("memNum");
		String memName = request.getParameter("memName");
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		String memPwCon = request.getParameter("memPwCon");
		String memPhone1 = request.getParameter("memPhone1");
		String memPhone2 = request.getParameter("memPhone2");
		String memAddr = request.getParameter("memAddr");
		String memEmail = request.getParameter("memEmail");
		String memGender = request.getParameter("memGender");
		// 문자열 date로 변경
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date regiDate = null;
		String memRegiDate = request.getParameter("memRegidate");
		System.out.println(memRegiDate);
		try {
			regiDate = sdf.parse(memRegiDate);
		}catch (Exception e) {e.printStackTrace();}
		String memBirth = request.getParameter("memBirth");
		String [] dateTime = memBirth.split("T");
		// 문자열을 date로 변경한 후에 Timestamp로 변경한다. 
		
		Date memBirthDay = null;
		try {
			memBirthDay = sdf.parse(dateTime[0]); // 년월일
		}catch (Exception e) {e.printStackTrace();}
		Timestamp birthday = new Timestamp(memBirthDay.getTime());
		
		MemberDTO dto = new MemberDTO();
		dto.setMemAddr(memAddr);
		dto.setMemBirth(birthday);
		dto.setMemEmail(memEmail);
		dto.setMemGender(memGender);
		dto.setMemId(memId);
		dto.setMemName(memName);
		dto.setMemNum(memNum);
		dto.setMemPhone1(memPhone1);
		dto.setMemPhone2(memPhone2);
		dto.setMemPw(memPw);
		dto.setMemRegiDate(regiDate);
	
		// dto 를 다오에 전달해야 db에 전달할 수 있음.
		
		MemberDAO dao = new MemberDAO();
		dao.memberInsert(dto);
		
	}
}
