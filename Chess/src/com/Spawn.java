package com;

import java.util.List;

public class Spawn extends Piece {
	public Spawn(int col, int row, boolean isWhite) {
		super(col, row, 6, ID.SPAWN, isWhite);
		// TODO Auto-generated constructor stub

	}

	@Override
	public List<Box> getValidMove() {
		// TODO Auto-generated method stub
		validMove.clear();
		int moveWay = isWhite ? 1 : -1;

		try {
			if (Board.board[row - (1 * moveWay)][col].getPiece() == null) { // check if spawn going straight empty
				validMove.add(Board.board[row - (1 * moveWay)][col]);
			}
			if (isFirstMove && Board.board[row - (2 * moveWay)][col].getPiece() == null) {
				validMove.add(Board.board[row - (2 * moveWay)][col]);
			}
			if (Board.board[row - 1 * moveWay][col - 1].getPiece() != null) {
				addValidMove(row - 1 * moveWay, col - 1);
			}

		} catch (Exception e) {

		}

		try {
			if (Board.board[row - 1 * moveWay][col + 1].getPiece() != null) { // check the diagonal move is enemy
				addValidMove(row - 1 * moveWay, col + 1);
			}

		} catch (Exception e) {

		}

		return validMove;
	}

}
