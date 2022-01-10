package controller.goods;

import javax.servlet.http.HttpServletRequest;

import model.DAO.GoodsDAO;

public class GoodsAutoNumController {
	public void execute (HttpServletRequest request) {
		GoodsDAO dao = new GoodsDAO();
		int num = dao.autoNum();
		request.setAttribute("goodsNum", num); // 받은 num 을 goodsNum이라는 이름으로 goodsForm.jsp 에 전달 
		
	}
}
