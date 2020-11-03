package com;

import java.util.List;

public class Horse extends Piece {

	public Horse(int col, int row, boolean isWhite) {
		// TODO Auto-generated constructor stub
		super(col, row, 4,ID.HORSE, isWhite);
	}

	@Override
	public List<Box> getValidMove() {
		// TODO Auto-generated method stub
		validMove.clear();
		int one = 1, two = 2;
		
		do {
			addValidMove(row+one,col+two);
			addValidMove(row+one,col-two);
			addValidMove(row+two,col+one);
			addValidMove(row+two,col-one);
			one*=-1;
			two*=-1;
		}while(one==-1);
		
		
		return validMove;
	}

}
