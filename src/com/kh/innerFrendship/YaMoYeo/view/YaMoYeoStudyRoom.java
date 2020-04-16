package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
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
	public static int myNumber;
	public static int roomNumber;
	private String[] toDoArray;
	private StudyRoom sr;
	private JTextField txt;
	private JTextField txt2;
	private JTextField txt3;
	
	public YaMoYeoStudyRoom() {}
	
	public YaMoYeoStudyRoom(JFrame mf) {
		this.mf = mf;
		this.panel = this;
		
		roomList = readFile();
		
		sr = roomList.get(roomNumber);
		
		toDoArray = new String[3];
		
		this.setSize(600, 600);
		this.setLayout(null);
		this.setBackground(new Color(234, 208, 184));
		
		JLabel title = new JLabel(sr.getRoomName());
		title.setLocation(240, 20);
		title.setSize(250, 50);
		title.setFont(new Font("돋움", Font.BOLD, 35));
		
		Image backImage = new ImageIcon("images/back.png").getImage().getScaledInstance(56, 56, 0);
		JLabel back = new JLabel(new ImageIcon(backImage));
		back.setLocation(5, 10);
		back.setSize(56, 56);
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new YaMoYeoEnter(mf));
			}
		});
		
		Image menuImage = new ImageIcon("images/menu.PNG").getImage().getScaledInstance(64, 64, 0);
		JLabel menu = new JLabel(new ImageIcon(menuImage));
		menu.setLocation(530, 15);
		menu.setSize(64, 64);
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MenuManager mm = new MenuManager();
				mm.getMyNumber(myNumber);
				mm.getRoomNumber(sr.getRoomNumber());
				ChangePanel.changePanel(mf, panel, new MenuManager(mf));
			}
		});
		
		Image month4 = new ImageIcon("images/4월.jpg").getImage().getScaledInstance(600, 300, 0);
		JLabel m4 = new JLabel(new ImageIcon(month4));
		m4.setSize(600, 300);
		m4.setLocation(0, 270);
		this.add(m4);
		
		Image month5 = new ImageIcon("images/5월.jpg").getImage().getScaledInstance(600, 300, 0);
		JLabel m5 = new JLabel(new ImageIcon(month5));
		m5.setSize(600, 300);
		m5.setLocation(0, 270);
		
		m4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel.remove(m4);
				panel.add(m5);
				panel.repaint();
			}
		});
		
		m5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel.remove(m5);
				panel.add(m4);
				panel.repaint();
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
		
		txt = new JTextField("to do list");
		txt.setLocation(85, 110);
		txt.setSize(200,30);
		txt.setOpaque(false);
		txt.addMouseListener(new Clear());
		txt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				toDoArray[0] = txt.getText();
				txt.setText(toDoArray[0]);
				fileOutput();
			}
		});
		
		txt2 = new JTextField("to do list");
		txt2.setLocation(85, 155);
		txt2.setSize(200,30);
		txt2.setOpaque(false);
		txt2.addMouseListener(new Clear());
		txt2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				toDoArray[1] = txt2.getText();
				txt2.setText(toDoArray[1]);
				fileOutput();
			}
		});
		
		txt3 = new JTextField("to do list");
		txt3.setLocation(85, 205);
		txt3.setSize(200,30);
		txt3.setOpaque(false);
		txt3.addMouseListener(new Clear());
		txt3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				toDoArray[2] = txt3.getText();
				txt3.setText(toDoArray[2]);
				fileOutput();
			}
		});
		
		fileInput();
		
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
	
	public void getRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	class Clear extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			((JTextField) e.getComponent()).setText("");
		}
	}
	
	public void fileOutput() {
		DataOutputStream dos = null;
		File file = new File("todoList" + sr.getRoomName() + ".txt");
		try {
			dos = new DataOutputStream(new FileOutputStream(file));
			
			dos.writeUTF(toDoArray[0]);
			dos.writeUTF(toDoArray[1]);
			dos.writeUTF(toDoArray[2]);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				dos.flush();
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fileInput() {
		DataInputStream dis = null;
		File file = new File("todoList" + sr.getRoomName() + ".txt");
		try {
			dis = new DataInputStream(new FileInputStream(file));

			for(int i = 0; i < 3; i++) {
				toDoArray[i] = dis.readUTF();
			}
			
			txt.setText(toDoArray[0]);
			txt2.setText(toDoArray[1]);
			txt3.setText(toDoArray[2]);
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
}
