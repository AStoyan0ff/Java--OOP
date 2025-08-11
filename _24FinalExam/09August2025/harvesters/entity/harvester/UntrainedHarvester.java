package harvesters.entity.harvester;

public class UntrainedHarvester extends BaseHarvester {

    public UntrainedHarvester(String name) {
        super(name, 50);
    }

    @Override
    public void harvesting() {

        if (getStrength() > 0) {

            increaseHarvest(1);
            decreaseStrength(10);
        }
    }
}
