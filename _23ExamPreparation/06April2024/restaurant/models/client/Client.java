package restaurant.models.client;

import java.util.Collection;

public interface Client {

    Collection<String> getClientOrders();
    //Collection<String> getWaiters();
    String getName();
}
