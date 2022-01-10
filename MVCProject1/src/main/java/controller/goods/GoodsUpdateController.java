package controller.goods;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.DAO.EmployeeDAO;
import model.DAO.GoodsDAO;
import model.DTO.AuthInfo;
import model.DTO.GoodsDTO;

public class GoodsUpdateController {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// request 누가 바다와 
		String path = "/goods/upload";
		String realPath = request.getServletContext().getRealPath(path);
		int fileSize = 1024*1024*5 ; 
		
		// 관리자 변경 하려면 session 받아오기 (현재 로그인한 사용자의 정보)
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		// 직원 id 를 갖고있음 -> 직워 id를 이용해서 직원 번호를 갖고오기 위해서는 직우너 dao 로 가져옴
		EmployeeDAO dao = new EmployeeDAO();
		String empNum = dao.selectEmpNum(authInfo.getUserId());
		// 아이디를 넘겨서 번호 가져옴 
		
		// IP 주소도 갖고오자
		String ipAddr = request.getRemoteAddr();
		
		// MultipartRequest 쓰려고 lib파일에 있는 cos.jar 사용함 
		MultipartRequest multi = new MultipartRequest(request,realPath, fileSize , "utf-8", new DefaultFileRenamePolicy());
		String goodsNum = multi.getParameter("goodsNum");
		String goodsName = multi.getParameter("goodsName");
		String goodsPrice = multi.getParameter("goodsPrice");
		String goodsContent = multi.getParameter("goodsContent");
		String goodsQty = multi.getParameter("goodsQty");
		String goodsCompany = multi.getParameter("goodsCompany");
		String img1 = multi.getFilesystemName("img1");
		String img2 = multi.getFilesystemName("img2");
		String img3 = multi.getFilesystemName("img3");
		
		// 날짜 저장은 길지만 어절수엄드아
		String goodsDate = multi.getParameter("goodsDate");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date =null;
		try {
			date = sdf.parse(goodsDate);
		} catch (Exception e) {e.printStackTrace();		}
		Timestamp gDate = new Timestamp(date.getTime());
		
		// 2.업데이트 전 파일삭제 
		GoodsDAO dao1 = new GoodsDAO();
		String goodsImages = dao1.getImages(goodsNum); // goodsnum 을넘기면 이미지 파일을 가죠옴
		// 각각의 파일명을 알기 위해서 스플릿
		String [] fileImages = goodsImages.split("`");
		if (fileImages.length>=1) {
			File file = null; // 임포트할때 자바 io
			// 배열이니까 파일을 반복해서 삭제하기 위한 for문
			for (String fileName : fileImages) {
				file = new File(realPath+"/" +fileName);
				if(file.exists()) file.delete();
			}
			
		}
		GoodsDTO dto = new GoodsDTO();
		dto.setEmpNum(empNum);
		dto.setGoodsCompany(goodsCompany);
		dto.setGoodsContent(goodsContent);
		dto.setGoodsDate(gDate);
		dto.setGoodsName(goodsName);
		dto.setGoodsNum(goodsNum);
		dto.setGoodsPrice(Integer.parseInt(goodsPrice));
		dto.setGoodsQty(Integer.parseInt(goodsQty));
		dto.setIpAddr(ipAddr);
		dto.setGoodsImages(img1+"`"+img2+"`"+img3);
		
		// 1. 저장                      했으면  dao 가서 업데이트
		// 2. 업데이트 하기 위해서는 기존의 파일을 삭제한 후에 업데이트 해야한다.
		// 3. 업대이투 
		dao1.goodsUpdate(dto);
		
		// Front 에 Http 서블릿 response 추가했듬 보내보내  
		response.sendRedirect("goodsInfo.gd?num="+goodsNum);
	}

}
