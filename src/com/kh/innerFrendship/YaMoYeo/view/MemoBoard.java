package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemoBoard extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private JTextField txt1;
	private JButton rm1;

	public MemoBoard(JFrame mf) {
		this.mf = mf;
		this.panel = this;

		this.setSize(600, 600);
		this.setLayout(null);
		this.setBackground(new Color(234, 208, 184));

		JLabel title = new JLabel("조원에게 메모를 남겨보세요.");
		title.setLocation(180, 10);
		title.setSize(250, 40);
		title.setFont(new Font("돋움", Font.BOLD, 18));

		JLabel underLine = new JLabel();
		underLine.setBackground(Color.BLACK);
		underLine.setOpaque(true);
		underLine.setLocation(180, 45);
		underLine.setSize(245, 2);
		
		Image plusImage = new ImageIcon("images/plus.png").getImage().getScaledInstance(50, 50, 0);
		JLabel plus = new JLabel(new ImageIcon(plusImage));
		plus.setBounds(500, 40, 50, 50);

		JLabel back = new JLabel(new ImageIcon("images/back.png"));
		back.setLocation(20, 20);
		back.setSize(45, 45);

		JButton save = new JButton(new ImageIcon("images/save.png"));
		save.setBounds(500, 100, 40, 40);
		save.setContentAreaFilled(false);
		save.addActionListener(new saveMemoAdapter());
		back.addMouseListener(new MyMouseAdapter());
		plus.addMouseListener(new plusMemoAdapter());

		this.add(save);
		this.add(plus);
		this.add(title);
		this.add(underLine);
		this.add(back);

		mf.add(this);
	}

	class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			panel.repaint();
			ChangePanel.changePanel(mf, panel, new MenuManager(mf));
		}
	}

	class plusMemoAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			txt1 = new JTextField();
			txt1.setBounds(100, 100, 160, 30);
			panel.add(txt1);
			rm1 = new JButton(new ImageIcon("images/minus.png"));
			rm1.setBounds(70, 70, 30, 30);
			panel.add(rm1);
			panel.repaint();
			rm1.addMouseListener(new rmAdapter());
		}
	}

	class rmAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			panel.remove(txt1);
			panel.remove(rm1);
			panel.repaint();
		}

	}

	class saveMemoAdapter implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			BufferedReader br = null;
			FileReader fr = null;
			BufferedWriter bw = null;
			try {
				// 콘솔 입력에서 입력 받을 경우
				br = new BufferedReader(new InputStreamReader(System.in));

				// 파일 입력 받을 경우
				fr = new FileReader("Memo.txt");
				bw = new BufferedWriter(new FileWriter("Memo.txt", true));
				if (txt1 == null) {
					JOptionPane.showMessageDialog(null, "메모창을 추가하지 않았습니다", "오류", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "메모창이 저장되었습니다.", "완료", JOptionPane.INFORMATION_MESSAGE);
					bw.write(txt1.getText() + "/");
					bw.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "메모창을 추가하지 않았습니다", "오류", JOptionPane.ERROR_MESSAGE);
			} finally {
				try {
					br.close();
					fr.close();
					bw.flush();
					bw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
