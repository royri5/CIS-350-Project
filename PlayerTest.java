import static org.junit.Assert.assertTrue;
import org.junit.Test;
public class PlayerTest {
    
    @Test
    public void testGetPlayer() {
        Player player = new Player();
        assertTrue(player.getPlayer().equals(player));
    }
}
