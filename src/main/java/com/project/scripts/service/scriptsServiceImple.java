package com.project.scripts.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.scripts.model.scriptsDAO;
import com.project.scripts.model.scriptsVO;

public class scriptsServiceImple implements scriptsService {

	scriptsDAO dao=scriptsDAO.getInstance();
	public void sendMessage(HttpServletRequest request, HttpServletResponse response) {
		
		String id=request.getParameter("user_id");
		String detail=request.getParameter("letter_detail");
		String send_id=request.getParameter("letter_send_id");
		dao.saveMessage(id,detail,send_id);			
	}
	
	public ArrayList<scriptsVO> getMessage(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user_id");
		ArrayList<scriptsVO> list=dao.getMessage(id);
		
		return list;
	}

	
	public scriptsVO selectMessage(HttpServletRequest request, HttpServletResponse response) {
		String bno=request.getParameter("bno");
		scriptsVO vo=dao.selectMessage(bno);
		return vo;
	}

	
	public void deleteMessage(HttpServletRequest request, HttpServletResponse response) {
		String bno=request.getParameter("bno");
		dao.deleteMessage(bno);
		
	}

	@Override
	public boolean idCheck(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("letter_send_id");
		if(dao.idCheck(id)) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public String getLetter(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		return dao.getLetter((String)session.getAttribute("user_id"));

	}


}
