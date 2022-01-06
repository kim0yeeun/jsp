package controller.login;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFrontController  extends HttpServlet implements Servlet{
	public void doProcess( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String  requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if (command.equals("/loginPro.login")) {
			LoginProController action = new LoginProController();
			action.execute(request, response);
		}else if (command.equals("/logout.login")) {
			// 로그아웃시 자동로그인을 위한 쿠키삭제해서 기능 해제 
			Cookie cookie = new Cookie ("autoLogin","") ;
			cookie.setPath("/");
			cookie.setMaxAge(0); 
			response.addCookie(cookie);
			
			/// 세션 객체를 생성
			HttpSession session = request.getSession();
			session.invalidate(); // 로그아웃 (세션 날림띠) 로그인은 attribute 맹글면되고 로그ㅏ웃은 invalidate하면 됨 
			response.sendRedirect(contextPath + "/");// 후에 메인 페이지로 넘어감 
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
