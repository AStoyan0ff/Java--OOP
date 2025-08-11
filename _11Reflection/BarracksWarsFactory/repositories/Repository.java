package _11Reflection.BarracksWarsFactory.repositories;
import java.util.Map;

public interface Repository {

    void addUnit(String unitType);
    Map<String, Integer> getStatistics();
}
