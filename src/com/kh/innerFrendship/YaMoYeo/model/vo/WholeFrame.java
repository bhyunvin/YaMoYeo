package com.kh.innerFrendship.YaMoYeo.model.vo;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class WholeFrame extends JPanel {
	//테이블 필드 생성
	private JTable table;

	JTable userTable;  
	JScrollPane listJs;
	JPanel listPanel;

	Vector<String> userColumn = new Vector<>();
	DefaultTableModel model;
	Vector<String> userRow;

	public WholeFrame() {

		userColumn.addElement("이름");
		userColumn.addElement("개설자");
		userColumn.addElement("참여자수");			

		//테이블 생성
		model = new DefaultTableModel(userColumn,0);

		//테이블 생성
		userTable = new JTable(model); // 테이블 생성

		setBounds(50,150,450,300);

		listPanel = new JPanel();
		listPanel.setLayout(new BorderLayout());
		listJs = new JScrollPane(userTable);
		
		add(listPanel);
		userRow = new Vector<String>(); // 내용추가(행추가)
		userRow.addElement("홍길동");
		userRow.addElement("의적");
		model.addRow(userRow);
		
	}

}