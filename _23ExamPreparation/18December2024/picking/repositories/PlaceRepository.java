package picking.repositories;

import picking.entities.places.Place;

import java.util.*;

public class PlaceRepository implements Repository<Place> {

    private final Map<String, Place> places;

    public PlaceRepository() {
        this.places = new LinkedHashMap<>();
    }


    @Override
    public Collection<Place> getCollection() {
        return Collections.unmodifiableCollection(places.values());
    }

    @Override
    public void add(Place place) {
        places.put(place.getName(), place);
    }

    @Override
    public boolean remove(Place place) {
        return places.remove(place.getName()) != null;
    }

    @Override
    public Place byName(String name) {
        return places.get(name);
    }
}
