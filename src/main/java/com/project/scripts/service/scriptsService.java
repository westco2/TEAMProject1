package com.project.scripts.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.scripts.model.scriptsVO;

public interface scriptsService {
	public void sendMessage(HttpServletRequest request,HttpServletResponse response) ;
	public ArrayList<scriptsVO> getMessage(HttpServletRequest request, HttpServletResponse response);
	public scriptsVO selectMessage(HttpServletRequest request, HttpServletResponse response) ;
	public void deleteMessage(HttpServletRequest request, HttpServletResponse response);
	public boolean idCheck(HttpServletRequest request, HttpServletResponse response);
	public String getLetter(HttpServletRequest request, HttpServletResponse response);

	
}
