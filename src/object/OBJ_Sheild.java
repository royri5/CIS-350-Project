package object;
import entity.Entity;
import main.GamePanel;

public class OBJ_Sheild extends Entity {
	
	public OBJ_Sheild(GamePanel gp) {
		super(gp);
		
		name = "Sheild";
		down1 = setup("/objects/shield_wood");
		sheildValue = 2;
	}

	
	
}
