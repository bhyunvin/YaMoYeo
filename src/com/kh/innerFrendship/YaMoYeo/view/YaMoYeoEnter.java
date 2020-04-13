package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.kh.innerFrendship.YaMoYeo.model.vo.StudyRoom;
import com.kh.innerFrendship.YaMoYeo.model.vo.User;

public class YaMoYeoEnter extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private int myNumber;
	private ArrayList<StudyRoom> roomList;
	private ArrayList<User> userList;

	public YaMoYeoEnter() {}

	public YaMoYeoEnter(JFrame mf) {
		this.mf = mf;
		this.panel = this;

		this.setSize(600, 600);
		this.setBackground(new Color(234, 208, 184));
		this.setLayout(null);
		
		if(roomList == null) {
			
		} else {
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new FileInputStream("roomList.txt"));
				roomList = (ArrayList<StudyRoom>) ois.readObject();
				
				ois = new ObjectInputStream(new FileInputStream("userList.txt"));
				userList = (ArrayList<User>) ois.readObject();
			} catch (FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} catch (ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
			}
		}
		
		// 테이블 작성 시작
		String[] header = {"이름", "개설자", "참여자 수"};
		String[][] contents = null;
		
		if(roomList == null) {
			contents = new String[1][3];
			contents[0] = new String[]{"", "", ""};
		} else {
			contents = new String[roomList.size()][3];
			for(int i = 0; i < roomList.size(); i++) {
				contents[i] = new String[]{roomList.get(i).getRoomName(),
				userList.get(roomList.get(i).getMyNumber()).getName(),
				Integer.toString(roomList.get(i).getMemberCount())};
			}
		}
		
		DefaultTableModel dtm = new DefaultTableModel(contents, header);
		JTable roomListTable = new JTable(dtm);
		
		DefaultTableModel model = new DefaultTableModel(contents, header) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		roomListTable.setSize(400, 425);
		roomListTable.setLocation(100, 175);
		// 테이블 작성 완료
		
		JButton back = new JButton("이전화면");
		back.setBounds(0, 0, 100, 50);
		
		Image searchIcon = new ImageIcon("images/searchIcon.PNG").getImage().getScaledInstance(77, 77, 0);
		JLabel search = new JLabel(new ImageIcon(searchIcon));
		search.setBounds(75, 100, 77, 77);
		search.setBorder(new LineBorder(Color.BLACK, 1));

		JTextField searchTxt = new JTextField("");
		searchTxt.setBounds(152, 100, 373, 77);

		Image icon = new ImageIcon("images/title.jpg").getImage().getScaledInstance(200, 60, 0);
		JLabel title = new JLabel(new ImageIcon(icon));
		title.setBounds(200, 10, 200, 60);
		
		JButton registerBtn = new JButton("등록하기");
		registerBtn.setBounds(490, 0, 100, 30);
		registerBtn.setBackground(Color.WHITE);
		registerBtn.addMouseListener(new Change());

		JButton alramBtn = new JButton(new ImageIcon("images/alram.PNG"));
		alramBtn.setBounds(510, 50, 60, 60);
		alramBtn.setBorderPainted(false);
		alramBtn.setContentAreaFilled(false);

		JButton profileBtn = new JButton(new ImageIcon("images/profile.PNG"));
		profileBtn.setBounds(510, 120, 60, 60);
		profileBtn.setBorderPainted(false);
		profileBtn.setContentAreaFilled(false);

		back.addMouseListener(new MyMouseAdapter());

		this.add(profileBtn);
		this.add(alramBtn);
		this.add(registerBtn);
		this.add(title);
		this.add(searchTxt);
		this.add(back);
		this.add(search);
		this.add(roomListTable);

		mf.add(this);
	}

	class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			int result = JOptionPane.showConfirmDialog(panel, "로그아웃 하시겠습니까?", "이전화면", JOptionPane.YES_NO_OPTION);
			// 사용자가 "예", "아니오"의 선택 없이 다이얼로그 창을 닫은 경우
			if (result == JOptionPane.CLOSED_OPTION) {
				ChangePanel.changePanel(mf, panel, panel);
				// 예를 선택한 경우
			} else if (result == JOptionPane.YES_OPTION) {
				ChangePanel.changePanel(mf, panel, new YaMoYeoLogin(mf));
			} else {
				// 사용자가 "아니오"를 선택 한 경우
				ChangePanel.changePanel(mf, panel, panel);
			}

		}
	}

	class Change extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			ChangePanel.changePanel(mf, panel, new StudyRoomOpen(mf));
		}
	}

	public void getMyNumber(int myNumber) {
		this.myNumber = myNumber;
	}
}
