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

public class MemoBoard extends JPanel {
	
	public MemoBoard(JFrame mf) {
		
		this.setSize(600,600);
		this.setLocation(100,100);
		this.setLayout(null);
		this.setBackground(new Color(234, 208, 184));
		
		
		JLabel title = new JLabel("조원에게 메모를 남기세요.");
		title.setLocation(180,10);
		title.setSize(240,40);
		title.setFont(new Font("돋움", Font.BOLD, 18));
		
		Image icon = new ImageIcon("images/memo1.jpg").getImage().getScaledInstance(200, 200, 0);
		JLabel memo1 = new JLabel(new ImageIcon(icon));
		memo1.setLocation(70, 80);
		memo1.setSize(200,200);
		
		Image icon2 = new ImageIcon("images/memo2.jpg").getImage().getScaledInstance(200, 200, 0);
		JLabel memo2 = new JLabel(new ImageIcon(icon2));
		memo2.setLocation(70, 300);
		memo2.setSize(200,200);
		
		Image icon3 = new ImageIcon("images/memo3.jpg").getImage().getScaledInstance(200, 200, 0);
		JLabel memo3 = new JLabel(new ImageIcon(icon3));
		memo3.setLocation(330, 80);
		memo3.setSize(200,200);
		
		JButton btn = new JButton(new ImageIcon("images/plus.PNG"));
		btn.setContentAreaFilled(false);
		btn.setLocation(380,360);
		btn.setSize(70,70);
		
	
		
		
		this.add(title);
		this.add(memo1);
		this.add(memo2);
		this.add(memo3);
		this.add(btn);
	
		
	
		
		mf.add(this);
		
		
		
	}
	
	
}
