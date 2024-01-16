package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;


import com.project.post.model.listVO;
import com.project.post.service.postService;
import com.project.post.service.postServiceImpl;
import com.project.scripts.service.scriptsService;
import com.project.scripts.service.scriptsServiceImple;
import com.project.user.medel.*;
import com.project.user.service.UserService;
import com.project.user.service.UserServiceImpl;


@WebServlet("*.user") 
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8"); 
		
		String uri = request.getRequestURI();
		String path = uri.substring( request.getContextPath().length()  );
		
		System.out.println(path);
		
		
		
		UserService service = new UserServiceImpl();
		postService service2 = new postServiceImpl();
		scriptsService service3 = new scriptsServiceImple();
		
		if(path.equals("/main/join.user")) { 
			
			
			request.getRequestDispatcher("/user/user_join.jsp").forward(request, response);

		} else if(path.equals("/main/login.user") ) { 

			request.getRequestDispatcher("/user/user_login.jsp").forward(request, response);
		
		} else if(path.equals("/main/joinForm.user") ) { 
			
		
			int result = service.join(request, response);
			
			System.out.println("실행결과:" + result);
			
			if(result == 3) {
				request.setAttribute("msg", "아이디가 중복되었습니다");
				request.getRequestDispatcher("/user/user_join.jsp").forward(request, response);
			}else if(result == 4){
				request.setAttribute("msg", "닉네임이 중복되었습니다");
				request.getRequestDispatcher("/user/user_join.jsp").forward(request, response);
			}else {
				response.sendRedirect("login.user");
			}
		
			
		}else if(path.equals("/main/loginForm.user")) {
			UserVO vo=service.login(request, response);
			System.out.println("실행");
			if(vo != null) {
				System.out.println("실행");
				HttpSession session=request.getSession();
				session.setAttribute("user_id", vo.getId());
				session.setAttribute("user_name", vo.getName());
				String get = service3.getLetter(request,response);
				String cls = service.getLetter(request,response);
				System.out.println(get);
				System.out.println(cls);
				if(!get.equals(cls)) {
					System.out.println("실행");
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('새로운 쪽지가 있습니다.');");
					out.println("location.href='/main/index.jsp';");
					out.println("</script>");
				}else {
					response.sendRedirect("/main/index.jsp");
				}
			}else {
				request.setAttribute("msg", "아이디 비밀번호 확인하세요");
				request.getRequestDispatcher("/user/user_login.jsp").forward(request, response);
			
			}
		}else if(path.equals("/main/logout.user")) {
			HttpSession session = request.getSession();
			String a = service3.getLetter(request,response);
			service.setLetter(request,response, a);
			session.invalidate();
			
			response.sendRedirect("/main/index.jsp");
		}else if(path.equals("/main/mypage.user")) {
		

			request.getRequestDispatcher("/user/user_mypage.jsp").forward(request, response);

		}else if(path.equals("/main/update.user")) {
			UserVO vo=service.getUserInfo(request, response);
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("/user/user_update.jsp").forward(request, response);
			
		}else if(path.equals("/main/updateFrom.user")) {
			int result=service.update(request,response);
			
			if(result ==1) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('변경했습니다');");
				out.println("location.href='/main/index.jsp';");
				out.println("</script>");
				
			}else {
				response.sendRedirect("mypage.user");
			}
		}else if(path.equals("/main/delete.user")) {
			request.getRequestDispatcher("/user/user_delete.jsp").forward(request, response);
		}else if (path.equals("/main/deleteForm.user")) {
			int result = service.delete(request, response);
			
			if(result == 1) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('탈퇴되었습니다');");
				out.println("location.href='/main/index.jsp';");
				out.println("</script>");
			}else {
				request.setAttribute("msg", "비밀번호를 확인하세요");
				request.getRequestDispatcher("/user/user_delete.jsp").forward(request, response);
			}
		}
		
	}

	
}
