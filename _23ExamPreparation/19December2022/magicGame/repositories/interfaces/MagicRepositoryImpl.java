package magicGame.repositories.interfaces;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.Magic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MagicRepositoryImpl implements MagicRepository<Magic> {

    private final Collection<Magic> data = new ArrayList<>();

    @Override
    public Collection<Magic> getData() {
        return Collections.unmodifiableCollection(data);
    }

    @Override
    public void addMagic(Magic model) {

        if (model == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC_REPOSITORY);
        }
        data.add(model);
    }

    @Override
    public boolean removeMagic(Magic model) {
        return data.remove(model);
    }

    @Override
    public Magic findByName(String name) {

        return data
                .stream()
                .filter(magic -> magic.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
