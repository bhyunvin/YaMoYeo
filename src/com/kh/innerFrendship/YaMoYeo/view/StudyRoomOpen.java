package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.innerFrendship.YaMoYeo.model.vo.StudyRoom;

public class StudyRoomOpen extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private JTextField txtTitle;
	private JTextField txtPassword;
	private JTextField txtSubject;
	private JTextField txtMail;
	private JTextField txtArea;
	public static int myNumber;
	
	public StudyRoomOpen() {}

	public StudyRoomOpen(JFrame mf) {
		this.mf = mf;
		this.panel = this;
		
		this.setSize(600, 600);
		this.setLayout(null);
		this.setBackground(new Color(234, 208, 184));
    
		Image backImage = new ImageIcon("images/back.PNG").getImage().getScaledInstance(56, 56, 0);
		JLabel back = new JLabel(new ImageIcon(backImage));		
		back.setLocation(5, 10);
		back.setSize(56, 56);
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new YaMoYeoEnter(mf));
			}
		});	

		JLabel lbTitle = new JLabel("스터디 일정 공유방 개설");
		lbTitle.setLocation(190, 10);
		lbTitle.setSize(250, 40);
		lbTitle.setFont(new Font("돋움", Font.BOLD, 18));

		JLabel underLine = new JLabel();
		underLine.setBackground(Color.BLACK);
		underLine.setOpaque(true);
		underLine.setLocation(190, 45);
		underLine.setSize(215, 2);

		Image icon = new ImageIcon("images/Roomtitle.jpg").getImage().getScaledInstance(70, 50, 0);
		JLabel lbtitle = new JLabel(new ImageIcon(icon));
		lbtitle.setLocation(65, 95);
		lbtitle.setSize(70, 50);

		Image icon2 = new ImageIcon("images/lock.jpg").getImage().getScaledInstance(70, 60, 0);
		JLabel lblock = new JLabel(new ImageIcon(icon2));
		lblock.setLocation(65, 170);
		lblock.setSize(70, 60);

		Image icon3 = new ImageIcon("images/book.jpg").getImage().getScaledInstance(70, 50, 0);
		JLabel lbbook = new JLabel(new ImageIcon(icon3));
		lbbook.setLocation(65, 255);
		lbbook.setSize(70, 50);

		Image icon4 = new ImageIcon("images/mail.jpg").getImage().getScaledInstance(60, 60, 0);
		JLabel lbmail = new JLabel(new ImageIcon(icon4));
		lbmail.setLocation(70, 330);
		lbmail.setSize(60, 60);

		Image icon5 = new ImageIcon("images/local.jpg").getImage().getScaledInstance(70, 65, 0);
		JLabel lblocal = new JLabel(new ImageIcon(icon5));
		lblocal.setLocation(63, 405);
		lblocal.setSize(70, 65);

		JButton btn = new JButton("개설완료!");
		btn.setLocation(200, 500);
		btn.setSize(200, 40);
		btn.setBackground(Color.WHITE);
		
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String roomName = txtTitle.getText();
				String roomPassword = txtPassword.getText();
				String roomSubject = txtSubject.getText();
				String roomEmail = txtMail.getText();
				String roomArea = txtArea.getText();
				
				StudyRoom studyRoom = new StudyRoom(roomName, roomPassword, roomSubject, roomEmail, roomArea, myNumber);
				makeRoom(studyRoom);
			}
		});
		
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new YaMoYeoEnter(mf));
			}
		});

		Font f = new Font("돋움", Font.BOLD, 15);
		
		txtTitle = new JTextField();
		txtTitle.setText("방 제목을 입력해주세요.");
		txtTitle.setBounds(170, 90, 350, 60);
		txtTitle.setFont(f);
		txtTitle.addMouseListener(new Clear());

		txtPassword = new JTextField();
		txtPassword.setText("사용하실 비밀번호를 입력하세요.");
		txtPassword.setBounds(170, 170, 350, 60);
		txtPassword.setFont(f);
		txtPassword.addMouseListener(new Clear());

		txtSubject = new JTextField();
		txtSubject.setText("공부 주제를 입력해주세요.");
		txtSubject.setBounds(170, 250, 350, 60);
		txtSubject.setFont(f);
		txtSubject.addMouseListener(new Clear());

		txtMail = new JTextField();
		txtMail.setText("사용하실 E-mail 주소를 입력해주세요.");
		txtMail.setBounds(170, 330, 350, 60);
		txtMail.setFont(f);
		txtMail.addMouseListener(new Clear());

		txtArea = new JTextField();
		txtArea.setText("주로 활동하실 지역을 입력해주세요.");
		txtArea.setBounds(170, 410, 350, 60);
		txtArea.setFont(f);
		txtArea.addMouseListener(new Clear());

		this.add(btn);
		this.add(lbTitle);
		this.add(lbtitle);
		this.add(underLine);
		this.add(lblock);
		this.add(lbbook);
		this.add(lbmail);
		this.add(lblocal);
		this.add(back);
		this.add(txtTitle);
		this.add(txtPassword);
		this.add(txtSubject);
		this.add(txtMail);
		this.add(txtArea);

		mf.add(this);
	}

	class Clear extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			((JTextField) e.getComponent()).setText("");
		}
	}
	
	public void makeRoom(StudyRoom studyroom) {
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("roomList.txt", true));
			
			oos.writeObject(studyroom);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.flush();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void getMyNumber(int myNumber) {
		this.myNumber = myNumber;
	}
}
