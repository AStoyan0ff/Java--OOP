package _09Polymorphism.Word;

import java.util.function.Consumer;

public class CutTransform extends TextTransform {

    private Consumer<String> lastCutConsumer;

    public void setLastCutConsumer(Consumer<String> consumer) {
        this.lastCutConsumer = consumer;
    }

    @Override
    public void invokeOn(StringBuilder buff, int start, int end) {

        String cutText = buff.substring(start, end);
        this.lastCutConsumer.accept(cutText);

        buff.delete(start, end);
    }
}
