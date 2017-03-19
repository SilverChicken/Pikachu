package ui;

import java.awt.Button;

import javax.swing.*;

public class jFrameThing {
	public static void main(String[] s) {
		JFrame frame = new JFrame("Assessment");
		frame.setVisible(true);
		frame.setSize(600,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Assessed Employee Id:");
		JPanel panel = new JPanel();
		JButton button = new JButton("Begin Assessment");
		
		frame.add(panel);
		frame.add(label);
		frame.add(button);
	}
}
