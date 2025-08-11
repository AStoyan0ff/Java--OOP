package picking.core;

import picking.common.ConstantMessages;
import picking.common.ExceptionMessages;
import picking.entities.action.Action;
import picking.entities.action.ActionImpl;
import picking.entities.pickers.ExperiencedPicker;
import picking.entities.pickers.JuniorPicker;
import picking.entities.pickers.Picker;
import picking.entities.places.Place;
import picking.entities.places.PlaceImpl;
import picking.repositories.PlaceRepository;
import picking.repositories.Repository;

import java.util.Collection;
import java.util.List;

//TODO - Implement all the methods
public class ControllerImpl implements Controller {

    private final Repository<Place> placeRepository;

    public ControllerImpl() {
        this.placeRepository = new PlaceRepository();
    }

    @Override
    public String addPlace(String placeName, String... mushrooms) {

        Place place = new PlaceImpl(placeName);
        place.getMushrooms().addAll(List.of(mushrooms));

        this.placeRepository.add(place);
        return String.format(ConstantMessages.PLACE_ADDED, placeName);
    }

    @Override
    public String addPicker(String placeName, String pickerType, String pickerName) {
        Place place = placeRepository.byName(placeName);

        Picker pickerByName = place
                .getPickers()
                .stream()
                .filter(picker -> picker
                .getName()
                .equals(pickerName))
                .findFirst()
                .orElse(null);

        if (pickerByName != null) {
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_PICKER);
        }

        switch (pickerType) {

            case "JuniorPicker" -> pickerByName = new JuniorPicker(pickerName);
            case "ExperiencedPicker" -> pickerByName =new ExperiencedPicker(pickerName);
            default -> throw new IllegalArgumentException(ExceptionMessages.INVALID_PICKER);

        }
        place.getPickers().add(pickerByName);
        return String.format(ConstantMessages.PICKER_ADDED, pickerType, pickerName);
    }

    @Override
    public String startPicking(String placeName) {
        Place place = placeRepository.byName(placeName);

        if (place == null) {
            throw new NullPointerException(String.format(ExceptionMessages.NON_EXISTING_PLACE, placeName));

        }
        Action action = new ActionImpl();
        action.startPicking(place);

        return String.format(ConstantMessages.PLACE_VISITED, placeName);
    }

    @Override
    public String getStatistics() {
        
        StringBuilder buff = new StringBuilder();
        Collection<Place> places = placeRepository.getCollection();

        for (Place place : places) {

            buff
                    .append(String.format("Pickers in the %s:", place.getName()))
                    .append(System.lineSeparator());

            for (Picker picker : place.getPickers()) {
                Collection<String> mushrooms = picker.getBag().getMushrooms();

                buff
                        .append(String.format("Name: %s%n", picker.getName()))
                        .append(String.format("Vitality: %s%n", picker.getVitality()))
                        .append(String.format("Bag mushrooms: %s%n", !mushrooms.isEmpty()
                                ? String.join(", ", mushrooms)
                                : "none"));

            }
        }
        return buff.toString().trim();
    }
}
