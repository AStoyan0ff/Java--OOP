package _11Reflection.BarracksWarsFactory.repositories;
import java.util.HashMap;
import java.util.Map;

public class RepositoryImpl implements Repository {

    private final Map<String, Integer> units = new HashMap<>();


    @Override
    public void addUnit(String unitType) {
        units.put(unitType, units.getOrDefault(unitType, 0) + 1);
    }

    @Override
    public Map<String, Integer> getStatistics() {
        return units;
    }
}
