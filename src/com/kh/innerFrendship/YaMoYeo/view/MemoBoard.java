package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MemoBoard extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private JLabel memoLabel1;
	private JLabel memoLabel2;
	private JLabel memoLabel3;
	private JLabel memoLabel4;
	private ImageIcon memo1;
	private ImageIcon memo2;
	private ImageIcon memo3;
	private ImageIcon memo4;
	
	public MemoBoard(JFrame mf) {
		this.mf = mf;
		this.panel = this;

		this.setSize(600,600);
		this.setLayout(null);
		this.setBackground(new Color(234, 208, 184));

		memo1 = new ImageIcon("images/memo11.jpg");
		memo2 = new ImageIcon("images/memo22.jpg");
		memo3 = new ImageIcon("images/memo3.jpg");
		memo4 = new ImageIcon("images/memo33.jpg");

		JLabel title = new JLabel("조원에게 메모를 남겨보세요.");
		title.setLocation(180,10);
		title.setSize(250,40);
		title.setFont(new Font("돋움", Font.BOLD, 18));

		JLabel underLine = new JLabel();
		underLine.setBackground(Color.BLACK);
		underLine.setOpaque(true);
		underLine.setLocation(180, 45);
		underLine.setSize(245, 2);

		memoLabel1 = new JLabel(new ImageIcon("images/plus.PNG"));
		memoLabel1.setLocation(60, 70);
		memoLabel1.setSize(220,220);
		memoLabel2 = new JLabel(new ImageIcon("images/plus.PNG"));
		memoLabel2.setLocation(60, 310);
		memoLabel2.setSize(220,220);

		memoLabel3 = new JLabel(new ImageIcon("images/plus.PNG"));
		memoLabel3.setLocation(320, 70);
		memoLabel3.setSize(220,220);

		memoLabel4 = new JLabel(new ImageIcon("images/plus.PNG"));
		memoLabel4.setLocation(320,310);
		memoLabel4.setSize(220,220);

		JButton back = new JButton(new ImageIcon("images/back.png"));
		back.setLocation(20,20);
		back.setSize(45,45);
		back.setContentAreaFilled(false);

		memoLabel1.addMouseListener(new MemoAdapter1());
		memoLabel2.addMouseListener(new MemoAdapter2());
		memoLabel3.addMouseListener(new MemoAdapter3());
		memoLabel4.addMouseListener(new MemoAdapter4());
		back.addMouseListener(new MyMouseAdapter());

		this.add(title);
		this.add(underLine);
		this.add(memoLabel1);
		this.add(memoLabel2);
		this.add(memoLabel3);
		this.add(memoLabel4);
		this.add(back);

		mf.add(this);

	}
	
	class MemoAdapter1 extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			memoLabel1.setIcon(memo1);
		}
	}

	class MemoAdapter2 extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			memoLabel2.setIcon(memo2);
		}

	}
	
	class MemoAdapter3 extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			memoLabel3.setIcon(memo3);
		}

	}
	
	class MemoAdapter4 extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			memoLabel4.setIcon(memo4);
		}

	}
	
	class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			ChangePanel.changePanel(mf, panel, new MenuManager(mf));
		}
	}
}