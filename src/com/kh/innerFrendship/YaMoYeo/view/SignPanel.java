package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.innerFrendship.YaMoYeo.model.vo.User;

public class SignPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5592443955694293436L;
	private JFrame mf;
	private JPanel panel;
	private JTextField txtPwd;
	private JTextField txtPwdTF;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtArea;
	private JTextField txtMajor;
	private JTextField txtEmail;
	private JLabel lblPwdWrong;
	private JLabel lblPwdCorrect;
	private boolean isOkToSignUp;
	private boolean passwordCheck;
	public static int userCount;
	private ArrayList userList;
	
	public SignPanel(JFrame mf) {
		this.mf = mf;
		this.panel = this;
		
		Font font = new Font("돋움", Font.BOLD, 14);
		
		setUserCount();
		userList = readUser();
		
		this.setSize(600, 600);
		this.setBackground(new Color(234, 208, 184));
		this.setLayout(null);
		
		JLabel lbltitle = new JLabel("회원가입");
		lbltitle.setFont(new Font("돋움", Font.BOLD, 36));
		lbltitle.setSize(200, 42);
		lbltitle.setLocation(220, 20);
		
		JLabel underLine = new JLabel();
		underLine.setBackground(Color.BLACK);
		underLine.setOpaque(true);
		underLine.setLocation(220, 62);
		underLine.setSize(150, 3);
		
		Image id = new ImageIcon("images/id.PNG").getImage();
		JLabel lblId = new JLabel(new ImageIcon(id));
		lblId.setBounds(30, 70, 56, 56);
		lblId.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JLabel idLbl = new JLabel("아이디");
				idLbl.setSize(56, 56);
				idLbl.setLocation(30, 70);
				idLbl.setFont(font);
				panel.remove(lblId);
				panel.add(idLbl);
				panel.repaint();
			}
		});
		
		txtId = new JTextField(20);
		txtId.setText("아이디를 입력하세요");
		txtId.addMouseListener(new Clear());
		txtId.setBounds(110, 80, 400, 40);
		
		Image password = new ImageIcon("images/lock.jpg").getImage().getScaledInstance(56, 56, 0);
		JLabel lblPwd = new JLabel(new ImageIcon(password));
		lblPwd.setBounds(30, 130, 56, 56);
		lblPwd.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JLabel pwdLbl = new JLabel("패스워드");
				pwdLbl.setSize(66, 56);
				pwdLbl.setLocation(30, 130);
				pwdLbl.setFont(font);
				panel.remove(lblPwd);
				panel.add(pwdLbl);
				panel.repaint();
			}
		});
		
		txtPwd = new JTextField(20);
		txtPwd.setText("비밀번호를 입력하세요");
		txtPwd.addMouseListener(new Clear());
		txtPwd.setBounds(110, 140, 400, 40);
		
		Image passwordIsCorrect = new ImageIcon("images/passwordIsCorrect.png").getImage().getScaledInstance(52, 52, 0);
		JLabel lblPwdIsCorrect = new JLabel(new ImageIcon(passwordIsCorrect));
		lblPwdIsCorrect.setBounds(30, 195, 56, 56);
		lblPwdIsCorrect.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JLabel pwdIsCorrectLbl1 = new JLabel("비밀번호");
				pwdIsCorrectLbl1.setSize(66, 56);
				pwdIsCorrectLbl1.setLocation(30, 175);
				pwdIsCorrectLbl1.setFont(font);
				JLabel pwdIsCorrectLbl2 = new JLabel("확인");
				pwdIsCorrectLbl2.setSize(66, 56);
				pwdIsCorrectLbl2.setLocation(42, 201);
				pwdIsCorrectLbl2.setFont(font);
				panel.remove(lblPwdIsCorrect);
				panel.add(pwdIsCorrectLbl1);
				panel.add(pwdIsCorrectLbl2);
				panel.repaint();
			}
		});
		
		Image passwordWrong = new ImageIcon("images/wrong.PNG").getImage().getScaledInstance(30, 30, 0);
		lblPwdWrong = new JLabel(new ImageIcon(passwordWrong));
		lblPwdWrong.setBounds(535, 205, 30, 30);
		add(lblPwdWrong);
		
		Image passwordCorrect = new ImageIcon("images/OK.PNG").getImage().getScaledInstance(30, 30, 0);
		lblPwdCorrect = new JLabel(new ImageIcon(passwordCorrect));
	
		txtPwdTF = new JTextField(20);
		txtPwdTF.setText("비밀번호 한번 더 입력하세요");
		txtPwdTF.addMouseListener(new Clear());
		txtPwdTF.setBounds(110, 200, 400, 40);
		
