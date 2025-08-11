package aquarium.repositories.interfaces;

import aquarium.entries.decorations.interfaces.Decoration;

public interface Repository  {

    void add(Decoration decoration);

    boolean remove(Decoration decoration);

    Decoration findByType(String type);
}
