package restaurant.models.waiter;

public class HalfTimeWaiter extends BaseWaiter {

    public HalfTimeWaiter(String name) {
        super(name, 4);
    }

    @Override
    public void work() {
        this.setEfficiency(this.getEfficiency() - 2);
    }
}
