package com.project.scripts.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.scripts.model.scriptsVO;

public interface scriptsService {
	public int sendMessage(HttpServletRequest request,HttpServletResponse response) ;
	public scriptsVO receiveMessage(HttpServletRequest request,HttpServletResponse response); 	
	
}
