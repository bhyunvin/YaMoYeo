package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.innerFrendship.YaMoYeo.model.vo.User;

public class YaMoYeoLogin extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private JTextField txtId;
	private JPasswordField txtPassword;
	private ArrayList<User> userList;

	public YaMoYeoLogin(JFrame mf) {
		this.mf = mf;
		this.panel = this;

		this.setSize(600, 600);
		this.setBackground(new Color(234, 208, 184));
		this.setLayout(null);

		JLabel id = new JLabel("ID");
		JLabel pwd = new JLabel("비밀번호");

		id.setBounds(200, 280, 100, 30);
		pwd.setBounds(200, 320, 100, 30);

		txtId = new JTextField();
		txtPassword = new JPasswordField();

		txtId.setBounds(260, 280, 100, 30);
		txtPassword.setBounds(260, 320, 100, 30);

		Image welcome = new ImageIcon("images/YaMoYeo.PNG").getImage().getScaledInstance(300, 100, 0);
		JLabel label = new JLabel(new ImageIcon(welcome));
		label.setSize(300, 100);
		label.setLocation(150, 100);

		JButton login = new JButton("로그인");
		login.setSize(100, 50);
		login.setLocation(200, 400);
		login.addMouseListener(new Login());

		JButton signUp = new JButton("회원가입");
		signUp.setSize(100, 50);
		signUp.setLocation(300, 400);
		signUp.addMouseListener(new SignPanelAdapter());

		this.add(txtId);
		this.add(txtPassword);
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
			String id = "";
			String password = "";
			String inputId = "";
			String inputPassword = "";
			ObjectInputStream ois = null;
			boolean isOkToEnter = false;
			
			try {
				ois = new ObjectInputStream(new FileInputStream("userList.txt"));
				userList = (ArrayList<User>)ois.readObject();
				inputId = txtId.getText();
				inputPassword = String.valueOf(txtPassword.getPassword());
				
				for(int i = 0; i < userList.size(); i++) {
					id = userList.get(i).getId();
					password = userList.get(i).getPassword();
					
					if(!(id.equals(inputId) && password.equals(inputPassword))) {
						isOkToEnter = false;
					} else {
						isOkToEnter = true;
						break;
					}
				}
				
				if(isOkToEnter == true) {
					JOptionPane.showMessageDialog(panel, "로그인에 성공했습니다", "로그인 성공", JOptionPane.PLAIN_MESSAGE);
					ChangePanel.changePanel(mf, panel, new YaMoYeoEnter(mf));
				} else {
					JOptionPane.showMessageDialog(panel, "로그인에 실패했습니다", "로그인 실패", JOptionPane.ERROR_MESSAGE);
				}
				
			} catch (FileNotFoundException fnfe) {
				JOptionPane.showMessageDialog(panel, "user.txt파일이 존재하지 않습니다. 개발진에게 문의해주세요.", "에러", JOptionPane.ERROR_MESSAGE);
			} catch (IOException ioe) {
				JOptionPane.showMessageDialog(panel, "입출력 예외가 발생했습니다. 개발진에게 문의해주세요.", "에러", JOptionPane.ERROR_MESSAGE);
			} catch (ClassNotFoundException cnfe) {
				JOptionPane.showMessageDialog(panel, "ClassNotFound 예외가 발생했습니다. 개발진에게 문의해주세요.", "에러", JOptionPane.ERROR_MESSAGE);
			} finally {
				try {
					ois.close();
				} catch (IOException ioe) {
					JOptionPane.showMessageDialog(panel, "입출력 예외가 발생했습니다. 개발진에게 문의해주세요.", "에러", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}