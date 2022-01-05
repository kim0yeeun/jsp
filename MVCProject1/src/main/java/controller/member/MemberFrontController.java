package controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberFrontController  extends  HttpServlet implements Servlet{

	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()); // URI에서 contextPath를 뺀 게  주소
		if (command.equals("/memberList.mem")) {
			MemberListController action = 
					new MemberListController();
			action. execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/member/memberList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberRegist.mem")) {
			MemberNumberContoller action = 
					new MemberNumberContoller();
			action. execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/member/memberForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberWrite.mem")) {
			MemberWriteController   action = new MemberWriteController();
	         action.execute(request);
	         response.sendRedirect("memberList.mem");
	      // 등록하고 나서 회원리스트로 이동 
		}else if (command.equals("/memberDetail.mem")) {
			MemberDetailController  action = new MemberDetailController();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/member/memberInfo.jsp");
			dispatcher.forward(request, response);
		}else if (command.equals("/memberDelete.mem")) {
			MemberDeleteController action = new MemberDeleteController();
			action.execute(request);
	         response.sendRedirect("memberList.mem");
			// 사람 없어졌으니까 회원리스트로 ㄱㅈㅇ
		}else if (command.equals("/memberModify.mem")) {
			MemberDetailController  action = new MemberDetailController();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/member/memberUpdate.jsp");
			dispatcher.forward(request, response);
		}else if (command.equals("/memberUpdate.mem")) {
			MemberModifyController action = new MemberModifyController();
			action.execute(request);
			response.sendRedirect("memberDetail.mem?num=" + request.getParameter("memNum"));
		}else if (command.equals("/memberAgree.mem")) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/member/agree.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberJoin.mem")) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/member/memberJoinForm.jsp");
			dispatcher.forward(request, response);
		}else if (command.equals("/memberJoinOk.mem")) {
			MemberJoinController action = new MemberJoinController();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/member/welcome.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberDiscript.mem")) {
			MemberDiscriptController action = new MemberDiscriptController();
			action.execute(request);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/myPage/memberDetail.jsp");
			dispatcher.forward(request, response);
		}else if (command.equals("/memberInfoModify.mem")) {
			// discript controller 내용 ㅇ같으니까 위에서 복붙헤야 데이터를 불러옴 
			MemberDiscriptController action = new MemberDiscriptController();
			action.execute(request);
			// dispatcher 는 페이지를 열 때 필요한 것. 
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/myPage/memberInfoModify.jsp");
			dispatcher.forward(request, response);
		}else if (command.equals("/memberInfoUpdate.mem")) {
			// 내 정보를 수정하고 나서 새로운 페이지가 열리게 하려면 requestdispatcher하면 되고
			// detail 페이지로 가고싶다면 response.send 하면됨. -> 수정하기위한 주소에서 수정한 뒤 (controller )원하는 주소(memberDiscript)로 넘어감
			MemberMyUpdateController action = new MemberMyUpdateController();
			action.execute(request,response);
			// controller보면 reponse받는다고 되어있음 
		}else if (command.equals("/memberDrop.mem")) {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/myPage/memberDrop.jsp");
			dispatcher.forward(request, response);
		}else if (command.equals("/memberDropOk.mem")) {
			MemberDropController action =  new MemberDropController();
			action.execute(request,response);
			// alert창을 띄우기 위해서 response가 필요하다
		}else if (command.equals("/memberPass.mem")) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/myPage/memberPass.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberPassword.mem")) {
			MemberPassController action = new MemberPassController();
			String path = action.execute(request);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if (command.equals("/memberPassModify.mem")) {
			MemberPassModifyController action = new MemberPassModifyController();
			action.execute(request, response);
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}
