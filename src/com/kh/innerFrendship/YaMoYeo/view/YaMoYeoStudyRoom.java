package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.innerFrendship.YaMoYeo.model.vo.StudyRoom;

public class YaMoYeoStudyRoom extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private List<StudyRoom> roomList = new ArrayList<>();
	private int myNumber;
	private int roomNumber;
	
	public YaMoYeoStudyRoom() {}
	
	public YaMoYeoStudyRoom(JFrame mf) {
		this.mf = mf;
		this.panel = this;
		
		roomList = readFile();
		getRoomNumber();
		
		StudyRoom sr = roomList.get(roomNumber);
		System.out.println(roomNumber);
		
		this.setSize(600, 600);
		this.setLayout(null);
		this.setBackground(new Color(234, 208, 184));
		
		JLabel title = new JLabel(sr.getRoomName());
		title.setLocation(240, 20);
		title.setSize(250, 50);
		title.setFont(new Font("돋움", Font.BOLD,35));
		
		JButton back = new JButton(new ImageIcon("images/back.png"));
		back.setLocation(20, 20);
		back.setSize(45, 45);
		back.setContentAreaFilled(false);
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new YaMoYeoEnter(mf));
			}
		});
		
		JButton menu = new JButton(new ImageIcon("images/menu.png"));
		menu.setLocation(530, 15);
		menu.setSize(50, 50);
		menu.setContentAreaFilled(false);
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new MenuManager(mf));
			}
		});
		
		JCheckBox chk1 = new JCheckBox();
		chk1.setLocation(50, 100);
		chk1.setSize(50, 50);
		chk1.setOpaque(false);
		
		JCheckBox chk2 = new JCheckBox();
		chk2.setLocation(50, 145);
		chk2.setSize(50, 50);
		chk2.setOpaque(false);
				
		JCheckBox chk3 = new JCheckBox();
		chk3.setLocation(50, 190);
		chk3.setSize(50, 50);
		chk3.setOpaque(false);
		
		JTextField txt = new JTextField("to do list");
		txt.setLocation(85, 110);
		txt.setSize(200,30);
		txt.setOpaque(false);
		
		JTextField txt2 = new JTextField("to do list");
		txt2.setLocation(85, 155);
		txt2.setSize(200,30);
		txt2.setOpaque(false);
		
		JTextField txt3 = new JTextField("to do list");
		txt3.setLocation(85, 205);
		txt3.setSize(200,30);
		txt3.setOpaque(false);
		
		this.add(title);
		this.add(back);
		this.add(menu);
		this.add(chk1);
		this.add(chk2);
		this.add(chk3);
		this.add(txt);
		this.add(txt2);
		this.add(txt3);
		
		mf.add(this);
	}
	
	public ArrayList readFile() {
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
	
	public void getMyNumber(int myNumber) {
		this.myNumber = myNumber;
	}
	
	public void getRoomNumber() {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream("roomNumber.txt"));
			
			roomNumber = dis.readInt();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
