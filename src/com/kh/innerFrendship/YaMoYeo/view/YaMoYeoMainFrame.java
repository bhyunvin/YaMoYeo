package com.kh.innerFrendship.YaMoYeo.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class YaMoYeoMainFrame extends JFrame {
	public YaMoYeoMainFrame() {
		this.setSize(600, 600);
		this.setLocation(500, 200);
		this.setTitle("YaMoYeo");
		this.setIconImage(new ImageIcon("images/ya.PNG").getImage());
		this.setResizable(false);
		
		new YaMoYeoLoading(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
