package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudyRoom extends JPanel {
	
	public StudyRoom(JFrame mf) {
		this.setSize(600,600);
		this.setLocation(100,100);
		this.setLayout(null);
		this.setBackground(new Color(234, 208, 184));
		
		JLabel title = new JLabel("���͵�");
		title.setLocation(240,20);
		title.setSize(250,50);
		title.setFont(new Font("����", Font.BOLD,35));
		
		JButton back = new JButton(new ImageIcon("images/back.png"));
		back.setLocation(20,20);
		back.setSize(45,45);
		back.setContentAreaFilled(false);
		
		JButton menu = new JButton(new ImageIcon("images/menu.png"));
		menu.setLocation(530,15);
		menu.setSize(50,50);
		menu.setContentAreaFilled(false);
		
		JCheckBox chk1 = new JCheckBox();
		chk1.setLocation(50, 80);
		chk1.setSize(100, 100);
		chk1.setOpaque(false);
		
		JCheckBox chk2 = new JCheckBox();
		chk2.setLocation(50, 120);
		chk2.setSize(100, 100);
		chk2.setOpaque(false);
				
		JCheckBox chk3 = new JCheckBox();
		chk3.setLocation(50, 160);
		chk3.setSize(100, 100);
		chk3.setOpaque(false);
		
		
		JTextField txt = new JTextField("to do list");
		txt.setLocation(85, 110);
		txt.setSize(200,30);
		txt.setOpaque(false);
		
		
		JTextField txt2 = new JTextField("to do list");
		txt2.setLocation(85, 155);
		txt2.setSize(200,30);
		txt2.setOpaque(false);
		
		JTextField txt3 = new JTextField("to do list");
		txt3.setLocation(85, 200);
		txt3.setSize(200,30);
		txt3.setOpaque(false);
		
		
		
		
		
		
		
		
		this.add(title);
		this.add(back);
		this.add(menu);
		this.add(chk1);
		this.add(chk2);
		this.add(chk3);
		this.add(txt);
		this.add(txt2);
		this.add(txt3);
		
		mf.add(this);
	}
}
