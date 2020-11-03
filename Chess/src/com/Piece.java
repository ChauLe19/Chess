package com;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
	protected int row, col;
	private static int boxWidth = Game.boxSize;
	protected boolean isFirstMove = true;
	private static SpriteSheet chessSS;
	protected List<Box> validMove = new ArrayList<>();
	protected BufferedImage pieceImage;
	protected boolean isWhite;
	private ID id;

	public Piece(int col, int row, int imageCol, ID id,boolean isWhite) {
		// TODO Auto-generated constructor stub
		this.row = row;
		this.col = col;
		this.id = id;
		this.isWhite = isWhite;
		pieceImage = chessSS.grabImage(imageCol, isWhite ? 1 : 2, boxWidth, boxWidth);
	}

	public Piece(int imageCol, boolean isWhite) {
		// TODO Auto-generated constructor stub
		pieceImage = chessSS.grabImage(imageCol, isWhite ? 1 : 2, boxWidth, boxWidth);
	}

	public abstract List<Box> getValidMove();



	public ID getId() {
		return id;
	}

	public Rectangle getBounds() {
		return new Rectangle(col * boxWidth, row * boxWidth, boxWidth, boxWidth);
	}

	public void render(Graphics g) {
//		g.setColor(Color.white);
//		g.drawString("row: " + row + " col: " + col, col * boxWidth, row * boxWidth);
		g.drawImage(pieceImage, col * boxWidth, row * boxWidth, null);
	}
	
	protected boolean addValidMove(int x, int y) { // return true if still going
			
		try {
			Box tempBox  =Board.board[x][y];
			if(tempBox.getPiece()== null ) {   //valid if empty box
				validMove.add(tempBox);
				return true;
			}else if(tempBox.getPiece().isWhite!=isWhite) { // valid enemy different color
				validMove.add(tempBox);
			}
			return false;
		}catch(Exception e) {
			return true;
		}
	}

	public void setFirstMove() {
		isFirstMove = false;
	}

	public static void loadSpriteSheet(SpriteSheet chessSS) {
		Piece.chessSS = chessSS;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public Box getBox() {
		return Board.board[row][col];

	}
}
