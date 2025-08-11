package _07InterfacesAbstraction.CollectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable {

    public int add(String item) {

        this.items.add(0, item);
        return 0;
    }

    public String remove() {

        String itemToRemove = this.items.get(this.items.size() - 1);
        this.items.remove(this.items.size() - 1);
        return itemToRemove;
    }
}