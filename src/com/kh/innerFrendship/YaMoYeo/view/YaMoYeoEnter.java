package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class YaMoYeoEnter extends JPanel {
	private JFrame mf;
	private JPanel yaMoYeoEnter;
	
	public YaMoYeoEnter(JFrame mf) {
		this.mf = mf;
		this.yaMoYeoEnter = this;
		
		// JPanel사이즈를 메인프레임과 같은 600X800으로 설정
		// 확인이 편하도록 흰배경으로 설정
		// JPanel의 레이아웃을 null로 설정해 원하는 곳에 컴포넌트 배치
		this.setSize(600, 600);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		
		JLabel label = new JLabel("안녕하세요 입장 페이지입니다.");
		label.setSize(300, 200);
		label.setLocation(100, 100);
		
		// 마우스 이벤트를 갖고옵니다
		this.addMouseListener(new MyMouseAdapter());
		
		this.add(label);
		
		mf.add(this);
	}
	
	// 마우스가 눌리면 changePanel을 실행합니다
	// 여기선 yaMoYeoEnter 패널을 YaMoYeoLogin패널로 변경합니다
	class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			ChangePanel.changePanel(mf, yaMoYeoEnter, new YaMoYeoLogin(mf));
		}
	}
}
