package harpoonDiver.models.diving;

import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.divingSite.DivingSite;

import java.util.Collection;

public class DivingImpl implements Diving {


    @Override
    public void searching(DivingSite divingSite, Collection<Diver> divers) {

        Collection<String> divingSeaCreatures = divingSite.getSeaCreatures();

        for (Diver diver : divers) {
            while (diver.canDive() && divingSeaCreatures.iterator().hasNext()) {

                diver.shoot();

                String currSeaCreature = divingSeaCreatures.iterator().next();
                diver.getSeaCatch().getSeaCreatures().add(currSeaCreature);
                divingSeaCreatures.remove(currSeaCreature);
            }
        }
    }
}
