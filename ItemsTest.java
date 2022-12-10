package backend;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ItemsTest {

    @Test
    public void testGetName() {
        Items item = new Items("TestName");
        assertTrue(item.getName().equals("TestName"));
    }

    @Test
    public void testSetName() {
        Items item = new Items("TestName");
        item.setName("NameTest");
        assertTrue(item.getName().equals("NameTest"));
    }

    @Test
    public void testGetItem() {
        Items item = new Items("testName");
        assertTrue(item.getItem().equals(item));
    }
}
