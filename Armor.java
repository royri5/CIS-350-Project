package backend;

public class Armor extends Items {

    // slot in which the armor goes on the player(Head, Body, Legs)
    private String slot;

    // defense value of the armor piece
    private int defense;

    // This is a default constructor. It is used to initialize the variables of the
    // class.
    public Armor() {
        setName("N/A");
        slot = "";
        defense = 0;
    }

    // This is a constructor that takes in 3 parameters and sets the name, slot, and
    // defense of the
    // armor.
    public Armor(String name, String s, int def) {
        setName(name);
        setSlot(s);
        setDefense(def);
    }

    /**
     * This function returns the slot of the armor
     * 
     * @return The slot variable is being returned.
     */
    public String getSlot() {
        return slot;
    }

    /**
     * If the string passed to the function is "Head", "Body", or "Legs", then set
     * the slot variable to
     * that string. Otherwise, set the slot variable to null
     * 
     * @param s The slot you want to set the item to.
     */
    public void setSlot(String s) {
        switch (s) {
            case "Head":
                slot = s;
                break;
            case "Body":
                slot = s;
                break;
            case "Legs":
                slot = s;
                break;
            default:
                slot = null;
                break;
        }
    }

    /**
     * If the object is null, return 0, otherwise return the defense value
     * 
     * @return The defense of the character.
     */
    public int getDefense() {
        if (this.equals(null)) {
            return 0;
        } else {
            return defense;
        }
    }

    /**
     * If the parameter is greater than or equal to 0, set the defense variable to
     * the parameter.
     * Otherwise, set the defense variable to 0
     * 
     * @param def The new defense value.
     */
    public void setDefense(int def) {
        if (def >= 0) {
            defense = def;
        } else {
            defense = 0;
        }
    }

}
