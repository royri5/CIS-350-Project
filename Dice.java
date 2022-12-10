package backend;

import java.util.Random;

public class Dice {
    private String diceType;

    // It's a constructor.
    public Dice() {

    }

    // It's a constructor.
    public Dice(String d) {
        diceType = d;
    }

    /**
     * This function returns the dice type
     * 
     * @return The diceType variable is being returned.
     */
    public String getDiceType() {
        return diceType;
    }

    /**
     * This function sets the dice type to the value of the parameter d
     * 
     * @param d The dice type.
     */
    public void setDiceType(String d) {
        diceType = d;
    }

    /**
     * @return int
     */
    // Should probably be only public (besides constructor/getDiceType, maybe
    // setDiceType for switching between two and one handed), covers all rolls
    /**
     * If the dice type is d4, return the result of the d4 function, else if the
     * dice type is d6,
     * return the result of the d6 function, etc
     * 
     * @return A random number between 1 and the number of sides on the dice.
     */
    public int roll() {
        if (this.getDiceType().equals("d4")) {
            return d4();
        } else if (this.getDiceType().equals("d6")) {
            return d6();
        } else if (this.getDiceType().equals("d8")) {
            return d8();
        } else if (this.getDiceType().equals("d10")) {
            return d10();
        } else if (this.getDiceType().equals("d12")) {
            return d12();
        } else if (this.getDiceType().equals("d20")) {
            return d20();
        } else if (this.getDiceType().equals("d100")) {
            return d100();
        } else {
            // unarmed
            return 1;
        }
    }

    /**
     * This function returns a random number between 1 and 4.
     * 
     * @return A random number between 1 and 4
     */
    public int d4() {
        Random n = new Random();
        return n.nextInt(1, 4);
    }

    /**
     * The function d6() returns a random number between 1 and 6.
     * 
     * @return A random number between 1 and 6.
     */
    public int d6() {
        Random n = new Random();
        return n.nextInt(1, 6);
    }

    /**
     * > This function returns a random number between 1 and 8
     * 
     * @return A random number between 1 and 8
     */
    public int d8() {
        Random n = new Random();
        return n.nextInt(1, 8);
    }

    /**
     * This function returns a random number between 0 and 10.
     * 
     * @return A random number between 0 and 10.
     */
    public int d10() {
        Random n = new Random();
        return n.nextInt(0, 10);
    }

    /**
     * This function returns a random number between 1 and 12.
     * 
     * @return A random number between 1 and 12.
     */
    public int d12() {
        Random n = new Random();
        return n.nextInt(1, 12);
    }

    /**
     * This function returns a random number between 1 and 20.
     * 
     * @return A random number between 1 and 20.
     */
    public int d20() {
        Random n = new Random();
        return n.nextInt(1, 20);
    }

    /**
     * This function returns a random number between 0 and 100.
     * 
     * @return A random number between 0 and 100
     */
    public int d100() {
        Random n = new Random();
        return n.nextInt(0, 100);
    }

}
