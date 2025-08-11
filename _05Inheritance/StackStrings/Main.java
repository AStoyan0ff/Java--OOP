package _05Inheritance.StackStrings;

public class Main {
    public static void main(String[] args) {

        StackOfStrings sos = new StackOfStrings();
        sos.push("one");
        sos.push("tow");     // вероятно имаш предвид "two", но оставям както е
        sos.push("three");

        System.out.println(sos.isEmpty()); // false
        System.out.println(sos.peek());    // three

        System.out.println(sos.pop());     // three
        System.out.println(sos.pop());     // tow
        System.out.println(sos.pop());     // one
    }
}
