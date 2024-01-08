package com.project.scripts.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.scripts.model.scriptsDAO;
import com.project.scripts.model.scriptsVO;

public class scriptsServiceImple implements scriptsService {

	scriptsDAO dao=scriptsDAO.getInstance();
	public int sendMessage(HttpServletRequest request, HttpServletResponse response) {
		int result=0;
		String id=request.getParameter("user_id");
		String detail=request.getParameter("letter_detail");
		String send_id=request.getParameter("letter_send_id");
		String date=request.getParameter("letter_date");
		
		result=dao.saveMessage(id,detail,send_id,date);
		
		
		return result;
	}
	
	public scriptsVO receiveMessage(HttpServletRequest request, HttpServletResponse response) {
		
		String send_id=request.getParameter("letter_send_id");
		String detail=request.getParameter("letter_detail");
		scriptsVO vo=dao.getMessage(send_id,detail);
		
		return vo;
	}
	

}
