package com.project.scripts.model;



public class scriptsVO {
	private String letter_send_id;
	private String letter_detail;
	private String letter_date;
	private String user_id;
	public scriptsVO() {
		super();
	}
	public scriptsVO(String letter_send_id, String letter_detail, String letter_date, String user_id) {
		super();
		this.letter_send_id = letter_send_id;
		this.letter_detail = letter_detail;
		this.letter_date = letter_date;
		this.user_id = user_id;
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
	public String getLetter_date() {
		return letter_date;
	}
	public void setLetter_date(String letter_date) {
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
				+ letter_date + ", user_id=" + user_id + "]";
	}
	
	
	
	
}
