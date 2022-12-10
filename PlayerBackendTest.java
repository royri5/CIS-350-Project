package backend;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PlayerBackendTest {

    @Test
    public void testGetPlayer() {
        PlayerBackend player = new PlayerBackend();
        assertTrue(player.getPlayer().equals(player));
    }

    @Test
    public void testEquipArmorHeadNoHead() {
        PlayerBackend player = new PlayerBackend();
        Inventory inv = new Inventory();
        inv.addToInventory(ArmorList.plateHead);
        player.equipArmor(((Armor) inv.getInventory().get(0)), inv);
        assertTrue(player.getDefense() == 4);
        assertTrue(inv.getInventory().size() == 0);

    }

    @Test
    public void testEquipArmorHeadYesHead() {
        PlayerBackend player = new PlayerBackend();
        Inventory inv = new Inventory();
        inv.addToInventory(ArmorList.plateHead);
        player.setHead(ArmorList.leatherHead);
        player.equipArmor(((Armor) inv.getInventory().get(0)), inv);
        assertTrue(player.getDefense() == 4);
        assertTrue(inv.getInventory().get(0).getName().equals("Leather Cap"));

    }

    @Test
    public void testUnequipArmor() {
        PlayerBackend player = new PlayerBackend();
        Inventory inv = new Inventory();
        player.setHead(ArmorList.plateHead);
        player.unequipArmor(player.getHead(), inv);
        assertTrue(inv.getInventory().get(0).getName().equals("Plate Helm"));
        assertTrue(player.getDefense() == 0);
    }

    @Test
    public void testUnequipNothing() {
        PlayerBackend player = new PlayerBackend();
        Inventory inv = new Inventory();
        player.unequipArmor(ArmorList.chainHead, inv);
        assertTrue(inv.getInventory().size() == 0);
        assertTrue(player.getDefense() == 0);
    }

    @Test
    public void testEquipWeapon() {
        PlayerBackend player = new PlayerBackend();
        Inventory inv = new Inventory();
        inv.addToInventory(WeaponList.greatSword);
        player.setWeapon(WeaponList.longSword);
        player.equipWeapon((Weapon) inv.getInventory().get(0), inv);
        assertTrue(inv.getInventory().size() == 1);
        assertTrue(player.getDamage().equals("d12"));
    }

    @Test
    public void testUnequipWeapon() {
        PlayerBackend player = new PlayerBackend();
        Inventory inv = new Inventory();
        player.setWeapon(WeaponList.longSword);
        player.unequipWeapon(player.getWeapon(), inv);
        assertTrue(inv.getInventory().size() == 1);
        assertTrue(player.getDamage().equals(""));
    }

    @Test
    public void testEquipShield() {
        PlayerBackend player = new PlayerBackend();
        Inventory inv = new Inventory();
        inv.addToInventory(ShieldsList.greatShield);
        player.setShield(ShieldsList.kiteShield);
        player.equipShield((Shield) inv.getInventory().get(0), inv);
        assertTrue(inv.getInventory().size() == 1);
        assertTrue(player.getDefense() == 5);
    }

    @Test
    public void testUnequipShield() {
        PlayerBackend player = new PlayerBackend();
        Inventory inv = new Inventory();
        player.setShield(ShieldsList.kiteShield);
        player.unequipShield(player.getShield(), inv);
        assertTrue(inv.getInventory().size() == 1);
        assertTrue(player.getDefense() == 0);
    }

    @Test
    public void testGetHead() {
        PlayerBackend player = new PlayerBackend();
        player.setHead(ArmorList.chainHead);
        assertTrue(player.getHead().equals(ArmorList.chainHead));
    }

    @Test
    public void testGetBody() {
        PlayerBackend player = new PlayerBackend();
        player.setBody(ArmorList.chainBody);
        assertTrue(player.getBody().equals(ArmorList.chainBody));
    }

    @Test
    public void testGetLegs() {
        PlayerBackend player = new PlayerBackend();
        player.setLegs(ArmorList.chainLegs);
        assertTrue(player.getLegs().equals(ArmorList.chainLegs));
    }

    @Test
    public void testGetWeapon() {
        PlayerBackend player = new PlayerBackend();
        player.setWeapon(WeaponList.greatSword);
        assertTrue(player.getWeapon().equals(WeaponList.greatSword));
    }

    @Test
    public void testGetShield() {
        PlayerBackend player = new PlayerBackend();
        player.setShield(ShieldsList.greatShield);
        assertTrue(player.getShield().equals(ShieldsList.greatShield));
    }

    @Test
    public void testSetHead1() {
        PlayerBackend player = new PlayerBackend();
        player.setHead(ArmorList.plateHead);
        assertTrue(player.getDefense() == 4);
    }

    @Test
    public void testSetHead2() {
        PlayerBackend player = new PlayerBackend();
        player.setHead(ArmorList.leatherHead);
        player.setHead(ArmorList.plateHead);
        assertTrue(player.getDefense() == 4);
    }

    @Test
    public void testSetBody1() {
        PlayerBackend player = new PlayerBackend();
        player.setBody(ArmorList.plateBody);
        assertTrue(player.getDefense() == 4);
    }

    @Test
    public void testSetBody2() {
        PlayerBackend player = new PlayerBackend();
        player.setBody(ArmorList.leatherBody);
        player.setBody(ArmorList.plateBody);
        assertTrue(player.getDefense() == 4);
    }

    @Test
    public void testSetLegs1() {
        PlayerBackend player = new PlayerBackend();
        player.setLegs(ArmorList.plateLegs);
        assertTrue(player.getDefense() == 4);
    }

    @Test
    public void testSetLegs2() {
        PlayerBackend player = new PlayerBackend();
        player.setLegs(ArmorList.leatherLegs);
        player.setLegs(ArmorList.plateLegs);
        assertTrue(player.getDefense() == 4);
    }

    @Test
    public void testSetWeapon1() {
        PlayerBackend player = new PlayerBackend();
        player.setWeapon(WeaponList.greatSword);
        assertTrue(player.getDamage().equals("d12"));
    }

    @Test
    public void testSetWeapon2() {
        PlayerBackend player = new PlayerBackend();
        player.setWeapon(WeaponList.woodenSword);
        player.setWeapon(WeaponList.greatSword);
        assertTrue(player.getDamage().equals("d12"));
    }

    @Test
    public void testSetShield1() {
        PlayerBackend player = new PlayerBackend();
        player.setShield(ShieldsList.greatShield);
        assertTrue(player.getDefense() == 5);
    }

    @Test
    public void testSetShield2() {
        PlayerBackend player = new PlayerBackend();
        player.setShield(ShieldsList.plankShield);
        player.setShield(ShieldsList.greatShield);
        assertTrue(player.getDefense() == 5);
    }

}
