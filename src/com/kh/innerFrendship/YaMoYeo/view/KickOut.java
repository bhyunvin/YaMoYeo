package com.kh.innerFrendship.YaMoYeo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.kh.innerFrendship.YaMoYeo.model.vo.User;

public class KickOut extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private ArrayList userList;
	public static int userIndex;
	public boolean confirm;
	
	public KickOut() {}

	public KickOut(JFrame mf) {
		this.mf = mf;
		this.panel = this;
		
		userList = readFile();

		this.setSize(600, 600);
		this.setLayout(null);
		this.setBackground(new Color(234, 208, 184));

		JLabel title = new JLabel("강퇴투표");
		title.setLocation(210, 20);
		title.setSize(250, 50);
		title.setFont(new Font("돋움", Font.BOLD, 40));

		JLabel underLine = new JLabel();
		underLine.setBackground(Color.BLACK);
		underLine.setOpaque(true);
		underLine.setLocation(210, 70);
		underLine.setSize(165, 2);

		JLabel title2 = new JLabel("조원의 강퇴 투표가 진행중입니다.");
		title2.setLocation(110, 100);
		title2.setSize(400, 50);
		title2.setFont(new Font("돋움", Font.BOLD, 25));

		JLabel txt = new JLabel(((User) userList.get(userIndex)).getName() + "의 강제퇴장에");
		txt.setLocation(200, 180);
		txt.setSize(210, 50);
		txt.setFont(new Font("돋움", Font.BOLD, 25));

		Image icon = new ImageIcon("images/강퇴.jpg").getImage().getScaledInstance(300, 100, 0);
		JLabel out = new JLabel(new ImageIcon(icon));
		out.setLocation(150, 380);
		out.setSize(300, 100);
		
		JRadioButton chk1 = new JRadioButton("동의합니다", true);
		chk1.setLocation(220, 210);
		chk1.setSize(200, 100);
		chk1.setOpaque(false);
		chk1.setFont(new Font("돋움", Font.BOLD, 25));
		confirm = chk1.isSelected();
		
		JRadioButton chk2 = new JRadioButton("반대합니다", true);
		chk2.setLocation(220, 280);
		chk2.setSize(200, 100);
		chk2.setOpaque(false);
		chk2.setFont(new Font("돋움", Font.BOLD, 25));
		confirm = !chk2.isSelected();
		
		ButtonGroup group = new ButtonGroup();
		group.add(chk1);
		group.add(chk2);

		Image check = new ImageIcon("images/checkButton.PNG").getImage().getScaledInstance(200, 40, 0);
		JButton btn = new JButton(new ImageIcon(check));
		btn.setSize(200, 40);
		btn.setLocation(200, 400);
		btn.addMouseListener(new LastConfirm());

		JButton back = new JButton(new ImageIcon("images/back.png"));
		back.setLocation(20, 20);
		back.setSize(45, 45);
		back.setContentAreaFilled(false);
		back.addMouseListener(new MyMouseAdapter());

		this.add(title);
		this.add(underLine);
		this.add(title2);
		this.add(txt);
		this.add(btn);
		this.add(out);
		this.add(chk1);
		this.add(chk2);
		this.add(back);

		mf.add(this);
	}

	class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			ChangePanel.changePanel(mf, panel, new MenuManager(mf));

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
	
	public void getUserIndex(int index) {
		userIndex = index;
	}
	
	class LastConfirm extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			int result = 0;
			if(confirm == true) {
				result = JOptionPane.showConfirmDialog(panel, "정말 강퇴하시겠습니까?", "최종확인", JOptionPane.ERROR_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(panel, ((User) userList.get(userIndex)).getName() + "이/가 강퇴되었습니다", "강퇴", JOptionPane.INFORMATION_MESSAGE);
					userList.remove(userIndex);
				}
			}
		}
	}
}
