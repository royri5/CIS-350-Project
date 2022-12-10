package backend;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DiceTest {

    @Test
    public void testd4() {
        Dice d = new Dice("d4");
        int x = d.roll();
        assertTrue(x >= 1 && x <= 4);
        System.out.println("d4: " + x);
    }

    @Test
    public void testd6() {
        Dice d = new Dice("d6");
        int x = d.roll();
        assertTrue(x >= 1 && x <= 6);
        System.out.println("d6: " + x);
    }

    @Test
    public void testd8() {
        Dice d = new Dice("d8");
        int x = d.roll();
        assertTrue(x >= 1 && x <= 8);
        System.out.println("d8: " + x);
    }

    @Test
    public void testd10() {
        Dice d = new Dice("d10");
        int x = d.roll();
        assertTrue(x >= 0 && x <= 10);
        System.out.println("d10: " + x);
    }

    @Test
    public void testd12() {
        Dice d = new Dice("d12");
        int x = d.roll();
        assertTrue(x >= 1 && x <= 12);
        System.out.println("d12: " + x);
    }

    @Test
    public void testd20() {
        Dice d = new Dice("d20");
        int x = d.roll();
        assertTrue(x >= 1 && x <= 20);
        System.out.println("d20: " + x);
    }

    @Test
    public void testd100() {
        Dice d = new Dice("d100");
        int x = d.roll();
        assertTrue(x >= 0 && x <= 100);
        System.out.println("d100: " + x);
    }
}
