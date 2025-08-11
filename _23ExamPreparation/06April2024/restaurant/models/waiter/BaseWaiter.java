package restaurant.models.waiter;

import restaurant.common.ExceptionMessages;
import restaurant.models.orders.TakenOrders;
import restaurant.models.orders.TakenOrdersImpl;

public abstract class BaseWaiter implements Waiter {

    private String name;
    private int efficiency;
    private TakenOrders takenOrders;

    protected BaseWaiter(String name, int efficiency) {

        setName(name);
        this.efficiency = efficiency;
        this.takenOrders = new TakenOrdersImpl();
    }

    public void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.WAITER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setEfficiency(int efficiency) {

        if (efficiency < 0) {
            throw new IllegalArgumentException(ExceptionMessages.WAITER_EFFICIENCY_LESS_THAN_ZERO);
        }
        this.efficiency = efficiency;
    }

    public void setTakenOrders(TakenOrders takenOrders) {
        this.takenOrders = takenOrders;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getEfficiency() {
        return efficiency;
    }

    @Override
    public boolean canWork() {
        return efficiency > 0;
    }


    @Override
    public TakenOrders getOrders() {
        return this.takenOrders;
    }


    @Override
    abstract public void work();
}
