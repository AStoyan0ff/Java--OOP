package furnitureFactory.entities.factories;

import furnitureFactory.common.ExceptionMessages;
import furnitureFactory.entities.factories.Interfaces.Factory;
import furnitureFactory.entities.workshops.Workshop;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseFactory implements Factory {

    private String name;
    private Collection<Workshop> workshops;
    private Collection<Workshop> removedWorkshops;

    protected BaseFactory(String name) {

        this.name = name;
        this.workshops = new ArrayList<>();
        this.removedWorkshops = new ArrayList<>();
    }

    public void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.FACTORY_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void addWorkshop(Workshop workshop) {
        this.workshops.add(workshop);
    }

    @Override
    public Collection<Workshop> getWorkshops() {
        return workshops;
    }

    @Override
    public Collection<Workshop> getRemovedWorkshops() {
        return removedWorkshops;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
