package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
	private String roomPassword;
	private ArrayList<StudyRoom> roomList;
	private ArrayList<User> userList;
	private JTable roomListTable;

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
		String[] header = {"이름", "개설자", "참여자 수"};
		String[][] contents = null;
		
		if(roomList == null) {
			contents = new String[1][3];
		} else {
			contents = new String[roomList.size()][3];
		}
		
		for(int i = 0; i < roomList.size(); i++) {
			contents[i] = new String[] {
					roomList.get(i).getRoomName(),
					userList.get(roomList.get(i).getMyNumber() - 1).getName(),
					String.valueOf(roomList.get(i).getMemberCount())};
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
		scroll.setSize(450, 395);
		scroll.setLocation(75, 175);
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
		this.add(scroll);

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
						
						DataOutputStream dos = null;
						try {
							dos = new DataOutputStream(new FileOutputStream("roomNumber.txt"));
						
							dos.writeInt(i);
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						} finally {
							if(dos != null) {
								try {
									dos.flush();
									dos.close();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
						}
						
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
				ChangePanel.changePanel(mf, panel, new YaMoYeoStudyRoom(mf));
			} else if(!inputPassword.equals(roomPassword)) {
				JOptionPane.showMessageDialog(panel, "비밀번호가 틀렸습니다", "비밀번호 오류", JOptionPane.ERROR_MESSAGE);
				checkPassword();
			}
		}
	}
}
