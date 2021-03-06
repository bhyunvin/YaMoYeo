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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.kh.innerFrendship.YaMoYeo.model.vo.StudyRoom;
import com.kh.innerFrendship.YaMoYeo.model.vo.User;

public class YaMoYeoEnter extends JPanel {
	private JFrame mf;
	private JPanel panel;
	public static int myNumber;
	public static int roomNumber;
	private String roomPassword;
	private ArrayList<StudyRoom> roomList;
	private ArrayList<User> userList;
	private JTable roomListTable;
	private YaMoYeoStudyRoom ymysr = new YaMoYeoStudyRoom();
	private StudyRoomOpen sro = new StudyRoomOpen();

	public YaMoYeoEnter() {}

	public YaMoYeoEnter(JFrame mf) {
		this.mf = mf;
		this.panel = this;
		
		roomList = readFile();
		userList = readUser();

		this.setSize(600, 600);
		this.setBackground(new Color(234, 208, 184));
		this.setLayout(null);
		
		// 테이블 작성 시작
		String[] header = {"방 이름", "지역", "공부 주제"};
		String[][] contents = new String[roomList.size()][3];
		
		for(int i = 0; i < roomList.size(); i++) {
			contents[i] = new String[] {
					roomList.get(i).getRoomName(),
					roomList.get(i).getArea(),
					roomList.get(i).getSubject()};
		}
		
		DefaultTableModel model = new DefaultTableModel(contents, header) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		roomListTable = new JTable(model);
		roomListTable.setRowHeight(60);
		roomListTable.addMouseListener(new Enter());
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로

		TableColumnModel tcm = roomListTable.getColumnModel() ; // 정렬할 테이블의 컬럼모델을 가져옴

		for(int i = 0 ; i < tcm.getColumnCount() ; i++){
			tcm.getColumn(i).setCellRenderer(dtcr);  
		}
		
		JScrollPane scroll = new JScrollPane(roomListTable);
		scroll.setSize(450, 500);
		scroll.setLocation(75, 75);
		// 테이블 작성 완료
		
		Image info = new ImageIcon("images/개설.jpg").getImage().getScaledInstance(60, 60, 0);
		JLabel myInfo = new JLabel(new ImageIcon(info));
		myInfo.setSize(60, 60);
		myInfo.setLocation(530, 110);
		myInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MyInfo myInfo = new MyInfo();
				myInfo.getMyNumber(myNumber);
				ChangePanel.changePanel(mf, panel, new MyInfo(mf));
			}
		});

		Image backImage = new ImageIcon("images/back.png").getImage().getScaledInstance(56, 56, 0);
		JLabel back = new JLabel(new ImageIcon(backImage));
		back.setBounds(5, 10, 56, 56);
		back.addMouseListener(new MyMouseAdapter());

		Image icon = new ImageIcon("images/title.jpg").getImage().getScaledInstance(200, 60, 0);
		JLabel title = new JLabel(new ImageIcon(icon));
		title.setBounds(200, 10, 200, 60);
		
		Image registerImage = new ImageIcon("images/등록하기.png").getImage();
		JButton registerBtn = new JButton(new ImageIcon(registerImage));
		registerBtn.setBounds(490, 0, 100, 60);
		registerBtn.setBackground(Color.WHITE);
		registerBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				sro.getMyNumber(myNumber);
			}
		});
		registerBtn.addMouseListener(new Change());

		JButton profileBtn = new JButton(new ImageIcon("images/profile.PNG"));
		profileBtn.setBounds(510, 120, 60, 60);
		profileBtn.setBorderPainted(false);
		profileBtn.setContentAreaFilled(false);

		this.add(myInfo);
		this.add(profileBtn);
		this.add(registerBtn);
		this.add(title);
		this.add(back);
		this.add(scroll);

		mf.add(this);
	}

	class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			int result = JOptionPane.showConfirmDialog(panel, "로그아웃 하시겠습니까?", "이전화면", JOptionPane.YES_NO_OPTION);
			
			if (result == JOptionPane.CLOSED_OPTION) {
				ChangePanel.changePanel(mf, panel, panel);
			} else if (result == JOptionPane.YES_OPTION) {
				ChangePanel.changePanel(mf, panel, new YaMoYeoLogin(mf));
			} else {
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
	
	class Enter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			int selectedRow = roomListTable.getSelectedRow();
			
			if(selectedRow >= 0 && selectedRow <= roomListTable.getRowCount()) {
				String roomName = roomListTable.getValueAt(selectedRow, 0).toString();
				for(int i = 0; i < roomList.size(); i++) {
					if(roomName.equals(roomList.get(i).getRoomName())) {
						roomPassword = roomList.get(i).getRoomPassword();
						roomNumber = i;
						break;
					}
				}
			}
			
			checkPassword();
		}
	}
	
	public void checkPassword() {
		String inputPassword = JOptionPane.showInputDialog(panel, "비밀번호를 입력하세요", "", JOptionPane.QUESTION_MESSAGE);
	
		if(inputPassword != null) {
			if(inputPassword.equals(roomPassword)) {
				JOptionPane.showMessageDialog(panel, "비밀번호가 일치합니다", "환영합니다", JOptionPane.INFORMATION_MESSAGE);
				ymysr.getMyNumber(myNumber);
				ymysr.getRoomNumber(roomNumber);
				ChangePanel.changePanel(mf, panel, new YaMoYeoStudyRoom(mf));
			} else if(!inputPassword.equals(roomPassword)) {
				JOptionPane.showMessageDialog(panel, "비밀번호가 틀렸습니다", "비밀번호 오류", JOptionPane.ERROR_MESSAGE);
				checkPassword();
			}
		}
	}
}
