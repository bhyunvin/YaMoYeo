package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

public class RoomMemberManager extends JPanel {
	private JFrame mf;
	private JPanel panel;

	public RoomMemberManager(JFrame mf) {
		this.mf = mf;
		this.panel = this;
		this.setSize(600, 600);
		this.setBackground(new Color(234, 208, 184));
		this.setLayout(null);

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

		// 회원을 불러와서 2차원배열에 2중 for문으로 집어넣으면 될 것 같아요
		String[] header = {"번호", "이름", "이메일", "지역", "전공", "강퇴"};
		String[][] contents = new String[30][6];

		for(int i = 0; i < contents.length; i++) {
			for(int j = 0; j < contents[i].length; j++) {
				if(i == 0) {
					contents[i] = new String[]{Integer.toString(i + 1), "개설자", "이메일" + i, "지역" + i, "전공" + i, ""};
				} else {
					contents[i] = new String[]{Integer.toString(i + 1), "조원" + i, "이메일" + i, "지역" + i, "전공" + i, ""};
				}
			}
		}
		
		DefaultTableModel model = new DefaultTableModel(contents, header) {
	        public boolean isCellEditable(int row, int column) {
	                return false;
	            }
	        };
		
		JTable manageTable = new JTable(model);
		manageTable.setSize(540, 450);
		manageTable.setLocation(10, 125);
		manageTable.setRowHeight(60);

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
}
