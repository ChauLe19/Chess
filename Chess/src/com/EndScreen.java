package com;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class EndScreen {
	private boolean hasWon;
	private Font titleFont = new Font("arial", 1, 70);
	private Font buttonFont = new Font("arial", 1, 50);
	public EndScreen() {
		// TODO Auto-generated constructor stub
	}
	
	public void setWon(boolean hasWon) {
		this.hasWon = hasWon;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.setFont(titleFont);
		g.drawString((hasWon?"White":"Black")+ " wins", 100, 300);
		g.setFont(buttonFont);
		g.drawRect(300, 500, 300, 75); 
		g.drawString("RESTART", 325, 560);	
	}
	
}
