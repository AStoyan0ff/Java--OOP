package _07InterfacesAbstraction.CollectionHierarchy;

public interface MyList extends AddRemovable {

    public interface MyLists extends AddRemovable{
        int getUsed();
    }
}
