package _01WorkingAbstraction.GreedyTimes;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Bag {

    private long capacity;
    private long totalGold = 0;
    private long totalGems = 0;
    private long totalCash = 0;
    private long curr = 0;

    private Map<ItemType, Map<String, Long>> contentsMap = new LinkedHashMap<>();

    public Bag(long capacity) {
        this.capacity = capacity;
    }

    public boolean add(TreasureItem it) {

        if (!it.bFirst()) return false;
        long qty = it.getQuantity();

        if (curr + qty > capacity) return false;

        switch (it.getType()) {

            case GOLD: break;
            case GEM:

                if (totalGems + qty > totalGold) return false;
                break;

            case CASH:

                if (totalCash + qty > totalGems) return false;
                break;

            }

            contentsMap.putIfAbsent(it.getType(), new LinkedHashMap<>());
            contentsMap.get(it.getType()).merge(it.getName(), qty, Long::sum);
            curr += qty;

            switch (it.getType()) {

                case GOLD: totalGold += qty; break;
                case GEM: totalGems += qty; break;
                case CASH: totalCash += qty; break;
            }

        return true;
    }

    public void print() {

        contentsMap.entrySet().stream()
                .sorted((a, b) -> Long.compare(getTotal(b.getValue()), getTotal(a.getValue())))
                .forEach(entry -> {
                    System.out.printf("<%s> $%d%n", upperCase(entry.getKey().name()), getTotal(entry.getValue()));
                    entry.getValue().entrySet().stream()
                            .sorted(Map.Entry.<String, Long>comparingByKey(Comparator.reverseOrder())
                            .thenComparing(Map.Entry.comparingByValue()))
                            .forEach(e -> System.out.printf("##%s - %d%n", e.getKey(), e.getValue()));
                });
    }

    private long getTotal(Map<String, Long> map) {
        return map.values().stream().mapToLong(Long::longValue).sum();
    }

    private String upperCase(String s) {
        return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
    }
}
