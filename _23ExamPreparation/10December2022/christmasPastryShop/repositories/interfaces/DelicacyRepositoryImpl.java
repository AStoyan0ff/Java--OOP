package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DelicacyRepositoryImpl implements DelicacyRepository<Delicacy> {

    private Collection<Delicacy> models = new ArrayList<>();


    @Override
    public Delicacy getByName(String name) {

        return models
                .stream()
                .filter(delicacy -> delicacy.getName()
                .equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Delicacy> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Delicacy delicacy) {
        models.add(delicacy);
    }
}
