package dolphinarium.entities.dolphins;

public class SpinnerDolphin extends BaseDolphin {

    public SpinnerDolphin(String name, int energy) {
        super(name, energy);
    }

    @Override
    public void jump() {

        super.jump();
        this.setEnergy(this.getEnergy() - 40);
    }
}
