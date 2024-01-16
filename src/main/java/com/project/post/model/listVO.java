package com.project.post.model;

import java.sql.Timestamp;

public class listVO {
	private String pno; //글 번호
	private String writer; //글 작성자
	private String price;
	private String address; //주소
	private int hit; //조회수
	private String title; //제목
	private String attention; //찜
	private Timestamp postDate; //date
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public listVO(String pno, String writer, String price, String address, int hit, String title, String attention,
				  Timestamp postDate, String path) {
		super();
		this.pno = pno;
		this.writer = writer;
		this.price = price;
		this.address = address;
		this.hit = hit;
		this.title = title;
		this.attention = attention;
		this.postDate = postDate;
		this.path = path;
	}
	public listVO() {
		
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAttention() {
		return attention;
	}
	public void setAttention(String attention) {
		this.attention = attention;
	}
	public Timestamp getPostDate() {
		return postDate;
	}
	public void setPostDate(Timestamp postDate) {
		this.postDate = postDate;
	}
	
	public String toString() {
		return "listVO [pno=" + pno + ", writer=" + writer + ", price=" + price + ", address=" + address + ", hit="
				+ hit + ", title=" + title + ", attention=" + attention + ", postDate=" + postDate + "]";
	}
	
	
}
