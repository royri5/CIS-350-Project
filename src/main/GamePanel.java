package main;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;


public class GamePanel extends JPanel implements Runnable{
	//SCREEN SETTINGS FOR THE GAME
	final int originalTileSize = 16; //this is setting the game by 16 x 16 
	
	final int scale =3; //scales the pixels up so the char doesn't look small
	
	public final int tileSize = originalTileSize * scale;
	final int maxScreenCol=16;
	final int maxScreenRow =12;
	final int screenWidth =tileSize * maxScreenCol; //768 pixels
	final int screenHeight = tileSize * maxScreenRow; // 576 pixels
	
	int FPS =60;
	
	KeyHandler keyH =new KeyHandler();
	Thread gameThread;
	Player player = new Player(this,keyH);
	
	
	//This is setting up the players default position as well as how fast they move
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 5;
	
	public GamePanel () {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void sstartGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void run() {
		double drawInterval = 1000000000/FPS; //0.01666 seconds
		double nextDrawTime= System.nanoTime()+ drawInterval;
		
		while(gameThread != null) {
			
	
			update();
			
			repaint();
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				if (remainingTime < 0) {
					remainingTime = 0;
				}
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
			}
			
			catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		
	}
	public void update() {
		player.update();
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		
		player.draw(g2);
		
		g2.dispose();
	}
}
