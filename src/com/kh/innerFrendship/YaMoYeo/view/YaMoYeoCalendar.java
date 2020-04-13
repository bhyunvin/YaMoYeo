package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class YaMoYeoCalendar extends JPanel{
	private JFrame mf;
	private JPanel yaMoYeoEnter;
	private JButton tempBtn;
	private JPanel YaMoYeaCalender;

	public YaMoYeoCalendar(JFrame mf){
		this.mf = mf;
		this.YaMoYeaCalender = this;

		setSize(600,600);
		
		ArrayList<Integer> calArr = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);

		int date = cal.get(Calendar.DATE);
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		//이번 달 세팅//
		for(int i = 0; i<lastDay; i++) {
			calArr.add(i+1);
		}
		//지난 달 세팅 완료
		cal.set(Calendar.DATE, 1); //1일 로 세팅
		int yoil = cal.get(Calendar.DAY_OF_WEEK); // 
		int numOfPreMonth = yoil - 1;
		cal.add(Calendar.MONTH,-1);
		lastDay = cal.getActualMaximum(Calendar.DATE);
		for(int i = 0; i < numOfPreMonth; i++) {
			calArr.add(0,lastDay);
			lastDay--;
		}
		//다음 달 세팅//
		cal.add(Calendar.MONTH,1);
		lastDay = cal.getActualMaximum(Calendar.DATE);
		cal.set(Calendar.DATE,lastDay);
		yoil = cal.get(Calendar.DAY_OF_WEEK);

		int numOfNextMonth = 7 - yoil;
		for(int i = 0; i<numOfNextMonth; i++) {
			calArr.add(i+1);
		}

		//패널로 구현//
		GridLayout gridLayout = new GridLayout(calArr.size()/7,7);
		this.setLayout(gridLayout);



		for(int i = 0; i<calArr.size(); i++) {
			tempBtn = new JButton(calArr.get(i) + "");
			if(i%7 == 0) {
				tempBtn.setForeground(Color.red);
			} else if(i%7 == 6) {
				tempBtn.setForeground(Color.BLUE);
			} 
			this.add(tempBtn);
		}
		
		//		tempBtn.addMouseListener(new CalendarListener());

		mf.add(this);
	}
	//	class CalendarListener extends MouseAdapter {
	//		@Override
	//		public void mousePressed(MouseEvent e) {
	//			// 날짜를 버튼으로 만들어  클릭 후 할일등 작성 기능
	//	
	//		}
}



