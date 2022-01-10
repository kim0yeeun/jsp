package controller.goods;


import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.DAO.EmployeeDAO;
import model.DAO.GoodsDAO;
import model.DTO.AuthInfo;
import model.DTO.GoodsDTO;

public class GoodsProController {
	public void execute (HttpServletRequest request)  {
		String path ="/goods/upload";
		String realPath = request.getServletContext().getRealPath(path);
		// c:/
		int fileSize = 1024*1024*5;
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		// session    AuthInfo 얘 보면 emp_id 만 가져올수 있으니가 얘를 이용해서 emp_num 도 가져오자 
		// 그러기 위해선 employee dao다녀와야함
		String empId = authInfo.getUserId();
		//emp_id 로 emp_num가져오기
		EmployeeDAO dao = new EmployeeDAO();
		String empNum = dao.selectEmpNum(empId);
		// empNum 을가져오는 쿼리문 작성 -> EmployeeDAO 로 ㄱㄱ
		String ipAddr = request.getRemoteAddr();
		// 파일로 넘긴건 request로 못바든ㄴ다 그럴땐 cos.jar을 통해서 받움 멀티 머시기 모야 기억안나요
		// request 저장경로 파일사이즈 한글로요 디폴트폴리쉬로 같은명의 파일이 이슬경우 파일 이름 자동 변경 해ㅅ섯슴 jsp에서,,
		
		// 리ㅅ퀘스트항거 멀티로 갖고와! 
		String goodsNum= null;
		String goodsName= null;
		String goodsPrice= null;
		String goodsContent= null;
		String goodsQty= null;
		String goodsCompany = null;
		String img1 = null;
		String img2 = null;
		String img3 = null;
		Timestamp gDate  = null;
		MultipartRequest multi = null;
			try {
				multi = new MultipartRequest(request,realPath, fileSize , "utf-8", new DefaultFileRenamePolicy());
			
				goodsNum = multi.getParameter("goodsNum");
			goodsName = multi.getParameter("goodsName");
			goodsPrice = multi.getParameter("goodsPrice");
			goodsContent = multi.getParameter("goodsContent");
			goodsQty = multi.getParameter("goodsQty");
			goodsCompany = multi.getParameter("goodsCompany");
			// 화면에 출력할 것이므로 오리지날 파일 이름이 필요 없음 (다운로드가 아님)
			img1 = multi.getFilesystemName("img1");
			img2 = multi.getFilesystemName("img2");
			img3 = multi.getFilesystemName("img3");

			String goodsDate = multi.getParameter("goodsDate");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(goodsDate);
			gDate = new Timestamp(date.getTime());
			
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
			System.out.println(dto.getGoodsImages());
			
			// dto 에 저장한 값을  dao 를 통해 bd에 저장
			GoodsDAO dao1 = new GoodsDAO();
			dao1.goodsInsert(dto);
			} catch (Exception e) {
				File file = new File(realPath + "/" +multi.getFilesystemName("img1"));
				if(file.exists()) file.delete();
				file = new File(realPath + "/" +multi.getFilesystemName("img2"));
				if(file.exists()) file.delete();
				file = new File(realPath + "/" +multi.getFilesystemName("img3"));
				if(file.exists()) file.delete();
				e.printStackTrace();
			}
			// 멀티로 받은걸 dto에 저장 
		
		
	
		
	}

}
