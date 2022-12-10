package backend;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class WeaponTest {

    @Test
    public void testGetName() {
        Weapon weapon = new Weapon("TestName", "d8");
        assertTrue(weapon.getName().equals("TestName"));
    }

    @Test
    public void testSetName() {
        Weapon weapon = new Weapon("TestName", "d8");
        weapon.setName("NameTest");
        assertTrue(weapon.getName().equals("NameTest"));
    }

    @Test
    public void testGetDamaged4() {
        Weapon weapon = new Weapon("TestName", "d4");
        assertTrue(weapon.getDamage().equals("d4"));
    }

    @Test
    public void testSetDamaged4() {
        Weapon weapon = new Weapon("TestName", "d6");
        weapon.setDamage("d4");
        assertTrue(weapon.getDamage().equals("d4"));
    }

    @Test
    public void testGetDamaged6() {
        Weapon weapon = new Weapon("TestName", "d6");
        assertTrue(weapon.getDamage().equals("d6"));
    }

    @Test
    public void testSetDamaged6() {
        Weapon weapon = new Weapon("TestName", "d4");
        weapon.setDamage("d6");
        assertTrue(weapon.getDamage().equals("d6"));
    }

    @Test
    public void testGetDamaged8() {
        Weapon weapon = new Weapon("TestName", "d4");
        assertTrue(weapon.getDamage().equals("d4"));
    }

    @Test
    public void testSetDamaged8() {
        Weapon weapon = new Weapon("TestName", "d4");
        weapon.setDamage("d8");
        assertTrue(weapon.getDamage().equals("d8"));
    }

    @Test
    public void testGetDamaged10() {
        Weapon weapon = new Weapon("TestName", "d10");
        assertTrue(weapon.getDamage().equals("d10"));
    }

    @Test
    public void testSetDamaged10() {
        Weapon weapon = new Weapon("TestName", "d4");
        weapon.setDamage("d10");
        assertTrue(weapon.getDamage().equals("d10"));
    }

    @Test
    public void testGetDamaged12() {
        Weapon weapon = new Weapon("TestName", "d12");
        assertTrue(weapon.getDamage().equals("d12"));
    }

    @Test
    public void testSetDamaged12() {
        Weapon weapon = new Weapon("TestName", "d4");
        weapon.setDamage("d12");
        assertTrue(weapon.getDamage().equals("d12"));
    }

}
