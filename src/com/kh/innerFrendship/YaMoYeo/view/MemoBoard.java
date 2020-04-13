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
	
	private JFrame mf;
	private JPanel panel;
	

	public MemoBoard(JFrame mf) {
		
		this.mf = mf;
		this.panel = this;
		
		this.setSize(600,600);
		this.setLayout(null);
		this.setBackground(new Color(234, 208, 184));
		
		
		JLabel title = new JLabel("조원에게 메모를 남겨보세요.");
		title.setLocation(180,10);
		title.setSize(250,40);
		title.setFont(new Font("돋움", Font.BOLD, 18));
		
		Image icon = new ImageIcon("images/memo11.jpg").getImage().getScaledInstance(220, 220, 0);
		JLabel memo1 = new JLabel(new ImageIcon(icon));
		memo1.setLocation(60, 70);
		memo1.setSize(220,220);
		
		Image icon2 = new ImageIcon("images/memo22.jpg").getImage().getScaledInstance(220, 220, 0);
		JLabel memo2 = new JLabel(new ImageIcon(icon2));
		memo2.setLocation(60, 310);
		memo2.setSize(220,220);
		
		Image icon3 = new ImageIcon("images/memo33.jpg").getImage().getScaledInstance(220, 220, 0);
		JLabel memo3 = new JLabel(new ImageIcon(icon3));
		memo3.setLocation(320, 70);
		memo3.setSize(220,220);
		
		JButton btn = new JButton(new ImageIcon("images/plus.PNG"));
		btn.setContentAreaFilled(false);
		btn.setLocation(395,380);
		btn.setSize(70,70);
		
		JButton back = new JButton(new ImageIcon("images/back.png"));
		back.setLocation(20,20);
		back.setSize(45,45);
		back.setContentAreaFilled(false);
		back.addMouseListener(new MyMouseAdapter());
		
	
		
	
		
		
		this.add(title);
		this.add(memo1);
		this.add(memo2);
		this.add(memo3);
		this.add(btn);
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
