package com.kh.innerFrendship.YaMoYeo.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChangePanel {
	// JPanel을 변경하기위한 메서드입니다
	// static으로 작성하여 ChangePanel.changePanel() 로 사용 가능합니다
	public static void changePanel(JFrame mf, JPanel oldPanel, JPanel newPanel) {
		mf.remove(oldPanel); 
		mf.add(newPanel);
		mf.repaint();
	}
}
