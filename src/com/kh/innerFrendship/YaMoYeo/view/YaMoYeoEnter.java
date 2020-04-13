package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class YaMoYeoEnter extends JPanel {
	private JFrame mf;
	private JPanel yaMoYeoEnter;
	private JTable table;
	private String[] columnNames = {"이름","개설자","참여수"};
			String data[][] ={
            {"","",""},
            {"","",""},
            {"","",""},};


	public YaMoYeoEnter(JFrame mf) {
		this.mf = mf;
		this.yaMoYeoEnter = this;

	
	// JPanel사이즈를 메인프레임과 같은 600X600으로 설정
	// 확인이 편하도록 흰배경으로 설정
	// JPanel의 레이아웃을 null로 설정해 원하는 곳에 컴포넌트 배치
	this.setSize(600, 600);
	this.setBackground(new Color(234, 208, 184));
	this.setLayout(null);

	JButton back = new JButton("이전화면");
	back.setBounds(0, 0, 100, 50);
	Image searchIcon = new ImageIcon("images/searchIcon.PNG").getImage().getScaledInstance(150, 77, 0);
	JButton search = new JButton(new ImageIcon(searchIcon));
	search.setBounds(20,100,150,77);

	JTextField searchTxt = new JTextField("");
	searchTxt.setBounds(170,100,300,77);


	Image icon = new ImageIcon("images/title.jpg").getImage().getScaledInstance(150, 50, 0);
	JLabel title= new JLabel(new ImageIcon(icon));
	title.setBounds(200,10,150,100);

	 DefaultTableModel model =
             new DefaultTableModel(data,columnNames);
     JTable tbl =new JTable(model);
     
     
     
     //JTable tbl = new JTable(data,columnNames);
     // Table은 JScrollPane위에 출력해야 컬럼 이름이 출력된다! 명심할것
     JScrollPane scoll =new JScrollPane(tbl);
      
     //add(tbl);
  
     scoll.setBounds(20,175,450,150);
     this.add(scoll);
     
     
     JButton registerBtn = new JButton("등록하기");
     registerBtn.setBounds(490,0,100,30);
     registerBtn.setBackground(Color.WHITE);
     
 	JButton alramBtn= new JButton(new ImageIcon("images/alram.PNG"));
 	alramBtn.setBounds(510,50,60,60);
 	alramBtn.setBorderPainted(false);
 	alramBtn.setContentAreaFilled(false);
 	
 	JButton profileBtn = new JButton(new ImageIcon("images/profile.PNG"));
 	profileBtn.setBounds(510,120,60,60);
 	profileBtn.setBorderPainted(false);
 	profileBtn.setContentAreaFilled(false);
 	
	// 마우스 이벤트를 갖고옵니다
	back.addMouseListener(new MyMouseAdapter());
	
	this.add(profileBtn);
	this.add(alramBtn);
	this.add(registerBtn);
	this.add(new JScrollPane(table));
	this.add(title);
	this.add(searchTxt);
	this.add(back);
	this.add(search);

	mf.add(this);
}

// 마우스가 눌리면 changePanel을 실행합니다
// 여기선 yaMoYeoEnter 패널을 YaMoYeoLogin패널로 변경합니다
class MyMouseAdapter extends MouseAdapter {
	@Override
	public void mousePressed(MouseEvent e) {
		int result = JOptionPane.showConfirmDialog(null, 
				"로그아웃 하시겠습니까?", "이전화면",JOptionPane.YES_NO_OPTION);
		//사용자가 "예", "아니오"의 선택 없이 다이얼로그 창을 닫은 경우
		if(result == JOptionPane.CLOSED_OPTION) {
			ChangePanel.changePanel(mf, yaMoYeoEnter, yaMoYeoEnter);

			//예를 선택한 경우
		} else if(result == JOptionPane.YES_OPTION) {
			ChangePanel.changePanel(mf, yaMoYeoEnter, new YaMoYeoLogin(mf));

		} else {
			// 사용자가 "아니오"를 선택 한 경우
			ChangePanel.changePanel(mf, yaMoYeoEnter, yaMoYeoEnter);
		}

	}
}

}
