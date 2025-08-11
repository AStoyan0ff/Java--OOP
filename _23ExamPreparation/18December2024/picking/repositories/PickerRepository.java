package picking.repositories;

import picking.entities.pickers.Picker;

import java.util.*;

public class PickerRepository implements Repository<Picker> {

    private Map<String, Picker> pickers;

     PickerRepository() {
        this.pickers = new LinkedHashMap<>();
    }

    @Override
    public Collection<Picker> getCollection() {
        return Collections.unmodifiableCollection(pickers.values());
    }

    @Override
    public void add(Picker picker) {
        pickers.put(picker.getName(), picker);
    }

    @Override
    public boolean remove(Picker picker) {
        return pickers.remove(picker) != null;
    }

    @Override
    public Picker byName(String name) {
        return pickers.get(name);
    }
}
