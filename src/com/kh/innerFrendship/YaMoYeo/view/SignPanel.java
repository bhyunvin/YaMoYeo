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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.innerFrendship.YaMoYeo.model.vo.User;

public class SignPanel extends JPanel {
	private JFrame mf;
	private JPanel signPanel;
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
	List<User> userList = new ArrayList<User>();

	public SignPanel(JFrame mf) {
		this.mf = mf;
		this.signPanel = this;

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
		
		txtId = new JTextField(20);
		txtId.setText("아이디를 입력하세요");
		txtId.addMouseListener(new Clear());
		txtId.setBounds(110, 80, 400, 40);
		
		Image password = new ImageIcon("images/lock.jpg").getImage().getScaledInstance(56, 56, 0);
		JLabel lblPwd = new JLabel(new ImageIcon(password));
		lblPwd.setBounds(30, 130, 56, 56);
		
		txtPwd = new JTextField(20);
		txtPwd.setText("비밀번호를 입력하세요");
		txtPwd.addMouseListener(new Clear());
		txtPwd.setBounds(110, 140, 400, 40);
		
		Image passwordIsCorrect = new ImageIcon("images/passwordIsCorrect.png").getImage().getScaledInstance(52, 52, 0);
		JLabel lblPwdIsCorrect = new JLabel(new ImageIcon(passwordIsCorrect));
		lblPwdIsCorrect.setBounds(30, 195, 56, 56);
		
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
					signPanel.add(lblPwdCorrect);
					lblPwdCorrect.setBounds(535, 205, 30, 30);
					signPanel.remove(lblPwdWrong);
				} else {
					passwordCheck = false;
					signPanel.add(lblPwdWrong);
					lblPwdWrong.setBounds(535, 205, 30, 30);
					signPanel.remove(lblPwdCorrect);
				}
			}
		});
		
		Image name = new ImageIcon("images/name.PNG").getImage();
		JLabel lblName = new JLabel(new ImageIcon(name));
		lblName.setBounds(30, 250, 56, 56);
		
		txtName = new JTextField(20);
		txtName.setText("이름을 입력하세요");
		txtName.addMouseListener(new Clear());
		txtName.setBounds(110, 260, 400, 40);
		
		Image email = new ImageIcon("images/mail.jpg").getImage().getScaledInstance(52, 48, 0);
		JLabel lblEmail = new JLabel(new ImageIcon(email));
		lblEmail.setBounds(30, 310, 56, 56);
		
		txtEmail = new JTextField();
		txtEmail.setText("이메일을 입력하세요");
		txtEmail.addMouseListener(new Clear());
		txtEmail.setBounds(110, 320, 400, 40);
		
		Image area = new ImageIcon("images/local.jpg").getImage().getScaledInstance(56, 56, 0);
		JLabel lblArea = new JLabel(new ImageIcon(area));
		lblArea.setBounds(27, 370, 56, 56);
		
		txtArea = new JTextField();
		txtArea.setText("지역을 입력하세요");
		txtArea.addMouseListener(new Clear());
		txtArea.setBounds(110, 380, 400, 40);
		
		Image major = new ImageIcon("images/major.png").getImage();
		JLabel lblMajor = new JLabel(new ImageIcon(major));
		lblMajor.setBounds(28, 430, 56, 56);
		
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
				if((txtPwd.getText() != null) && (txtPwdTF.getText() != null) && (txtId.getText() != null) && (txtName.getText() != null)
					&& (txtArea.getText() != null) && (txtMajor.getText() != null) && (txtEmail.getText() != null) && (passwordCheck == true)) {
					isOkToSignUp = true;
				}
				
				if(isOkToSignUp == true) {
					JOptionPane.showMessageDialog(signPanel, "회원가입이 완료되었습니다!", "환영합니다", JOptionPane.INFORMATION_MESSAGE);
					signUp();
				} else {
					JOptionPane.showMessageDialog(signPanel, "일부 항목을 작성하지 않았거나 패스워드 확인에 실패했습니다", "", JOptionPane.ERROR_MESSAGE);
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
			ChangePanel.changePanel(mf, signPanel, new YaMoYeoLogin(mf));
		}
	}
	
//	회원가입
	public void signUp() {
		userList.add(new User(txtId.getText(), txtPwd.getText(), txtName.getText(), txtEmail.getText(), txtArea.getText(), txtMajor.getText()));
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("userList.txt"));
			for(int i = 0; i < userList.size(); i++) {
				oos.writeObject(userList);
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(signPanel, "user.txt파일이 존재하지 않습니다. 개발진에게 문의해주세요.", "에러", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(signPanel, "입출력 예외가 발생했습니다. 개발진에게 문의해주세요.", "에러", JOptionPane.ERROR_MESSAGE);
		} finally {
			try {
				oos.flush();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}