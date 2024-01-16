package com.project.user.medel;

import java.sql.Timestamp;

public class UserVO {
	
	//DB의 컬럼과 동일하게 변수명 선언
	private String id;
	private String pw;
	private String name;
	private String email;
	private String address;
	private String nick;
	private String gender;
	private Timestamp regdate;
	
	public UserVO() {
	}

	public UserVO(String id, String pw, String name, String email, String address, String nick, String gender,
			Timestamp regdate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.address = address;
		this.nick = nick;
		this.gender = gender;
		this.regdate = regdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", nick=" + nick + ", gender=" + gender + ", regdate=" + regdate + "]";
	}
	
}	