package harvesters.entity.harvester;

public class ExpertHarvester extends BaseHarvester {

    public ExpertHarvester(String name) {
        super(name, 150);
    }

    @Override
    public void harvesting() {

        if (getStrength() > 0) {
            increaseHarvest(2);
            decreaseStrength(15);
        }
    }
}
