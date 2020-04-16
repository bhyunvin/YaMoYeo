package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.innerFrendship.YaMoYeo.model.vo.User;

public class MyInfo extends JPanel {
	private JFrame mf;
	private JPanel panel;
	public static int myNumber;
	private ArrayList<User> userList;
	
	public MyInfo() {}

	public MyInfo(JFrame mf) {
		this.mf = mf;
		this.panel = this;
		
		userList = readUser();
		
		User user = userList.get(myNumber);
		
		Font f = new Font("돋움", Font.BOLD, 20);

		this.setSize(600, 600);
		this.setBackground(new Color(234, 208, 184));
		this.setLayout(null);

		Image back = new ImageIcon("images/back.PNG").getImage().getScaledInstance(56, 56, 0);
		JLabel backBtn = new JLabel(new ImageIcon(back));
		backBtn.setSize(56, 56);
		backBtn.setLocation(5, 10);
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new YaMoYeoEnter(mf));
			}
		});

		JLabel title = new JLabel("내 정보");
		title.setSize(190, 42);
		title.setLocation(250, 15);
		title.setFont(new Font("돋움", Font.BOLD, 28));

		JLabel underLine = new JLabel();
		underLine.setBackground(Color.BLACK);
		underLine.setSize(120, 3);
		underLine.setLocation(240, 55);
		underLine.setOpaque(true);

		Image id = new ImageIcon("images/id.PNG").getImage().getScaledInstance(56, 56, 0);
		JLabel idIcon = new JLabel(new ImageIcon(id));
		idIcon.setSize(56, 56);
		idIcon.setLocation(30, 90);

		TextField idtf = new TextField(user.getId());
		idtf.setSize(400, 45);
		idtf.setLocation(110, 95);
		idtf.setEditable(false);
		idtf.setFont(f);

		Image password = new ImageIcon("images/lock.PNG").getImage().getScaledInstance(53, 57, 0);
		JLabel pwIcon = new JLabel(new ImageIcon(password));
		pwIcon.setSize(53, 57);
		pwIcon.setLocation(30, 165);

		TextField pwtf = new TextField(user.getPassword());
		pwtf.setSize(400, 45);
		pwtf.setLocation(110, 170);
		pwtf.setEditable(false);
		pwtf.setFont(f);

		Image name = new ImageIcon("images/name.PNG").getImage().getScaledInstance(63, 63, 0);
		JLabel nameIcon = new JLabel(new ImageIcon(name));
		nameIcon.setSize(58, 57);
		nameIcon.setLocation(30, 245);

		TextField nametf = new TextField(user.getName());
		nametf.setSize(400, 45);
		nametf.setLocation(110, 250);
		nametf.setEditable(false);
		nametf.setFont(f);

		Image email = new ImageIcon("images/email.PNG").getImage().getScaledInstance(52, 52, 0);
		JLabel emailIcon = new JLabel(new ImageIcon(email));
		emailIcon.setSize(53, 53);
		emailIcon.setLocation(31, 315);

		TextField emailtf = new TextField(user.getEmail());
		emailtf.setSize(400, 45);
		emailtf.setLocation(110, 320);
		emailtf.setEditable(false);
		emailtf.setFont(f);

		Image area = new ImageIcon("images/local.PNG").getImage().getScaledInstance(56, 56, 0);
		JLabel areaIcon = new JLabel(new ImageIcon(area));
		areaIcon.setSize(56, 56);
		areaIcon.setLocation(27, 380);

		TextField areatf = new TextField(user.getArea());
		areatf.setSize(400, 45);
		areatf.setLocation(110, 385);
		areatf.setEditable(false);
		areatf.setFont(f);

		Image major = new ImageIcon("images/major.png").getImage().getScaledInstance(56, 56, 0);
		JLabel majorIcon = new JLabel(new ImageIcon(major));
		majorIcon.setSize(56, 56);
		majorIcon.setLocation(27, 455);

		TextField majortf = new TextField(user.getMajor());
		majortf.setSize(400, 45);
		majortf.setLocation(110, 460);
		majortf.setEditable(false);
		majortf.setFont(f);

		this.add(areaIcon);
		this.add(emailtf);
		this.add(emailIcon);
		this.add(nametf);
		this.add(nameIcon);
		this.add(pwtf);
		this.add(pwIcon);
		this.add(idtf);
		this.add(idIcon);
		this.add(underLine);
		this.add(title);
		this.add(backBtn);
		this.add(areatf);
		this.add(majorIcon);
		this.add(majortf);

		mf.add(this);
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
	
	public void getMyNumber(int myNumber) {
		this.myNumber = myNumber;
	}
}
