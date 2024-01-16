package com.project.upload.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public interface upService {
	public void upFile(HttpServletRequest request, HttpServletResponse response,String fileName);
	public void reFile(HttpServletRequest request, HttpServletResponse response,String fileName);

}
