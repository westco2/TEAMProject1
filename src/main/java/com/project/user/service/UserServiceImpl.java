package com.project.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.project.user.medel.UserDAO;
import com.project.user.medel.UserVO;



public class UserServiceImpl implements UserService {
	
	private UserDAO dao =UserDAO.getInstance();
	@Override
	public int join(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String nickname = request.getParameter("nickname");
		
		
		
		
		
		
		int result = dao.idCheck(id);
		int result2 = dao.nickCheck(nickname);
		
		if(result == 1 ) {
			return 3;
		}else if(result2 == 1) {
			return 4;
		} else { 
			
			UserVO vo = new UserVO(id,pw,name,email,address,nickname,gender,null);
			dao.insertUser(vo); 
			return 0;
		}
		
		
		
		
		
	}

	@Override
	public UserVO login(HttpServletRequest request, HttpServletResponse response) {
		String id= request.getParameter("id");
		String pw= request.getParameter("pw");

		System.out.println("??");
		
		UserVO vo=dao.login(id,pw); 
		return vo;
		
	}

	@Override
	public UserVO getUserInfo(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		String id= (String)session.getAttribute("user_id");
		
		UserVO vo=dao.getUserInfo(id);
		return vo;
	}

	@Override
	public int update(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String nickname= request.getParameter("nickname");
		
		UserVO vo = new UserVO(id,pw,name,email,address,nickname,gender,null);
		int result = dao.update(vo);
		
		if(result == 1) {
			HttpSession session=request.getSession();
			session.setAttribute("user_name", name);
		}
		return result;
	}

	@Override
	public int delete(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("user_id");
		System.out.println(id);
		String pw=request.getParameter("pw");
		
		UserVO vo=dao.login(id, pw);
		
		if(vo != null) {
			dao.delete(id);
			session.invalidate();
			return 1;
		}else
		return 0;
	}

	@Override
	public void setLetter(HttpServletRequest request, HttpServletResponse response, String a) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user_id");
		dao.setLetter(id, a);
	}

	@Override
	public String getLetter(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user_id");
		return dao.getLetter(id);

	}


}
