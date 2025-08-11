package _05Inheritance.RandomArrayList;

public class Main {
    public static void main(String[] args) {

        RandomArrayList<Integer> list = new RandomArrayList<>();

        list.add(3);
        list.add(5);
        list.add(7);

        System.out.println(list.getRandomElement());
        System.out.println(list);

    }
}
