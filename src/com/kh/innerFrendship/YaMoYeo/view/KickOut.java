package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KickOut extends JPanel {

	public KickOut(JFrame mf) {

		this.setSize(600,600);
		this.setLocation(100,100);
		this.setLayout(null);
		this.setBackground(new Color(234, 208, 184));

		JLabel title = new JLabel("������ǥ");
		title.setLocation(210,20);
		title.setSize(250,50);
		title.setFont(new Font("����", Font.BOLD,40));

		JLabel title2 = new JLabel("������ ���� ��ǥ�� �������Դϴ�.");
		title2.setLocation(110,100);
		title2.setSize(400,50);
		title2.setFont(new Font("����", Font.BOLD, 25));

		JLabel txt = new JLabel("������ �������忡");
		txt.setLocation(200,180);
		txt.setSize(210,50);
		txt.setFont(new Font("����", Font.BOLD, 25));

		Image icon = new ImageIcon("images/����.jpg").getImage().getScaledInstance(300, 100, 0);
		JLabel out = new JLabel(new ImageIcon(icon));
		out.setLocation(150,380);
		out.setSize(300,100);

		JCheckBox chk1 = new JCheckBox("�����մϴ�", true);
		chk1.setLocation(220, 210);
		chk1.setSize(200, 100);
		chk1.setOpaque(false);
		chk1.setFont(new Font("����",Font.BOLD,25));
		JCheckBox chk2 = new JCheckBox("�ݴ��մϴ�", true);
		chk2.setLocation(220, 280);
		chk2.setSize(200, 100);
		chk2.setOpaque(false);
		chk2.setFont(new Font("����",Font.BOLD,25));

		


		JButton btn = new JButton("Ȯ��");
		btn.setLocation(240,500);
		btn.setSize(100,30);
		btn.setBackground(Color.LIGHT_GRAY);

		JButton back = new JButton(new ImageIcon("images/back.png"));
		back.setLocation(20,20);
		back.setSize(45,45);
		back.setContentAreaFilled(false);


		this.add(title);
		this.add(title2);
		this.add(txt);
		this.add(btn);
		this.add(out);
		this.add(chk1);
		this.add(chk2);
		this.add(back);
		

		mf.add(this);
	}

}
