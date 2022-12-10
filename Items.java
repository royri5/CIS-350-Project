package backend;

public class Items {
    private String name;

    // A constructor.
    public Items() {
        name = "N/A";
    }

    // A constructor that takes in a string and sets the name of the item to that
    // string.
    public Items(String name) {
        setName(name);
    }

    /**
     * This function returns the name of the item.
     * 
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * This function returns the current object.
     * 
     * @return The item object itself.
     */
    public Items getItem() {
        return this;
    }

    /**
     * If the name is null, set it to N/A, otherwise set it to the name.
     * 
     * @param n The name of the item
     */
    public void setName(String n) {
        if (n == null) {
            name = "N/A";
        } else {
            name = n;
        }
    }

}
