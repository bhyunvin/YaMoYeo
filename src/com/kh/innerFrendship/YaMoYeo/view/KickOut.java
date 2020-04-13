package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class KickOut extends JPanel {
	
	private JFrame mf;
	private JPanel panel;


	public KickOut(JFrame mf) {
		
		this.mf = mf;
		this.panel = this;

		this.setSize(600,600);
		this.setLayout(null);
		this.setBackground(new Color(234, 208, 184));

		JLabel title = new JLabel("강퇴투표");
		title.setLocation(210,20);
		title.setSize(250,50);
		title.setFont(new Font("돋움", Font.BOLD,40));
		
		JLabel underLine = new JLabel();
		underLine.setBackground(Color.BLACK);
		underLine.setOpaque(true);
		underLine.setLocation(210, 70);
		underLine.setSize(165, 2);


		JLabel title2 = new JLabel("조원의 강퇴 투표가 진행중입니다.");
		title2.setLocation(110,100);
		title2.setSize(400,50);
		title2.setFont(new Font("돋움", Font.BOLD, 25));

		JLabel txt = new JLabel("조원의 강제퇴장에");
		txt.setLocation(200,180);
		txt.setSize(210,50);
		txt.setFont(new Font("돋움", Font.BOLD, 25));

		Image icon = new ImageIcon("images/강퇴.jpg").getImage().getScaledInstance(300, 100, 0);
		JLabel out = new JLabel(new ImageIcon(icon));
		out.setLocation(150,380);
		out.setSize(300,100);

		JCheckBox chk1 = new JCheckBox("동의합니다", true);
		chk1.setLocation(220, 210);
		chk1.setSize(200, 100);
		chk1.setOpaque(false);
		chk1.setFont(new Font("돋움",Font.BOLD,25));
		JCheckBox chk2 = new JCheckBox("반대합니다", true);
		chk2.setLocation(220, 280);
		chk2.setSize(200, 100);
		chk2.setOpaque(false);
		chk2.setFont(new Font("돋움",Font.BOLD,25));

		


		JButton btn = new JButton("확인");
		btn.setLocation(240,500);
		btn.setSize(100,30);
		btn.setBackground(Color.LIGHT_GRAY);

		JButton back = new JButton(new ImageIcon("images/back.png"));
		back.setLocation(20,20);
		back.setSize(45,45);
		back.setContentAreaFilled(false);
		back.addMouseListener(new MyMouseAdapter());

		this.add(title);
		this.add(underLine);
		this.add(title2);
		this.add(txt);
		this.add(btn);
		this.add(out);
		this.add(chk1);
		this.add(chk2);
		this.add(back);
		

		mf.add(this);
	}

	class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			ChangePanel.changePanel(mf, panel, new Notice(mf));
			
		}
	}
	
	

}
