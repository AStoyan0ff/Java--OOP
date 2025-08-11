package picking.entities.pickers;

import picking.common.ExceptionMessages;
import picking.entities.bag.Bag;
import picking.entities.bag.BagImpl;

public abstract class BasePicker implements Picker {

    private String name;
    private int vitality;
    private Bag bag;

    public BasePicker(String name, int vitality) {

        setName(name);
        setVitality(vitality);
        this.bag = new BagImpl();
    }

    private void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.PICKER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setVitality(int vitality) {

        if (vitality < 0 ) {
            throw new IllegalArgumentException(ExceptionMessages.PICKER_VITALITY_LESS_THAN_ZERO);
        }
        this.vitality = vitality;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public int getVitality() {
        return this.vitality;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void pick() {
        this.vitality = Math.max(0, this.vitality - 10);

        /*this.vitality -= 10;
        if (this.vitality < 0) {
            setVitality(0);
        }*/
    }
}
