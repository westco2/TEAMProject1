package com.project.scripts.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		if(path.equals("/scripts/writeForm.scripts")) {
			
			int result=service.sendMessage(request,response);
			if(result==1) {
				scriptsVO vo=service.receiveMessage(request,response);
					request.setAttribute("user_id", vo.getUser_id());
					request.setAttribute("Letter_send_id", vo.getLetter_send_id());
					request.setAttribute("letter_detail", vo.getLetter_detail());
					request.setAttribute("Letter_date", vo.getLetter_date());
					System.out.println(vo.toString()+"이곳은 컨트롤영역입니다.");
					System.out.println(vo.getLetter_date());
					System.out.println(vo.getLetter_send_id());
					request.getRequestDispatcher("recieve_scripts.jsp").forward(request, response);
				
			}else {
				
			}
		}else {
			
		}
		
	}

}
