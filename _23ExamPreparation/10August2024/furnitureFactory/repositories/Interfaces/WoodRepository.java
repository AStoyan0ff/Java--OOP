package furnitureFactory.repositories.Interfaces;

import furnitureFactory.entities.wood.Interfaces.Wood;

public interface WoodRepository {

    void add(Wood wood);
    boolean remove(Wood wood);
    Wood findByType(String type);
}
