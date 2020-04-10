package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class YaMoYeoLogin extends JPanel {
	private JFrame mf;
	private JPanel yaMoYeoLogin;
	private JTextField idTxt;
	private JPasswordField pwdTxt;

	public YaMoYeoLogin(JFrame mf) {
		this.mf = mf;
		this.yaMoYeoLogin = this;

		this.setSize(600, 600);
		this.setBackground(new Color(234, 208, 184));
		this.setLayout(null);

		JLabel id = new JLabel("ID");
		JLabel pwd = new JLabel("��й�ȣ");

		id.setBounds(200,280,100,30);
		pwd.setBounds(200,320,100,30);

		idTxt = new JTextField();
		pwdTxt = new JPasswordField();

		idTxt.setBounds(260, 280, 100, 30);
		pwdTxt.setBounds(260, 320, 100, 30);



		JLabel label = new JLabel("�ȳ��ϼ��� �α��� �������Դϴ�.");
		label.setSize(300, 200);
		label.setLocation(200, 100);

		JButton login = new JButton("�α���");
		login.setSize(100, 50);
		login.setLocation(200, 400);
		login.addMouseListener(new Login());

		JButton signUp = new JButton("ȸ������");
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
			ChangePanel.changePanel(mf, yaMoYeoLogin, new SignPanel(mf));

		}
	}

	class Login extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			try {
				String s;
				String[] array;
				BufferedReader br = new BufferedReader(new FileReader("ȸ�����.txt"));
				try {
					while((s=br.readLine())!=null) {
						array=s.split("/");
						
						if(idTxt.getText().equals(array[1]) && String.valueOf(pwdTxt.getPassword()).equals(array[2]))
						{
							JOptionPane.showMessageDialog(null, "�α��� ����");
							ChangePanel.changePanel(mf, yaMoYeoLogin, new YaMoYeoEnter(mf));
						}
						else {
							JOptionPane.showMessageDialog(null, "���̵� ��й�ȣ�� Ʋ�Ƚ��ϴ�");
							br.close();
						}
					}
				} catch (HeadlessException | IOException e1) {
					e1.printStackTrace();
				}

			} 

			catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}
}