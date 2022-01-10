package controller.goods;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import model.DAO.GoodsDAO;

public class GoodsDeleteController {
	public void execute(HttpServletRequest request) {
		String goodsNum  = request.getParameter("goodsNum");
		GoodsDAO dao = new GoodsDAO();
		// 이미지 갖고와야해 
		String goodsImages = dao.getImages(goodsNum);
		// GoodsDAO에 public String getImages 맹글맹글 
		// blueheart1.png`border.png`border1.png
		// ↑ 갖고왔따 
		// 이미지를 다 갖고온걸 하나씩 나눠야하니까 `을 기준으로 배열에 넣기
		String  [] fileImages = goodsImages.split("`");
		// fileImages = {"blueheart1.png",  "border.png",  "border1.png"}
		if (fileImages.length >=1) {
			// 파일의 위치를 알아야함 (절대경로 디렉토리를 가져옴 )
			// 파일명으로는 삭제가 안되는 거고 절대경로를 알아야 삭제 가능하다. 
			String path = "/goods/upload";
			String realPath = request.getServletContext().getRealPath(path);
			File file = null;
			// 
			for(String fileName : fileImages) {
				// 파일의 절대경로 + 파일이름 <- 이렇게 해야 삭제가 가능하다. 
				file = new File(realPath + "/" + fileName);
				if (file.exists()) file.delete(); // 파일이 존재하는지 묻고 존재하면 파일 삭제 
			}
		}
		// 파일이 삭제되었으면 다오에 가서 상품 정보를 삭제한다. 
		dao.goodsDelete(goodsNum); 
		
	}
}
