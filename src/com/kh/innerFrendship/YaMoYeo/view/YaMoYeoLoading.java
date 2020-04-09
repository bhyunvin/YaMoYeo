package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class YaMoYeoLoading extends JPanel {
	private JFrame mf;
	private JPanel panel;
	
	public YaMoYeoLoading(JFrame mf) {
		this.mf = mf;
		this.panel = this;
		
		// 사이즈, 배경색, 레이아웃 설정
		this.setSize(600, 600);
		this.setBackground(new Color(234, 208, 184));
		this.setLayout(null);
		
		JLabel welcome1 = new JLabel("단체 스터디 일정관리 프로그램");
		welcome1.setSize(540, 60);
		welcome1.setLocation(30, 150);
		welcome1.setFont(new Font("돋움", Font.BOLD, 36));
		
		JLabel welcome2 = new JLabel("돌아오신 것을 환영합니다");
		welcome2.setSize(470, 60);
		welcome2.setLocation(65, 350);
		welcome2.setFont(new Font("돋움", Font.BOLD, 36));
		
		// 이미지라벨
		JLabel image = new JLabel(new ImageIcon(new ImageIcon("images/오늘_1.JPG").getImage().getScaledInstance(300, 100, 0)));
		image.setLocation(150, 230);
		image.setSize(300, 100);
		
		this.add(image);
		this.add(welcome1);
		this.add(welcome2);
		
		mf.add(this);		
		
		// 구글링으로 찾아낸 시간 지연
		// swing에선 Thread.sleep를 그냥 쓰면 안먹는다고 합니다
		Thread t = new Thread(new Runnable() {
		      public void run() {
		        try {
					Thread.sleep(2000);
					ChangePanel.changePanel(mf, panel, new YaMoYeoLogin(mf));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		      }
		});
		t.start();
	}
}
