package furnitureFactory.repositories;

import furnitureFactory.entities.wood.BaseWood;
import furnitureFactory.entities.wood.Interfaces.Wood;
import furnitureFactory.repositories.Interfaces.WoodRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WoodRepositoryImpl implements WoodRepository  {

    private Collection<Wood> woodTypes;

    public WoodRepositoryImpl() {
        this.woodTypes = new ArrayList<>();
    }

    @Override
    public void add(Wood wood) {
        this.woodTypes.add(wood);
    }

    @Override
    public boolean remove(Wood wood) {
        return woodTypes.remove(wood);
    }

    public Wood findByType(String type) {

        return this.woodTypes
                .stream()
                .filter(wood -> wood.getClass()
                .getSimpleName()
                .equals(type))
                .findFirst()
                .orElse(null);
    }
    public Collection<Wood> getWoodTypes() {
        return woodTypes;
    }
}
