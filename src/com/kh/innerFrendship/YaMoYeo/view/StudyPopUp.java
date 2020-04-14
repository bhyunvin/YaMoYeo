package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudyPopUp extends JPanel {
	
	private JFrame mf;
	private JPanel panel;

	public StudyPopUp(JFrame mf) {
		
		this.mf = mf;
		this.panel = this;
		  
		this.setLayout(null);
		this.setSize(600, 600);
		this.setBackground(new Color(232,221,201));
		 	
//		Image image = new ImageIcon("img/back.PNG").getImage().getScaledInstance(40, 40, 0);
//		JLabel label = new JLabel(new ImageIcon(image));
//		label.setSize(40, 40);
//		label.setLocation(10, 10);
		
		JButton back = new JButton(new ImageIcon("images/back.png"));
		back.setLocation(10,10);
		back.setSize(50,50);
		back.setContentAreaFilled(false);
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new YaMoYeoStudyRoom(mf));
			}
		});
		
		JLabel label2 = new JLabel("3월 10일의 스터디 일정");
		label2.setSize(260, 40);
		label2.setLocation(170, 10);
		label2.setFont(new Font("돋움", Font.BOLD, 23));
		
		Image image2 = new ImageIcon("img/save.PNG").getImage().getScaledInstance(40, 40, 0);
		JLabel label3 = new JLabel(new ImageIcon(image2));
		label3.setSize(40, 40);
		label3.setLocation(520, 10);
		
		String[] hour = new String[24];
		for(int i = 0; i < 24; i++) {
			hour[i] = Integer.toString(i);
		}
		JComboBox hourlist = new JComboBox(hour);
		hourlist.setSize(115, 40);
		hourlist.setLocation(120, 70);
		
		JLabel label4 = new JLabel("시");
		label4.setSize(30,30);
		label4.setLocation(255, 73);
		label4.setFont(new Font("돋움", Font.BOLD, 20));
		
		int temp = 0;
		String[] min = new String[12];	
		for(int i = 0; i < 12; i++) {
			if(i == 0) {
				min[i] = "0";
			} else {
				temp = i * 5;
				min[i] = Integer.toString(temp);
			}
		}

		JComboBox minlist = new JComboBox(min);
		minlist.setSize(115, 40);
		minlist.setLocation(305, 70);
	
		JLabel label5 = new JLabel("분");
		label5.setSize(30, 30);
		label5.setLocation(440, 73);
		label5.setFont(new Font("돋움", Font.BOLD, 20));
		
		JTextField tf3 = new JTextField("장소를 입력해주세요");
		tf3.setSize(350, 50);
		tf3.setLocation(120, 130);
		
		JTextField tf4 = new JTextField("해야할 일, 공부범위 등을 입력해주세요");
		tf4.setSize(350, 50);
		tf4.setLocation(120, 190);		
		
		JTextField tf5 = new JTextField("해야할 일, 공부범위 등을 입력해주세요");
		tf5.setSize(350, 50);
		tf5.setLocation(120, 250);
		
		JTextField tf6 = new JTextField("해야할 일, 공부범위는 최대 3개까지 입력 가능합니다.");
		tf6.setSize(350, 50);
		tf6.setLocation(120, 310);
		
		JTextField tf7 = new JTextField("과제, 특이사항 등이 있다면 입력해주세요.");
		tf7.setSize(350, 50);
		tf7.setLocation(120, 370);		
				
		this.add(tf7);
		this.add(tf6);
		this.add(tf5);
		this.add(tf4);
		this.add(tf3);
		
		this.add(label5);
		this.add(minlist);
		this.add(label4);
		this.add(hourlist);
		this.add(label3);
		this.add(label2);
	//	this.add(label);
		this.add(back);
		mf.add(this);
	}
}
