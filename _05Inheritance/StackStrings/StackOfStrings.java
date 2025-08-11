package _05Inheritance.StackStrings;
import java.util.ArrayList;

public class StackOfStrings {

    private ArrayList<String> dataList;

    public StackOfStrings() {
        this.dataList = new ArrayList<>();
    }

    public void push(String element) {
        dataList.add(element);
    }

    public String pop() {

        if (!isEmpty()) {
            return dataList.removeLast();
        }
        return null;
    }
    public String peek() {

        if (!isEmpty()) { // // return data.get(data.size() - 1);
            return dataList.getLast();
        }
        return  null;
    }

    public boolean isEmpty() {
        return dataList.isEmpty();
    }
}
