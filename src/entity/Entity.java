package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {
	
	GamePanel gp;
	/**
	 * the Entitys worldX and worldY position
	 */
	public int worldX, worldY;
	/**
	 * how fast the entity moves ie mpc has a speed of 1 so it walks for and PC has a speed of 4
	 */
	public int speed;
	/**
	 * buffering the images for every direction alternates between the same direction for animation
	 */
	public BufferedImage up1, up2, up3, down1, down2, down3, left1 ,left2, left3, right1, right2, right3;
	/**
	 * starting entity direction is down
	 */
	public String direction = "down";
	/**
	 * sprite counter to know when to alternate frames for walking entity
	 */
	public int spriteCounter =0;
	/**
	 *  0 or 1 to make movement frames alternate
	 */
	public int spriteNum =0;
	/**
	 * sets up a default hitbox for entity can change in their respected class like player
	 */
	public Rectangle solidArea = new Rectangle(0,0,48,48);
	/**
	 * set equal to solidArea.x or .y  for hitbox
	 */
	public int solidAreaDefaultX, solidAreaDefaultY;
	/**
	 * collision is set to false need to set to true if you want entity to have a collision hitbox
	 */
	public boolean collision = false;
	/**
	 * much like spriteCounter but for every entity besides player
	 */
	public int actionLockCounter =0;
	/**
	 * dialouges for NPC holds up to 20 dialogues 
	 */
	String dialogues[] = new String[20];
	/**
	 * rotates through all the diaologes
	 */
	int dialougeIndex = 0;
	//public BufferedImage image, image2, image3;

	
	
	//character attributes
	/**
	 * type of character attributes 0 player, 1 npc, and 2 monster
	 */
	public int type; // 0 = player 1 = npc and 2 = monster
	/**
	 * name place holder for other entitys 
	 */
	public String name;
	/**
	 * level attribute
	 */
	public int level ;
	/**
	 * movment attribute different than speed. This is for combat ie Player can move 30ft
	 */
	public int movement;
	/**
	 * max life/ maxhitpoints of entity
	 */
	public int maxLife;
	/**
	 * current hitpoints
	 */
	public int hitpoints;
	/**
	 * strength score
	 */
	public int str;
	/**
	 * dexerity score
	*/
	public int dex;
	/**
	 * constitution score
	 */
	public int con;
	/**
	 * intelligence score
	 */
	public int INT;
	/**
	 * wisdom score
	 */
	public int wis;
	/**
	 * charisma score
	 */
	public int cha;
	/**
	 * strength modifier based on strength score
	 */
	public int strMOD;
	/**
	 * dexerity modifier based on dex score
	 */
	public int dexMOD;
	/**
	 * constitution modifier based on con score
	 */
	public int conMOD;
	/**
	 * inteligence modifier based on inteligence score
	 */
	public int INTMOD;
	/**
	 * wisdom modifier 
	 */
	public int wisMOD;
	/**
	 * charsma modifier based on cha score
	 */
	public int chaMOD;
	/**
	 * coins for entity
	 */
	public int coin;
	/**
	 * current weapon of the entity
	 */
	public Entity currentWeapon;
	/**
	 * current Sheild of the entity 
	 */
	public Entity currentShield;
	/**
	 * currentArrmor of the entity
	 */
	public Entity currentArmor;
	/**
	 * return value of attackValue + modifiers and Proficiency bonus for damage 
	 */
	public int attack;
	/**
	 * armor class check to see if attack hits >= ac means it hits
	 */
	public int armorClass;
	/**
	 * descriptions of items for inventory
	 */
	public String descriptions = "";
	
	
	// item attributes
	/**
	 * gets the actual dice roll 
	 */
	public String attackValue; //d8 for example
	/**
	 * define sheild value for entity
	 */
	public int sheildValue;
	/**
	 * defines armorvalue for entitys
	 */
	public int armorValue;
	/**
	 * ties entity to gamepanel
	 * @param gp
	 */
	public Entity(GamePanel gp) {
		this.gp =gp;
	}
	
	public void setAction() {}
	/**
	 * sets up the speak function for entitys like npc
	 */
	public void speak() {
		if (dialogues[dialougeIndex] == null){
			dialougeIndex = 0;
		}
		gp.ui.currentDialogue = dialogues[dialougeIndex];
		dialougeIndex++;
		
		switch(gp.player.direction) {
		case "up":
			direction = "down";
			break;
		case "down":
			direction = "up";
			break;
		case "left":
			direction = "right";
			break;
		case "right":
			direction = "left";
			break;
		}
	}
	/**
	 * updates the tiles player and collision
	 */
	public void update() {
		setAction();
		
		collision = false;
		gp.colchecker.checkTile(this);
		gp.colchecker.checkObject(this, false);
		gp.colchecker.checkPlayer(this);
		
		//if collision is false player can move
		if (collision == false) {
			switch(direction) {
			case "up": worldY -= speed; break;
			case "down": worldY += speed; break;
			case "left": worldX -= speed; break;
			case "right": worldX += speed; break;
				
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
	 * d
	 * @param g2
	 */
	public void draw(Graphics2D g2) {
		
		BufferedImage image =  null;
		
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
			worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
			worldY + gp.tileSize > gp.player.worldY -gp.player.screenY &&
			worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
			
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
			g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		}
	}
	public BufferedImage setup(String imagepath) {
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
	
		try {
			image = ImageIO.read(getClass().getResourceAsStream( imagepath + ".png"));
			image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		} catch (IOException e) {
		
		}
		return image;
	}
	//DICE STUFF FOR ALL THE ENTITY
		public String diceType;

	    public void setDiceType(String d) {
	        diceType = d;
	    }

	    public String getDiceType() {
	        return diceType;
	    }



	    //Should probably be only public (besides constructor/getDiceType, maybe setDiceType for switching between two and one handed), covers all rolls
	    public  int roll() {
	        if(this.getDiceType().equals("d4")) {
	            return d4();
	        } else if(this.getDiceType().equals("d6")) {
	            return d6();
	        } else if(this.getDiceType().equals("d8")) {
	            return d8();
	        } else if(this.getDiceType().equals("d10")) {
	            return d10();
	        } else if(this.getDiceType().equals("d12")) {
	            return d12();
	        } else if(this.getDiceType().equals("d20")) {
	            return d20();
	        } else if(this.getDiceType().equals("d100")) {
	            return d100();
	        } else {
	            //unarmed
	            return 1;
	        }
	    }

	    /**
	     * Returns an integer between 1 and 4
	     * @return int
	     */
	    public int d4() {
	        Random n = new Random();
	        return n.nextInt(3);
	    
	    }  

	    /**
	     * Returns an integer between 1 and 6
	     * @return int
	     */
	    public int d6() {
	        Random n = new Random();
	        return n.nextInt(5);
	    }

	    /**
	     * Returns an integer between 1 and 8
	     * @return int
	     */
	    public int d8() {
	        Random n = new Random();
	        return n.nextInt(7);
	    }

	    /**
	     * Returns an integer between 0 and 10
	     * @return int
	     */
	    public int d10() {
	        Random n = new Random();
	        return n.nextInt(9);
	    }

	    /**
	     * Returns an integer between 1 and 12
	     * @return int
	     */
	    public int d12() {
	        Random n = new Random();
	        return n.nextInt(11);
	    }

	    /**
	     * Returns an integer between 1 and 20
	     * @return int
	     */
	    public int d20() {
	        Random n = new Random();
	        return n.nextInt(19);
	    }

	    /**
	     * Returns an integer between 0 and 100
	     * @return int
	     */
	    public int d100() {
	        Random n = new Random();
	        return n.nextInt(99);
	    }

	    
}

