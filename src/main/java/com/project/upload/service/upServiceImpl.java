package com.upload.service;

import java.io.File;
import java.util.Collection;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.upload.model.upDAO;
import com.upload.model.upVO;

public class upServiceImpl implements upService {
	upDAO dao = upDAO.getInstance();

	@Override
	public void upFile(HttpServletRequest request, HttpServletResponse response) {
		Collection<Part> parts = request.getParts();
		String f = "";
		for (Part part : parts) {
            if (part.getName().equals("file")) {
                // 파일을 처리하는 로직을 여기에 추가
                f = getFileName(part);
               
            }
        }
		
		dao.upFile(f);
		
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
