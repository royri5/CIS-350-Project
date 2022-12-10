package backend;

public class Enemy extends Entity {
    private String enemyType;

    // This is the constructor for the Enemy class. It sets the default values for
    // the Enemy class.
    public Enemy() {
        setHp(100);
        setMaxHp(100);
        setDefense(0);
        setDamage("");
        setEnemyType("");

    }

    /**
     * This function returns the enemy type.
     * 
     * @return The enemyType variable is being returned.
     */
    public String getEnemyType() {
        return enemyType;
    }

    /**
     * If the type is one of the valid types, set the enemyType to that type.
     * Otherwise, set the
     * enemyType to null
     * 
     * @param type The type of enemy you want to create.
     */
    public void setEnemyType(String type) {
        switch (type) {
            case "Aberration":
                enemyType = "Aberration";
                break;
            case "Beast":
                enemyType = "Beast";
                break;
            case "Celestial":
                enemyType = "Celestial";
                break;
            case "Construct":
                enemyType = "Construct";
                break;
            case "Dragon":
                enemyType = "Dragon";
                break;
            case "Elemental":
                enemyType = "Elemental";
                break;
            case "Fey":
                enemyType = "Fey";
                break;
            case "Fiend":
                enemyType = "Fiend";
                break;
            case "Giant":
                enemyType = "Giant";
                break;
            case "Humanoid":
                enemyType = "Humanoid";
                break;
            case "Monstrosity":
                enemyType = "Monstrosity";
                break;
            case "Ooze":
                enemyType = "Ooze";
                break;
            case "Plant":
                enemyType = "Plant";
                break;
            case "Undead":
                enemyType = "Undead";
                break;
            default:
                enemyType = null;
                break;
        }
    }

}
