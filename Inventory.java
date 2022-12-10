package backend;

import java.util.*;

public class Inventory {

    private ArrayList<Items> inventory = new ArrayList<>();

    /**
     * @return ArrayList<Items>
     */
    public ArrayList<Items> getInventory() {
        return inventory;
    }

    /**
     * @param i
     */
    public void addToInventory(Items i) {
        inventory.add(i);
    }

    /**
     * @param item
     */
    public void removeFromInventory(Items item) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).equals(item)) {
                inventory.remove(i);
            }
        }
    }

}
