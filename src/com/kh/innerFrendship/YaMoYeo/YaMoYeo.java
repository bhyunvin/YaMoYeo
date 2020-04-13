package com.kh.innerFrendship.YaMoYeo;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.kh.innerFrendship.YaMoYeo.view.*;

// 연습용 클래스 입니다 편하게 17행의 생성자 이름을 바꿔가면서 JPanel을 올려보세요

public class YaMoYeo extends JFrame {
	public YaMoYeo() {
		this.setSize(600, 600);
		this.setTitle("YaMoYeo");
		this.setIconImage(new ImageIcon("images/ya.PNG").getImage());
		this.setResizable(false);
		
    new RoomMemberManager(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new YaMoYeo();
	}
}
