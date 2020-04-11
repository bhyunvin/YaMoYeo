package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignPanel extends JPanel {
	private JFrame mf;
	private JPanel SignPanel;
	private JTextField txtId;
	private JTextField txtPwd;
	private JTextField txtPwdTF;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtArea;

	public SignPanel(JFrame mf) {
		this.mf = mf;
		this.SignPanel = this;

		this.setSize(600, 600);
		this.setBackground(new Color(234, 208, 184));
		this.setLayout(null);

		JLabel lblId = new JLabel("아이디");
		JLabel lblPwd = new JLabel("비밀번호");
		JLabel lblPwdRight = new JLabel("비밀번호확인");
		JLabel lblName = new JLabel("이름");
		JLabel lblEmail = new JLabel("이메일");
		JLabel lblArea = new JLabel("거주지");

		lblId.setBounds(150, 50, 100, 20);
		lblPwd.setBounds(150, 80, 100, 20);
		lblPwdRight.setBounds(150, 110, 100, 20);
		lblName.setBounds(150, 140, 100, 20);
		lblEmail.setBounds(150, 170, 100, 20);
		lblArea.setBounds(150, 200, 100, 20);

		add(lblId);
		add(lblPwd);
		add(lblPwdRight);
		add(lblName);
		add(lblEmail);
		add(lblArea);

		txtId = new JTextField(20);
		txtId.setText("아이디를 입력하세요");
		txtId.addMouseListener(new IdClear());

		txtPwd = new JTextField(20);
		txtPwd.setText("비밀번호를 입력하세요");
		txtPwd.addMouseListener(new PwdClear());

		txtPwdTF = new JTextField(20);
		txtPwdTF.setText("비밀번호 한번 더 입력하세요");
		txtPwdTF.addMouseListener(new PwdTFClear());

		txtName = new JTextField(20);
		txtName.setText("이름을 입력하세요");
		txtName.addMouseListener(new NameClear());

		txtEmail = new JTextField();
		txtEmail.setText("이메일을 입력하세요");
		txtEmail.addMouseListener(new EmailClear());

		txtArea = new JTextField();
		txtArea.setText("지역을 입력하세요");
		txtArea.addMouseListener(new AreaClear());

		JButton btnCancel = new JButton("메인으로");
		JButton btnSubmit = new JButton("가입완료");
		btnSubmit.addActionListener(new SignUpComplete());

		btnCancel.addMouseListener(new MyMouseAdapter());

		txtId.setBounds(230, 50, 160, 20);
		txtPwd.setBounds(230, 80, 160, 20);
		txtPwdTF.setBounds(230, 110, 160, 20);
		txtName.setBounds(230, 140, 160, 20);
		txtEmail.setBounds(230, 170, 160, 20);
		txtArea.setBounds(230, 200, 160, 20);

		btnSubmit.setBounds(250, 300, 100, 100);
		btnCancel.setBounds(0, 0, 100, 100);
		File temp = new File("test.txt");

		System.out.println(temp.getAbsolutePath()); // 절대주소값 구함.

		add(txtId);
		add(txtPwd);
		add(txtPwdTF);
		add(txtName);
		add(txtEmail);
		add(txtArea);

		add(btnSubmit);
		add(btnCancel);

		setSize(600, 800);
		setVisible(true);

		mf.add(this);
	}

	class IdClear extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			txtId.setText("");
		}
	}

	class PwdClear extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			txtPwd.setText("");
		}
	}

	class PwdTFClear extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			txtPwdTF.setText("");
		}
	}

	class NameClear extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			txtName.setText("");
		}
	}

	class EmailClear extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			txtEmail.setText("");
		}
	}

	class AreaClear extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			txtArea.setText("");
		}
	}

	class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			ChangePanel.changePanel(mf, SignPanel, new YaMoYeoLogin(mf));
		}
	}

	class SignUpComplete implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("회원명단.txt", true));
				bw.write(txtId.getText() + "/");
				bw.write(txtPwd.getText() + "/");
				bw.write(txtName.getText() + "/");
				bw.write(txtEmail.getText() + "/");
				bw.write(txtArea.getText() + "/");
				bw.close();
				JOptionPane.showMessageDialog(null, "회원가입성공");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "회원가입실패");
			}
		}
	}
}