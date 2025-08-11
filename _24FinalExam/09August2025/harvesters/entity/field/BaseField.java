package harvesters.entity.field;

import harvesters.common.ExceptionMessages;
import harvesters.entity.harvester.Harvester;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseField implements Field {

    private String name;
    private int crop;
    private Collection<Harvester> harvesters;

    protected BaseField(String name, int crop) {

        setName(name);
        this.crop = crop;
        this.harvesters = new ArrayList<>();
    }

    private void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setCrop(int crop) {
        this.crop = crop;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCrop() {
        return crop;
    }

    protected void decreaseCropValue(int amount) {
        this.crop -= amount;

        if (this.crop < 0) {
            this.crop = 0;
        }
    }

    @Override
    public Collection<Harvester> getHarvesters() {
        return harvesters;
    }
}
