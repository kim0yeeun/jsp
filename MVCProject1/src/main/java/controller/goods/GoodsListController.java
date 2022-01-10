package controller.goods;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.GoodsDAO;
import model.DTO.GoodsDTO;

public class GoodsListController {
	public void execute (HttpServletRequest request) {
		GoodsDAO dao = new GoodsDAO();
		List<GoodsDTO> list = dao.selectAll();
		// "list" 이름으로 list를 담겠다.
		request.setAttribute("list", list);
	}
}
