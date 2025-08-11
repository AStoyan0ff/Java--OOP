package _07InterfacesAbstraction.MilitaryElite;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {

    private Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corps) {

        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    @Override
    public Corps getCorps() {
        return corps;
    }

    public abstract Iterable<Mission> getMissions();

    @Override
    public String toString() {
        return String.format("%s%nCorps: %s", super.toString(), corps);
    }
}
