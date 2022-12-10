package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Shortsword_Normal extends Entity{
	public OBJ_Shortsword_Normal(GamePanel gp) {
		super(gp);
		
		name= "Shortsword";
		down1 = setup("/objects/shortsword");
		attackValue = "d8";
		
		descriptions= "[" + name + "]" + "An old Shortsword that was given to you. (does 1d8 damage)";
	}
}
