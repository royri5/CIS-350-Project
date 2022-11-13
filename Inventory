//import java.util.LinkedList;
//import java.io.*;
import java.util.*;

public class Inventory {
    
    private ArrayList<Items> inventory = new ArrayList<>();

    public ArrayList<Items> getInventory() {
        return inventory;
    }

    public void addToInventory(Items i) {
        inventory.add(i);
    }

    public void removeFromInventory(Items item) {
        for(int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).equals(item)) {
                inventory.remove(i);
            }
        }
    }

    public void printInv() {
        System.out.println(inventory);
    }

}
