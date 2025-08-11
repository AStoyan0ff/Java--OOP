package _11Reflection.BarracksWarsFactory.units;

public class Gunner implements Unit {

    private int health = 20;
    private int attack = 20;


    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getAttack() {
        return attack;
    }
}
