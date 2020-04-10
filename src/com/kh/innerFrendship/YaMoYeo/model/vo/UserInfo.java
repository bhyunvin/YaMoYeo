package com.kh.innerFrendship.YaMoYeo.model.vo;

public class UserInfo {
	private String id; 
	private String password; //�н�����
	private boolean passwordIsCorrect; //�н����尡 �´���
	private String name; //�̸�
	private String email; // �̸���
	private String area; // ����
	private String major; // ����
	private int userNumber; // ������ȣ
	
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
		// ���߿� �����ϰ� �������� ����� ã�ƾ� �ҰͰ���
		this.userNumber = userNumber;
	}
	
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", password=" + password + ", passwordIsCorrect=" + passwordIsCorrect + ", name="
				+ name + ", email=" + email + ", area=" + area + ", major=" + major + ", userNumber=" + userNumber
				+ "]";
	}
	
	
}
