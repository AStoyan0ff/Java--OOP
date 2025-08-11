package _09Polymorphism.Word;

import java.util.HashMap;
import java.util.Map;

public class CommandImpl implements CommandInterface {

    private final StringBuilder buff;
    private final Map<String, TextTransform> transforms;
    private String lastCut = ""; // keep the last cut text

    public CommandImpl(StringBuilder text) {

        this.buff = text;
        this.transforms = new HashMap<>();
        initCommands();
    }

    private void initCommands() {

        this.transforms.put("uppercase", new UppercaseTransform());
        this.transforms.put("cut", new CutTransform());
        this.transforms.put("paste", new PasteTransform());
    }

    @Override
    public Command handle(String input) {
        String[] parts = input.split("\\s+");

        String commandName = parts[0];
        int startIndex = Integer.parseInt(parts[1]);
        int endIndex = Integer.parseInt(parts[2]);

        TextTransform editForms = this.transforms.get(commandName);
        if (editForms == null) {
            throw new IllegalArgumentException("Unknown command: " + commandName);
        }

        if (editForms instanceof CutTransform) {
            ((CutTransform) editForms).setLastCutConsumer(s -> this.lastCut = s);
        }

        if (editForms instanceof PasteTransform) {
            ((PasteTransform) editForms).setLastCut(() -> this.lastCut);
        }

        return new Command(startIndex, endIndex, editForms);
    }
}
