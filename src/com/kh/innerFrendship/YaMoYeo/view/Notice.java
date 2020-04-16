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

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.innerFrendship.YaMoYeo.model.vo.StudyRoom;

public class Notice extends JPanel {
	private JFrame mf;
	private JPanel panel;
	public static int myNumber;
	public static int roomNumber;
	private JTextField btn;
	private JTextField btn2;
	private JTextField btn3;
	private JTextField btn4;
	private String[] noticeArray;
	private ArrayList roomList;
	
	public Notice() {}

	public Notice(JFrame mf) {
		this.mf = mf;
		this.panel = this;
		
		noticeArray = new String[4];
		
		roomList = readFile();
		
		this.setSize(600, 600);
		this.setLayout(null);
		this.setBackground(new Color(234, 208, 184));

		Image backImage = new ImageIcon("images/back.PNG").getImage().getScaledInstance(56, 56, 0);
		JLabel back = new JLabel(new ImageIcon(backImage));		
		back.setLocation(5, 10);
		back.setSize(56, 56);
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new YaMoYeoStudyRoom(mf));
			}
		});

		JLabel label = new JLabel();
		label = new JLabel("공지사항");
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setSize(600, 150);
		label.setFont(new Font("돋움", Font.BOLD, 35));
		
		JLabel underLine = new JLabel();
		underLine.setBackground(Color.BLACK);
		underLine.setSize(162, 3);
		underLine.setLocation(220, 100);
		underLine.setOpaque(true);

		JTextField text = new JTextField("번  호");
		text.setLocation(30, 150);
		text.setSize(100, 50);
		text.setBackground(Color.LIGHT_GRAY);
		text.setFont(new Font("돋음", Font.BOLD, 15));
		text.setHorizontalAlignment(JTextField.CENTER);
		text.setEditable(false);

		JTextField text2 = new JTextField("1");
		text2.setLocation(30, 200);
		text2.setSize(100, 50);
		text2.setBackground(Color.LIGHT_GRAY);
		text2.setFont(new Font("돋음", Font.BOLD, 15));
		text2.setHorizontalAlignment(JTextField.CENTER);
		text2.setEditable(false);

		JTextField text3 = new JTextField("2");
		text3.setLocation(30, 250);
		text3.setSize(100, 50);
		text3.setBackground(Color.LIGHT_GRAY);
		text3.setFont(new Font("돋음", Font.BOLD, 15));
		text3.setHorizontalAlignment(JTextField.CENTER);
		text3.setEditable(false);

		JTextField text4 = new JTextField("3");
		text4.setLocation(30, 300);
		text4.setSize(100, 50);
		text4.setBackground(Color.LIGHT_GRAY);
		text4.setFont(new Font("돋음", Font.BOLD, 15));
		text4.setHorizontalAlignment(JTextField.CENTER);
		text4.setEditable(false);

		JTextField text5 = new JTextField("4");
		text5.setLocation(30, 350);
		text5.setSize(100, 50);
		text5.setBackground(Color.LIGHT_GRAY);
		text5.setFont(new Font("돋음", Font.BOLD, 15));
		text5.setHorizontalAlignment(JTextField.CENTER);
		text5.setEditable(false);

		JTextField text6 = new JTextField("제  목");
		text6.setLocation(130, 150);
		text6.setSize(440, 50);
		text6.setBackground(Color.LIGHT_GRAY);
		text6.setFont(new Font("돋음", Font.BOLD, 15));
		text6.setHorizontalAlignment(JTextField.CENTER);
		text6.setEditable(false);

		btn = new JTextField("공지사항 1");
		btn.setLocation(130, 200);
		btn.setSize(440, 50);
		btn.setBackground(Color.WHITE);
		btn.setFont(new Font("돋음", Font.PLAIN, 20));
		btn.setForeground(Color.BLACK);

		btn2 = new JTextField("공지사항 2");
		btn2.setLocation(130, 250);
		btn2.setSize(440, 50);
		btn2.setBackground(Color.WHITE);
		btn2.setFont(new Font("돋음", Font.PLAIN, 20));
		btn2.setForeground(Color.BLACK);

		btn3 = new JTextField("공지사항 3");
		btn3.setLocation(130, 300);
		btn3.setSize(440, 50);
		btn3.setBackground(Color.WHITE);
		btn3.setFont(new Font("돋음", Font.PLAIN, 20));
		btn3.setForeground(Color.BLACK);

		btn4 = new JTextField("공지사항 4");
		btn4.setLocation(130, 350);
		btn4.setSize(440, 50);
		btn4.setBackground(Color.WHITE);
		btn4.setFont(new Font("돋음", Font.PLAIN, 20));
		btn4.setForeground(Color.BLACK);
		
		btn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				noticeArray[0] = btn.getText();
				
				fileOutput();
			}
		});
		
		btn2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				noticeArray[1] = btn2.getText();
				
				fileOutput();
			}
		});
		
		btn3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				noticeArray[2] = btn3.getText();
				
				fileOutput();
			}
		});
		
		btn4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				noticeArray[3] = btn4.getText();
				
				fileOutput();
			}
		});
		
		btn.setEditable(false);
		btn2.setEditable(false);
		btn3.setEditable(false);
		btn4.setEditable(false);
		
		JLabel label2 = new JLabel("제목을 누르시면 공지사항을 확인할 수 있습니다.");
		label2.setLocation(30, 420);
		label2.setSize(540, 100);
		label2.setFont(new Font("돋음", Font.BOLD, 20));
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setOpaque(false);
		
		fileInput();
		
		check();
		
		this.add(label);
		this.add(label2);
		this.add(underLine);
		this.add(back);
		this.add(text);
		this.add(text2);
		this.add(text3);
		this.add(text4);
		this.add(text5);
		this.add(text6);
		this.add(btn);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);

		mf.add(this);
	}
	
	public void getMyNumber(int myNumber) {
		this.myNumber = myNumber;
	}
	
	public void getRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
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
	
	
	class Clear extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			((JTextField) e.getComponent()).setText("");
		}
	}
	
	public void fileOutput() {
		DataOutputStream dos = null;
		File file = new File("notice" + ((StudyRoom) roomList.get(roomNumber)).getRoomName() + ".txt");
		try {
			dos = new DataOutputStream(new FileOutputStream(file));
			
			dos.writeUTF(noticeArray[0]);
			dos.writeUTF(noticeArray[1]);
			dos.writeUTF(noticeArray[2]);
			dos.writeUTF(noticeArray[3]);
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
		File file = new File("notice" + ((StudyRoom) roomList.get(roomNumber)).getRoomName() + ".txt");
		try {
			dis = new DataInputStream(new FileInputStream(file));

			for(int i = 0; i < 4; i++) {
				noticeArray[i] = dis.readUTF();
			}
			
			btn.setText(noticeArray[0]);
			btn2.setText(noticeArray[1]);
			btn3.setText(noticeArray[2]);
			btn4.setText(noticeArray[3]);
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
	public void check() {
		if(roomNumber == myNumber) {
			btn.setEditable(true);
			btn2.setEditable(true);
			btn3.setEditable(true);
			btn4.setEditable(true);
			btn.addMouseListener(new Clear());
			btn2.addMouseListener(new Clear());
			btn3.addMouseListener(new Clear());
			btn4.addMouseListener(new Clear());
		}
	}
}
