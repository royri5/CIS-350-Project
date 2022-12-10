package backend;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CombatSystemTest {

    @Test
    public void testWeaponAttack() {

        PlayerBackend p = new PlayerBackend();

        Enemy e = new SkeletalKnight();

        p.setHead(ArmorList.plateHead);
        p.setBody(ArmorList.plateBody);
        p.setLegs(ArmorList.plateLegs);
        p.setShield(ShieldsList.greatShield);
        p.setWeapon(WeaponList.greatSword);
        CombatSystem.weaponAttack(p, e);
        System.out.println(e.getHp());
    }
}
