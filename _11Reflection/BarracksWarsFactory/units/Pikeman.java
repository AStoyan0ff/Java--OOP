package _11Reflection.BarracksWarsFactory.units;

public class Pikeman implements Unit {

    private static final int HEALTH = 35;
    private static final int ATTACK_DAMAGE = 10;


    @Override
    public int getHealth() {
        return HEALTH;
    }

    @Override
    public int getAttack() {
        return ATTACK_DAMAGE;
    }
}
