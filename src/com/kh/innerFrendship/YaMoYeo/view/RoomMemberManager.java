package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.kh.innerFrendship.YaMoYeo.model.vo.User;

public class RoomMemberManager extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private ArrayList userList;
	private JTable manageTable;
	public static int myNumber;
	public static int roomNumber;
	
	public RoomMemberManager() {}

	public RoomMemberManager(JFrame mf) {
		this.mf = mf;
		this.panel = this;
		this.setSize(600, 600);
		this.setBackground(new Color(234, 208, 184));
		this.setLayout(null);
		
		userList = readFile();

		Image backImage = new ImageIcon("images/back.PNG").getImage().getScaledInstance(40, 40, 0);
		JLabel back = new JLabel(new ImageIcon(backImage));
		back.setSize(40, 40);
		back.setLocation(0, 20);
		back.addMouseListener(new Back());

		JLabel title = new JLabel();
		title.setSize(180, 70);
		title.setLocation(210, 5);
		title.setText("조원 관리");
		title.setFont(new Font("돋움", Font.BOLD, 36));

		JLabel underLine = new JLabel();
		underLine.setBackground(Color.BLACK);
		underLine.setSize(162, 3);
		underLine.setLocation(210, 65);
		underLine.setOpaque(true);

		String[] header = {"번호", "이름", "이메일", "지역", "전공", "강퇴"};
		String[][] contents = new String[userList.size()][6];
		int roomUserCount = 0;

		while(roomUserCount < userList.size()) {
			contents[roomUserCount] = new String[] {Integer.toString(roomUserCount + 1),
					((User) userList.get(roomUserCount)).getName(), ((User) userList.get(roomUserCount)).getEmail(),
					((User) userList.get(roomUserCount)).getArea(), ((User) userList.get(roomUserCount)).getMajor(),
			""};
			roomUserCount++;
		}

		DefaultTableModel model = new DefaultTableModel(contents, header) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		manageTable = new JTable(model);
		manageTable.setSize(540, 450);
		manageTable.setLocation(10, 125);
		manageTable.setRowHeight(60);
		manageTable.addMouseListener(new TableKickOut());

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로

		TableColumnModel tcm = manageTable.getColumnModel() ; // 정렬할 테이블의 컬럼모델을 가져옴

		for(int i = 0 ; i < tcm.getColumnCount() ; i++){
			tcm.getColumn(i).setCellRenderer(dtcr);  
		}

		DefaultTableCellRenderer renderer = new MyDefaultTableCellRenderer();
		manageTable.getColumn("강퇴").setCellRenderer(renderer);

		JScrollPane scroll = new JScrollPane(manageTable);
		scroll.setSize(540, 450);
		scroll.setLocation(25, 100);

		this.add(back);
		this.add(title);
		this.add(underLine);
		this.add(scroll);

		mf.add(this);
	}

	class Back extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			ChangePanel.changePanel(mf, panel, new YaMoYeoEnter(mf));
		}
	}

	class MyDefaultTableCellRenderer extends DefaultTableCellRenderer{
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			Component comp = null;

			if(column == 5){
				comp = new JButton("강퇴투표");
			}
			return comp;
		}
	}

	class TableKickOut extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			KickOut ko = new KickOut();
			MenuManager mm = new MenuManager();
			int selectedRow = manageTable.getSelectedRow();
			int selectedCol = manageTable.getSelectedColumn();
			
			if(selectedRow >= 0 && selectedRow <= manageTable.getRowCount() && selectedCol == 5) {
				int index = Integer.parseInt(manageTable.getValueAt(selectedRow, 0).toString()) - 1;
				ko.getUserIndex(index);
				mm.getUserIndex(index);
				ChangePanel.changePanel(mf, panel, new KickOut(mf));
			}
		}
	}
	
	public ArrayList readFile() {
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
	
	public void getRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
}

