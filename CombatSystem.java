package backend;

public class CombatSystem {

    /**
     * This function takes two entities and rolls a d20 to see if the first entity
     * can hit the second
     * entity. If it can, it rolls the damage dice of the first entity and deals
     * that damage to the
     * second entity
     * 
     * @param e1 the attacking entity
     * @param e2 the entity that is being attacked
     */
    public static void weaponAttack(Entity e1, Entity e2) {
        Dice dice = new Dice();
        // don't remember if d20 can be the same as def
        // update for crits
        if (dice.d20() >= e2.getDefense()) {
            dice.setDiceType(e1.getDamage());
            e2.takeDamage(dice.roll());
        }
    }

}
