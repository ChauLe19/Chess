package com;

import java.util.List;

public class Queen extends Piece {
	public Queen(int row, int col, boolean isWhite) {
		super(row, col, 2,ID.QUEEN, isWhite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Box> getValidMove() {
		// TODO Auto-generated method stub
		validMove.clear();
		boolean upLeft = true, downLeft = true, upRight = true, downRight = true;

		for (int tempRow = row + 1; tempRow < 8; tempRow++) { // vertical showing , down
			if (!addValidMove(tempRow, col)) {
				break;
			}
		}
		for (int tempRow = row - 1; tempRow > -1; tempRow--) { // vertical showing , up
			if (!addValidMove(tempRow, col)) {
				break;
			}
		}
		for (int tempCol = col + 1; tempCol < 8; tempCol++) { // vertical showing , right
			if (!addValidMove(row, tempCol)) {
				break;
			}
		}
		for (int tempCol = col - 1; tempCol > -1; tempCol--) { // vertical showing , left
			if (!addValidMove(row, tempCol)) {
				break;
			}
		}
		while (validMove.contains((Board.board[this.row][this.col]))) {
			validMove.remove(Board.board[this.row][this.col]);
		}
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
