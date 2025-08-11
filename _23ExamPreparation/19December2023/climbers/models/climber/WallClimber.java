package climbers.models.climber;

public class WallClimber extends BaseClimber {

    public WallClimber(String name) {
        super(name, 90);
    }


    @Override
    public void climb() {
        decreaseStrength(30);
    }
}
