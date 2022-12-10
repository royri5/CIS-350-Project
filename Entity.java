package backend;

public class Entity {
    private int hp;
    private int maxhp;
    private int defense;
    private String damage;

    // This is the base constructor for the Entity class. It sets the max hp, hp,
    // defense, and damage
    // to default values.
    public Entity() {
        setMaxHp(100);
        setHp(100);
        setDefense(0);
        setDamage("");

    }

    /**
     * This function returns the entity that this component is attached to.
     * 
     * @return The Entity object.
     */
    public Entity getEntity() {
        return this;
    }

    /**
     * This function returns the value of the variable hp.
     * 
     * @return The value of the hp variable.
     */
    public int getHp() {
        return hp;
    }

    /**
     * If newHp is less than or equal to maxhp and greater than 0, set hp to newHp.
     * Otherwise, if newHp
     * is greater than maxhp, set hp to maxhp. Otherwise, set hp to 1
     * 
     * @param newHp the new hp value
     */
    public void setHp(int newHp) {
        // checks if newHp is greater than maxhp
        // checks if newHp is at least 1
        if (newHp <= maxhp && newHp > 0) {
            hp = newHp;
            // in the case that newHp is greater than max
            // set hp to max
        } else if (newHp > maxhp) {
            hp = maxhp;
            // if newHp is less than 1 set hp to 1
        } else {
            hp = 1;
        }
    }

    /**
     * This function returns the maxhp variable.
     * 
     * @return The maxhp variable is being returned.
     */
    public int getMaxHp() {
        return maxhp;
    }

    /**
     * If newMax is a positive integer, set maxhp to newMax, unless newMax is less
     * than hp, in which
     * case set hp to newMax
     * 
     * @param newMax the new maximum hp
     */
    public void setMaxHp(int newMax) {
        // checks that newMax is a positive integer
        if (newMax > 0) {
            // as long as newMax is greater than the
            // current hp, update maxhp
            if (hp <= newMax) {
                maxhp = newMax;
                // if hp is greater than newMax
                // lower hp to meet the newMax
            } else {
                hp = newMax;
                maxhp = newMax;
            }
        } else {
            hp = 1;
            maxhp = 1;
        }
    }

    // method to be called in combatSystem
    /**
     * If the damage is less than 0, return. If the damage is greater than the
     * entity's health, set the
     * entity's health to 0 and end combat. Otherwise, subtract the damage from the
     * entity's health
     * 
     * @param dmg the amount of damage to be taken
     */
    public void takeDamage(int dmg) {
        // check if entity dies
        if (dmg < 0) {
            return;
        }
        if (hp - dmg > 0) {
            hp -= dmg;
            // entity dies
        } else {
            hp = 0;
            // TODO: implement player/enemy death
            // TODO: end combat(if 1v1)
        }
    }

    // method to be called in combatSystem
    /**
     * If the heal is positive, then add the heal to the hp, but if the heal goes
     * over the maxhp, then
     * set the hp to the maxhp
     * 
     * @param heal the amount of health to be gained
     */
    public void gainHealth(int heal) {
        // checks if heal is negative or 0
        if (heal > 0) {
            // checks if heal goes over maxhp
            if (hp + heal <= maxhp) {
                hp += heal;
                // if healing goes over maxhp
                // hp sets to maxhp
            } else {
                hp = maxhp;
            }
        }

    }

    /**
     * @return int
     */
    // may be removed
    // public int getLevel() {
    // return level;
    // }

    // may be removed
    /*
     * public void setLevel(int newlvl) {
     * //newlvl must be positive integer
     * if(newlvl > 0) {
     * level = newlvl;
     * //if newlvl is not a positive integer
     * //default to 1
     * } else {
     * level = 1;
     * }
     * }
     */

    /**
     * This function returns the value of the defense variable.
     * 
     * @return The defense variable is being returned.
     */
    public int getDefense() {
        return defense;
    }

    /**
     * If the new defense value is greater than or equal to 0, set the defense to
     * the new value.
     * Otherwise, set the defense to 0
     * 
     * @param newDef the new defense value
     */
    public void setDefense(int newDef) {
        // newDef must be at least 0
        if (newDef >= 0) {
            defense = newDef;
            // if newDef is negative
            // default to 0
        } else {
            defense = 0;
        }
    }

    /**
     * @param def
     */
    // may be unneeded
    // called when equipping armor/shields
    // called if buffs are implemented
    /**
     * This function adds defense to the player, but only if the defense is greater
     * than 0.
     * 
     * @param def the amount of defense to add
     */
    public void addDefense(int def) {
        // can't add 0 or negative defense
        if (def > 0) {
            defense += def;
        }
    }

    // may be unneeded
    // called when equipping/unequipping armor/shields
    // called if debuffs are implemented
    /**
     * If the defense is lowered below 0, default to 0.
     * 
     * @param def the amount of defense to remove
     */
    public void removeDefense(int def) {
        // defense cannot go lower than 0
        // TODO: (diff method/class) if debuffs are implemented
        // remove them upon end of combat to avoid exploits
        if (def < 0) {
            return;
        }
        if (defense - def >= 0) {
            defense -= def;
            // if defense is lowered below 0
            // default to 0
        } else {
            defense = 0;
        }
    }

    /**
     * This function returns the damage of the entity
     * 
     * @return The damage of the entity.
     */
    public String getDamage() {
        return damage;
    }

    /**
     * If the string passed in is a valid damage type, set the damage type to that
     * string. Otherwise,
     * set the damage type to an empty string
     * 
     * @param dmg the damage die to be set
     */
    public void setDamage(String dmg) {
        switch (dmg) {
            case "d4":
                damage = "d4";
                break;
            case "d6":
                damage = "d6";
                break;
            case "d8":
                damage = "d8";
                break;
            case "d10":
                damage = "d10";
                break;
            case "d12":
                damage = "d12";
                break;
            default:
                damage = "";
                // remember to account for this in attacking
                break;
        }
    }

}
