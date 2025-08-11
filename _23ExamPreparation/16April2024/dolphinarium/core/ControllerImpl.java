package dolphinarium.core;

import dolphinarium.entities.dolphins.BottleNoseDolphin;
import dolphinarium.entities.dolphins.Dolphin;
import dolphinarium.entities.dolphins.SpinnerDolphin;
import dolphinarium.entities.dolphins.SpottedDolphin;
import dolphinarium.entities.foods.Food;
import dolphinarium.entities.foods.Herring;
import dolphinarium.entities.foods.Mackerel;
import dolphinarium.entities.foods.Squid;
import dolphinarium.entities.pools.DeepWaterPool;
import dolphinarium.entities.pools.Pool;
import dolphinarium.entities.pools.ShallowWaterPool;
import dolphinarium.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Collectors;

import static dolphinarium.common.ConstantMessages.*;
import static dolphinarium.common.ConstantMessages.SUCCESSFULLY_ADDED_DOLPHIN_IN_POOL;
import static dolphinarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{

    private FoodRepositoryImpl foodRepository;
    private Collection<Pool> pools;


    public ControllerImpl() {

        this.foodRepository = new FoodRepositoryImpl();
        this.pools = new ArrayList<>();
    }

    @Override
    public String addPool(String poolType, String poolName) {

        if (!(poolType.equals("DeepWaterPool") || poolType.equals("ShallowWaterPool"))) {
            throw new NullPointerException(INVALID_POOL_TYPE);
        }

        Pool poolByName = getPoolName(poolName);

        if (poolByName != null) {
            throw new NullPointerException(POOL_EXISTS);
        }

        Pool pool;

        switch (poolType) {

            case "DeepWaterPool" -> {
                pool = new DeepWaterPool(poolName);
                pools.add(pool);
            }
            case "ShallowWaterPool" -> {
                pool = new ShallowWaterPool(poolName);
                pools.add(pool);
            }
        }
        return String.format(SUCCESSFULLY_ADDED_POOL_TYPE, poolType, poolName);
    }

    @Override
    public String buyFood(String foodType) {

        if (!(foodType.equals("Squid") || foodType.equals("Herring") || foodType.equals("Mackerel"))) {
            throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }

        Food food;

        switch (foodType) {

            case "Squid" -> {
                food = new Squid();
                foodRepository.add(food);
            }
            case "Herring" -> {
                food = new Herring();
                foodRepository.add(food);
            }
            case "Mackerel" -> {
                food = new Mackerel();
                foodRepository.add(food);
            }
        }

        return String.format(SUCCESSFULLY_BOUGHT_FOOD_TYPE, foodType);
    }

    @Override
    public String addFoodToPool(String poolName, String foodType) {

        Pool pool = getPoolName(poolName);
        Food food = foodRepository.findByType(foodType);

        if (food == null) {
            throw new IllegalArgumentException(String.format(NO_FOOD_FOUND, foodType));
        }
        pool.addFood(food);
        foodRepository.remove(food);

        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_POOL, foodType, poolName);
    }

    @Override
    public String addDolphin(String poolName, String dolphinType, String dolphinName, int energy) {

        Dolphin dolphin;
        Pool pool = getPoolName(poolName);

        for (Dolphin d : pool.getDolphins()) {

            if (d.getName().equals(dolphinName)) {
                throw new IllegalArgumentException(DOLPHIN_EXISTS);
            }
        }

        switch (dolphinType) {

            case "BottleNoseDolphin" -> dolphin = new BottleNoseDolphin(dolphinName, energy);
            case "SpottedDolphin" -> dolphin = new SpottedDolphin(dolphinName, energy);
            case "SpinnerDolphin" -> dolphin = new SpinnerDolphin(dolphinName, energy);
            default -> throw new IllegalArgumentException(INVALID_DOLPHIN_TYPE);
        }

        if (pool.getClass().getSimpleName().equals("DeepWaterPool")
                && dolphinType.equals("BottleNoseDolphin")
                || dolphinType.equals("SpottedDolphin")) {

            pool.addDolphin(dolphin);
        }
        else if (pool.getClass().getSimpleName().equals("ShallowWaterPool")
                && dolphinType.equals("SpinnerDolphin")) {

            pool.addDolphin(dolphin);
        }
        else {
            return POOL_NOT_SUITABLE;
        }
        return String.format(SUCCESSFULLY_ADDED_DOLPHIN_IN_POOL, dolphinType, dolphinName, poolName);
    }

    @Override
    public String feedDolphins(String poolName, String foodType) {

        Pool pool = getPoolName(poolName);

        Food foods = pool.getFoods()
                .stream()
                .filter(f -> f.getClass().getSimpleName().equals(foodType))
                .findFirst()
                .orElse(null);

        if (foods == null) {
            throw new IllegalArgumentException(NO_FOOD_OF_TYPE_ADDED_TO_POOL);
        }
        for (Dolphin dolphin : pool.getDolphins()) {
            dolphin.eat(foods);
        }

        pool.getFoods().remove(foods);
        return String.format(DOLPHINS_FED, pool.getDolphins().size(), pool.getName());
    }

    @Override
    public String playWithDolphins(String poolName) {

        Pool pool = getPoolName(poolName);
        int removed = 0;

        if (pool.getDolphins().isEmpty()) {
            throw new IllegalArgumentException(NO_DOLPHINS);
        }

        Iterator<Dolphin> dolphins = pool.getDolphins().iterator();

        while (dolphins.hasNext()) {

            Dolphin dolphin = dolphins.next();
            dolphin.jump();

            if (dolphin.getEnergy() <= 0) {

                dolphins.remove();
                removed++;
            }
        }
        return String.format(DOLPHINS_PLAY, poolName, removed);
    }

    @Override
    public String getStatistics() {

        StringBuilder buff = new StringBuilder();
        for (Pool pool : pools) {

            buff.append(String.format(DOLPHINS_FINAL, pool.getName()))
                    .append(System.lineSeparator());

            if (pool.getDolphins().isEmpty()) {
                buff.append(NONE).append(System.lineSeparator());
            }
            else {
                buff.append(pool.getDolphins()
                                .stream()
                                .map(dolphin -> dolphin
                                .getName() + " - " + dolphin.getEnergy())
                                .collect(Collectors.joining(DELIMITER)))
                                .append(System.lineSeparator());
            }
        }
        return buff.toString().trim();
    }

    public Pool getPoolName(String pollName) {

        return pools.stream()
                .filter(a -> a.getName().equals(pollName))
                .findFirst()
                .orElse(null);
    }
}
