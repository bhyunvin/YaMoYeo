package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

import com.kh.innerFrendship.YaMoYeo.model.vo.StudyRoom;
import com.kh.innerFrendship.YaMoYeo.model.vo.User;

public class YaMoYeoLogin extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4889478794334192789L;
	private JFrame mf;
	private JPanel panel;
	private JTextField txtId;
	private JPasswordField txtPassword;
	private YaMoYeoEnter enter = new YaMoYeoEnter();
	private StudyRoomOpen sro = new StudyRoomOpen();
	private ArrayList userList;
	private ArrayList roomList;
	public static int myNumber;

	public YaMoYeoLogin(JFrame mf) {
		this.mf = mf;
		this.panel = this;
		this.setSize(600, 600);
		this.setBackground(new Color(234, 208, 184));
		this.setLayout(null);
		
		userList = readFile();
		
		Image idImage = new ImageIcon("images/id.PNG").getImage().getScaledInstance(40, 40, 0);
		JLabel id = new JLabel(new ImageIcon(idImage));
		id.setBounds(120, 260, 40, 40);

		Image passwordImage = new ImageIcon("images/lock.PNG").getImage().getScaledInstance(40, 40, 0);
		JLabel pwd = new JLabel(new ImageIcon(passwordImage));
		pwd.setBounds(120, 310, 40, 40);

		txtId = new JTextField();
		txtId.setBounds(170, 260, 280, 40);
		txtId.addMouseListener(new Clear());

		txtPassword = new JPasswordField();
		txtPassword.setBounds(170, 310, 280, 40);
		txtPassword.addMouseListener(new Clear());

		Image welcome = new ImageIcon("images/YaMoYeo.PNG").getImage().getScaledInstance(300, 100, 0);
		JLabel label = new JLabel(new ImageIcon(welcome));
		label.setSize(300, 100);
		label.setLocation(150, 100);

		Image loginButton = new ImageIcon("images/login.PNG").getImage();
		JButton login = new JButton(new ImageIcon(loginButton));
		login.setSize(260, 40);
		login.setLocation(180, 370);
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
			String inputId = txtId.getText();
			String inputPwd = String.valueOf(txtPassword.getPassword());
			String id = "";
			String password = "";
			int num = 0;
			boolean isOkToLogin = false;
			
			if(userList == null) {
				JOptionPane.showMessageDialog(panel, "회원이 없습니다. 처음으로 가입해보세요!", "오류", JOptionPane.ERROR_MESSAGE);
				ChangePanel.changePanel(mf, panel, new YaMoYeoLogin(mf));
			} else {
				for(int i = 0; i < userList.size(); i++) {
					id = ((User) userList.get(i)).getId();
					password = ((User) userList.get(i)).getPassword();

					if(inputId.equals(id) && inputPwd.equals(password)) {
						isOkToLogin = true;
						num = ((User) userList.get(i)).getUserNumber();
						break;
					} else {
						isOkToLogin = false;
					}
				}
			}
			
			roomList = readRoom();
			
			if(isOkToLogin == true && roomList == null) {
				JOptionPane.showMessageDialog(panel, "방이 한개도 없습니다. 처음으로 방을 만들어보세요!", "오류", JOptionPane.ERROR_MESSAGE);
				sro.getMyNumber(num);
				enter.getMyNumber(num);
				ChangePanel.changePanel(mf, panel, new StudyRoomOpen(mf));
			} else if(isOkToLogin == true) {
				JOptionPane.showMessageDialog(panel, "로그인에 성공했습니다", "로그인 성공", JOptionPane.PLAIN_MESSAGE);
				enter.getMyNumber(num);
				ChangePanel.changePanel(mf, panel, new YaMoYeoEnter(mf));
			} else {
				JOptionPane.showMessageDialog(panel, "로그인에 실패했습니다", "로그인 실패", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	class Clear extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			((JTextField) e.getComponent()).setText("");
		}
	}
	
	public ArrayList readFile() {
		ArrayList list = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("userList.txt");
			list = new ArrayList();
			while(true){
				ObjectInputStream ois = new ObjectInputStream(fis);
				User user = (User) ois.readObject();
				list.add(user);
			}
		} catch (EOFException e) {
			return list;
		} catch (FileNotFoundException fnfe) {
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return list;
	}
	
	public ArrayList readRoom() {
		ArrayList list = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("roomList.txt");
			list = new ArrayList();
			while(true){
				ObjectInputStream ois = new ObjectInputStream(fis);
				StudyRoom studyRoom = (StudyRoom) ois.readObject();
				list.add(studyRoom);
			}
		} catch (EOFException e) {
			return list;
		} catch (FileNotFoundException fnfe) {
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return list;
	}
}