//		패스워드 확인작업
		txtPwdTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtPwd.getText().equals(txtPwdTF.getText())) {
					passwordCheck = true;
					panel.add(lblPwdCorrect);
					lblPwdCorrect.setBounds(535, 205, 30, 30);
					panel.remove(lblPwdWrong);
					panel.repaint();
				} else {
					passwordCheck = false;
					panel.add(lblPwdWrong);
					lblPwdWrong.setBounds(535, 205, 30, 30);
					panel.remove(lblPwdCorrect);
					panel.repaint();
				}
			}
		});
		
		Image name = new ImageIcon("images/name.PNG").getImage();
		JLabel lblName = new JLabel(new ImageIcon(name));
		lblName.setBounds(30, 250, 56, 56);
		lblName.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JLabel nameLbl = new JLabel("이름");
				nameLbl.setSize(66, 56);
				nameLbl.setLocation(30, 250);
				nameLbl.setFont(font);
				panel.remove(lblName);
				panel.add(nameLbl);
				panel.repaint();
			}
		});
		
		txtName = new JTextField(20);
		txtName.setText("이름을 입력하세요");
		txtName.addMouseListener(new Clear());
		txtName.setBounds(110, 260, 400, 40);
		
		Image email = new ImageIcon("images/mail.jpg").getImage().getScaledInstance(52, 48, 0);
		JLabel lblEmail = new JLabel(new ImageIcon(email));
		lblEmail.setBounds(30, 310, 56, 56);
		lblEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JLabel emailLbl = new JLabel("이메일");
				emailLbl.setSize(66, 56);
				emailLbl.setLocation(30, 310);
				emailLbl.setFont(font);
				panel.remove(lblEmail);
				panel.add(emailLbl);
				panel.repaint();
			}
		});
		
		txtEmail = new JTextField();
		txtEmail.setText("이메일을 입력하세요");
		txtEmail.addMouseListener(new Clear());
		txtEmail.setBounds(110, 320, 400, 40);
		
		Image area = new ImageIcon("images/local.jpg").getImage().getScaledInstance(56, 56, 0);
		JLabel lblArea = new JLabel(new ImageIcon(area));
		lblArea.setBounds(27, 370, 56, 56);
		lblArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JLabel areaLbl = new JLabel("지역");
				areaLbl.setSize(66, 56);
				areaLbl.setLocation(30, 370);
				areaLbl.setFont(font);
				panel.remove(lblArea);
				panel.add(areaLbl);
				panel.repaint();
			}
		});
		
		txtArea = new JTextField();
		txtArea.setText("지역을 입력하세요");
		txtArea.addMouseListener(new Clear());
		txtArea.setBounds(110, 380, 400, 40);
		
		Image major = new ImageIcon("images/major.png").getImage();
		JLabel lblMajor = new JLabel(new ImageIcon(major));
		lblMajor.setBounds(28, 430, 56, 56);
		lblMajor.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JLabel majorLbl = new JLabel("관심분야");
				majorLbl.setSize(66, 56);
				majorLbl.setLocation(30, 430);
				majorLbl.setFont(font);
				panel.remove(lblMajor);
				panel.add(majorLbl);
				panel.repaint();
			}
		});
		
		txtMajor = new JTextField();
		txtMajor.setText("전공을 입력하세요");
		txtMajor.addMouseListener(new Clear());
		txtMajor.setBounds(110, 440, 400, 40);

		Image back = new ImageIcon("images/back.png").getImage().getScaledInstance(40, 40, 0);
		JLabel btnBack = new JLabel(new ImageIcon(back));
		btnBack.addMouseListener(new MyMouseAdapter());
		btnBack.setBounds(0, 20, 40, 40);
		
		Image signUp = new ImageIcon("images/signup.PNG").getImage();
		JButton btnSubmit = new JButton(new ImageIcon(signUp));
		btnSubmit.setBounds(150, 500, 300, 40);
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				String password = txtPwd.getText();
				String passwordChk = txtPwdTF.getText();
				String name = txtName.getText();
				String area = txtArea.getText();
				String major = txtMajor.getText();
				String email = txtEmail.getText();
				
				if((!id.equals("")) && (!password.equals("")) && (!passwordChk.equals(""))
						&& (!name.equals("")) && (!area.equals(""))
						&& (!major.equals("")) && (!email.equals(""))
						&& (passwordCheck == true)) {
					isOkToSignUp = true;
				}
				
				if(isOkToSignUp == true) {
					JOptionPane.showMessageDialog(panel, "회원가입이 완료되었습니다!", "환영합니다", JOptionPane.INFORMATION_MESSAGE);
					User user = new User(id, password, name, email, area, major, userCount);
					signUp(user);
					userCount++;
					
					DataOutputStream dos = null;
					try {
						dos = new DataOutputStream(new FileOutputStream("userCount.txt"));
						
						dos.writeInt(userCount);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						try {
							dos.flush();
							dos.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					
					ChangePanel.changePanel(mf, panel, new YaMoYeoLogin(mf));
				} else if (isOkToSignUp == false){
					JOptionPane.showMessageDialog(panel, "일부 항목을 작성하지 않았거나 패스워드 확인에 실패했습니다", "", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		add(lblId);
		add(lblPwd);
		add(lblPwdIsCorrect);
		add(lblName);
		add(lblEmail);
		add(lblArea);
		add(lbltitle);
		add(lblMajor);
		add(underLine);

		add(txtId);
		add(txtPwd);
		add(txtPwdTF);
		add(txtName);
		add(txtEmail);
		add(txtArea);
		add(txtMajor);

		add(btnSubmit);
		add(btnBack);

		setSize(600, 600);
		setVisible(true);
		
		mf.add(this);
	}
	
	class Clear extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			((JTextField) e.getComponent()).setText("");
		}
	}
	
	class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			ChangePanel.changePanel(mf, panel, new YaMoYeoLogin(mf));
		}
	}
	
	public void signUp(User user) {
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("userList.txt", true));
			oos.writeObject(user);
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
	
	public void setUserCount() {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream("userCount.txt"));
			
			userCount = dis.readInt();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dis != null) {
					dis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList readUser() {
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
}