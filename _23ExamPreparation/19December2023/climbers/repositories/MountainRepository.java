package climbers.repositories;

import climbers.models.mountain.Mountain;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MountainRepository implements Repository<Mountain> {

    private final Collection<Mountain> mountains = new ArrayList<>();

    @Override
    public Collection<Mountain> getCollection() {
        return Collections.unmodifiableCollection(mountains);
    }

    @Override
    public void add(Mountain entity) {
        this.mountains.add(entity);
    }

    @Override
    public boolean remove(Mountain entity) {
        return this.mountains.remove(entity);
    }

    @Override
    public Mountain byName(String name) {

        return mountains
                .stream()
                .filter(m -> m.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
