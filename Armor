public class Armor extends Items {

    //slot in which the armor goes on the player(Head, Body, Legs)
    private String slot;

    //defense value of the armor piece
    private int defense;

    //default constructor
    public Armor() {
        setName("N/A");
        slot = "";
        defense = 0;
    }

    //constructor
    public Armor(String name, String s, int def) {
        setName(name);
        setSlot(s);
        setDefense(def);
    }

    //getter for slot variable
    public String getSlot() {
        return slot;
    }

    //setter for slot variable
    public void setSlot(String s) {
        switch(s) {
            case "Head": slot = s;
            break;
            case "Body": slot = s;
            break;
            case "Legs": slot = s;
            break;
            default: slot = null;
            break;
        } 
    }

    //getter for defense variable
    public int getDefense() {
        if(this.equals(null)) {
            return 0;
        } else {
            return defense;
        }
    }

    //setter for defense variable
    public void setDefense(int def) {
        if(def >= 0) {
            defense = def;
        } else {
            defense = 0;
        }
    }


    
}
