package com;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Board {
	public static Box[][] board = new Box[8][8];
	private boolean bORw = true;
	private int boxSize=80;
	

	public Board() {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				board[row][col] = new Box(col, row, bORw); //0-7
				bORw = !bORw;
			}
			bORw = !bORw;
		}
	}
	
	public Board(int boxSize)
	{
	    this.boxSize = boxSize;
	    for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = new Box(col, row, bORw); //0-7
                bORw = !bORw;
            }
            bORw = !bORw;
        }
	}

	public void render(Graphics g) {

		for (Box[] boxRow : board) {
			for (Box box : boxRow) {
				box.render(g);
			}
		}
	}
	
	public void restore() {
		for (Box[] boxRow : board) {
			for (Box box : boxRow) {
				box.restore();
			}
		}
	}

	
	public void tick() {

	}
}
