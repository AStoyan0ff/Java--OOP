package furnitureFactory.entities.workshops;

import furnitureFactory.entities.wood.Interfaces.Wood;

public class TableWorkshop extends BaseWorkshop {

    private int producedFurnitureCount;

    public TableWorkshop(int woodQuantity) {
        super(woodQuantity, 50);
    }

    @Override
    public int getProducedFurnitureCount() {
        return producedFurnitureCount;
    }

    @Override
    public void produce() {

        if (this.getWoodQuantity() >= 50) {
            producedFurnitureCount++;

            this.setWoodQuantity(this.getWoodQuantity() - 50);
        }
    }
}
