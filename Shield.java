package backend;

public class Shield extends Items {
    private int defense;

    // A constructor that sets the name to N/A and the defense to 0.
    public Shield() {
        setName("N/A");
        defense = 0;
    }

    // A constructor that takes in a name and a defense value and sets the name and
    // defense of the
    // shield to those values.
    public Shield(String name, int def) {
        setName(name);
        setDefense(def);
    }

    /**
     * If the object is null, return 0, otherwise return the defense value
     * 
     * @return The defense of the shield.
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
