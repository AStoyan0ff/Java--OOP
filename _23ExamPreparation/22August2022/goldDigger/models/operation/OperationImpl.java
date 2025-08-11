package goldDigger.models.operation;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.spot.Spot;

import java.util.Collection;
import java.util.Iterator;

public class OperationImpl implements Operation {

    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {

        for (Discoverer discoverer : discoverers) {
            if (!discoverer.canDig()) continue;

            Iterator<String> it = spot.getExhibits().iterator();

            while (it.hasNext() && discoverer.canDig()) {
                String exhibit = it.next();

                discoverer.dig();
                discoverer.getMuseum().getExhibits().add(exhibit);
                it.remove();
            }
        }
    }
}
