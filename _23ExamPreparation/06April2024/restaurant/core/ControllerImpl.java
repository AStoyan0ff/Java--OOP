package restaurant.core;

import restaurant.common.ConstantMessages;
import restaurant.common.ExceptionMessages;
import restaurant.models.client.Client;
import restaurant.models.client.ClientImpl;
import restaurant.models.waiter.FullTimeWaiter;
import restaurant.models.waiter.HalfTimeWaiter;
import restaurant.models.waiter.Waiter;
import restaurant.models.working.Working;
import restaurant.models.working.WorkingImpl;
import restaurant.repositories.ClientRepository;
import restaurant.repositories.Repository;
import restaurant.repositories.WaiterRepository;

import java.util.Collection;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private final Repository<Client> clientRepository;
    private final Repository<Waiter> waiterRepository;
    private int servedClient;

    public ControllerImpl() {

        this.clientRepository = new ClientRepository();
        this.waiterRepository = new WaiterRepository();

    }

    @Override
    public String addWaiter(String type, String waiterName) {

        Waiter waiter = switch (type) {

            case "FullTimeWaiter" -> new FullTimeWaiter(waiterName);
            case "HalfTimeWaiter" -> new HalfTimeWaiter(waiterName);
            default -> throw new IllegalArgumentException(ExceptionMessages.WAITER_INVALID_TYPE);
        };
        waiterRepository.add(waiter);
        return String.format(ConstantMessages.WAITER_ADDED, type, waiterName);
    }

    @Override
    public String addClient(String clientName, String... orders) {

        Client client = new ClientImpl(clientName);

        for (String order : orders) {
            client.getClientOrders().add(order);
        }
        clientRepository.add(client);
        return String.format(ConstantMessages.CLIENT_ADDED, clientName);
    }

    @Override
    public String removeWaiter(String waiterName) {
        Waiter waiter = this.waiterRepository.byName(waiterName);

        if (waiter == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.WAITER_DOES_NOT_EXIST, waiterName));
        }
        waiterRepository.remove(waiter);
        return String.format(ConstantMessages.WAITER_REMOVE, waiterName);
    }

    @Override
    public String removeClient(String clientName) {
        Client client = this.clientRepository.byName(clientName);

        if (client == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CLIENT_DOES_NOT_EXIST, clientName));
        }
        clientRepository.remove(client);
        return String.format(ConstantMessages.CLIENT_REMOVE, clientName);
    }

    @Override
    public String startWorking(String clientName) {

        Collection<Waiter> waiters = this.waiterRepository
                .getCollection()
                .stream()
                .filter(w -> w.getEfficiency() > 0)
                .collect(Collectors.toList());

        StringBuilder buff = new StringBuilder();

        if (waiters.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.THERE_ARE_NO_WAITERS);
        }

        Client client = this.clientRepository.byName(clientName);

        Working working = new WorkingImpl();
        working.takingOrders(client, waiters);
        servedClient++;

        buff.append(String.format(ConstantMessages.ORDERS_SERVING, clientName));
        return buff.toString();
    }

    @Override
    public String getStatistics() {
        StringBuilder buff = new StringBuilder();

        buff.append(String.format(ConstantMessages.FINAL_CLIENTS_COUNT, servedClient));
        buff.append(System.lineSeparator());
        buff.append(ConstantMessages.FINAL_WAITERS_STATISTICS);
        // List
        Collection<Waiter> waiters = waiterRepository.getCollection();

        for (Waiter waiter : waiters) {
            buff.append(System.lineSeparator());

            buff.append(String.format(ConstantMessages.FINAL_WAITER_NAME, waiter.getName()));
            buff.append(System.lineSeparator());
            buff.append(String.format(ConstantMessages.FINAL_WAITER_EFFICIENCY, waiter.getEfficiency()));
            buff.append(System.lineSeparator());

            if (waiter.getOrders().getOrdersList().isEmpty()) {
                buff.append(String.format(ConstantMessages.FINAL_WAITER_ORDERS, "None"));
            }
            else {
                buff.append(String.format(ConstantMessages.FINAL_WAITER_ORDERS,
                        String.join(ConstantMessages.FINAL_WAITER_ORDERS_DELIMITER, waiter.getOrders().getOrdersList())));
            }
        }

        return buff.toString().trim();
    }
}
