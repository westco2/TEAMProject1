package com.project.post.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.post.model.listVO;
import com.project.post.model.postVO;
import com.project.post.model.postVO;

public interface postService {
	public void regist(HttpServletRequest request, HttpServletResponse response);
	public ArrayList<listVO> getList(HttpServletRequest request, HttpServletResponse response);
	public ArrayList<listVO> getListMy(HttpServletRequest request, HttpServletResponse response);
	public ArrayList<listVO> getListPop(HttpServletRequest request, HttpServletResponse response);
	public ArrayList<listVO> getSearch(HttpServletRequest request, HttpServletResponse response)throws UnsupportedEncodingException;
	//게시글 삭제
	public void deleteP(HttpServletRequest request, HttpServletResponse response);
	//게시글 수정
	public int updateP(HttpServletRequest request, HttpServletResponse response);
	//게시글 조회
	public postVO content(HttpServletRequest request, HttpServletResponse response);
	//조회수
	public void hitUpdate(HttpServletRequest request, HttpServletResponse response);
	//카테고리 조회
	public ArrayList<listVO> getListC(HttpServletRequest request, HttpServletResponse response);
	//키워드
	public void insertKey(HttpServletRequest request, HttpServletResponse response);
	public void updateKey(HttpServletRequest request, HttpServletResponse response);
	public String getKey(HttpServletRequest request, HttpServletResponse response); //키워드 얻기
	public boolean attention(HttpServletRequest request, HttpServletResponse response);
	public ArrayList<listVO> getAttention(HttpServletRequest request, HttpServletResponse response);
	public void deletekey(HttpServletRequest request, HttpServletResponse response);
	public void deleteAttention(HttpServletRequest request, HttpServletResponse response);
}
