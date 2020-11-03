package com;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window{

	public Window(int width, int height,Game game) {
		Dimension windowSize = new Dimension(width,height);
		JFrame window = new JFrame("Chess");
		window.setPreferredSize(windowSize);
		window.setMaximumSize(windowSize);
		window.setMinimumSize(windowSize);
		window.add(game);
		window.setResizable(false);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
