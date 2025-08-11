package restaurant.repositories;

import restaurant.models.waiter.Waiter;

import java.util.*;

public class WaiterRepository implements Repository<Waiter> {

    private final Map<String, Waiter> waiterMap;

    public WaiterRepository() {
        this.waiterMap = new LinkedHashMap<>();
    }

    @Override
    public Collection<Waiter> getCollection() {
        return Collections.unmodifiableCollection(this.waiterMap.values());
    }

    @Override
    public void add(Waiter entity) {
        waiterMap.put(entity.getName(), entity);
    }

    @Override
    public boolean remove(Waiter entity) {
        return waiterMap.remove(entity.getName()) != null;
    }

    @Override
    public Waiter byName(String name) {
        return waiterMap.get(name);
    }
}
