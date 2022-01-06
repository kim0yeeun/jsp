package controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO.LoginDAO;
import model.DTO.AuthInfo;

public class LoginProController {
	public void execute (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		LoginDAO dao = new LoginDAO();
		AuthInfo authInfo = dao.loginCk(id,pw); // 사용자가 있는지 확인
		
		/////////////////////////////////////////////////// 세션 생성
		
		// i=1이면 아이디와 비밀번호가 일치 , 0이면 아이디는 존재하지만 비밀번호 틀림, -1 이면 ㅂ번트림 
		HttpSession session = request.getSession();  // 섹션 객체 생성 
		
		/////////////////////////////////////////////////// 쿠키 생성
		// 아이디 저장 storeid 에 해당되는 name (storeId)을  가진다.  // index.jsp에서 확인 
		String storeId = request.getParameter("storeId");  
		
		// 로구인 유지
		String autoLogin = request.getParameter("autoLogin");
		
		
		
		if (authInfo==null) { // 아이디가 존재하지 않음.
			request.setAttribute("idErr", "아이디가 존재하지 않습니다.");
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/login.jsp"); // 로그인 화면으로 다시 넘어감
			dispatcher.forward(request, response);
		}else { // 아이디가 존재하는경우에서 
			if (pw.equals(authInfo.getUserPw())){ // i==1 아디와 비번이 같음 
				session.setAttribute("authInfo", authInfo); // session 속성에 id가 있다면 로그인 된 상태로 정함. 
				
			
				// 로그인 되었을때 쿠키생성 (v 아이디저장에 체크하면 쿠키생성, 체크하지 않으면 쿠키삭제)
				if (storeId != null && storeId.equals("store")) {  // 쿠키가 날아왔느냐  // value값  
					// 쿠키는 사용자 컴퓨터에 파일로 저장되므로 객체를 저장할 수 없고 문자열만 저장 가능하다. 
					Cookie cookie = new Cookie ("storeId",id) ; // id : summit했을때 response로 날아온 아이디를 쿠키에 저장하겠다. // 쿠키이름 storeId
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30); // 쿠키 지속 시간 설정
					//response를 이용해서 쿠키를 사용자쪽으로 보냄
					response.addCookie(cookie);
				}else { // 아이디 저장에 체크가 안되어있을 경우
					Cookie cookie = new Cookie ("storeId",id) ;
					cookie.setPath("/");
					cookie.setMaxAge(0); // 시간이 만료되면 쿠키 삭제 
					response.addCookie(cookie);
				}// 자동로구인 
				if ( autoLogin != null && autoLogin.equals("autoLogin")) {
					Cookie cookie = new Cookie ("autoLogin",id) ;
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30); 
					response.addCookie(cookie);
				}
				
				String contextPath = request.getContextPath(); 
				response.sendRedirect(contextPath + "/");  // index.jsp페이지가 됨 
				
			
			}else { // i==0
				request.setAttribute("pwErr", "비밀번호가 틀렸습니다.");
				request.setAttribute("userId", id);	 // session에서 사용한 id이름과 다른게 좋다.  request랑 session 구별이 안가기 대문 
				// 비밀번호가 틀렸을 때도 쿠키 저장 
				Cookie [] cookies = request.getCookies();
				if (cookies != null && cookies.length > 0) {
					for (Cookie c : cookies) {
						if (c.getName().startsWith("stor") ) { // 내가 요청한 쿠키가 맞으면  (첫글자가 stor로시작한다면 )
							request.setAttribute("isId",c.getValue()); // value값을 isId에 저장 
						}
					}
				}
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/login.jsp"); // 로그인 화면으로 다시 넘어감
				dispatcher.forward(request, response);
			}
			
			
		}
		
		/*
		
		if (i==1) {
			session.setAttribute("id", id); // session 속성에 id가 있다면 로그인 된 상태로 정함. 
			String contextPath = request.getContextPath(); 
			response.sendRedirect(contextPath + "/");  // index.jsp페이지가 됨 
		}else if (i==0) { // 비밀번호가 틀림
			request.setAttribute("pwErr", "비밀번호가 틀렸습니다.");
			request.setAttribute("userId", id);	 // session에서 사용한 id이름과 다른게 좋다.  request랑 session 구별이 안가기 대문 
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/login.jsp"); // 로그인 화면으로 다시 넘어감
			dispatcher.forward(request, response);
		}else if (i==-1)  { // 아이디가 존재하지 않음
			request.setAttribute("idErr", "아이디가 존재하지 않습니다.");
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/login.jsp"); // 로그인 화면으로 다시 넘어감
			dispatcher.forward(request, response);
		}
		
		
		*/
	}
}
