package com.kh.innerFrendship.YaMoYeo.model.vo;

import java.io.Serializable;
import java.util.Date;

public class StudyRoom implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3773890462791718830L;
	private String roomName;
	private String roomPassword;
	private int roomNumber;
	private String subject;
	private String email;
	private String area;
	private int maxMember;
	private int[] outMembers;
	private Date today = new Date(); // 오늘 날짜 저장
	// 일정 arraylist
	
	public StudyRoom(String roomName, String roomPassword, String subject, String email, String area,
			int maxMember, int roomNumber) {
		this.roomName = roomName;
		this.roomPassword = roomPassword;
		this.subject = subject;
		this.email = email;
		this.area = area;
		this.maxMember = maxMember;
		this.roomNumber = roomNumber;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomPassword() {
		return roomPassword;
	}

	public void setRoomPassword(String roomPassword) {
		this.roomPassword = roomPassword;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
//		this.roomNumber = roomNumber;
		// 유저 번호랑 같게
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	public int getMaxMember() {
		return maxMember;
	}

	public void setMaxMember(int maxMember) {
		this.maxMember = maxMember;
	}

	public int[] getOutMembers() {
		return outMembers;
	}

	public void setOutMembers(int[] outMembers) {
		this.outMembers = outMembers;
	}

	public Date getToday() {
		return today;
	}
	
}
