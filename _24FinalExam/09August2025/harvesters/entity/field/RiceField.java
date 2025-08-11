package harvesters.entity.field;

public class RiceField extends BaseField {

    public RiceField(String name, int crop) {
        super(name, crop);
    }

    @Override
    public void reduceCrop() {
        decreaseCropValue(2);
    }
}
