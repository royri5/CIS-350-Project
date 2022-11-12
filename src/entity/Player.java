package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp,KeyHandler keyH) {
		this.gp =gp;
		this.keyH= keyH;
		setDeafaultValues();
		getPlayerImage();
	}
	public void setDeafaultValues() {
		x = 100;
		y= 100;
		speed =4;
		direction = "down";
		
	}
	public void getPlayerImage() {
		try {
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/down1.png.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/up2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
			
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	public void update() {
		if(keyH.upPressed == true || keyH.downPressed == true || keyH.rightPressed == true || keyH.leftPressed ==true) {
			if (keyH.upPressed == true) {
				direction ="up";
				y -= speed;
			}
			else if (keyH.downPressed == true) {
				direction="down";
				y += speed;
			}
			else if (keyH.leftPressed == true){
				direction="left";
				x -= speed;
			}
			else if (keyH.rightPressed == true) {
				direction=	"right";
				x += speed;
			}
			
			spriteCounter++; 
			if(spriteCounter > 10) {
				if(spriteNum == 0) {
					spriteNum = 1;
				}
				else if (spriteNum ==1) {
					spriteNum = 0;
				}
				spriteCounter =0;
			}
		}

	}
	
	public void draw(Graphics2D g2) {
		BufferedImage image =  null;
		switch(direction) {
		case"up":
			if(spriteNum ==0) {
				image =up1;
			}
			if(spriteNum ==1) {
				image =up2;
			}
			break;
		case "down":
			if(spriteNum ==0) {
				image = down1;
			}
			if(spriteNum ==1) {
				image =down2;
			}
			
			break;
		case "left":
			if(spriteNum ==0) {
				image = left1;
			}
			if(spriteNum ==1) {
				image =left2;
			}
			break;
		case "right":
			if(spriteNum ==0) {
				image = right1;
			}
			if(spriteNum ==1) {
				image =right2;
			}
			break;
		}
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	}
	
}
