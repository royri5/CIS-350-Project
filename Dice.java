import java.util.Random;

public class Dice {
    private String diceType;

    public Dice() {

    }

    public Dice(String d) {
        diceType = d;
    }

    public String getDiceType() {
        return diceType;
    }

    public void setDiceType(String d) {
        diceType = d;
    }

    //Should probably be only public (besides constructor/getDiceType, maybe setDiceType for switching between two and one handed), covers all rolls
    public int roll() {
        if(this.getDiceType().equals("d4")) {
            return d4();
        } else if(this.getDiceType().equals("d6")) {
            return d6();
        } else if(this.getDiceType().equals("d8")) {
            return d8();
        } else if(this.getDiceType().equals("d10")) {
            return d10();
        } else if(this.getDiceType().equals("d12")) {
            return d12();
        } else if(this.getDiceType().equals("d20")) {
            return d20();
        } else if(this.getDiceType().equals("d100")) {
            return d100();
        } else {
            //unarmed
            return 1;
        }
    }

    /**
     * Returns an integer between 1 and 4
     * @return int
     */
    public int d4() {
        Random n = new Random();
        return n.nextInt(1, 4);
    }

    /**
     * Returns an integer between 1 and 6
     * @return int
     */
    public int d6() {
        Random n = new Random();
        return n.nextInt(1, 6);
    }

    /**
     * Returns an integer between 1 and 8
     * @return int
     */
    public int d8() {
        Random n = new Random();
        return n.nextInt(1,8);
    }

    /**
     * Returns an integer between 0 and 10
     * @return int
     */
    public int d10() {
        Random n = new Random();
        return n.nextInt(0, 10);
    }

    /**
     * Returns an integer between 1 and 12
     * @return int
     */
    public int d12() {
        Random n = new Random();
        return n.nextInt(1, 12);
    }

    /**
     * Returns an integer between 1 and 20
     * @return int
     */
    public int d20() {
        Random n = new Random();
        return n.nextInt(1, 20);
    }

    /**
     * Returns an integer between 0 and 100
     * @return int
     */
    public int d100() {
        Random n = new Random();
        return n.nextInt(0, 100);
    }

    
    
}