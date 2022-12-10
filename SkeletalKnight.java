package backend;

public class SkeletalKnight extends Enemy {

    // This is the constructor for the SkeletalKnight class. It is called when a new
    // SkeletalKnight
    // object is created.
    public SkeletalKnight() {
        setHp(50);
        setMaxHp(50);
        setDefense(6);
        setDamage("d8");
        setEnemyType("Undead");
    }
}
