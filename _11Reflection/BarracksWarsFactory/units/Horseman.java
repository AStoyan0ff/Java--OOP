package _11Reflection.BarracksWarsFactory.units;

public class Horseman implements Unit {

    private int health = 50;
    private int attack = 10;

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getAttack() {
        return attack;
    }
}
