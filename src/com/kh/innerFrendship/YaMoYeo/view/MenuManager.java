package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuManager extends JPanel {
	private JFrame mf;
	private JPanel panel;

	public MenuManager(JFrame mf) {
		this.mf = mf;
		this.panel = this;
		
		this.setSize(600, 600);
		this.setLayout(null);

		JPanel panel = new JPanel();
		panel.setSize(600, 600);
		panel.setBackground(new Color(234, 208, 184));
		panel.setLayout(null);

		JButton btn = new JButton("뒤로가기");
		btn.setLocation(0, 0);
		btn.setSize(600, 50);
		btn.setBackground(Color.BLACK);
		btn.setFont(new Font("돋음", Font.BOLD, 20));
		((JButton) btn).setForeground(Color.WHITE);

		JButton btn2 = new JButton("공지사항");
		btn2.setLocation(0, 50);
		btn2.setSize(150, 550);
		btn2.setBackground(new Color(232, 221, 204));
		btn2.setFont(new Font("돋음", Font.BOLD, 18));
		((JButton) btn2).setForeground(Color.BLACK);

		JButton btn3 = new JButton("메뉴");
		btn3.setLocation(150, 50);
		btn3.setSize(150, 550);
		btn3.setBackground(new Color(234, 208, 184));
		btn3.setFont(new Font("돋음", Font.BOLD, 18));
		((JButton) btn3).setForeground(Color.BLACK);

		JButton btn4 = new JButton("조원 강퇴 투표");
		btn4.setLocation(300, 50);
		btn4.setSize(150, 550);
		btn4.setBackground(new Color(240, 149, 125));
		btn4.setFont(new Font("돋음", Font.BOLD, 17));
		((JButton) btn4).setForeground(Color.BLACK);

		JButton btn5 = new JButton("조원 관리");
		btn5.setLocation(450, 50);
		btn5.setSize(150, 550);
		btn5.setBackground(new Color(217, 106, 83));
		btn5.setFont(new Font("돋음", Font.BOLD, 18));
		((JButton) btn5).setForeground(Color.BLACK);
		
		Image icon = new ImageIcon("images/ya.png").getImage().getScaledInstance(55, 55, 0);
		JLabel label = new JLabel(new ImageIcon(icon));
		label.setLocation(490, 50);
		label.setSize(100, 100);

		this.add(btn);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
		this.add(label);
		this.add(panel);
		
		mf.add(this);

	}

}
