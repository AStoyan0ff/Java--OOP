package furnitureFactory.repositories;

import furnitureFactory.entities.workshops.Workshop;
import furnitureFactory.repositories.Interfaces.WorkshopRepository;
import static furnitureFactory.common.ExceptionMessages.*;

import java.util.ArrayList;
import java.util.Collection;

public class WorkshopRepositoryImpl implements WorkshopRepository {
    private Collection<Workshop> workshops;

    public WorkshopRepositoryImpl() {
        this.workshops = new ArrayList<>();
    }


    @Override
    public void add(Workshop workshop) {

        if (workshop.getWoodQuantity() <= 0) {
            throw new IllegalArgumentException(WORKSHOP_WOOD_QUANTITY_BELOW_OR_EQUAL_ZERO);
        }

        for (Workshop w : workshops) {

            if (w.getClass().getSimpleName().equals(workshop.getClass().getSimpleName())) {
                throw new IllegalArgumentException(WORKSHOP_EXISTS_IN_REPOSITORY);
            }
        }
        this.workshops.add(workshop);
    }

    @Override
    public boolean remove(Workshop workshop) {

        if(workshops.isEmpty()) {
            throw new NullPointerException("No workshops in repository.");
        }
        return this.workshops.remove(workshop);
    }

    @Override
    public Workshop findByType(String type) {

        return workshops
                .stream()
                .filter(workshop -> workshop.getClass()
                .getSimpleName()
                .equals(type))
                .findFirst()
                .orElse(null);
    }

    public boolean contains(Workshop workshop) {
        return workshops.contains(workshop);
    }
}
