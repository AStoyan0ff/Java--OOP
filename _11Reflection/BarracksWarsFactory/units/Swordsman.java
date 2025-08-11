package _11Reflection.BarracksWarsFactory.units;

public class Swordsman implements Unit {

    private static final int HEALTH = 40;
    private static final int ATTACK_DAMAGE = 20;


    @Override
    public int getHealth() {
        return HEALTH;
    }

    @Override
    public int getAttack() {
        return ATTACK_DAMAGE;
    }
}
