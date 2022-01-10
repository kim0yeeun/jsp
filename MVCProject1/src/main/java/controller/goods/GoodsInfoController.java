package controller.goods;

import javax.servlet.http.HttpServletRequest;

import model.DAO.GoodsDAO;
import model.DTO.GoodsDTO;

public class GoodsInfoController {
	public void execute (HttpServletRequest request) {
		// 뭐 받아와야헤 num
		String num = request.getParameter("num");
		GoodsDAO dao = new GoodsDAO();
		GoodsDTO dto = dao.selectOne(num);
		request.setAttribute("dto", dto);
	}
}
