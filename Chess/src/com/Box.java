package com;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Box {
	private int row;
	private int col;
	private static final int boxWidth = Game.boxSize;
	private int x, y;
	private Piece piece;
	private Color boxColor;
	private boolean isSelected = false;
	private final Color defaultBoxColor;

	public Box(int col, int row, boolean isBlackBox) { // bORw => black == true; white == false;
		// TODO Auto-generated constructor stub s
		// create pieces

		this.row = row; // 1-8
		this.col = col; // 1-8
//		defaultBoxColor = isBlackBox ? Color.black : Color.white;
		defaultBoxColor = isBlackBox ? Color.blue : Color.yellow;
		boxColor = defaultBoxColor;
		x = col * boxWidth;
		y = row * boxWidth + 15;
		boolean isWhitePiece;
		if (row == 0 || row == 1) {
			isWhitePiece = false;
			createPieces(isWhitePiece);
		} else if (row == 6 || row == 7) {
			isWhitePiece = true;
			createPieces(isWhitePiece);
		}

//		createPieces(isBlackPiece);

	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
		if (this.piece != null) {
			this.piece.setCol(col);
			this.piece.setRow(row);
		}
	}

	private void createPieces(boolean isWhitePiece) {
		if (row == 1 || row == 6) {
			piece = new Spawn(col, row, isWhitePiece);
		} else if (col == 0 || col == 7) {// rook
			piece = new Rook(col, row, isWhitePiece);
		} else if (col == 1 || col == 6) {// horse
			piece = new Horse(col, row, isWhitePiece);
		} else if (col == 2 || col == 5) {// bishop
			piece = new Bishop(col, row, isWhitePiece);
		} else if (col == 3) {// queen
			piece = new King(col, row, isWhitePiece);
		} else if (col == 4) {// king
			piece = new Queen(col, row, isWhitePiece);
		}
	}

	public void setBoxColor(Color boxColor) {
		this.boxColor = boxColor;
	}
	
	public void restore() {
		this.boxColor = defaultBoxColor;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, boxWidth, boxWidth);

	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
		if (isSelected) {
			boxColor = Color.green;
		} else {
			restore();
		}
	}

	public void render(Graphics g) {
		g.setColor(boxColor);
		g.fillRect(col * boxWidth, row * boxWidth, boxWidth, boxWidth);
		g.setColor(Color.pink);
//		g.drawString("row: " + row + " col: " + col, x, y);
		if (piece != null) {
			piece.render(g);
		}

	}
}
