package picking.entities.places;

import picking.common.ExceptionMessages;
import picking.entities.pickers.Picker;

import java.util.ArrayList;
import java.util.Collection;

public class PlaceImpl implements Place {

    private String name;
    private Collection<String> mushrooms;
    private Collection<Picker> pickers;

    public PlaceImpl(String name) {

        setName(name);
        this.mushrooms = new ArrayList<>();
        this.pickers = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.PLACE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getMushrooms() {
        return mushrooms;
    }

    @Override
    public Collection<Picker> getPickers() {
        return pickers;
    }


}
