package furnitureFactory.entities.workshops;

import furnitureFactory.entities.wood.Interfaces.Wood;
import furnitureFactory.entities.wood.OakWood;

public class DeckingWorkshop extends BaseWorkshop {

    private int producedFurnitureCount;

    public DeckingWorkshop(int woodQuantity) {
        super(woodQuantity, 150);
    }

    @Override
    public int getProducedFurnitureCount() {
        return producedFurnitureCount;
    }

    @Override
    public void produce() {

        if (this.getWoodQuantity() >= 150) {
            producedFurnitureCount++;

            this.setWoodQuantity(this.getWoodQuantity() - 150);
        }
    }
}

