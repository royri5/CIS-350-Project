public class Weapon extends Items {
    //Weapon types: Sword, Axe, etc.

    //may not be needed
    //private String weaponType;
    private String damage;

    public Weapon() {
        setName("N/A");
        //weaponType = "N/A";
        setDamage(null);
    }

    public Weapon(String name, String dmg) {
        setName(name);
        //weaponType = wT;
        setDamage(dmg);
    }

    //may not be needed
    //public String getWeaponType() {
    //    return weaponType;
    //}

    //^
    //public void setWeaponType(String wT) {
    //    weaponType = wT;
    //}

    public String getDamage() {
        if(this.equals(null)) {
            return null;
        } else {
            return damage;
        }
    }

    public void setDamage(String dmg) {
        switch(dmg) {
            case "d4": damage = dmg; 
            break;
            case "d6": damage = dmg;
            break;
            case "d8": damage = dmg;
            break;
            case "d10": damage = dmg;
            break;
            case "d12": damage = dmg;
            break;
            default: damage = null;
            break;
        }
    }

}
