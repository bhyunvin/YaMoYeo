package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyInfo extends JPanel {

	private JFrame mf;
	private JPanel panel;

	// editable false 수정 금지
	// 저장 세이브 지우기

	public MyInfo(JFrame mf) {

		this.mf = mf;
		this.panel = this;

		this.setSize(600, 600);
		this.setBackground(new Color(232, 221, 204));
		this.setLayout(null);

		Image back = new ImageIcon("images/back.PNG").getImage().getScaledInstance(40, 40, 0);
		JLabel backBtn = new JLabel(new ImageIcon(back));
		backBtn.setSize(40, 40);
		backBtn.setLocation(0, 20);

		JLabel title = new JLabel("내 정보");
		title.setSize(190, 42);
		title.setLocation(250, 15);
		title.setFont(new Font("돋움", Font.BOLD, 28));

		JLabel underLine = new JLabel();
		underLine.setBackground(Color.BLACK);
		underLine.setSize(120, 3);
		underLine.setLocation(240, 55);
		underLine.setOpaque(true);

//		Image save = new ImageIcon("images/save.PNG").getImage().getScaledInstance(40, 40, 0);
//		JLabel saveBtn = new JLabel(new ImageIcon(save));
//		saveBtn.setSize(40, 40);
//		saveBtn.setLocation(540, 20);

		Image id = new ImageIcon("images/id.PNG").getImage().getScaledInstance(56, 56, 0);
		JLabel idIcon = new JLabel(new ImageIcon(id));
		idIcon.setSize(56, 56);
		idIcon.setLocation(30, 80);

		TextField idtf = new TextField("사용하실 ID를 입력해주세요");
		idtf.setSize(400, 35);
		idtf.setLocation(110, 90);

		Image password = new ImageIcon("images/lock.PNG").getImage().getScaledInstance(53, 57, 0);
		JLabel pwIcon = new JLabel(new ImageIcon(password));
		pwIcon.setSize(53, 57);
		pwIcon.setLocation(30, 140);

		TextField pwtf = new TextField("사용하실 비밀번호를 입력해주세요");
		pwtf.setSize(400, 35);
		pwtf.setLocation(110, 150);

		// 패스워드 확인 이미지, 확인창,
		Image passwordCorrect = new ImageIcon("images/passwordIsCorrect.PNG").getImage().getScaledInstance(56, 56, 0);
		JLabel pwCorrect = new JLabel(new ImageIcon(passwordCorrect));
		pwCorrect.setSize(56, 56);
		pwCorrect.setLocation(28, 205);

		TextField pwtf2 = new TextField("비밀번호를 한번 더 입력해주세요");
		pwtf2.setSize(400, 35);
		pwtf2.setLocation(110, 210);

		Image passwordWrong = new ImageIcon("images/wrong.PNG").getImage().getScaledInstance(30, 30, 0);
		JLabel pwWrong = new JLabel(new ImageIcon(passwordWrong));
		pwWrong.setSize(30, 30);
		pwWrong.setLocation(535, 215);

		Image name = new ImageIcon("images/name.PNG").getImage().getScaledInstance(58, 57, 0);
		JLabel nameIcon = new JLabel(new ImageIcon(name));
		nameIcon.setSize(58, 57);
		nameIcon.setLocation(30, 265);

		TextField nametf = new TextField("성함을 입력해 주세요");
		nametf.setSize(400, 35);
		nametf.setLocation(110, 275);

		Image email = new ImageIcon("images/email.PNG").getImage().getScaledInstance(53, 53, 0);
		JLabel emailIcon = new JLabel(new ImageIcon(email));
		emailIcon.setSize(53, 53);
		emailIcon.setLocation(32, 330);

		TextField emailtf = new TextField("사용하실 E-mail 주소를 입력해주세요");
		emailtf.setSize(400, 35);
		emailtf.setLocation(110, 340);

		Image area = new ImageIcon("images/local.PNG").getImage().getScaledInstance(56, 56, 0);
		JLabel areaIcon = new JLabel(new ImageIcon(area));
		areaIcon.setSize(56, 56);
		areaIcon.setLocation(27, 385);

		TextField areatf = new TextField("현재 거주중인 지역을 입력해주세요");
		areatf.setSize(400, 35);
		areatf.setLocation(110, 400);

		Image major = new ImageIcon("images/major.png").getImage().getScaledInstance(56, 56, 0);
		JLabel majorIcon = new JLabel(new ImageIcon(major));
		majorIcon.setSize(56, 56);
		majorIcon.setLocation(27, 448);

		TextField majortf = new TextField("전공을 입력해주세요");
		majortf.setSize(400, 35);
		majortf.setLocation(110, 460);

		JButton btn = new JButton("등록하기");
		btn.setLocation(480, 10);
		btn.setSize(110, 40);
		btn.setBackground(Color.BLACK);
		btn.setFont(new Font("돋음", Font.BOLD, 17));
		btn.setForeground(Color.WHITE);

		this.add(areaIcon);
		this.add(emailtf);
		this.add(emailIcon);
		this.add(nametf);
		this.add(nameIcon);
		this.add(pwWrong);
		this.add(pwtf2);
		this.add(pwCorrect);
		this.add(pwCorrect);
		this.add(pwtf);
		this.add(pwIcon);
		this.add(idtf);
		this.add(idIcon);
//		this.add(saveBtn);
		this.add(underLine);
		this.add(title);
		this.add(backBtn);
		this.add(areatf);
		this.add(majorIcon);
		this.add(majortf);
		this.add(btn);

		mf.add(this);

	}

}
