package restaurant.models.client;

import restaurant.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ClientImpl implements Client {

    private String name;
    private Collection<String> clientOrders;

    public ClientImpl(String name, String... clientOrders) {

        setName(name);
        this.clientOrders = new ArrayList<>(Arrays.asList(clientOrders));

    }

    @Override
    public String getName() {
        return name;
    }

    protected void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.CLIENT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getClientOrders() {
        return clientOrders;
    }


    public void setClientOrders(Collection<String> clientOrders) {
        this.clientOrders = clientOrders;
    }
}
