import static org.junit.Assert.assertTrue;
import org.junit.Test;
public class EntityTest {
    
    @Test
    public void testGetEntity() {
        Entity entity = new Entity();
        assertTrue(entity.getEntity().equals(entity));
    }

    @Test
    public void testGetHp() {
        Entity entity = new Entity();
        assertTrue(entity.getHp() == 100);
    }

    @Test
    public void testSetHp() {
        Entity entity = new Entity();
        entity.setHp(50);
        assertTrue(entity.getHp() == 50);
    }

    @Test
    public void testSetHpGreater() {
        Entity entity = new Entity();
        entity.setHp(101);
        assertTrue(entity.getHp() == 100);
    }

    @Test
    public void testSetHpLower() {
        Entity entity = new Entity();
        entity.setHp(0);
        assertTrue(entity.getHp() == 1);
    }

    @Test
    public void testGetMaxHp() {
        Entity entity = new Entity();
        assertTrue(entity.getMaxHp() == 100);
    }

    @Test
    public void testSetMaxHp() {
        Entity entity = new Entity();
        entity.setMaxHp(50);
        assertTrue(entity.getHp() == 50);
        assertTrue(entity.getMaxHp() == 50);
    }

    @Test
    public void testSetMaxHpGreater() {
        Entity entity = new Entity();
        entity.setMaxHp(150);
        assertTrue(entity.getHp() == 100);
        assertTrue(entity.getMaxHp() == 150);
    }

    @Test
    public void testSetMaxHpLower() {
        Entity entity = new Entity();
        entity.setMaxHp(0);
        assertTrue(entity.getHp() == 1);
        assertTrue(entity.getMaxHp() == 1);
    }

    @Test
    public void testTakeDamage() {
        Entity entity = new Entity();
        entity.takeDamage(5);
        assertTrue(entity.getHp() == 95);
        assertTrue(entity.getMaxHp() == 100);
    }

    @Test
    public void testTakeDamageNegative() {
        Entity entity = new Entity();
        entity.takeDamage(-5);
        assertTrue(entity.getHp() == 100);
        assertTrue(entity.getMaxHp() == 100);
    }

    @Test
    public void testTakeDamageDeath() {
        Entity entity = new Entity();
        entity.takeDamage(100);
        assertTrue(entity.getHp() == 0);
        assertTrue(entity.getMaxHp() == 100);
    }

    @Test
    public void testGainHealthNothing() {
        Entity entity = new Entity();
        entity.gainHealth(5);
        assertTrue(entity.getHp() == 100);
        assertTrue(entity.getMaxHp() == 100);
    }

    @Test
    public void testGainHealth() {
        Entity entity = new Entity();
        entity.takeDamage(20);
        entity.gainHealth(5);
        assertTrue(entity.getHp() == 85);
        assertTrue(entity.getMaxHp() == 100);
    }

    @Test
    public void testGainHealthNegative() {
        Entity entity = new Entity();
        entity.takeDamage(20);
        entity.gainHealth(-5);
        assertTrue(entity.getHp() == 80);
        assertTrue(entity.getMaxHp() == 100);
    }

    @Test
    public void testGetDefense() {
        Entity entity = new Entity();
        assertTrue(entity.getDefense() == 0);
    }

    @Test
    public void testSetDefense() {
        Entity entity = new Entity();
        entity.setDefense(10);
        assertTrue(entity.getDefense() == 10);
    }

    @Test
    public void testSetDefenseNegative() {
        Entity entity = new Entity();
        entity.setDefense(-1);
        assertTrue(entity.getDefense() == 0);
    }

    @Test
    public void testAddDefense1() {
        Entity entity = new Entity();
        entity.addDefense(5);
        assertTrue(entity.getDefense() == 5);
    }

    @Test
    public void testAddDefense2() {
        Entity entity = new Entity();
        entity.addDefense(5);
        entity.addDefense(5);
        assertTrue(entity.getDefense() == 10);
    }

    @Test
    public void testAddDefenseNegative1() {
        Entity entity = new Entity();
        entity.addDefense(-5);
        assertTrue(entity.getDefense() == 0);
    }

    @Test
    public void testAddDefenseNegative2() {
        Entity entity = new Entity();
        entity.addDefense(10);
        entity.addDefense(-5);
        assertTrue(entity.getDefense() == 10);
    }

    @Test
    public void testRemoveDefense1() {
        Entity entity = new Entity();
        entity.removeDefense(5);
        assertTrue(entity.getDefense() == 0);
    }

    @Test
    public void testRemoveDefense2() {
        Entity entity = new Entity();
        entity.addDefense(10);
        entity.removeDefense(5);
        assertTrue(entity.getDefense() == 5);
    }

    @Test
    public void testRemoveDefenseNegative() {
        Entity entity = new Entity();
        entity.addDefense(10);
        entity.removeDefense(-5);
        assertTrue(entity.getDefense() == 10);
    }

    @Test
    public void testRemoveDefenseGreater() {
        Entity entity = new Entity();
        entity.addDefense(100);
        entity.removeDefense(101);
        assertTrue(entity.getDefense() == 0);
    }

    @Test
    public void testGetDamage() {
        Entity entity = new Entity();
        assertTrue(entity.getDamage().equals(""));
    }

    @Test
    public void testSetDamaged4() {
        Entity entity = new Entity();
        entity.setDamage("d4");
        assertTrue(entity.getDamage().equals("d4"));
    }

    @Test
    public void testSetDamaged6() {
        Entity entity = new Entity();
        entity.setDamage("d6");
        assertTrue(entity.getDamage().equals("d6"));
    }

    @Test
    public void testSetDamaged8() {
        Entity entity = new Entity();
        entity.setDamage("d8");
        assertTrue(entity.getDamage().equals("d8"));
    }

    @Test
    public void testSetDamaged10() {
        Entity entity = new Entity();
        entity.setDamage("d10");
        assertTrue(entity.getDamage().equals("d10"));
    }

    @Test
    public void testSetDamaged12() {
        Entity entity = new Entity();
        entity.setDamage("d12");
        assertTrue(entity.getDamage().equals("d12"));
    }

    @Test
    public void testSetDamageBadInput() {
        Entity entity = new Entity();
        entity.setDamage("d3");
        assertTrue(entity.getDamage().equals(""));
    }

}
