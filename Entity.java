public class Entity {
    private int hp;
    private int maxhp;
    //private int level;
    private int defense;
    private String damage;

    //implement damage
    //private String damage;

    //base constructor
    public Entity() {
        setMaxHp(100);
        setHp(100);
        //setLevel(1);
        setDefense(0);
        setDamage("");
        
    }

    public Entity getEntity() {
        return this;
    }

    public int getHp() {
        return hp;
    }

    //set hp between 1 and max (cannot die from this)
    public void setHp(int newHp) {
        //checks if newHp is greater than maxhp
        //checks if newHp is at least 1
        if(newHp <= maxhp && newHp > 0) {
            hp = newHp;
        //in the case that newHp is greater than max
        //set hp to max
        } else if(newHp > maxhp) {
            hp = maxhp;
        //if newHp is less than 1 set hp to 1
        } else {
            hp = 1;
        }
    }

    public int getMaxHp() {
        return maxhp;
    }

    public void setMaxHp(int newMax) {
        //checks that newMax is a positive integer
        if(newMax > 0) {
            //as long as newMax is greater than the
            //current hp, update maxhp
            if(hp <= newMax) {
                maxhp = newMax;
            //if hp is greater than newMax
            //lower hp to meet the newMax
            } else {
                hp = newMax;
                maxhp = newMax;
            }
        } else {
            hp = 1;
            maxhp = 1;
        }
    }

    //method to be called in combatSystem
    public void takeDamage(int dmg) {
        //check if entity dies
        if(dmg < 0) {
            return;
        }
        if(hp - dmg > 0) {
            hp -= dmg;
        //entity dies
        } else {
            hp = 0;
            //TODO: implement player/enemy death
            //TODO: end combat(if 1v1)
        }
    }

    //method to be called in combatSystem
    public void gainHealth(int heal) {
        //checks if heal is negative or 0
        if(heal > 0) {
            //checks if heal goes over maxhp
            if(hp + heal <= maxhp) {
                hp += heal;
            //if healing goes over maxhp
            //hp sets to maxhp
            } else {
                hp = maxhp;
            }
        }

    }

    //may be removed
    //public int getLevel() {
    //    return level;
    //}

    //may be removed 
    /*public void setLevel(int newlvl) {
        //newlvl must be positive integer
        if(newlvl > 0) {
            level = newlvl;
        //if newlvl is not a positive integer
        //default to 1
        } else {
            level = 1;
        }
    }*/

    public int getDefense() {
        return defense;
    }

    public void setDefense(int newDef) {
        //newDef must be at least 0
        if(newDef >= 0) {
            defense = newDef;
        //if newDef is negative
        //default to 0
        } else {
            defense = 0;
        }
    }

    //may be unneeded
    //called when equipping armor/shields
    //called if buffs are implemented
    public void addDefense(int def) {
        //can't add 0 or negative defense
        if(def > 0) {
            defense += def;
        }
    }

    //may be unneeded
    //called when equipping/unequipping armor/shields
    //called if debuffs are implemented
    public void removeDefense(int def) {
        //defense cannot go lower than 0
            //TODO: (diff method/class) if debuffs are implemented
            //remove them upon end of combat to avoid exploits
        if(def < 0) {
            return;
        }
        if(defense - def >= 0) {
            defense -= def;
        //if defense is lowered below 0
        //default to 0
        } else {
            defense = 0;
        }
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String dmg) {
        switch(dmg) {
            case "d4": damage = "d4";
            break;
            case "d6": damage = "d6";
            break;
            case "d8": damage = "d8";
            break;
            case "d10": damage = "d10";
            break;
            case "d12": damage = "d12";
            break;
            default: damage = "";
            //remember to account for this in attacking
            break;
        }
    }

    







}