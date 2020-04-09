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
		
		// JPanel����� ���������Ӱ� ���� 600X800���� ����
		// Ȯ���� ���ϵ��� �������� ����
		// JPanel�� ���̾ƿ��� null�� ������ ���ϴ� ���� ������Ʈ ��ġ
		this.setSize(600, 600);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		
		JLabel label = new JLabel("�ȳ��ϼ��� ���� �������Դϴ�.");
		label.setSize(300, 200);
		label.setLocation(100, 100);
		
		// ���콺 �̺�Ʈ�� ����ɴϴ�
		this.addMouseListener(new MyMouseAdapter());
		
		this.add(label);
		
		mf.add(this);
	}
	
	// ���콺�� ������ changePanel�� �����մϴ�
	// ���⼱ yaMoYeoEnter �г��� YaMoYeoLogin�гη� �����մϴ�
	class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			ChangePanel.changePanel(mf, yaMoYeoEnter, new YaMoYeoLogin(mf));
		}
	}
}
