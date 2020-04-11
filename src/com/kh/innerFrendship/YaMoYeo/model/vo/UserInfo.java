package com.kh.innerFrendship.YaMoYeo.model.vo;

public class UserInfo {
	private String id; 
	private String password; //패스워드
	private boolean passwordIsCorrect; //패스워드가 맞는지
	private String name; //이름
	private String email; // 이메일
	private String area; // 지역
	private String major; // 전공
	private int userNumber; // 고유번호
	
	public UserInfo() {}
	
	public UserInfo(String id, String password, String name, String email, String area,
			String major, int userNumber) {
		super();
		this.id = id;
		this.password = password;
//		this.passwordIsCorrect = passwordIsCorrect;
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
	
	public boolean isPasswordIsCorrect() {
		return passwordIsCorrect;
	}
	
	public void setPasswordIsCorrect(boolean passwordIsCorrect) {
		this.passwordIsCorrect = passwordIsCorrect;
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
		// 나중에 랜덤하게 넣을만한 방법을 찾아야 할것같음
		this.userNumber = userNumber;
	}
	
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", password=" + password + ", passwordIsCorrect=" + passwordIsCorrect + ", name="
				+ name + ", email=" + email + ", area=" + area + ", major=" + major + ", userNumber=" + userNumber
				+ "]";
	}
	
	
}
