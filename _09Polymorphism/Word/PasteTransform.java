package _09Polymorphism.Word;

import java.util.function.Supplier;

public class PasteTransform extends  TextTransform {

    private Supplier<String> lastCut;

    public void setLastCut(Supplier<String> supplier) {
        this.lastCut = supplier;
    }

    @Override
    public void invokeOn(StringBuilder text, int start, int end) {
        String paste = this.lastCut.get();

        text.delete(start, end);
        text.insert(start, paste);
    }
}
