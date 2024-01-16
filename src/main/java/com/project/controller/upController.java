package com.project.controller;

import com.project.post.service.postService;
import com.project.post.service.postServiceImpl;
import com.project.upload.service.upService;
import com.project.upload.service.upServiceImpl;

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



@MultipartConfig(location = "C:\\Users\\westc\\Documents\\TEAMProject\\src\\main\\webapp\\img",
				 maxFileSize = -1,
				 maxRequestSize = -1,
				 fileSizeThreshold = 1024)
@WebServlet("*.upload")
public class upController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	upService service = new upServiceImpl();
	postService servicePost = new postServiceImpl();

	public upController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String uri = request.getRequestURI();
		String path = uri.substring(request.getContextPath().length());
		System.out.println(path);
		if (path.equals("/main/file.upload")) {
			// 게시글 및 키워드 업로드
			servicePost.regist(request, response);
			servicePost.insertKey(request, response);

			// 업로드된 파일의 이름을 얻기 위해 Part를 가져옵니다.
			Part filePart = request.getPart("file");

			// Part에서 파일 이름을 얻습니다.
			String fileName = getSubmittedFileName(filePart);

			// 다른 로직 수행...

			// 서버로 응답을 반환 (예를 들어, 업로드된 파일의 다운로드 링크를 포함하는 HTML을 반환할 수 있음)
			service.upFile(request, response, fileName);

			try {
				Collection<Part> parts = request.getParts();
				String realFileName = null;
				for (Part part : parts) {
					if (part.getHeader("Content-Disposition").contains("filename=")) {
						realFileName = part.getSubmittedFileName();
						if (part.getSize() > 0) {
							// 동적인 업로드 경로 생성
							String uploadPath = "C:\\Users\\westc\\Documents\\TEAMProject\\src\\main\\webapp\\img\\";
							part.write(uploadPath + realFileName);
							part.delete();
						}
					}
				}

				// 적절한 리다이렉트 경로를 지정
				response.sendRedirect("list.post");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (path.equals("/main/reFile.upload")) {
			String pno = request.getParameter("pno");
			// 게시글 및 키워드 업로드
			request.setAttribute("pno",pno);
			servicePost.updateP(request, response);
			servicePost.updateKey(request, response);

			// 업로드된 파일의 이름을 얻기 위해 Part를 가져옵니다.
			Part filePart = request.getPart("file");

			// Part에서 파일 이름을 얻습니다.
			String fileName = getSubmittedFileName(filePart);

			// 다른 로직 수행...

			// 서버로 응답을 반환 (예를 들어, 업로드된 파일의 다운로드 링크를 포함하는 HTML을 반환할 수 있음)
			service.reFile(request, response, fileName);

			try {
				Collection<Part> parts = request.getParts();
				String realFileName = null;
				for (Part part : parts) {
					if (part.getHeader("Content-Disposition").contains("filename=")) {
						realFileName = part.getSubmittedFileName();
						if (part.getSize() > 0) {
							// 동적인 업로드 경로 생성
							String uploadPath = "C:\\Users\\westc\\Documents\\TEAMProject\\src\\main\\webapp\\img\\";
							part.write(uploadPath + realFileName);
							part.delete();
						}
					}
				}

				// 적절한 리다이렉트 경로를 지정
				request.getRequestDispatcher("update.post").forward(request,response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private String getSubmittedFileName(Part part) {
		String contentDisposition = part.getHeader("content-disposition");
		String[] tokens = contentDisposition.split(";");
		for (String token : tokens) {
			if (token.trim().startsWith("filename")) {
				return token.substring(token.indexOf("=") + 2, token.length() - 1);
			}
		}
		return "";
	}


}
