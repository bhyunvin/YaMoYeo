package com.kh.innerFrendship.YaMoYeo.model.vo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class StudyRoom implements Serializable {
//  문자열 방 이름
//	문자열 방 비밀번호
//	정수형 방 번호 (유저번호와 비교하여 개설자 여부 확인)
//	일정 객체
//	정수형 배열 강퇴된 유저번호 (유저번호와 비교하여 이전에 강퇴여부 확인)
//	일정 오늘
	private String roomName;
	private String roomPassword;
	private int roomNumber; // 개설자 유저번호랑 똑같게
	private int[] outMembers;
	private Date today = new Date(); // 오늘 날짜 저장
	
	public StudyRoom(String roomName, String roomPassword, int roomNumber, int[] outMembers, Date today) {
		this.roomName = roomName;
		this.roomPassword = roomPassword;
		this.roomNumber = roomNumber;
		this.outMembers = outMembers;
		this.today = today;
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
		this.roomNumber = roomNumber;
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

	public void setToday(Date today) {
		this.today = today;
	}

	@Override
	public String toString() {
		return "StudyRoom [roomName=" + roomName + ", roomPassword=" + roomPassword + ", roomNumber=" + roomNumber
				+ ", outMembers=" + Arrays.toString(outMembers) + ", today=" + today + "]";
	}
	
}
