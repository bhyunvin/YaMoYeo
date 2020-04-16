package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.innerFrendship.YaMoYeo.model.vo.User;

public class FindMembersPopUp extends JPanel {
	private JTextField idtf;
	private JTextField pwtf;
	private JFrame mf;
	private JPanel panel;
	private ArrayList<User> userList;
	
	public FindMembersPopUp(JFrame mf) {
		this.mf = mf;
		this.panel = this;
		
		userList = readUser();
		
		this.setLayout(null);
		this.setSize(600, 600);
		this.setBackground(new Color(224, 224, 224));
		
		Image img1 = new ImageIcon("images/email.PNG").getImage().getScaledInstance(50, 50, 0);
		JLabel email = new JLabel(new ImageIcon(img1));
		email.setSize(50, 50);
		email.setLocation(75, 90);
		
		JTextField emailtf = new JTextField(" 사용하셨던 e-mail 주소를 입력해주세요");
		emailtf.setSize(350, 40);
		emailtf.setLocation(155, 95);
		emailtf.addMouseListener(new Clear());
		
		Image input = new ImageIcon("images/inputButton.PNG").getImage().getScaledInstance(200, 40, 0);
		JButton button1 = new JButton(new ImageIcon(input));
		button1.setSize(200, 40);
		button1.setLocation(205, 160);
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String inputEmail = emailtf.getText();
				String userEmail = "";
				
				for(int i = 0; i < userList.size(); i++) {
					userEmail = userList.get(i).getEmail();
					if(inputEmail.equals(userEmail)) {
						idtf.setText(userList.get(i).getId());
						pwtf.setText(userList.get(i).getPassword());
						break;
					} else {
						idtf.setText("유저가 없습니다");
						pwtf.setText("유저가 없습니다");
					}
				}
			}
		});
		
		Image img2 = new ImageIcon("images/id.PNG").getImage().getScaledInstance(60, 60, 0);
		JLabel id = new JLabel(new ImageIcon(img2));
		id.setSize(60, 60);
		id.setLocation(73, 230);
		
		idtf = new JTextField(" ID입니다");
		idtf.setSize(350, 40);
		idtf.setLocation(155, 240);
		idtf.setEditable(false);
		
		Image img3 = new ImageIcon("images/lock.PNG").getImage().getScaledInstance(60, 60, 0);
		JLabel lock = new JLabel(new ImageIcon(img3));
		lock.setSize(60, 60);
		lock.setLocation(73, 300);
		
		pwtf = new JTextField(" 비밀번호입니다");
		pwtf.setSize(350, 40);
		pwtf.setLocation(155, 310);
		pwtf.setEditable(false);
		
		Image check = new ImageIcon("images/checkButton.PNG").getImage().getScaledInstance(200, 40, 0);
		JButton button2 = new JButton(new ImageIcon(check));
		button2.setSize(200, 40);
		button2.setLocation(205, 380);
		button2.addMouseListener(new Click());
		
		this.add(button2);
		this.add(pwtf);
		this.add(lock);
		this.add(idtf);
		this.add(id);
		this.add(button1);
		this.add(emailtf);
		this.add(email);
		mf.add(this);
	}
	
	class Clear extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			((JTextField) e.getComponent()).setText("");
			idtf.setText("");
			pwtf.setText("");
		}
	}
	
	class Click extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			ChangePanel.changePanel(mf, panel, new YaMoYeoLogin(mf));
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
