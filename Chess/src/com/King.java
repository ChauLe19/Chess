package com;

import java.util.List;

public class King extends Piece {

	public King(int col, int row, boolean isWhite) {
		// TODO Auto-generated constructor stub
		super(col, row, 1,ID.KING, isWhite);
	}

	@Override
	public List<Box> getValidMove() {
		// TODO Auto-generated method stub
		validMove.clear();
		for (int x = -1; x < 2; x++) {
			for (int y = -1; y < 2; y++) {
				addValidMove(row+x, col+y);
			}
		}
		while (validMove.contains((Board.board[row][col]))) {
			validMove.remove(Board.board[row][col]);
		}
		return validMove;

	}

}
