public class CombatSystem {

    //temp for testing
    public void weaponAttack(Entity e1, Entity e2) {
        Dice dice = new Dice();
        //Dice playerDamage = new Dice(p.getWeapon().getDamage());
        //don't remember if d20 can be the same as def
        //update for crits
        if(dice.d20() >= e2.getDefense()) {
            dice.setDiceType(e1.getDamage());
            e2.takeDamage(dice.roll());
        }
    }
    //TODO: add damage to entity class
    //player damage is weapon damage (or bare hands damage)
    //enemy damage is based on the invididual (claws, sword, fire, etc.)


}
