package model.DAO;


import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForTokens;

import model.DTO.MemberDTO;

public class MemberDAO  extends DataBaseInfo {  
	final String COLUMES = "MEM_NUM, MEM_NAME, MEM_REGI_DATE,"
			+ "MEM_ID, MEM_PW, MEM_PHONE1, MEM_PHONE2, MEM_ADDR,"
			+ "MEM_EMAIL, MEM_GENDER, MEM_BIRTH";
	// 상수로 하면 관리하기 편함
	// 대신 문자열 밖으로 뺴야함 
	
	public void memberPassUpdate(String memId, String memPw) {
		// MemberPassModifyController 에서 아이디와 새로운 비밀번호를 받아온다
		con = getConnection();
		String sql = "   update member  "
				+ "    set mem_pw = ? "
				+ "    where mem_id = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memPw);
			pstmt.setString(2, memId);
			int i = pstmt.executeUpdate();
			System.out.println(i + " 개의 행이(가) 변경되었습니다.");
		} catch (Exception e) {e.printStackTrace();	}
		finally {close();}
		
	}
	
	public void memberMyUpdate(MemberDTO dto) {
		con = getConnection();
		String sql = " update member"
				+" set MEM_NAME = ? , MEM_PHONE1 = ?, "
     			+" 	   MEM_PHONE2 = ?, MEM_ADDR =?, "
				+"	   MEM_EMAIL = ? , MEM_GENDER= ?, "
     			+"	   MEM_BIRTH = ?"
				+"  where MEM_ID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemName());
			pstmt.setString(2, dto.getMemPhone1());
			pstmt.setString(3, dto.getMemPhone2());
			pstmt.setString(4, dto.getMemAddr());
			pstmt.setString(5, dto.getMemEmail());
			pstmt.setString(6, dto.getMemGender());
			pstmt.setTimestamp(7, dto.getMemBirth());
			pstmt.setString(8, dto.getMemId());
			int i = pstmt.executeUpdate();
			System.out.println(i+" 개의 행이(가) 수정되었습니다. ");
		} catch (Exception e) {e.printStackTrace();}
		finally {close();}
	}
	
	
	public MemberDTO  selectUser(String memId) {
		MemberDTO dto = new MemberDTO();
		con =getConnection();
		String sql = "select " + COLUMES + " from member"
				+ " where MEM_ID = ? ";
		
		try {
			pstmt = con.prepareStatement(sql); 
			pstmt.setString(1, memId);
			rs = pstmt.executeQuery(); // select는 executeQuery
			if (rs.next()) {
				dto.setMemAddr(rs.getString("mem_addr"));
				dto.setMemBirth(rs.getTimestamp("mem_birth"));
				dto.setMemEmail(rs.getString("mem_email"));
				dto.setMemGender(rs.getString("mem_gender"));
				dto.setMemId(rs.getString("mem_id"));
				dto.setMemName(rs.getString("mem_name"));
				dto.setMemNum(rs.getString("mem_num"));
				dto.setMemPhone1(rs.getString("mem_phone1"));
				dto.setMemPhone2(rs.getString("mem_phone2"));
				dto.setMemPw(rs.getString("mem_pw"));
				dto.setMemRegiDate(
						new java.util.Date(rs.getDate("mem_regi_date").getTime()));
			}
		} catch (Exception e) {e.printStackTrace();	}
		finally {close();}
		return dto;
	}
	
	public void memberJoin (MemberDTO dto) {
		con = getConnection();
		String sql = "insert into member ( " + COLUMES + " )"
				 + " values(("
				 + "select concat('kosa',nvl(max(substr(mem_num,5)),100000)+1) from member"
				 + "),?,sysdate,?,?,?,?,?,?,?,?)" ;
		// () 는 서브쿼리로 갖고옴 regi_date는 안갖고옴 (오늘날짜)
		try {
			pstmt = con.prepareStatement(sql);
			// 첫번째 ? 가 memname 두 번재가 memid 
			// sysdate 는 ? 가 아니니까 id가 두번째 ! 물음표 순서대로 버호 붙이기
			pstmt.setString(1, dto.getMemName());
			pstmt.setString(2, dto.getMemId());
			pstmt.setString(3, dto.getMemPw());
			pstmt.setString(4, dto.getMemPhone1());
			pstmt.setString(5, dto.getMemPhone2());
			pstmt.setString(6, dto.getMemAddr());
			pstmt.setString(7, dto.getMemEmail());
			pstmt.setString(8, dto.getMemGender());
			pstmt.setTimestamp(9, dto.getMemBirth());
			int i = pstmt.executeUpdate();
			// 얘가 있어야 sql이 실행이 된다. 
			System.out.println(i+" 개의 행이(가) 삽입되었습니다. ");
			
		} catch (Exception e) {e.printStackTrace();	}
	}
	
	
	public void  memberUpdate (MemberDTO dto) {
		
		con = getConnection();
		String sql = " update member "
				+ "  			set MEM_NAME = ?, MEM_PHONE1 = ? , "
				+ "        		   MEM_PHONE2 = ?, MEM_ADDR = ? ,"
				+ "        		   MEM_EMAIL = ?, MEM_GENDER = ? ,"
				+ "        		   MEM_BIRTH = ? "
				+ "     		where MEM_NUM = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemName());
			pstmt.setString(2, dto.getMemPhone1());
			pstmt.setString(3, dto.getMemPhone1());
			pstmt.setString(4, dto.getMemAddr());
			pstmt.setString(5, dto.getMemEmail());
			pstmt.setString(6, dto.getMemGender());
			pstmt.setTimestamp(7, dto.getMemBirth());
			pstmt.setString(8, dto.getMemNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + " 개의 행이(가) 수정되었습니다.");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void MemberDelete (String num) {
		con = getConnection();
		String sql = "delete from member where mem_num = ?  ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,num);
			int i = pstmt.executeUpdate();
			System.out.println(i+"개 행이(가) 삭제되었습니다.");
					} catch (Exception e) {e.printStackTrace();}
		finally {close();}
	}
	
	
	public MemberDTO  selectOne(String num) {
		MemberDTO dto = new MemberDTO();
		con = getConnection();
		String sql = "select " + COLUMES + " from member " 
					+" where mem_num = ? ";
		try { 
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setMemAddr(rs.getString("mem_addr"));
				dto.setMemBirth(rs.getTimestamp("mem_birth"));
				dto.setMemEmail(rs.getString("mem_email"));
				dto.setMemGender(rs.getString("mem_gender"));
				dto.setMemName(rs.getString("mem_name"));
				dto.setMemNum(rs.getString("mem_num"));
				dto.setMemPhone1(rs.getString("mem_phone1"));
				dto.setMemPhone2(rs.getString("mem_phone2"));
				dto.setMemId(rs.getString("mem_Id"));
				dto.setMemPw(rs.getString("mem_pw"));
				dto.setMemRegiDate(new java.util.Date(rs.getDate("mem_regi_date").getTime()));
			}
		} catch (Exception e) {e.printStackTrace();}
		finally {close();}
		return dto;
	}
	
	public List<MemberDTO> selectAll(){
		List<MemberDTO> list = new ArrayList<MemberDTO>() ;
		con = getConnection();
		String sql = "select " + COLUMES + " from member";
		try {
			pstmt = con.prepareStatement(sql);
			rs= pstmt.executeQuery(); // 얘가 db데이터를 다 갖고온것
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setMemAddr(rs.getString("mem_addr"));
				dto.setMemBirth(rs.getTimestamp("mem_birth"));
				dto.setMemEmail(rs.getString("mem_email"));
				dto.setMemGender(rs.getString("mem_gender"));
				dto.setMemName(rs.getString("mem_name"));
				dto.setMemNum(rs.getString("mem_num"));
				dto.setMemPhone1(rs.getString("mem_phone1"));
				dto.setMemPhone2(rs.getString("mem_phone2"));
				dto.setMemId(rs.getString("mem_Id"));
				dto.setMemPw(rs.getString("mem_pw"));
				dto.setMemRegiDate(new java.util.Date(rs.getDate("mem_regi_date").getTime()));
				
				list.add(dto);
			}
		} catch (Exception e) {	e.printStackTrace();}
		finally {close();}
		return list;
	}
	
	public String numberGenerate() {
		String num = null;
		con = getConnection();
		String sql = "select nvl(max(substr(mem_num,5)),100000) + 1 from member";
		// 첫 번재 사람은 무조건 십만일
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) num = rs.getString(1); // 스트링으로 받아야한다 num이 스트링이라 
		} catch (Exception e) {	e.printStackTrace();}
		
		return num;
	}
	public void memberInsert (MemberDTO dto) {
		 con = getConnection();
		 String sql = "insert into member(" + COLUMES + " ) " 
				 	+ "values(?,?,?,?,?,?,?,?,?,?,?)";
		 try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getMemNum());
				pstmt.setString(2, dto.getMemName());
				pstmt.setDate(3, new java.sql.Date(dto.getMemRegiDate().getTime()));
				pstmt.setString(4, dto.getMemId());
				pstmt.setString(5, dto.getMemPw());
				pstmt.setString(6, dto.getMemPhone1());
				pstmt.setString(7, dto.getMemPhone2());
				pstmt.setString(8, dto.getMemAddr());
				pstmt.setString(9, dto.getMemEmail());
				pstmt.setString(10, dto.getMemGender());
				pstmt.setTimestamp(11, dto.getMemBirth());
				int i = pstmt.executeUpdate();
				System.out.println(i + "개 행이(가)  삽입되었습니다.");
		} catch (Exception e) {e.printStackTrace();}
		 finally {close();}
		 
	}

}
