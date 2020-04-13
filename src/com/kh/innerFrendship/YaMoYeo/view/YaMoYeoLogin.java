package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Font;
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

		Image idImage = new ImageIcon("images/id.PNG").getImage().getScaledInstance(40, 40, 0);
		JLabel id = new JLabel(new ImageIcon(idImage));
		id.setBounds(120, 260, 40, 40);
		
		Image passwordImage = new ImageIcon("images/lock.PNG").getImage().getScaledInstance(40, 40, 0);
		JLabel pwd = new JLabel(new ImageIcon(passwordImage));
		pwd.setBounds(120, 310, 40, 40);

		txtId = new JTextField();
		txtPassword = new JPasswordField();

		txtId.setBounds(170, 260, 280, 40);
		txtPassword.setBounds(170, 310, 280, 40);

		Image welcome = new ImageIcon("images/YaMoYeo.PNG").getImage().getScaledInstance(300, 100, 0);
		JLabel label = new JLabel(new ImageIcon(welcome));
		label.setSize(300, 100);
		label.setLocation(150, 100);
		
		Image loginButton = new ImageIcon("images/login.PNG").getImage();
		JButton login = new JButton(new ImageIcon(loginButton));
		login.setSize(260, 40);
		login.setLocation(160, 370);
		login.addMouseListener(new Login());

		JLabel signUp = new JLabel();
		signUp.setText("아직 야모여 회원이 아니라면?");
		signUp.setSize(200, 20);
		signUp.setLocation(145, 450);
		
		JLabel signUpButton = new JLabel();
		signUpButton.setText("회원가입");
		signUpButton.setSize(60, 20);
		signUpButton.setLocation(340, 450);
		signUpButton.setForeground(Color.BLUE);
		signUpButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new SignPanel(mf));
			}
		});
		
		JLabel findUser = new JLabel();
		findUser.setText("ID/PW를 잊으셨다면?");
		findUser.setSize(150, 20);
		findUser.setLocation(195, 480);
		
		JLabel findUserButton = new JLabel();
		findUserButton.setText("회원찾기");
		findUserButton.setSize(60, 20);
		findUserButton.setLocation(340, 480);
		findUserButton.setForeground(Color.BLUE);
		findUserButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new FindMembersPopUp(mf));
			}
		});

		this.add(txtId);
		this.add(txtPassword);
		this.add(pwd);
		this.add(id);
		this.add(label);
		this.add(login);
		this.add(signUp);
		this.add(findUser);
		this.add(findUserButton);
		this.add(signUp);
		this.add(signUpButton);
		
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