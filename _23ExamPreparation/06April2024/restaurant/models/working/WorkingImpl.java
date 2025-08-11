package restaurant.models.working;

import restaurant.models.client.Client;
import restaurant.models.waiter.Waiter;

import java.util.Collection;
import java.util.Iterator;

public class WorkingImpl implements Working {


    @Override
    public void takingOrders(Client client, Collection<Waiter> waiters) {
        Iterator<String> clientOrders = client.getClientOrders().iterator();

        for (Waiter waiter : waiters) {

            while (waiter.canWork() && clientOrders.hasNext()) {

                String order = clientOrders.next();
                waiter.getOrders().getOrdersList().add(order);
                waiter.work();
                clientOrders.remove();
            }
            if (!clientOrders.hasNext()) {
                break;
            }
        }
    }
}

