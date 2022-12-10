package entity;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;
import object.OBJ_Chainmail;
import object.OBJ_Key;
import object.OBJ_Sheild;
import object.OBJ_Shortsword_Normal;
/**
 * all the main character stats and functions and information regarding hitbox speed and staring position.
 * @author jlb74
 *
 */
public class Player extends Entity {
	GamePanel gp;
	KeyHandler keyH;
	/**
	 * The screen x coordinate of the player.
	 */
	public final int screenX;
	/**
	 * The screen y coordinate of the player.
	 */
	public final int screenY;
	/**
	 * The inventory of the player.
	 */
	public ArrayList<Entity> inventory = new ArrayList<>();
	/**
	 * The size of the player's inventory.
	 */
	public final int invnetorysize = 20;
	
	/**
	 * sets up the player for game panel like allowing for movement input 
	 * @param gp game panel to attach the player
	 * @param keyH keyListener so you can move the character
	 */
	public Player(GamePanel gp,KeyHandler keyH) {
		super(gp);
		
		this.gp =gp;
		this.keyH= keyH;
		
		screenX = gp.screenWidth/2 -(gp.tileSize)/2;
		screenY = gp.screenHeight/2 - (gp.tileSize)/2;
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height =32;
		
		setDeafaultValues();
		getPlayerImage();
		setItems();
		
	}
	/**
	 * sets all the default values defined in entity.
	 */
	public void setDeafaultValues() {
		worldX = gp.tileSize * 25;
		worldY= gp.tileSize * 22;
		speed =4;
		direction = "down";
		
		//Player Status

		level = 1;
		maxLife = 12;

		// The movement speed of the player.
		movement = 30;

		// The current hitpoints of the player.
		hitpoints = 12;

		// The strength attribute of the player.
		str = 16;

		// The dexterity attribute of the player.
		dex = 9;

		// The constitution attribute of the player.
		con = 15;

		// The intelligence attribute of the player.
		INT = 13;

		// The wisdom attribute of the player.
		wis = 11;

		// The charisma attribute of the player.
		cha = 14;

		// The strength modifier of the player.
		strMOD = +3;

		// The dexterity modifier of the player.
		dexMOD = -1;

		// The constitution modifier of the player.
		conMOD = +2;

		// The intelligence modifier of the player.
		INTMOD = +1;

		// The wisdom modifier of the player.
		wisMOD = +0;

		// The charisma modifier of the player.
		chaMOD = +2;

		// The amount of coin the player has.
		coin = +0;

		// The players current weapon.
		currentWeapon = new OBJ_Shortsword_Normal(gp);

		// The players current shield.
		currentShield = new OBJ_Sheild(gp);

		// The players current armor
		currentArmor = new OBJ_Chainmail(gp);
		
	}
	
	
	/**
	 * Adds the players current weapon, shield, and a key to the inventory.
	 */
	public void setItems() {
		inventory.add(currentWeapon);
		inventory.add(currentShield);
		inventory.add(new OBJ_Key(gp));
	}
	/**
	 * Calculates and returns the players attack value.
	 * @return The character's attack value.
	 */
	public int getAttack() {
		setDiceType(currentWeapon.attackValue);
		int holder  = roll();
		attack = holder + 1 + strMOD;
		return attack;	
	}
	/**
	 * Calculates and returns the players armor class.
	 *
	 * @return The character's armor class.
	 */
	public int getArmorClass() {
		return armorClass = currentShield.sheildValue + currentArmor.armorValue;
	}
	/**
	 * Loads and sets up the players images for different directions.
	 */
	public void getPlayerImage() {

			up1 = setup("/player/up1");
			up2 = setup("/player/up2");
			up3 = setup("/player/up2");
			down1 = setup("/player/down1");
			down2 = setup("/player/down2");
			down3 = setup("/player/down3");
			left1 = setup("/player/left1");
			left2 = setup("/player/left2");
			left3 = setup("/player/left3");
			right1 = setup("/player/right1");
			right2 = setup("/player/right2");
			right3 = setup("/player/right3");
				
	}
	/**
	 * Updates the players position, checks for collisions and interactions with other objects, and updates the players sprite.
	 */
	public void update() {
		
		if(keyH.upPressed == true || keyH.downPressed == true || keyH.rightPressed == true || keyH.leftPressed ==true) {
			if (keyH.upPressed == true) {
				direction ="up";
				
			}
			else if (keyH.downPressed == true) {
				direction="down";
				
			}
			else if (keyH.leftPressed == true){
				direction="left";
				
			}
			else if (keyH.rightPressed == true) {
				direction=	"right";
				
			}
			//Checking tile collision
			collision = false;
			gp.colchecker.checkTile(this);
			
			//check object collision
			int objIndex = gp.colchecker.checkObject(this, true);
			pickUpObject(objIndex);
			
			//Checking NPC collision
			int npcIndex = gp.colchecker.checkEntity(this, gp.npc);
			interactNPC(npcIndex);
			
			//CHECK EVENT
			gp.eHandler.checkEvent();
			
			gp.keyH.enterPressed = false;
			
			
			//if collision is false player can move
			if (collision == false) {
				switch(direction) {
				case "up":
					worldY -= speed;
					break;
				case "down":
					worldY += speed;
					break;
				case "left":
					worldX -= speed;
					break;
				case "right":
					worldX += speed;
					break;
					
				}
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
	/**
	 * Picks up an object at the specified index if it exists.
	 *
	 * @param i The index of the object to pick up.
	 */
	public void pickUpObject(int i) {
		if(i != 999) {
			
		}
	}
	/**
	 * Interacts with an NPC at the specified index if it exists.
	 *
	 * @param i The index of the NPC to interact with.
	 */
	public void interactNPC(int i) {
		if(i != 999) {
			if(gp.keyH.enterPressed) {
				gp.gameState = gp.dialougeState;
				gp.npc[i].speak();
			}	
		}
	
	}
	/**
	 * Draws the character's sprite on the screen.
	 *
	 * @param g2 The images used for drawing based on spriteNum.
	 */
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
			if(spriteNum ==15) {
				image =up3;
			}
			break;
		case "down":
			if(spriteNum ==0) {
				image = down1;
			}
			if(spriteNum ==1) {
				image =down2;
			}
			if(spriteNum ==16) {
				image =down3;
			}
			break;
		case "left":
			if(spriteNum ==0) {
				image = left1;
			}
			if(spriteNum ==1) {
				image =left2;
			}
			if(spriteNum ==17) {
				image =left3;
			}
			break;
		case "right":
			if(spriteNum ==0) {
				image = right1;
			}
			if(spriteNum ==1) {
				image =right2;
			}
			if(spriteNum ==18) {
				image =right3;
			}
			break;
		}
		g2.drawImage(image, screenX, screenY, null);
	}
}
