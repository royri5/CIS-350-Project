public class Enemy extends Entity{
    private String enemyType;

    public Enemy() {
        setHp(100);
        setMaxHp(100);
        //setLevel(1);
        setDefense(0);
        setDamage("");
        setEnemyType("");

    }

    public String getEnemyType() {
        return enemyType;
    }
    
    //may be unecessary/phased out
    public void setEnemyType(String type) {
        switch(type) {
            case "Aberration": enemyType = "Aberration";
            break;
            case "Beast": enemyType = "Beast";
            break;
            case "Celestial": enemyType = "Celestial";
            break;
            case "Construct": enemyType = "Construct";
            break;
            case "Dragon": enemyType = "Dragon";
            break;
            case "Elemental": enemyType = "Elemental";
            break;
            case "Fey": enemyType = "Fey";
            break;
            case "Fiend": enemyType = "Fiend";
            break;
            case "Giant": enemyType = "Giant";
            break;
            case "Humanoid": enemyType = "Humanoid";
            break;
            case "Monstrosity": enemyType = "Monstrosity";
            break;
            case "Ooze": enemyType = "Ooze";
            break;
            case "Plant": enemyType = "Plant";
            break;
            case "Undead": enemyType = "Undead";
            break;
            default: enemyType = null;
            break;
        }
    }

    //TODO: Make a few basic enemy classes, goblin, slime, skeleton, etc.
    //TODO: (Enemy A.I.) for wandering, rng distance
    //for pacing, rng pacing directing, check tiles
    //once player character is in view, (updating by ticks)
    //path toward them (slightly faster than player speed)
    //after ___ amount of time, return to spawn tile
    //via walking
    //if player leaves room, despawn
    //if player enters room, spawn (micro load screen)

}