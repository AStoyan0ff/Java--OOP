package climbers.models.climber;

import climbers.common.ExceptionMessages;
import climbers.models.roster.Roster;
import climbers.models.roster.RosterImpl;

public abstract class BaseClimber implements Climber {

    private String name;
    private double strength;
    private Roster roster;

    protected BaseClimber(String name, double strength) {

        setName(name);
        setStrength(strength);
        this.roster = new RosterImpl();

    }

    private void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.CLIMBER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setStrength(double strength) {

        if (strength < 0) {
            throw new IllegalArgumentException(ExceptionMessages.CLIMBER_STRENGTH_LESS_THAN_ZERO);
        }
        this.strength = strength;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getStrength() {
        return strength;
    }

    @Override
    public Roster getRoster() {
        return roster;
    }

    protected void decreaseStrength(double amount) {
        this.strength -= amount;

        if (this.strength < 0) this.strength = 0;
    }

    @Override
    public boolean canClimb() {
        return this.strength > 0;
    }

}
