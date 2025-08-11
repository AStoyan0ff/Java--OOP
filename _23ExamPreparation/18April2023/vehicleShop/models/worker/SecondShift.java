package vehicleShop.models.worker;

public class SecondShift extends BaseWorker {

    private static final int STRENGTH = 70;
    //private int energy = 5;

    public SecondShift(String name) {
        super(name, STRENGTH);
    }

    @Override
    public void working() {

        super.working();
        super.working();

        /*if (this.energy - 5 < 0) {
            this.energy = 0;
        }
        else {
            this.energy -= 5;
        }*/


    }
}
