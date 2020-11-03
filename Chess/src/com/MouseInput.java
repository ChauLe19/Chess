package com;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
	private int mouseX, mouseY;
	private Box selectedBox;
	private Board board;
	private boolean isWhiteTurn = true;
	private EndScreen endScreen;

	public MouseInput(Board board, EndScreen endScreen) {
		// TODO Auto-generated constructor stub
		this.board = board;
		this.endScreen = endScreen;
	}

	@Override
	public void mouseClicked(MouseEvent mouse) {
		// TODO Auto-generated method stub
		mouseX = mouse.getX();
		mouseY = mouse.getY();

		if (Game.state == State.GAME) {
			gameRender(mouseX, mouseY);
		} else if (Game.state == State.MENU) {
			if (mouseInBox(300, 200, 300, 75)) {
				Game.state = State.GAME;
			}
		} else if (Game.state == State.FINAL) {
			if (mouseInBox(300, 500, 300, 75)) {
				board = new Board();
				Game.state = State.GAME;
			}
		}

	}

	private void gameRender(int mouseX, int mouseY) {
		if (selectedBox != null) { // if box is green
			if (mouseInBox(selectedBox.getBounds())) { // if mouse click selected box -> unselect
				selectedBox.setSelected(false);
				selectedBox = null;
				board.restore();
			} else { // if mouse click other boxes
				for (Box box : selectedBox.getPiece().getValidMove()) {
					if (mouseInBox(box.getBounds())) {
						if (box.getPiece() != null && box.getPiece().getId() == ID.KING) {
							if (box.getPiece().isWhite) {
								endScreen.setWon(false);
							} else {
								endScreen.setWon(true);
							}

							Game.state = State.FINAL;
						}
						box.setPiece(selectedBox.getPiece()); // to box
						selectedBox.getPiece().setFirstMove();
						selectedBox.setSelected(false); // from box
						selectedBox.setPiece(null);
						selectedBox = null;
						board.restore();
						isWhiteTurn=!isWhiteTurn;
					}
				}
			}
		} else { // if nothing is selected
			for (Box[] boxRow : Board.board) {
				for (Box box : boxRow) {
					if (box.getPiece() != null && box.getPiece().isWhite == isWhiteTurn) {
						if (mouseInBox(box.getBounds()) ) {
							box.setSelected(true);
							selectedBox = box;
							for (Box validBox : box.getPiece().getValidMove()) { // show valid move
								validBox.setBoxColor(Color.red);
							}

						}
					}
				}
			}

		}
	}

	private boolean mouseInBox(int x, int y, int width, int height) {
		if (mouseX > x && mouseX < x + width) {
			if (mouseY > y && mouseY < y + height) {
				return true;
			}
		}
		return false;
	}

	private boolean mouseInBox(Rectangle rect) {

		if (mouseX > rect.x && mouseX < rect.x + rect.width) {
			if (mouseY > rect.y && mouseY < rect.y + rect.height) {
				return true;
			}
		}
		return false;
	}
}
