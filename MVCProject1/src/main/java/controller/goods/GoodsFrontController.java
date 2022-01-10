package controller.goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoodsFrontController  extends HttpServlet  implements Servlet {
	
	public void doProcess ( HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if (command.equals("/goodsList.gd")) {
			GoodsListController action = new GoodsListController();
			action.execute (request);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/goods/goodsList.jsp");
			dispatcher.forward(request, response);
		}else if (command.equals("/goodsEnter.gd")){
			GoodsAutoNumController action = new GoodsAutoNumController();
			action.execute(request); 
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/goods/goodsForm.jsp");
			dispatcher.forward(request, response);
		}else if (command.equals("/goodsRegist.gd")) {
			GoodsProController action = new GoodsProController();
			try {
				action.execute(request);
			} catch (Exception e) { e.printStackTrace();}
			
			response.sendRedirect("goodsList.gd"); // 제품 등록하믄 리스트로 넘어감 
			
		}else if (command.equals("/goodsInfo.gd")) {
			GoodsInfoController action = new GoodsInfoController();
			action.execute(request);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/goods/goodsInfo.jsp");
			dispatcher.forward(request, response);	
		}else if (command.equals("/goodsDelete.gd")) {
			GoodsDeleteController action = new GoodsDeleteController();
			action.execute(request); // 번호를 받아와야함 
			response.sendRedirect("goodsList.gd");
			// 상품 삭제시, 상품을 확인할 수 없으니까 리스트로 이동 
		}else if (command.equals("/goosdModify.gd")) {
			// 원래 값을 가져오고수정해야하니까 컨트롤러 필요
			GoodsModifyController action = new GoodsModifyController ();
			action.execute(request);
			
			// 수정을 누르면 수정 페이지가 있어야 하므로 jsp파일 하나 맹글맹글 
			RequestDispatcher dispatcher = 
										request.getRequestDispatcher("/goods/goodsModify.jsp");
			dispatcher.forward(request, response);
		}else if (command.equals("/goodsUpdate.gd")) { // 수정하고 나서 상품 상세페이지로 이동. 그러려면 num 이 필요
			GoodsUpdateController action = new GoodsUpdateController();
			// response 
			action.execute(request, response);
			// response.sendRedirect("goodsInfo.gd?num=" + request.getParameter("goodsNum"));
			// 근데 multipart 로 넘어오니까 request못쓴다. 
	
		}
	
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
