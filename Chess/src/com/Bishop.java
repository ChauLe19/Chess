package com;

import java.util.List;

public class Bishop extends Piece {

	public Bishop(int col, int row, boolean isWhite) {
		// TODO Auto-generated constructor stub
		super(col, row, 3,ID.BISHOP, isWhite);
	}

	@Override
	public List<Box> getValidMove() {
		// TODO Auto-generated method stub
		validMove.clear();
		boolean upLeft = true, downLeft = true, upRight = true, downRight = true;
		for (int col = this.col - 1; col > -1 && (upLeft || downLeft); col--) { // Diagonally from piece to the left
			int row = col - this.col;
			if (upLeft) {
				upLeft = addValidMove(this.row + row, col);
			}
			if (downLeft) {
				downLeft = addValidMove(this.row - row, col);
			}

		}
		for (int col = this.col + 1; col < 8 && (upRight || downRight); col++) { // Diagonally from piece to the right
			int row = col - this.col;
			if (upRight) {
				upRight = addValidMove(this.row - row, col);
			}
			if (downRight) {
				downRight = addValidMove(this.row + row, col);
			}

		}
		
		return validMove;
	}

}
