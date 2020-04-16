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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuManager extends JPanel {
	private JFrame mf;
	private JPanel panel;
	public static int myNumber;
	public static int roomNumber;
	
	public MenuManager() {}

	public MenuManager(JFrame mf) {
		this.mf = mf;
		this.panel = this;
		
		this.setSize(600, 600);
		this.setLayout(null);
		this.setBackground(new Color(234, 208, 184));

		JButton btn = new JButton("뒤로가기");
		btn.setLocation(0, 0);
		btn.setSize(600, 50);
		btn.setBackground(Color.BLACK);
		btn.setFont(new Font("돋음", Font.BOLD, 20));
		btn.setForeground(Color.WHITE);
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new YaMoYeoStudyRoom(mf));
			}
		});

		JButton btn2 = new JButton("공지사항");
		btn2.setLocation(0, 50);
		btn2.setSize(150, 550);
		btn2.setBackground(new Color(232, 221, 204));
		btn2.setFont(new Font("돋음", Font.BOLD, 18));
		btn2.setForeground(Color.BLACK);
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new Notice(mf));
			}
		});

		JButton btn3 = new JButton("메모");
		btn3.setLocation(150, 50);
		btn3.setSize(150, 550);
		btn3.setBackground(new Color(234, 208, 184));
		btn3.setFont(new Font("돋음", Font.BOLD, 18));
		btn3.setForeground(Color.BLACK);
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new MemoBoard(mf));
			}
		});

		JButton btn4 = new JButton("조원 강퇴 투표");
		btn4.setLocation(300, 50);
		btn4.setSize(150, 550);
		btn4.setBackground(new Color(240, 149, 125));
		btn4.setFont(new Font("돋음", Font.BOLD, 17));
		btn4.setForeground(Color.BLACK);
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new KickOut(mf));
			}
		});

		JButton btn5 = new JButton("조원 관리");
		btn5.setLocation(450, 50);
		btn5.setSize(150, 550);
		btn5.setBackground(new Color(217, 106, 83));
		btn5.setFont(new Font("돋음", Font.BOLD, 18));
		btn5.setForeground(Color.BLACK);
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(myNumber == roomNumber) {
					ChangePanel.changePanel(mf, panel, new RoomMemberManager(mf));
				} else {
					JOptionPane.showMessageDialog(panel, "개설자가 아닙니다.", "오류", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
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
		
		mf.add(this);
	}
	
	public void getMyNumber(int myNumber) {
		this.myNumber = myNumber;
	}
	
	public void getRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
}
