package ui;

import javax.swing.*;

public class jFrameThing {
	public static void main(String[] s) {
		JFrame frame = new JFrame("Assessment");
		frame.setVisible(true);
		frame.setSize(600,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel();
		JPanel panel = new JPanel();
		
		frame.add(panel);
		frame.add(label);
	}
}
