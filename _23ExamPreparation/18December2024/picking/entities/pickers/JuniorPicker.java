package picking.entities.pickers;

public class JuniorPicker extends BasePicker {

    private static final int INITIAL_VITALITY = 30;

    public JuniorPicker(String name) {
        super(name, INITIAL_VITALITY);
    }
}
