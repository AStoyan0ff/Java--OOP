package harpoonDiver.repositories;

import harpoonDiver.models.diver.Diver;
import java.util.*;

public class DiverRepository implements Repository<Diver> {

    private final Map<String, Diver> diverMap;

    public DiverRepository() {
        this.diverMap = new LinkedHashMap<>();
    }


    @Override
    public Collection<Diver> getCollection() {
        return Collections.unmodifiableCollection(diverMap.values());
    }

    @Override
    public void add(Diver entity) {
        diverMap.put(entity.getName(), entity);
    }

    @Override
    public boolean remove(Diver entity) {
        return diverMap.remove(entity.getName()) != null;
    }

    @Override
    public Diver byName(String name) {
        return diverMap.get(name);
    }
}
