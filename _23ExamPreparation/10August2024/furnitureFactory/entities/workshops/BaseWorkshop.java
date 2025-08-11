package furnitureFactory.entities.workshops;

import furnitureFactory.entities.wood.Interfaces.Wood;

public abstract class BaseWorkshop implements Workshop {

    private int woodQuantity;
    private int producedFurnitureCount;
    private int woodQuantityReduceFactor;

    public BaseWorkshop(int woodQuantity, int woodQuantityReduceFactor) {

        this.woodQuantityReduceFactor = woodQuantityReduceFactor;
        this.producedFurnitureCount = 0;
        this.woodQuantity = woodQuantity;
    }

    @Override
    public int getWoodQuantity() {
        return woodQuantity;
    }

    public void setWoodQuantity(int quantity) {

        if (quantity <= 0) {
            quantity = 0;
        }
        this.woodQuantity = quantity;
    }

    @Override
    public void addWood(Wood wood) {
        this.woodQuantity += wood.getWoodQuantity();
    }

    @Override
    public int getWoodQuantityReduceFactor() {
        return woodQuantityReduceFactor;
    }
}
