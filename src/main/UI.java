package main;

import java.io.IOException;
import java.io.InputStream;
import java.awt.*;
import java.text.DecimalFormat;

import entity.Entity;
import object.OBJ_Key;

public class UI {
	GamePanel gp;
	Graphics2D g2;
	Font maruMonica;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public boolean gameFinished = false;
	public String currentDialogue = "";
	public int commandNum = 0;
	public int slotCol = 0;
	public int slotRow = 0;
	
	public UI(GamePanel gp) {
		this.gp = gp;
		
		
		try {
			InputStream is = getClass().getResourceAsStream("/fonts/x12y16pxMaruMonica.ttf");
			maruMonica = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showMessage (String text) {
		message = text;
		messageOn = true;
	}
	
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		g2.setFont(maruMonica);
		g2.setColor(Color.white);
		//TITLE STATE
		if(gp.gameState == gp.titleState) {
			drawTitleScreen();

		}
		//PLAY STATE
		if(gp.gameState == gp.playState) {
			//Do playState stuff later
		}
		//PAUSE STATE
		if(gp.gameState == gp.pauseState) {
			drawPauseScreen();
		}
		//DIALOUGE STATE
		if(gp.gameState == gp.dialougeState) {
			drawDialougeScreen();
		}
		//CHARACTER STATE
		if(gp.gameState == gp.characterState) {
			drawCharacterScreen();
			drawInventory();
		}
	}
	public void drawTitleScreen() {
		//TITLE NAME
		g2.setFont (g2.getFont().deriveFont(Font.BOLD,96F));
		String text = "2D ADVENTURE!";
		int x = getXforCenteredText(text);
		int y = gp.tileSize *3;
		
		//SHADOW FOR LETTERING
		g2.setColor(Color.gray);
		g2.drawString( text , x+5 , y+5 );
		
		//MAIN COLOR AND TITLE
		g2.setColor(Color.white);
		g2.drawString( text , x , y );
		
		//IMAGE BELOW TITLE
		x = gp.screenWidth/2 - (gp.tileSize*3)/2;
		y += gp.tileSize;
		g2.drawImage(gp.player.down1, x , y , gp.tileSize*3, gp.tileSize*3, null);
		
		//MENU
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
		
		text = "NEW GAME";
		x = getXforCenteredText(text);
		y += gp.tileSize*4;
		g2.drawString(text , x , y);
		if(commandNum ==0) {
			g2.drawString(">", x- gp.tileSize, y);
			
		}
		
		text = "LOAD GAME";
		x = getXforCenteredText(text);
		y += gp.tileSize;
		g2.drawString(text , x , y);
		if(commandNum ==1) {
			g2.drawString(">", x- gp.tileSize, y);
			
		}
		text = "QUIT";
		x = getXforCenteredText(text);
		y += gp.tileSize;
		g2.drawString(text , x , y);
		if(commandNum ==2) {
			g2.drawString(">", x- gp.tileSize, y);
			
		}
	}

	public void drawPauseScreen() {
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80f));
		String text = "PAUSED";
		int x = getXforCenteredText(text);
		int y = gp.screenHeight/2;
		
