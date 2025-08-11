package harpoonDiver.models.divingSite;

import harpoonDiver.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DivingSiteImpl implements DivingSite {

    private String name;
    private Collection<String> seaCreatures;

    public DivingSiteImpl(String name) {

        setName(name);
        this.seaCreatures = new ArrayList<>();
    }

    public void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.SITE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getSeaCreatures() {
        return seaCreatures;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
