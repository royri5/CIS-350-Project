package entity;

import java.util.Random;

import main.GamePanel;

public class NPC_Farmer extends Entity {
	
	public NPC_Farmer(GamePanel gp) {
		super(gp);
		direction = "down"; 
		speed = 1;
		
		getImage();
		setDialouge();
	}
	public void getImage() {

		up1 = setup("/NPC/up1");
		up2 = setup("/NPC/up2");
		down1 = setup("/NPC/down1");
		down2 = setup("/NPC/down2");
		left1 = setup("/NPC/left1");
		left2 = setup("/NPC/left2");
		right1 = setup("/NPC/right1");
		right2 = setup("/NPC/right2");		
}
	public void setDialouge() {
		dialogues[0] = "Hey you there i need your help";
		dialogues[1] = "My boy has been taken by some goblins.  \nI need you to save him";
		dialogues[2] = "Do you have any equipment on you?";
	}
	public void setAction() {
		actionLockCounter ++;
		if (actionLockCounter == 120) {
			Random random = new Random();
			int i = random.nextInt(100)+1; //this picks a number from 1 to 100
			
			if(i <= 25) {
				direction = "up";
			}
			if( i > 25 && i <=50) {
				direction = "down";
			}
			if( i > 25 && i <=50) {
				direction = "left";
			}
			if( i > 25 && i <=50) {
				direction = "right";
			}
			actionLockCounter = 0;
		}
		
	}
	public void speak() {
		super.speak();
	}
}

