package harpoonDiver.repositories;

import harpoonDiver.models.divingSite.DivingSite;
import java.util.*;

public class DivingSiteRepository implements Repository<DivingSite> {

    private final Map<String, DivingSite> sitesMap;

    public DivingSiteRepository() {
        this.sitesMap = new LinkedHashMap<>();
    }


    @Override
    public Collection<DivingSite> getCollection() {
        return Collections.unmodifiableCollection(sitesMap.values());
    }

    @Override
    public void add(DivingSite entity) {
        sitesMap.put(entity.getName(), entity);
    }

    @Override
    public boolean remove(DivingSite entity) {
        return sitesMap.remove(entity.getName()) != null;
    }

    @Override
    public DivingSite byName(String name) {
        return sitesMap.get(name);
    }
}
