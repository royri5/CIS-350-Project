package backend;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class InventoryTest {

    @Test
    public void testGetInventoryAddToInventory() {
        Inventory inv = new Inventory();
        Items i = new Items("testItem");
        Items l = new Items("testItem2");
        inv.addToInventory(i);
        inv.addToInventory(l);
        assertTrue(inv.getInventory().get(0).getName().equals(i.getName()));
        assertTrue(inv.getInventory().get(1).getName().equals(l.getName()));
    }

    @Test
    public void testRemoveFromInventory() {
        Inventory inv = new Inventory();
        Items i = new Items("testItem");
        Items l = new Items("testItem2");
        inv.addToInventory(i);
        inv.addToInventory(l);
        inv.removeFromInventory(l);
        assertTrue(inv.getInventory().size() == 1);
    }

}
