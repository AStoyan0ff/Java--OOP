package harvesters.entity.harvester;

import harvesters.common.ExceptionMessages;

public abstract class BaseHarvester implements Harvester {

    private String name;
    private int harvest;
    private int strength;

    public BaseHarvester(String name, int strength) {

        setName(name);
        this.strength = strength;
        this.harvest = 0;
    }

    private void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.HARVESTER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHarvest() {
        return harvest;
    }

    protected void increaseHarvest(int amount) {
        this.harvest += amount;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    protected void decreaseStrength(int amount) {
        this.strength -= amount;

        if (this.strength < 0) {
            this.strength = 0;
        }
    }
}


