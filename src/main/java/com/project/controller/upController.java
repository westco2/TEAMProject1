package com.upload.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.upload.service.upService;
import com.upload.service.upServiceImpl;

@MultipartConfig(location = "C:\\Users\\user\\Desktop\\course\\jsp\\upload",
				 maxFileSize = -1,
				 maxRequestSize = -1,
				 fileSizeThreshold = 1024)
@WebServlet("/upload")
public class upController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	upService service = new upServiceImpl();

	public upController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post Request!!");
		request.setCharacterEncoding("UTF-8");
		service.upFile(request, response);
		response.sendRedirect("");
		try {
			Collection<Part> parts = request.getParts();
			String realFileName = null;
			for(Part part : parts) {
			if(part.getHeader("Content-Disposition").contains("filename=") ) { //전달된 코드가 파일업로드 형식이라면
				realFileName = part.getSubmittedFileName(); //업로드된 파일명을 받는다
			if(part.getSize() > 0) {
				part.write("C:\\Users\\user\\Desktop\\course\\jsp\\upload\\" + realFileName); //헤딩 경로에 업로드시킨다
				part.delete();
			}
			} 
			}
			//끝!!!!
			} catch (Exception e) {
			e.printStackTrace();
			}
		
		
		
//		// 실제 서블릿이 동작하는 서버 경로 (Not 개발 서버)
//		String realPath = request.getServletContext().getRealPath("/upload");
//
//		// form 태그 중 name="fileName" 인 요청 파트
//		Part filePart = request.getPart("fileName");
//
//		// 요청된 파트의 전송된 파일 이름
//		String fileName = filePart.getSubmittedFileName();
//
//		// 입력 스트림
//		InputStream fis = filePart.getInputStream();
//
//		// 실제 업로드 될 경로 + 파일명
//		String filePath = realPath + File.separator + fileName;
//
//		// 파일 출력 스트림 (저장)
//		FileOutputStream fos = new FileOutputStream(filePath);
//
//		// 1024byte 씩 버퍼에 담아 읽어오는 과정
//		// write(buffer, offset, length); 를 통해 읽어온 만큼만 쓰는 방법
//		byte[] buf = new byte[1024];
//		int size = 0;
//		while((size=fis.read(buf)) != -1)
//			fos.write(buf, 0, size);
//		fos.close();
//		fis.close();
//
//		PrintWriter out = response.getWriter();
//		out.write("file uploaded to " + realPath +" successfully!");
	}
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String uri = request.getRequestURI();
		String path = uri.substring(request.getContextPath().length());

	}


}
