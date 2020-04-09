package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class YaMoYeoLogin extends JPanel {
	private JFrame mf;
	private JPanel yaMoYeoLogin;
	
	public YaMoYeoLogin(JFrame mf) {
		this.mf = mf;
		this.yaMoYeoLogin = this;

		this.setSize(600, 600);
		this.setBackground(new Color(234, 208, 184));
		this.setLayout(null);

		JLabel label = new JLabel("안녕하세요 로그인 페이지입니다.");
		label.setSize(300, 200);
		label.setLocation(200, 100);

		JButton login = new JButton("로그인");
		login.setSize(100, 50);
		login.setLocation(200, 400);
		login.addMouseListener(new MyMouseAdapter());

		JButton signUp = new JButton("회원가입");
		signUp.setSize(100,50);
		signUp.setLocation(300,400);
		signUp.addMouseListener(new SignPanelAdapter());

		this.add(label);
		this.add(login);
		this.add(signUp);
		mf.add(this);
	}

	class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			ChangePanel.changePanel(mf, yaMoYeoLogin, new YaMoYeoEnter(mf));
		}
	}
	
	class SignPanelAdapter extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			ChangePanel.changePanel(mf, yaMoYeoLogin, new SignPanel(mf));

		}
	}
}