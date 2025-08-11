package magicGame.repositories.interfaces;

import magicGame.common.ExceptionMessages;
import magicGame.models.magicians.Magician;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MagicianRepositoryImpl implements MagicianRepository<Magician> {

    private final Collection<Magician> data = new ArrayList<>();

    @Override
    public Collection<Magician> getData() {
        return Collections.unmodifiableCollection(data);
    }

    @Override
    public void addMagician(Magician model) {

        if (model == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_REPOSITORY);
        }
        data.add(model);
    }

    @Override
    public boolean removeMagician(Magician model) {
        return data.remove(model);
    }

    @Override
    public Magician findByUsername(String name) {

        return data
                .stream()
                .filter(magician -> magician.getUsername().equals(name))
                .findFirst()
                .orElse(null);
    }
}
