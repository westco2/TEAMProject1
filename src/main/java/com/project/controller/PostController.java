package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.post.model.listVO;
import com.project.post.model.postVO;
import com.project.post.service.postService;
import com.project.post.service.postServiceImpl;



@WebServlet("*.post")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public PostController() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String uri = request.getRequestURI();
		String path = uri.substring(request.getContextPath().length());
		System.out.println(path);

		postService service = new postServiceImpl();
		if(path.equals("/main/write.post")) { //게시글 상세
			
			request.getRequestDispatcher("/post/post_sell.jsp").forward(request, response);
			
			
//		}else if(path.equals("/main/info.post")) { //게시글 작성 up컨트롤로 이전
//			service.regist(request, response); //게시글 업로드
//
//			service.insertKey(request, response); //키워드 업로드
//			request.getRequestDispatcher("/post/post_info.jsp").forward(request, response);
			
		}else if(path.equals("/main/list.post")) { //게시글 목록
			ArrayList<listVO> list = service.getList(request, response);

			request.setAttribute("list", list);
			request.getRequestDispatcher("/post/post_list.jsp").forward(request, response);

		}else if(path.equals("/main/delete.post")) { //게시글 지우기
        	service.deletekey(request,response);
			service.deleteAttention(request,response);
        	service.deleteP(request, response);
			response.setContentType("text/html; charset= UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제되었습니다.');");
			out.println("location.href='my.post';");
			out.println("</script>");

		} else if (path.equals("/main/update.post")) { //게시글 수정
			String pno = request.getParameter("pno");


			response.setContentType("text/html; charset= UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정이 완료되었습니다.');");
			out.println("location.href='sell.post?pno="+pno+"';");
			out.println("</script>");


		}else if (path.equals("/main/sell.post")) { //게시글 조회 및 조회수
        	
        	service.hitUpdate(request, response); //조회수
        	postVO vo = service.content(request, response); //내용조회
        	request.setAttribute("vo", vo);
        	request.getRequestDispatcher("/post/post_info.jsp").forward(request, response);

		} else if(path.equals("/main/pop.post")){ //인기
            ArrayList<listVO> list = service.getListPop(request, response);
            request.setAttribute("list",list);

            request.getRequestDispatcher("/post/post_pop.jsp").forward(request,response);

        }else if(path.equals("/main/search.post")){ //검색

			request.setCharacterEncoding("UTF-8");
            System.out.println(request.getParameter("search"));
            System.out.println(request.getParameter("sort"));
            ArrayList<listVO> list = service.getSearch(request,response);
            request.setAttribute("sch", request.getParameter("search"));
            request.setAttribute("list",list);
            request.getRequestDispatcher("/post/post_search.jsp").forward(request,response);

		}else if(path.equals("/main/list2.post")) { //카테고리 게시판
        	
			ArrayList<listVO> list = service.getListC(request, response);
			response.setCharacterEncoding("UTF-8");
			System.out.println();
			request.setAttribute("category", request.getParameter("category"));
			request.setAttribute("list", list);
			request.getRequestDispatcher("/post/post_list2.jsp").forward(request, response);

        }else if(path.equals("/main/category.post")) {
			
			request.getRequestDispatcher("list2.post").forward(request, response);

        }else if(path.equals("/main/update2.post")) { //파일 정보 가져오기
        	postVO vo = service.content(request, response);
        	System.out.println(request.getParameter("pno"));
        	String[] arr = service.getKey(request, response).split(" ");
        	request.setAttribute("key1",arr[0]);
        	request.setAttribute("key2",arr[1]);
        	request.setAttribute("key3",arr[2]);
        	request.setAttribute("vo", vo);
        	request.getRequestDispatcher("/post/rePost.jsp").forward(request, response);

        }else if(path.equals("/main/attention.post")) {
        	String pno = request.getParameter("pno");
        	if(service.attention(request, response)) {
        		response.setContentType("text/html; charset= UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('찜목록에 추가하였습니다.');");
				out.println("location.href='sell.post?pno="+pno+"';");
				out.println("</script>");

        	}else {
        		response.setContentType("text/html; charset= UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('찜목록에서 삭제했습니다.');");
				out.println("location.href='sell.post?pno="+pno+"';");
				out.println("</script>");
        	}

        }else if(path.equals("/main/my_attention.post")) {
        	HttpSession session=request.getSession();
    		request.setAttribute("id",(String)session.getAttribute("user_id")) ;
    		ArrayList<listVO> list = service.getAttention(request, response);
    		request.setAttribute("list", list);
    		request.getRequestDispatcher("/post/post_my_attention.jsp").forward(request, response);
    		
        	
        }else if(path.equals("/main/my.post")){
			ArrayList<listVO> list = service.getListMy(request, response);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/post/my_post.jsp").forward(request, response);
		}
	}
}
