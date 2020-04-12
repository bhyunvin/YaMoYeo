package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindMembersPopUp extends JPanel {

	public FindMembersPopUp(JFrame mf) {
		
		this.setLayout(null);
		this.setSize(600, 600);
		this.setBackground(new Color(224, 224, 224));
		
		Image img1 = new ImageIcon("images/email.PNG").getImage().getScaledInstance(50, 50, 0);
		JLabel email = new JLabel(new ImageIcon(img1));
		email.setSize(50, 50);
		email.setLocation(50, 50);
		
		//클릭하면 이 텍스트가 사라지고 입력받을 수 있어야 함. 이벤트 써야 할 것 같다.
		JTextField emailtf = new JTextField(" 사용하셨던 e-mail 주소를 입력해주세요");
		emailtf.setSize(350, 40);
		emailtf.setLocation(130, 55);
		
		Image input = new ImageIcon("images/inputButton.PNG").getImage().getScaledInstance(200, 40, 0);
		JButton button1 = new JButton(new ImageIcon(input));
		button1.setSize(200, 40);
		button1.setLocation(150, 110);
			
		
		
		Image img2 = new ImageIcon("images/id.PNG").getImage().getScaledInstance(60, 60, 0);
		JLabel id = new JLabel(new ImageIcon(img2));
		id.setSize(60, 60);
		id.setLocation(48, 180);
		
		JTextField idtf = new JTextField(" ID입니다");
		idtf.setSize(350, 40);
		idtf.setLocation(130, 190);
		
		
		
		Image img3 = new ImageIcon("images/lock.PNG").getImage().getScaledInstance(60, 60, 0);
		JLabel lock = new JLabel(new ImageIcon(img3));
		lock.setSize(60, 60);
		lock.setLocation(48, 250);
		
		JTextField pwtf = new JTextField(" 비밀번호입니다");
		pwtf.setSize(350, 40);
		pwtf.setLocation(130, 260);
		
		
		Image check = new ImageIcon("images/checkButton.PNG").getImage().getScaledInstance(200, 40, 0);
		JButton button2 = new JButton(new ImageIcon(check));
		button2.setSize(200, 40);
		button2.setLocation(150, 315);
		
		
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
	
	
	
}
