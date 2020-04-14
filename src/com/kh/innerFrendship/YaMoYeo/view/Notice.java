package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Notice extends JPanel {
	private JFrame mf;
	private JPanel panel;

	public Notice(JFrame mf) {
		this.mf = mf;
		this.panel = this;

		this.setSize(600, 600);
		this.setLayout(null);
		this.setBackground(new Color(234, 208, 184));

		Image backImage = new ImageIcon("images/back.PNG").getImage().getScaledInstance(40, 40, 0);
		JLabel back = new JLabel(new ImageIcon(backImage));		
		back.setLocation(15, 15);
		back.setSize(40, 40);
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new YaMoYeoStudyRoom(mf));
			}
		});

		JLabel label = new JLabel();
		label = new JLabel("공지사항");
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setSize(600, 150);
		label.setFont(new Font("돋움", Font.BOLD, 35));
		
		JLabel underLine = new JLabel();
		underLine.setBackground(Color.BLACK);
		underLine.setSize(162, 3);
		underLine.setLocation(220, 100);
		underLine.setOpaque(true);
		

		JTextField text = new JTextField("번  호");
		text.setLocation(30, 150);
		text.setSize(100, 50);
		text.setBackground(Color.LIGHT_GRAY);
		text.setFont(new Font("돋음", Font.BOLD, 15));
		text.setHorizontalAlignment(JTextField.CENTER);

		JTextField text2 = new JTextField("1");
		text2.setLocation(30, 200);
		text2.setSize(100, 50);
		text2.setBackground(Color.LIGHT_GRAY);
		text2.setFont(new Font("돋음", Font.BOLD, 15));
		text2.setHorizontalAlignment(JTextField.CENTER);

		JTextField text3 = new JTextField("2");
		text3.setLocation(30, 250);
		text3.setSize(100, 50);
		text3.setBackground(Color.LIGHT_GRAY);
		text3.setFont(new Font("돋음", Font.BOLD, 15));
		text3.setHorizontalAlignment(JTextField.CENTER);

		JTextField text4 = new JTextField("3");
		text4.setLocation(30, 300);
		text4.setSize(100, 50);
		text4.setBackground(Color.LIGHT_GRAY);
		text4.setFont(new Font("돋음", Font.BOLD, 15));
		text4.setHorizontalAlignment(JTextField.CENTER);

		JTextField text5 = new JTextField("4");
		text5.setLocation(30, 350);
		text5.setSize(100, 50);
		text5.setBackground(Color.LIGHT_GRAY);
		text5.setFont(new Font("돋음", Font.BOLD, 15));
		text5.setHorizontalAlignment(JTextField.CENTER);

		JTextField text6 = new JTextField("제  목");
		text6.setLocation(130, 150);
		text6.setSize(440, 50);
		text6.setBackground(Color.LIGHT_GRAY);
		text6.setFont(new Font("돋음", Font.BOLD, 15));
		text6.setHorizontalAlignment(JTextField.CENTER);

		JButton btn = new JButton("공지사항 1");
		btn.setLocation(130, 200);
		btn.setSize(440, 50);
		btn.setBackground(Color.WHITE);
		btn.setFont(new Font("돋음", Font.PLAIN, 20));
		((JButton) btn).setForeground(Color.BLACK);

		JButton btn2 = new JButton("공지사항 2");
		btn2.setLocation(130, 250);
		btn2.setSize(440, 50);
		btn2.setBackground(Color.WHITE);
		btn2.setFont(new Font("돋음", Font.PLAIN, 20));
		((JButton) btn2).setForeground(Color.BLACK);

		JButton btn3 = new JButton("공지사항 3");
		btn3.setLocation(130, 300);
		btn3.setSize(440, 50);
		btn3.setBackground(Color.WHITE);
		btn3.setFont(new Font("돋음", Font.PLAIN, 20));
		((JButton) btn3).setForeground(Color.BLACK);

		JButton btn4 = new JButton("공지사항 4");
		btn4.setLocation(130, 350);
		btn4.setSize(440, 50);
		btn4.setBackground(Color.WHITE);
		btn4.setFont(new Font("돋음", Font.PLAIN, 20));
		((JButton) btn4).setForeground(Color.BLACK);

		JLabel label2 = new JLabel("제목을 누르시면 공지사항을 확인할 수 있습니다.");
		label2.setLocation(30, 420);
		label2.setSize(540, 100);
		label2.setFont(new Font("돋음", Font.BOLD, 20));
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setOpaque(false);

		this.add(label);
		this.add(label2);
		this.add(underLine);
		this.add(back);
		this.add(text);
		this.add(text2);
		this.add(text3);
		this.add(text4);
		this.add(text5);
		this.add(text6);
		this.add(btn);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);

		mf.add(this);

	}

}
