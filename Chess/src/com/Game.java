package com;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {

	/**
	 * 
	 */
	private int WIDTH = 920, HEIGHT = 950;
	private static final long serialVersionUID = 7568470609794997690L;
	private boolean isRunning = false;
	private Thread thread;
	private Board board;
	private BufferImageLoader loader = new BufferImageLoader();
	private SpriteSheet chessSS;
	private Menu menu;
	private EndScreen endScreen;
	public static State state = State.MENU;
	public static int boxSize = 80;

	public Game() {
		BufferedImage chess_image = loader.loadImage("/chess.png");
		chessSS = new SpriteSheet(chess_image, boxSize);
		Piece.loadSpriteSheet(chessSS);
		new Window(WIDTH, HEIGHT, this);
		board = new Board(boxSize);
		menu = new Menu();
		endScreen = new EndScreen();

		addMouseListener(new MouseInput(board, endScreen));
		start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Game();
	}

	public void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		long timer = System.currentTimeMillis();
		double delta = 0;
		int frames = 0;

		while (isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
			}
		}
		stop();
	}

	private void render() {
		// TODO Auto-generated method stub
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(new Color(199, 141, 54));
		g.fillRect(0, 0, WIDTH, HEIGHT);

		if (state == State.GAME) {
			board.render(g);
		} else if (state == State.MENU) {
			menu.render(g);
		}else if(state == State.FINAL) {
			endScreen.render(g);
		}
		g.dispose();
		bs.show();
	}

	private void tick() {
		// TODO Auto-generated method stub

	}

	private void stop() {
		// TODO Auto-generated method stub
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
