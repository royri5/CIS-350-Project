import static org.junit.Assert.assertTrue;
import org.junit.Test;
public class EnemyTest {
    
    @Test
    public void testGetEnemyType() {
        Enemy enemy = new Enemy();
        assertTrue(enemy.getEnemyType() == null);
    }

    @Test
    public void testGetEnemyTypeAberration() {
        Enemy enemy = new Enemy();
        enemy.setEnemyType("Aberration");
        assertTrue(enemy.getEnemyType().equals("Aberration"));
    }

    @Test
    public void testGetEnemyTypeBeast() {
        Enemy enemy = new Enemy();
        enemy.setEnemyType("Beast");
        assertTrue(enemy.getEnemyType().equals("Beast"));
    }

    @Test
    public void testGetEnemyTypeCelestial() {
        Enemy enemy = new Enemy();
        enemy.setEnemyType("Celestial");
        assertTrue(enemy.getEnemyType().equals("Celestial"));
    }

    @Test
    public void testGetEnemyTypeConstruct() {
        Enemy enemy = new Enemy();
        enemy.setEnemyType("Construct");
        assertTrue(enemy.getEnemyType().equals("Construct"));
    }

    @Test
    public void testGetEnemyTypeDragon() {
        Enemy enemy = new Enemy();
        enemy.setEnemyType("Dragon");
        assertTrue(enemy.getEnemyType().equals("Dragon"));
    }

    @Test
    public void testGetEnemyTypeElemental() {
        Enemy enemy = new Enemy();
        enemy.setEnemyType("Elemental");
        assertTrue(enemy.getEnemyType().equals("Elemental"));
    }

    @Test
    public void testGetEnemyTypeFey() {
        Enemy enemy = new Enemy();
        enemy.setEnemyType("Fey");
        assertTrue(enemy.getEnemyType().equals("Fey"));
    }

    @Test
    public void testGetEnemyTypeFiend() {
        Enemy enemy = new Enemy();
        enemy.setEnemyType("Fiend");
        assertTrue(enemy.getEnemyType().equals("Fiend"));
    }

    @Test
    public void testGetEnemyTypeGiant() {
        Enemy enemy = new Enemy();
        enemy.setEnemyType("Giant");
        assertTrue(enemy.getEnemyType().equals("Giant"));
    }

    @Test
    public void testGetEnemyTypeHumanoid() {
        Enemy enemy = new Enemy();
        enemy.setEnemyType("Humanoid");
        assertTrue(enemy.getEnemyType().equals("Humanoid"));
    }

    @Test
    public void testGetEnemyTypeMonstrosity() {
        Enemy enemy = new Enemy();
        enemy.setEnemyType("Monstrosity");
        assertTrue(enemy.getEnemyType().equals("Monstrosity"));
    }

    @Test
    public void testGetEnemyTypeOoze() {
        Enemy enemy = new Enemy();
        enemy.setEnemyType("Ooze");
        assertTrue(enemy.getEnemyType().equals("Ooze"));
    }

    @Test
    public void testGetEnemyTypePlant() {
        Enemy enemy = new Enemy();
        enemy.setEnemyType("Plant");
        assertTrue(enemy.getEnemyType().equals("Plant"));
    }

    @Test
    public void testGetEnemyTypeUndead() {
        Enemy enemy = new Enemy();
        enemy.setEnemyType("Undead");
        assertTrue(enemy.getEnemyType().equals("Undead"));
    }

    @Test
    public void testGetEnemyTypeWrongType() {
        Enemy enemy = new Enemy();
        enemy.setEnemyType("Human");
        assertTrue(enemy.getEnemyType() == null);
    }

    @Test
    public void testSetEnemyType() {
        Enemy enemy = new Enemy();
        enemy.setEnemyType("Plant");
        enemy.setEnemyType("Undead");
        assertTrue(enemy.getEnemyType().equals("Undead"));
    }
}
