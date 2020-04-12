package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class YaMoYeoLogin extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private JTextField idTxt;
	private JPasswordField pwdTxt;

	public YaMoYeoLogin(JFrame mf) {
		this.mf = mf;
		this.panel = this;

		this.setSize(600, 600);
		this.setBackground(new Color(234, 208, 184));
		this.setLayout(null);

		JLabel id = new JLabel("ID");
		JLabel pwd = new JLabel("비밀번호");

		id.setBounds(200,280,100,30);
		pwd.setBounds(200,320,100,30);

		idTxt = new JTextField();
		pwdTxt = new JPasswordField();

		idTxt.setBounds(260, 280, 100, 30);
		pwdTxt.setBounds(260, 320, 100, 30);

		Image welcome = new ImageIcon("images/YaMoYeo.PNG").getImage().getScaledInstance(300, 100, 0);
		JLabel label = new JLabel(new ImageIcon(welcome));
		label.setSize(300, 100);
		label.setLocation(150, 100);

		JButton login = new JButton("로그인");
		login.setSize(100, 50);
		login.setLocation(200, 400);
		login.addMouseListener(new Login());

		JButton signUp = new JButton("회원가입");
		signUp.setSize(100,50);
		signUp.setLocation(300,400);
		signUp.addMouseListener(new SignPanelAdapter());

		this.add(idTxt);
		this.add(pwdTxt);
		this.add(pwd);
		this.add(id);
		this.add(label);
		this.add(login);
		this.add(signUp);
		
		mf.add(this);
	}
	
	class SignPanelAdapter extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			ChangePanel.changePanel(mf, panel, new SignPanel(mf));
		}
	}

	class Login extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new FileInputStream("userList.txt"));
			} catch (FileNotFoundException fnfe) {
				JOptionPane.showMessageDialog(panel, "user.txt파일이 존재하지 않습니다. 개발진에게 문의해주세요.", "에러", JOptionPane.ERROR_MESSAGE);
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}