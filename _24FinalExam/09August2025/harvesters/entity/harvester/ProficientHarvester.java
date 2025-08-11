package harvesters.entity.harvester;

public class ProficientHarvester extends BaseHarvester {

    public ProficientHarvester(String name) {
        super(name, 100);
    }

    @Override
    public void harvesting() {

        if (getStrength() > 0) {
            increaseHarvest(1);
            decreaseStrength(10);
        }
    }
}
