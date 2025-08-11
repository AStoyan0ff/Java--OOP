package restaurant.models.waiter;

public class FullTimeWaiter extends BaseWaiter {

    public FullTimeWaiter(String name) {
        super(name, 8);
    }

    @Override
    public void work() {
        this.setEfficiency(this.getEfficiency() - 1);
    }
}
