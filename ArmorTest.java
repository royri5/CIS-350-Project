package backend;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ArmorTest {

    @Test
    public void testGetSlotHead() {
        Armor armor = new Armor("HeadTest", "Head", 0);
        assertTrue(armor.getSlot().equals("Head"));
    }

    @Test
    public void testGetSlotBody() {
        Armor armor = new Armor("BodyTest", "Body", 0);
        assertTrue(armor.getSlot().equals("Body"));
    }

    @Test
    public void testGetSlotLegs() {
        Armor armor = new Armor("LegsTest", "Legs", 0);
        assertTrue(armor.getSlot().equals("Legs"));
    }

    @Test
    public void testGetName() {
        Armor armor = new Armor("TestName", "Head", 0);
        assertTrue(armor.getName().equals("TestName"));
    }

    @Test
    public void testGetDefense() {
        Armor armor = new Armor("TestName", "Head", 0);
        assertTrue(armor.getDefense() == 0);
    }

    @Test
    public void testSetSlotHead() {
        Armor armor = new Armor("TestName", "Body", 0);
        armor.setSlot("Head");
        assertTrue(armor.getSlot().equals("Head"));
    }

    @Test
    public void testSetSlotBody() {
        Armor armor = new Armor("TestName", "Head", 0);
        armor.setSlot("Body");
        assertTrue(armor.getSlot().equals("Body"));
    }

    @Test
    public void testSetSlotLegs() {
        Armor armor = new Armor("TestName", "Body", 0);
        armor.setSlot("Legs");
        assertTrue(armor.getSlot().equals("Legs"));
    }

    @Test
    public void testSetSlotnull() {
        Armor armor = new Armor("TestName", "Body", 0);
        armor.setSlot("Gloves");
        assertTrue(armor.getSlot() == null);
    }

    @Test
    public void testSetName() {
        Armor armor = new Armor("TestName", "Head", 0);
        armor.setName("NameTest");
        assertTrue(armor.getName().equals("NameTest"));
    }

    @Test
    public void testSetDefense() {
        Armor armor = new Armor("TestName", "Head", 0);
        armor.setDefense(10);
        assertTrue(armor.getDefense() == 10);
    }

    @Test
    public void testSetDefenseNegative() {
        Armor armor = new Armor("TestName", "Head", 10);
        armor.setDefense(-10);
        assertTrue(armor.getDefense() == 0);
    }

}
