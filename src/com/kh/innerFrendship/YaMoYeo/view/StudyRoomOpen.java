package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.innerFrendship.YaMoYeo.model.vo.StudyRoom;
import com.kh.innerFrendship.YaMoYeo.model.vo.User;

public class StudyRoomOpen extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private JTextField txtTitle;
	private JTextField txtPassword;
	private JTextField txtSubject;
	private JTextField txtMail;
	private JTextField txtArea;
	private JTextField txtMaxMember;
	private ArrayList<StudyRoom> roomList;
	private ArrayList<User> userList;
	private int myNumber;

	public StudyRoomOpen(JFrame mf) {

		this.mf = mf;
		this.panel = this;

		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("userList.txt"));

			userList = (ArrayList<User>) ois.readObject();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

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
				ChangePanel.changePanel(mf, panel, new YaMoYeoEnter(mf));
			}
		});
		
		JLabel lbTitle = new JLabel("스터디 일정 공유방 개설");
		lbTitle.setLocation(190, 10);
		lbTitle.setSize(250, 40);
		lbTitle.setFont(new Font("돋움", Font.BOLD, 18));
		
		JLabel underLine = new JLabel();
		underLine.setBackground(Color.BLACK);
		underLine.setSize(230, 2);
		underLine.setLocation(180, 50);
		underLine.setOpaque(true);
		
		Image icon = new ImageIcon("images/Roomtitle.jpg").getImage().getScaledInstance(80, 50, 0);
		JLabel lbtitle = new JLabel(new ImageIcon(icon));
		lbtitle.setLocation(65,80);
		lbtitle.setSize(80,50);
		
		Image icon2 = new ImageIcon("images/lock.jpg").getImage().getScaledInstance(60, 60, 0);
		JLabel lbrock = new JLabel(new ImageIcon(icon2));
		lbrock.setLocation(75, 140);
		lbrock.setSize(60,60);
		
		Image icon3 = new ImageIcon("images/book.jpg").getImage().getScaledInstance(70, 50, 0);
		JLabel lbbook = new JLabel(new ImageIcon(icon3));
		lbbook.setLocation(70, 215);
		lbbook.setSize(70,50);

		Image icon4 = new ImageIcon("images/mail.jpg").getImage().getScaledInstance(70, 40, 0);
		JLabel lbmail = new JLabel(new ImageIcon(icon4));
		lbmail.setLocation(65, 280);
		lbmail.setSize(70, 40);

		Image icon5 = new ImageIcon("images/local.jpg").getImage().getScaledInstance(70, 60, 0);
		JLabel lblocal = new JLabel(new ImageIcon(icon5));
		lblocal.setLocation(65, 330);
		lblocal.setSize(70, 60);

		Image icon6 = new ImageIcon("images/people.jpg").getImage().getScaledInstance(70, 50, 0);
		JLabel lbpeople = new JLabel(new ImageIcon(icon6));
		lbpeople.setLocation(65, 400);
		lbpeople.setSize(70, 50);

		JButton btn = new JButton("개설완료!");
		btn.setLocation(200, 500);
		btn.setSize(200, 40);
		btn.setBackground(Color.WHITE);
		btn.addMouseListener(new MakeRoom());
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new YaMoYeoEnter(mf));
			}
		});

		txtTitle = new JTextField();
		txtTitle.setText("방 제목을 입력해주세요.");
		txtTitle.setBounds(170, 90, 350, 30);
		txtTitle.addMouseListener(new Clear());

		txtPassword = new JTextField();
		txtPassword.setText("사용하실 비밀번호를 입력하세요.");
		txtPassword.setBounds(170, 160, 350, 30);
		txtPassword.addMouseListener(new Clear());

		txtSubject = new JTextField();
		txtSubject.setText("공부 주제를 입력해주세요.");
		txtSubject.setBounds(170, 225, 350, 30);
		txtSubject.addMouseListener(new Clear());

		txtMail = new JTextField();
		txtMail.setText("사용하실 E-mail 주소를 입력해주세요.");
		txtMail.setBounds(170, 285, 350, 30);
		txtMail.addMouseListener(new Clear());

		
		txtArea = new JTextField();
		txtArea.setText("주로 활동하실 지역을 입력해주세요.");
		txtArea.setBounds(170, 350, 350, 30);
		txtArea.addMouseListener(new Clear());
		
		txtMaxMember = new JTextField();
		txtMaxMember.setText("최대 인원수를 입력해주세요.");
		txtMaxMember.setBounds(170, 410, 350, 30);
		txtMaxMember.addMouseListener(new Clear());

		this.add(back);
		this.add(btn);
		this.add(lbTitle);
		this.add(underLine);
		this.add(lbtitle);
		this.add(lbrock);

		this.add(lbbook);
		this.add(lbmail);
		this.add(lblocal);
		this.add(lbpeople);
		this.add(txtTitle);
		this.add(txtPassword);
		this.add(txtSubject);
		this.add(txtMail);
		this.add(txtArea);
		this.add(txtMaxMember);

		mf.add(this);
	}

	class Clear extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			((JTextField) e.getComponent()).setText("");
		}
	}

	class MakeRoom extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			ObjectOutputStream oos = null;

			try {
				oos = new ObjectOutputStream(new FileOutputStream("roomList.txt"));

				oos.writeObject(new StudyRoom(txtTitle.getText(), txtPassword.getText(), txtSubject.getText(),
						txtMail.getText(), txtArea.getText(), Integer.parseInt(txtMaxMember.getText()), myNumber));
			} catch (FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} finally {
				try {
					oos.flush();
					oos.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
	}

	public void getMyNumber(int myNumber) {
		this.myNumber = myNumber;
	}
}
