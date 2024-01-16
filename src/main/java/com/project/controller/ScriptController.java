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

import com.project.scripts.model.scriptsVO;
import com.project.scripts.service.scriptsServiceImple;


@WebServlet("*.scripts")
public class ScriptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ScriptController() {
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
		String uri=request.getRequestURI();
		String path=uri.substring(request.getContextPath().length());
		System.out.println(path);
		scriptsServiceImple service = new scriptsServiceImple();
		
		if(path.equals("/main/writeForm.scripts")) {//저장메서드
			if(service.idCheck(request, response)) {
			service.sendMessage(request,response);
			request.getRequestDispatcher("listForm.scripts").forward(request, response);
			}else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('없는 회원입니다.');");
				out.println("location.href='write.scripts';");
				out.println("</script>");
			}
			
		}else if(path.equals("/main/listForm.scripts")) {
			
			ArrayList<scriptsVO> list=service.getMessage(request,response);
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("/scripts/list_scripts.jsp").forward(request, response);
		}else if(path.equals("/main/content.scripts")) {//목록조회 누르면 출력
			scriptsVO vo=service.selectMessage(request,response);
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("/scripts/recieve_scripts.jsp").forward(request, response);
		}else if(path.equals("/main/deleteForm.scripts")){
			service.deleteMessage(request,response);
			request.getRequestDispatcher("listForm.scripts").forward(request, response);
		}else if(path.equals("/main/write.scripts")) {
			HttpSession session=request.getSession();
			request.setAttribute("user_id", session.getAttribute("user_id"));
			request.setAttribute("writer", request.getParameter("writer"));
			request.getRequestDispatcher("/scripts/write_scripts.jsp").forward(request, response);
		}
		
	}

}
