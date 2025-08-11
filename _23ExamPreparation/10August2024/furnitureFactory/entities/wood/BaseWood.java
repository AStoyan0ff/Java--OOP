package furnitureFactory.entities.wood;

import furnitureFactory.entities.wood.Interfaces.Wood;

import java.nio.file.Paths;

public abstract class BaseWood implements Wood{

    private int woodQuantity;

    protected BaseWood(int woodQuantity) {
        this.woodQuantity = woodQuantity;
    }

    @Override
    public int getWoodQuantity() {
        return woodQuantity;
    }

    public void setWoodQuantity(int woodQuantity) {
        this.woodQuantity = woodQuantity;
    }
}