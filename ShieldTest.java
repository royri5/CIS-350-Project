package backend;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ShieldTest {

    @Test
    public void testGetName() {
        Shield shield = new Shield("TestName", 0);
        assertTrue(shield.getName().equals("TestName"));
    }

    @Test
    public void testGetDefense() {
        Shield shield = new Shield("TestName", 0);
        assertTrue(shield.getDefense() == 0);
    }

    @Test
    public void testSetName() {
        Shield shield = new Shield("TestName", 0);
        shield.setName("NameTest");
        assertTrue(shield.getName().equals("NameTest"));
    }

    @Test
    public void testSetDefense() {
        Shield shield = new Shield("TestName", 0);
        shield.setDefense(10);
        assertTrue(shield.getDefense() == 10);
    }

    @Test
    public void testSetDefenseNegative() {
        Shield shield = new Shield("TestName", 10);
        shield.setDefense(-10);
        assertTrue(shield.getDefense() == 0);
    }
}
