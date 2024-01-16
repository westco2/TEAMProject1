package com.project.user.service;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.user.medel.UserVO;



public interface UserService {
	
	public int join(HttpServletRequest request, HttpServletResponse response);
	public UserVO login(HttpServletRequest request, HttpServletResponse response);
	public UserVO getUserInfo(HttpServletRequest request, HttpServletResponse response);
	public int update(HttpServletRequest request, HttpServletResponse response);
	public int delete(HttpServletRequest request, HttpServletResponse response);
	public void setLetter(HttpServletRequest request, HttpServletResponse response,String a);
	public String getLetter(HttpServletRequest request, HttpServletResponse response);
}
