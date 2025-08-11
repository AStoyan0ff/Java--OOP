package _07InterfacesAbstraction.CollectionHierarchy;
import java.util.*;

public class Main { // 50/100
    public static void main(String[] args) {

        Addable addCollection = new AddCollection();
        AddRemovable addRemoveCollection = new AddRemoveCollection();
        MyList myList = new MyListImpl();

        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split(" ");

        StringBuilder addCollectionAddResult = new StringBuilder();
        StringBuilder addRemoveCollectionAddResult = new StringBuilder();
        StringBuilder myListAddResult = new StringBuilder();
        StringBuilder addRemoveCollectionRemoveResult = new StringBuilder();
        StringBuilder myListRemoveResult = new StringBuilder();

        for(String item : items) {

            addCollectionAddResult.append(addCollection.add(item));
            addCollectionAddResult.append(" ");
            addRemoveCollectionAddResult.append(addRemoveCollection.add(item));
            addRemoveCollectionAddResult.append(" ");
            myListAddResult.append(myList.add(item));
            myListAddResult.append(" ");
        }

        int removes = Integer.parseInt(scanner.nextLine());

        for (int pos = 0; pos < removes; pos++) {

            addRemoveCollectionRemoveResult.append(addRemoveCollection.remove());
            addRemoveCollectionRemoveResult.append(" ");
            myListRemoveResult.append(myList.remove());
            myListRemoveResult.append(" ");
        }

        System.out.println(addCollectionAddResult.toString());
        System.out.println(addRemoveCollectionAddResult.toString());
        System.out.println(myListAddResult.toString());
        System.out.println(addRemoveCollectionRemoveResult.toString());
        System.out.println(myListRemoveResult.toString());

    }
}