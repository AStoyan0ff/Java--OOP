package _11Reflection.BarracksWarsFactory.units;

public class Archer implements Unit {

    private static final int HEALTH = 30;
    private static final int ATTACK_DAMAGE = 15;

    @Override
    public int getHealth() {
        return HEALTH;
    }

    @Override
    public int getAttack() {
        return ATTACK_DAMAGE;
    }
}
