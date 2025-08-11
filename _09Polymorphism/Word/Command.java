package _09Polymorphism.Word;

public class Command {

    private final int startIndex;
    private final int endIndex;
    private final TextTransform transform;

    public Command(int startIndex, int endIndex, TextTransform transform) {

        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.transform = transform;
    }

    public void execute(StringBuilder text) {
        this.transform.invokeOn(text, startIndex, endIndex);
    }
}

