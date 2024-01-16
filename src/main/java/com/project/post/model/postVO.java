package com.project.post.model;

import java.sql.Timestamp;

public class postVO {
	private String pno;
    private Timestamp postdate;
    private Timestamp rePostdate;
    private String title;
    private String content;
    private String address;
    private String price;
    private String witer;
    private String categori;
    private int hit;
    private String sellType;
	private String path;



	public postVO() {
		super();
	}
	
	public postVO(String pno, Timestamp postdate, Timestamp rePostdate, String title, String content, String address,
			String price, String witer, String categori, int hit, String sellType, String path) {
		super();
		this.pno = pno;
		this.postdate = postdate;
		this.rePostdate = rePostdate;
		this.title = title;
		this.content = content;
		this.address = address;
		this.price = price;
		this.witer = witer;
		this.categori = categori;
		this.hit = hit;
		this.sellType = sellType;
		this.path = path;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public Timestamp getPostdate() {
		return postdate;
	}
	public void setPostdate(Timestamp postdate) {
		this.postdate = postdate;
	}
	public Timestamp getRePostdate() {
		return rePostdate;
	}
	public void setRePostdate(Timestamp rePostdate) {
		this.rePostdate = rePostdate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getWiter() {
		return witer;
	}
	public void setWiter(String witer) {
		this.witer = witer;
	}
	public String getCategori() {
		return categori;
	}
	public void setCategori(String categori) {
		this.categori = categori;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getSellType() {
		return sellType;
	}
	public void setSellType(String sellType) {
		this.sellType = sellType;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String toString() {
		return "postVO [pno=" + pno + ", postdate=" + postdate + ", rePostdate=" + rePostdate + ", title=" + title
				+ ", content=" + content + ", address=" + address + ", price=" + price + ", witer=" + witer
				+ ", categori=" + categori + ", hit=" + hit + ", sellType=" + sellType + "]";
	}
    
    
}
