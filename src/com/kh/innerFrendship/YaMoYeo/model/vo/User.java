package com.kh.innerFrendship.YaMoYeo.model.vo;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7262631511992160491L;
	private String id; 
	private String password; //패스워드
	private String name; //이름
	private String email; // 이메일
	private String area; // 지역
	private String major; // 전공
	private int userNumber; // 고유번호
	
	public User(String id, String password, String name, String email, String area, String major, int userNumber) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.area = area;
		this.major = major;
		this.userNumber = userNumber;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
	
	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public int getUserNumber() {
		return userNumber;
	}
	
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name="
				+ name + ", email=" + email + ", area=" + area + ", major=" + major + ", userNumber=" + userNumber
				+ "]";
	}
}