		g2.drawString(text , x , y);
	}
	public void drawDialougeScreen() {
		//WINDOW
		int x = gp.tileSize *2;
		int y= gp.tileSize/2;
		int width = gp.screenWidth - (gp.tileSize*4);
		int height = gp.tileSize*4;
		
		drawSubWindow( x , y , width , height);
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,28F));
		x += gp.tileSize;
		y += gp.tileSize;
		
		for(String line : currentDialogue.split("\n")) {
			g2.drawString(line, x ,y );
			y +=40;
		}
		
	}
	public void drawCharacterScreen(){
		
		//create a frame
		final int frameX = gp.tileSize*2;
		final int frameY = gp.tileSize;
		final int frameWidth = gp.tileSize*5;
		final int frameHeight = gp.tileSize*10;
		drawSubWindow(frameX, frameY, frameWidth, frameHeight);
		
		//text 
		g2.setColor(Color.white);
		g2.setFont(g2.getFont().deriveFont(32F));
		
		int textX = frameX + 20;
		int textY = frameY + gp.tileSize;
		final int lineheight = 35; // same as font
		
		//names
		g2.drawString("Level" , textX, textY);
		textY += lineheight;
		g2.drawString("Hitpoints" , textX, textY);
		textY += lineheight;
		g2.drawString("Strength" , textX, textY);
		textY += lineheight;
		g2.drawString("Dexerity" , textX, textY);
		textY += lineheight;
		g2.drawString("Constitution" , textX, textY);
		textY += lineheight;
		g2.drawString("Intelligence" , textX, textY);
		textY += lineheight;
		g2.drawString("Wisdom" , textX, textY);
		textY += lineheight;
		g2.drawString("Charisma" , textX, textY);
		textY += lineheight;
		g2.drawString("Armor Class" , textX, textY);
		textY += lineheight+30;
		g2.drawString("Weapon" , textX, textY);
		textY += lineheight+ 15;
		g2.drawString("Sheild" , textX, textY);
		textY += lineheight;
		
		//VALUES
		int tailX = (frameX + frameWidth);
		//reset textY
		textY = frameY + gp.tileSize;
		String value;
		
		value = String.valueOf(gp.player.level);
		textX = getXforAlignToRight(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineheight;
		
		value = String.valueOf(gp.player.hitpoints + "/" + gp.player.maxLife);
		textX = getXforAlignToRight(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineheight;
		
		value = String.valueOf(gp.player.str + "(+"+ gp.player.strMOD+")");
		textX = getXforAlignToRight(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineheight;
		
		value = String.valueOf(gp.player.dex + "("+ gp.player.dexMOD+")");
		textX = getXforAlignToRight(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineheight;
		
		value = String.valueOf(gp.player.con + "(+"+ gp.player.conMOD+")");
		textX = getXforAlignToRight(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineheight;
		
		value = String.valueOf(gp.player.INT + "(+"+ gp.player.INTMOD+")");
		textX = getXforAlignToRight(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineheight;
		
		value = String.valueOf(gp.player.wis + "(+"+ gp.player.wisMOD+")");
		textX = getXforAlignToRight(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineheight;
		
		value = String.valueOf(gp.player.cha + "(+"+ gp.player.chaMOD+")");
		textX = getXforAlignToRight(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineheight;
		
		value = String.valueOf(gp.player.armorClass + gp.player.sheildValue);
		textX = getXforAlignToRight(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineheight;
		
		g2.drawImage(gp.player.currentWeapon.down1, tailX- 10 - gp.tileSize, textY, null);
		textY += gp.tileSize;
		g2.drawImage(gp.player.currentShield.down1, tailX- 10 - gp.tileSize, textY, null);		
	}
	public void drawInventory(){
		
		int frameX = gp.tileSize*9;
		int frameY = gp.tileSize;
		int frameWidth = gp.tileSize *6;
		int frameHeight = gp.tileSize *5;
		drawSubWindow ( frameX, frameY, frameWidth, frameHeight);
		
		final int slotXstart = frameX + 20;
		final int slotYstart = frameY + 20;
		int slotX = slotXstart;
		int slotY = slotYstart;
		
		for(int i = 0; i < gp.player.inventory.size(); i++) {
			
			g2.drawImage(gp.player.inventory.get(i).down1,slotX,slotY,null);
			slotX += gp.tileSize;
			
			if( i == 4 || i ==9 || i == 14) {
				slotX = slotXstart;
				slotY += gp.tileSize;
			}
		}
		
		//cursor 
		int cursorX = slotXstart + (gp.tileSize * slotCol);
		int cursorY = slotYstart + (gp.tileSize * slotRow);
		int cursorWidth = gp.tileSize;
		int cursorHeight = gp.tileSize;
		
		//draw the cursor
		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(3));
		g2.drawRoundRect (cursorX, cursorY, cursorWidth, cursorHeight, 10 , 10);
		
		
		int dFrameX = frameX +20;
		int dFrameY = frameY + gp.tileSize;
		int dFrameWidth = frameWidth;
		int dFrameHeight = gp.tileSize*3;
		
		int textX = dFrameX +20;
		int textY = dFrameY + gp.tileSize;
	}
public void drawSubWindow (int x , int y , int width , int height) {
		Color c = new Color (0 , 0 , 0, 210);
		g2.setColor(c);
		g2.fillRoundRect(x , y , width , height , 35 , 35);
		
		c = new Color ( 255 , 255 , 255);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x +5  , y+5 , width-10 , height-10 , 25 , 25);
	}
	public int getXforCenteredText(String text) {
		int length = (int)g2.getFontMetrics().getStringBounds(text , g2).getWidth();
		int x = gp.screenWidth/2 - length/2;
		return x;
	}
	public int getXforAlignToRight(String text, int tailX) {
		int length = (int)g2.getFontMetrics().getStringBounds(text , g2).getWidth();
		int x = tailX - length-10;
		return x;
	}
	
}
