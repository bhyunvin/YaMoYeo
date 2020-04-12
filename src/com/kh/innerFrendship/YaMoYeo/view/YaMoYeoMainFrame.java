package com.kh.innerFrendship.YaMoYeo.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class YaMoYeoMainFrame extends JFrame {
	public YaMoYeoMainFrame() {
		this.setSize(600, 600);
		this.setLocation(500, 200);
		this.setTitle("YaMoYeo");
		this.setIconImage(new ImageIcon("images/ya.PNG").getImage());
		this.setResizable(false);
		
		// 클래스 나 자신(JFrame)을 매개변수로 하여 YaMoYeoLoading을 호출합니다
		new YaMoYeoLoading(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
