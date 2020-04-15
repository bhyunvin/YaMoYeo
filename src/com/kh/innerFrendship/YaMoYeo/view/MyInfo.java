package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new YaMoYeoEnter(mf));
			}
		});

		JLabel title = new JLabel("내 정보");
		title.setSize(190, 42);
		title.setLocation(250, 15);
		title.setFont(new Font("돋움", Font.BOLD, 28));

		JLabel underLine = new JLabel();
		underLine.setBackground(Color.BLACK);
		underLine.setSize(120, 3);
		underLine.setLocation(240, 55);
		underLine.setOpaque(true);

		Image id = new ImageIcon("images/id.PNG").getImage().getScaledInstance(56, 56, 0);
		JLabel idIcon = new JLabel(new ImageIcon(id));
		idIcon.setSize(56, 56);
		idIcon.setLocation(30, 90);

		TextField idtf = new TextField("사용하실 ID를 입력해주세요");
		idtf.setSize(400, 45);
		idtf.setLocation(110, 95);
		idtf.setEditable(false);

		Image password = new ImageIcon("images/lock.PNG").getImage().getScaledInstance(53, 57, 0);
		JLabel pwIcon = new JLabel(new ImageIcon(password));
		pwIcon.setSize(53, 57);
		pwIcon.setLocation(30, 165);

		TextField pwtf = new TextField("사용하실 비밀번호를 입력해주세요");
		pwtf.setSize(400, 45);
		pwtf.setLocation(110, 170);
		pwtf.setEditable(false);

		Image name = new ImageIcon("images/name.PNG").getImage().getScaledInstance(63, 63, 0);
		JLabel nameIcon = new JLabel(new ImageIcon(name));
		nameIcon.setSize(58, 57);
		nameIcon.setLocation(30, 245);

		TextField nametf = new TextField("성함을 입력해 주세요");
		nametf.setSize(400, 45);
		nametf.setLocation(110, 250);
		nametf.setEditable(false);

		Image email = new ImageIcon("images/email.PNG").getImage().getScaledInstance(52, 52, 0);
		JLabel emailIcon = new JLabel(new ImageIcon(email));
		emailIcon.setSize(53, 53);
		emailIcon.setLocation(31, 315);

		TextField emailtf = new TextField("사용하실 E-mail 주소를 입력해주세요");
		emailtf.setSize(400, 45);
		emailtf.setLocation(110, 320);
		emailtf.setEditable(false);

		Image area = new ImageIcon("images/local.PNG").getImage().getScaledInstance(56, 56, 0);
		JLabel areaIcon = new JLabel(new ImageIcon(area));
		areaIcon.setSize(56, 56);
		areaIcon.setLocation(27, 380);

		TextField areatf = new TextField("현재 거주중인 지역을 입력해주세요");
		areatf.setSize(400, 45);
		areatf.setLocation(110, 385);
		areatf.setEditable(false);

		Image major = new ImageIcon("images/major.png").getImage().getScaledInstance(56, 56, 0);
		JLabel majorIcon = new JLabel(new ImageIcon(major));
		majorIcon.setSize(56, 56);
		majorIcon.setLocation(27, 455);

		TextField majortf = new TextField("전공을 입력해주세요");
		majortf.setSize(400, 45);
		majortf.setLocation(110, 460);
		majortf.setEditable(false);

		this.add(areaIcon);
		this.add(emailtf);
		this.add(emailIcon);
		this.add(nametf);
		this.add(nameIcon);
		this.add(pwtf);
		this.add(pwIcon);
		this.add(idtf);
		this.add(idIcon);
		this.add(underLine);
		this.add(title);
		this.add(backBtn);
		this.add(areatf);
		this.add(majorIcon);
		this.add(majortf);

		mf.add(this);

	}

}
