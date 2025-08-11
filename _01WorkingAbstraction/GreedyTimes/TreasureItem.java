package _01WorkingAbstraction.GreedyTimes;

public class TreasureItem {

    private String name;
    private long qty;
    private ItemType type;

    public TreasureItem(String name, long qty) {

        this.name = name;
        this.qty = qty;
        this.type = ItemType.classify(name);
    }

    public String getName() {
        return name;
    }

    public long getQuantity() {
        return qty;
    }

    public ItemType getType() {
        return type;
    }

    public boolean bFirst() {
        return type != null;
    }
}
