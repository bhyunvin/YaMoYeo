package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class NoticePopUp extends JPanel {

	private JFrame mf;
	private JPanel panel;
	
	
	public NoticePopUp(JFrame mf) {
		
		this.mf = mf;
		this.panel = this;
		
		this.setSize(600, 600);
		this.setLayout(null);
		this.setBackground(new Color(232, 222, 204));
		
		Image img1 = new ImageIcon("images/back.PNG").getImage().getScaledInstance(40, 40, 0);
		JLabel back = new JLabel(new ImageIcon(img1));
		back.setSize(40, 40);
		back.setLocation(10, 25);
		
		
		JLabel title = new JLabel("공지1");
		title.setSize(250, 80);
		title.setLocation(240, 5);
		title.setFont(new Font("돋움", Font.BOLD, 30));
		
		JLabel underLine = new JLabel();
		underLine.setBackground(Color.BLACK);
		underLine.setOpaque(true);
		underLine.setLocation(227, 64);
		underLine.setSize(105, 2);
		
		
		JTextField noticetf = new JTextField();
		noticetf.setSize(500, 420);
		noticetf.setLocation(40, 90);
		
		
		
		this.add(noticetf);
		this.add(underLine);
		this.add(title);
		this.add(back);
		mf.add(this);
		
	}
	
	
	class Click extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			ChangePanel.changePanel(mf, panel, new Notice(mf));
		}
	}
}
