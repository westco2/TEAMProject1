package com.project.upload.service;


import com.project.upload.model.UpDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class upServiceImpl implements upService {
	private UpDAO dao = UpDAO.getInstance();

	@Override
	public void upFile(HttpServletRequest request, HttpServletResponse response,String fileName) {

		dao.upFile(fileName);
	}

	@Override
	public void reFile(HttpServletRequest request, HttpServletResponse response, String fileName) {
		String pno = request.getParameter("pno");
		dao.reFile(fileName, pno);
	}

	private String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}



}
