package com;

import java.util.List;

public class Rook extends Piece{

	public Rook(int col, int row, boolean isWhite) {
		super(col, row,5,ID.ROOK, isWhite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Box> getValidMove() {
		// TODO Auto-generated method stub
		validMove.clear();
		for (int tempRow = row+1; tempRow < 8; tempRow++) { // vertical showing , down
			if(!addValidMove(tempRow,col)) {
				break;}
		}
		for (int tempRow = row-1; tempRow >-1; tempRow--) { // vertical showing , up
			if(!addValidMove(tempRow,col)) {
				break;}
		}
		for (int tempCol = col+1; tempCol < 8; tempCol++) { // vertical showing , right
			if(!addValidMove(row,tempCol)) {
				break;}
		}
		for (int tempCol = col-1; tempCol > -1; tempCol--) { // vertical showing , left
			if(!addValidMove(row,tempCol)) {
				break;}
		}
		while (validMove.contains((Board.board[row][col]))) {
			validMove.remove(Board.board[row][col]);
		}
		return validMove;
	}

}
