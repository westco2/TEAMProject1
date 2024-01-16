package com.project.scripts.model;

import java.sql.Timestamp;

public class scriptsVO {
	private String letter_send_id;
	private String letter_detail;
	private Timestamp letter_date;
	private String user_id;
	private String bno;
	public scriptsVO() {
		super();
	}


		
	
	public scriptsVO(String letter_send_id, String letter_detail, Timestamp letter_date, String user_id, String bno) {
		super();
		this.letter_send_id = letter_send_id;
		this.letter_detail = letter_detail;
		this.letter_date = letter_date;
		this.user_id = user_id;
		this.bno = bno;
	}


	

	public String getBno() {
		return bno;
	}




	public void setBno(String bno) {
		this.bno = bno;
	}




	public String getLetter_send_id() {
		return letter_send_id;
	}
	public void setLetter_send_id(String letter_send_id) {
		this.letter_send_id = letter_send_id;
	}
	public String getLetter_detail() {
		return letter_detail;
	}
	public void setLetter_detail(String letter_detail) {
		this.letter_detail = letter_detail;
	}
	public Timestamp getLetter_date() {
		return letter_date;
	}
	public void setLetter_date(Timestamp letter_date) {
		this.letter_date = letter_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}




	
	public String toString() {
		return "scriptsVO [letter_send_id=" + letter_send_id + ", letter_detail=" + letter_detail + ", letter_date="
				+ letter_date + ", user_id=" + user_id + ", bno=" + bno + "]";
	}
	
	
	
	
}
