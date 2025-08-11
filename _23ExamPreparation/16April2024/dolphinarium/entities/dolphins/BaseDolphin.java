package dolphinarium.entities.dolphins;

import dolphinarium.common.ExceptionMessages;
import dolphinarium.entities.foods.BaseFood;
import dolphinarium.entities.foods.Food;

public abstract class BaseDolphin implements Dolphin {

    private String name;
    private int energy;

    protected BaseDolphin(String name, int energy) {

        setName(name);
        setEnergy(energy);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.DOLPHIN_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public int getEnergy() {
        return this.energy;
    }

    public void setEnergy(int energy) {

        if(energy <= 0) {
            energy = 0;
        }
        this.energy = energy;
    }

    @Override
    public void eat(Food food) {
        this.energy += food.getCalories();
    }

    @Override
    public void jump() {
        this.energy -= 10;

    }
    //protected abstract void reduceEnergy();
}
