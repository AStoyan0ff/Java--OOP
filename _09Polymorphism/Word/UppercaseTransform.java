package _09Polymorphism.Word;

public class UppercaseTransform extends TextTransform {

    @Override
    public void invokeOn(StringBuilder buff, int start, int end) {

        for (int pos = start; pos < end; pos++) {

            char upper = Character.toUpperCase(buff.charAt(pos));
            buff.setCharAt(pos, upper);
        }
    }
}
