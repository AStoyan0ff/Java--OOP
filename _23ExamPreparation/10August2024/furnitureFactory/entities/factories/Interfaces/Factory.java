package furnitureFactory.entities.factories.Interfaces;

import furnitureFactory.entities.workshops.Workshop;
import java.util.Collection;

public interface Factory {

    String getName();
    void addWorkshop(Workshop workshop);
    Collection<Workshop> getWorkshops();
    Collection<Workshop> getRemovedWorkshops();
}
