package _01WorkingAbstraction.GreedyTimes;

public enum ItemType {

    GOLD,
    GEM,
    CASH;

    public static ItemType classify(String name) {

        if (name.length() == 3) return CASH;
        if (name.equalsIgnoreCase("Gold")) return GOLD;
        if (name.length() >= 4 && name.toLowerCase().endsWith("gem")) return GEM;

        return null;
    }
}
