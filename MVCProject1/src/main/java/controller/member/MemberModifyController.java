package controller.member;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberModifyController {
	public void execute (HttpServletRequest request) {
		String memNum = request.getParameter("memNum");
		String memName = request.getParameter("memName");
		String memId = request.getParameter("memId");
		// 패스워드 갖고오면 안됨 
		String memPhone1 = request.getParameter("memPhone1");
		String memPhone2 = request.getParameter("memPhone2");
		String memAddr = request.getParameter("memAddr");
		String memEmail = request.getParameter("memEmail");
		String memGender = request.getParameter("memGender");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date regiDate = null;
		String memRegiDate = request.getParameter("memRegidate");
		System.out.println(memRegiDate);
		try {
			regiDate = sdf.parse(memRegiDate);
		}catch (Exception e) {e.printStackTrace();}
		
		String memBirth = request.getParameter("memBirth");
		String [] dateTime = memBirth.split("T");
		// 2002-12-15 T01:52
		Date memBirthDay = null;
		try {
			memBirthDay = sdf.parse(dateTime[0]);
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
		dto.setMemRegiDate(regiDate);
		
		MemberDAO dao = new MemberDAO();
		dao.memberUpdate(dto);
	}
}
