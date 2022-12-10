package main;

import entity.NPC_Farmer;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;
/**
 * sets the assets that arent the player to game panel
 * @author jlb74
 *
 */
public class AssetSetter {
	GamePanel gp;
	/**
	 * setting assetsetter to gamepanel
	 */
	public AssetSetter (GamePanel gp) {
		this.gp = gp;
	}
	/**
	 * sets all the objects that are in the function
	 */
	public void setObject() {
		gp.obj[0] = new OBJ_Door(gp);
		gp.obj[0].worldX = gp.tileSize*21;
		gp.obj[0].worldY = gp.tileSize*22;
		/*
		gp.obj[1] = new OBJ_Key(gp);
		gp.obj[1].worldX = gp.tileSize*23;
		gp.obj[1].worldY = gp.tileSize*22;
		 */
	}
	/**
	 * sets all the npcs in the function 
	 */
	public void setNPC() {
		gp.npc[0] = new NPC_Farmer(gp);
		gp.npc[0].worldX = gp.tileSize*21;
		gp.npc[0].worldY = gp.tileSize*21;
	}
}
