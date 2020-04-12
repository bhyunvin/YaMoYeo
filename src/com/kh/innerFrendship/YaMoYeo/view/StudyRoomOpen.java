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

public class StudyRoomOpen extends JPanel {
	
	private JFrame mf;
	private JPanel panel;
	private JTextField txtTitle;
	private JTextField txtRock;
	private JTextField txtBook;
	private JTextField txtMail;
	private JTextField txtLocal;
	private JTextField txtPeople;

	public StudyRoomOpen(JFrame mf) {
		
		this.mf = mf;
		this.panel = this;
		this.setSize(600,600);
		this.setLocation(100,100);
		this.setLayout(null);
		this.setBackground(new Color(234, 208, 184));
		
		JLabel lbTitle = new JLabel("스터디 일정 공유방 개설");
		lbTitle.setLocation(190,10);
		lbTitle.setSize(250,40);
		lbTitle.setFont(new Font("돋움", Font.BOLD, 18));
		
		Image icon = new ImageIcon("images/Roomtitle.jpg").getImage().getScaledInstance(70, 50, 0);
		JLabel lbtitle = new JLabel(new ImageIcon(icon));
		lbtitle.setLocation(65,80);
		lbtitle.setSize(70,50);
		
		Image icon2 = new ImageIcon("images/rock.jpg").getImage().getScaledInstance(70, 60, 0);
		JLabel lbrock = new JLabel(new ImageIcon(icon2));
		lbrock.setLocation(65, 140);
		lbrock.setSize(70,60);
		
		Image icon3 = new ImageIcon("images/book.jpg").getImage().getScaledInstance(70, 50, 0);
		JLabel lbbook = new JLabel(new ImageIcon(icon3));
		lbbook.setLocation(65, 215);
		lbbook.setSize(70,50);
		
		Image icon4 = new ImageIcon("images/mail.jpg").getImage().getScaledInstance(70, 40, 0);
		JLabel lbmail = new JLabel(new ImageIcon(icon4));
		lbmail.setLocation(65, 280);
		lbmail.setSize(70,40);
		
		Image icon5 = new ImageIcon("images/local.jpg").getImage().getScaledInstance(70, 60, 0);
		JLabel lblocal = new JLabel(new ImageIcon(icon5));
		lblocal.setLocation(65, 330);
		lblocal.setSize(70,60);
		
		Image icon6 = new ImageIcon("images/people.jpg").getImage().getScaledInstance(70, 50, 0);
		JLabel lbpeople = new JLabel(new ImageIcon(icon6));
		lbpeople.setLocation(65, 400);
		lbpeople.setSize(70,50);
		
		JButton btn = new JButton("개설완료!");
		btn.setLocation(200, 500);
		btn.setSize(200,40);
		btn.setBackground(Color.WHITE);
		
		txtTitle = new JTextField();
		txtTitle.setText("방 제목을 입력해주세요.");
		txtTitle.setBounds(170, 90, 350, 30);
		txtTitle.addMouseListener(new Clear());	
			
		txtRock = new JTextField();
		txtRock.setText("사용하실 비밀번호를 입력하세요.");
		txtRock.setBounds(170, 160, 350, 30);
		txtRock.addMouseListener(new Clear());
		
		txtBook = new JTextField();
		txtBook.setText("공부 주제를 입력해주세요.");
		txtBook.setBounds(170, 225, 350, 30);
		txtBook.addMouseListener(new Clear());
		
		txtMail = new JTextField();
		txtMail.setText("사용하실 E-mail 주소를 입력해주세요.");
		txtMail.setBounds(170, 285, 350, 30);
		txtMail.addMouseListener(new Clear());
		
		txtLocal = new JTextField();
		txtLocal.setText("주로 활동하실 지역을 입력해주세요.");
		txtLocal.setBounds(170, 350, 350, 30);
		txtLocal.addMouseListener(new Clear());
		
		txtPeople = new JTextField();
		txtPeople.setText("최대 인원수를 입력해주세요.");
		txtPeople.setBounds(170, 410, 350, 30);
		txtPeople.addMouseListener(new Clear());
		
		this.add(btn);
		this.add(lbTitle);
		this.add(lbtitle);
		this.add(lbrock);
		this.add(lbbook);
		this.add(lbmail);
		this.add(lblocal);
		this.add(lbpeople);
		this.add(txtTitle);
		this.add(txtRock);
		this.add(txtBook);
		this.add(txtMail);
		this.add(txtLocal);
		this.add(txtPeople);
		
		mf.add(this);
		
	}
	
	class Clear extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			((JTextField) e.getComponent()).setText("");
		}
	}	
}
