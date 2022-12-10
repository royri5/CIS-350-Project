package backend;

public class Weapon extends Items {

    private String damage;

    // This is a constructor. It is used to create an object of the class.
    public Weapon() {
        setName("N/A");
        setDamage(null);
    }

    // A constructor. It is used to create an object of the class.
    public Weapon(String name, String dmg) {
        setName(name);
        setDamage(dmg);
    }

    // may not be needed
    // public String getWeaponType() {
    // return weaponType;
    // }

    // ^
    // public void setWeaponType(String wT) {
    // weaponType = wT;
    // }

    /**
     * If the object is null, return null, otherwise return the damage
     * 
     * @return The damage of the weapon.
     */
    public String getDamage() {
        if (this.equals(null)) {
            return null;
        } else {
            return damage;
        }
    }

    /**
     * If the parameter is a valid damage type, set the damage type to the
     * parameter. Otherwise, set
     * the damage type to null
     * 
     * @param dmg The damage dice to be set.
     */
    public void setDamage(String dmg) {
        switch (dmg) {
            case "d4":
                damage = dmg;
                break;
            case "d6":
                damage = dmg;
                break;
            case "d8":
                damage = dmg;
                break;
            case "d10":
                damage = dmg;
                break;
            case "d12":
                damage = dmg;
                break;
            default:
                damage = null;
                break;
        }
    }

}
