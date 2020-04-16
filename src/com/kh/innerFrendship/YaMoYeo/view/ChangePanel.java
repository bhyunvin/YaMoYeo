package com.kh.innerFrendship.YaMoYeo.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChangePanel {
	public static void changePanel(JFrame mf, JPanel oldPanel, JPanel newPanel) {
		mf.remove(oldPanel); 
		mf.add(newPanel);
		mf.repaint();
	}
}
