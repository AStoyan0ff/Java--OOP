package restaurant.repositories;

import restaurant.models.client.Client;

import java.util.*;

public class ClientRepository implements Repository<Client> {

    private final Map<String, Client> clientsMap;

    public ClientRepository() {
        this.clientsMap = new LinkedHashMap<>();
    }

    @Override
    public Collection<Client> getCollection() {
        return Collections.unmodifiableCollection(this.clientsMap.values());
    }

    @Override
    public void add(Client entity) {
        clientsMap.put(entity.getName(), entity);
    }

    @Override
    public boolean remove(Client entity) {
        return clientsMap.remove(entity.getName()) != null;
    }

    @Override
    public Client byName(String name) {
        return clientsMap.get(name);
    }
}
