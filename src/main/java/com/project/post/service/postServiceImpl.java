package com.project.post.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.post.model.listVO;
import com.project.post.model.postDAO;
import com.project.post.model.postVO;

public class postServiceImpl implements postService {

	postDAO dao = postDAO.getInstance();
	public void regist(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String categori = request.getParameter("categori");
		String selltype = request.getParameter("sellType");
		String price = request.getParameter("price");
		String content = request.getParameter("content");
		String address = request.getParameter("address");
		HttpSession session =  request.getSession();
		String writer = (String)session.getAttribute("user_id");


		postVO vo = new postVO(null, null, null, title, content, address, price, writer, categori, 0, selltype,null);
		dao.insertPost(vo);

	}
	public ArrayList<listVO> getList(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<listVO> list = dao.getList("pno");
		return list;

	}
	public void deleteP(HttpServletRequest request, HttpServletResponse response) {
		String pno = request.getParameter("pno");
		dao.deleteAtentionPost(pno);
		dao.deleteP(pno);
	}
	public int updateP(HttpServletRequest request, HttpServletResponse response) {
		String pno = request.getParameter("pno");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String address = request.getParameter("address");
		String price = request.getParameter("price");
		String categori = request.getParameter("categori");
		String sellType = request.getParameter("sellType");

		int result = dao.updateP(pno, title, content, address, price, categori, sellType);

		return result;
	}
	public postVO content(HttpServletRequest request, HttpServletResponse response) {
		String pno = request.getParameter("pno");
		postVO vo = dao.content(pno);
		
		return vo;
	}
	public void hitUpdate(HttpServletRequest request, HttpServletResponse response) {
		String pno = request.getParameter("pno");

		String cooValue = "";
		boolean flag = true;
		Cookie[] arr = request.getCookies();

		if(arr != null) {
			for(Cookie c : arr) {

				if(c.getName().equals("hit")) {
					cooValue = c.getValue();

					if(c.getValue().contains(pno)) {
						flag = false;

					}
				}
			}
		}
		if(flag) {
			dao.hitUpdate(pno);
			cooValue += pno + "-";
		}

		Cookie coo = new Cookie("hit", cooValue);
		coo.setMaxAge(1);
		response.addCookie(coo);
	}
	@Override
	public ArrayList<listVO> getListPop(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<listVO> list = dao.getList("hit");
		return list;
		
	}
	@Override
	public ArrayList<listVO> getSearch(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String sch = request.getParameter("search");
		String sort = request.getParameter("sort");
		ArrayList<listVO> list = dao.search(sch , sort);
		
		return list;
	}
	@Override
	public ArrayList<listVO> getListC(HttpServletRequest request, HttpServletResponse response) {
		String category = request.getParameter("category");
		String sort = request.getParameter("sort");
		ArrayList<listVO> list = dao.getList2(category, sort);
		return list;
	}
	@Override
	public void insertKey(HttpServletRequest request, HttpServletResponse response) {
		String key1 = request.getParameter("key1");
		String key2 = request.getParameter("key2");
		String key3 = request.getParameter("key3");
		dao.insertKey(key1, key2, key3);
		
	}
	@Override
	public String getKey(HttpServletRequest request, HttpServletResponse response) {
	
		 
		return dao.getKey(request.getParameter("pno"));
	}
	@Override
	public ArrayList<listVO> getListMy(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user_id");
		ArrayList<listVO> list = dao.getListMy(id);
		return list;
	}
	@Override
	public void updateKey(HttpServletRequest request, HttpServletResponse response) {
		String key1 = request.getParameter("key1");
		String key2 = request.getParameter("key2");
		String key3 = request.getParameter("key3");
		String pno = request.getParameter("pno");
		dao.updateKey(key1, key2, key3, pno);
		
	}
	@Override
	public boolean attention(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		String id = (String)session.getAttribute("user_id");
		String pno = request.getParameter("pno");
		if(dao.checkAtention(pno, id) == 0) {
			dao.insertAtention(pno, id);
			return true;
		}else {
			dao.deleteAtention(pno, id);
			return false;
		}
		
	}
	@Override
	public ArrayList<listVO> getAttention(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		String id = (String)session.getAttribute("user_id");
		return dao.getAttention(id);
	}

	@Override
	public void deletekey(HttpServletRequest request, HttpServletResponse response) {
		dao.deleteKey(request.getParameter("pno"));
	}

	@Override
	public void deleteAttention(HttpServletRequest request, HttpServletResponse response) {
		dao.deleteP(request.getParameter("pno"));
	}


}
