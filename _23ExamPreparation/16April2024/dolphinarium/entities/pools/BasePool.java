package dolphinarium.entities.pools;

import dolphinarium.common.ExceptionMessages;
import dolphinarium.entities.dolphins.Dolphin;
import dolphinarium.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BasePool implements Pool {

    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Dolphin> dolphins;

    protected BasePool(String name, int capacity) {

        setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.dolphins = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.POOL_NAME_NULL_OR_EMPTY);
        }
        this.name = name;


    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public Collection<Dolphin> getDolphins() {
        return dolphins;
    }

    @Override
    public Collection<Food> getFoods() {
        return foods;
    }

    @Override
    public void addDolphin(Dolphin dolphin) {

        if (dolphins.size() >= capacity) {
            throw new IllegalStateException(ExceptionMessages.NOT_ENOUGH_CAPACITY);
        }

        if (dolphin.getEnergy() <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.DOLPHIN_ENERGY_BELOW_OR_EQUAL_ZERO);
        }
        dolphins.add(dolphin);
    }

    @Override
    public void removeDolphin(Dolphin dolphin) {
        dolphins.remove(dolphin);
    }

    @Override
    public void addFood(Food food) {
        foods.add(food);
    }
}
