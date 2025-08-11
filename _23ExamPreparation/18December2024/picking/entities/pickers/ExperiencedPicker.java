package picking.entities.pickers;

public class ExperiencedPicker extends BasePicker {

    private static final int INITIAL_VITALITY = 60;

    public ExperiencedPicker(String name) {
        super(name, INITIAL_VITALITY);
    }
}
