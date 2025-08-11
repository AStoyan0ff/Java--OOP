package harvesters.repository;

import harvesters.entity.field.Field;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FieldRepository implements Repository<Field> {
    private Collection<Field> fields = new ArrayList<>();

    @Override
    public Collection<Field> getCollection() {
        return Collections.unmodifiableCollection(fields);
    }

    @Override
    public void add(Field entity) {
        fields.add(entity);
    }

    @Override
    public Field byName(String name) {
        
        return fields
                .stream()
                .filter(f -> f.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
