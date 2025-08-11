package vehicleShop.repositories;

import vehicleShop.models.worker.Worker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class WorkerRepository<T> implements Repository<Worker> {

    private List<Worker> workers = new ArrayList<>();


    public Collection<Worker> getWorkers() {
        return Collections.unmodifiableCollection(this.workers);
    }


    public void add(Worker model) {
        workers.add(model);
    }


    public boolean remove(Worker model) {
        return workers.remove(model);
    }


    public Worker findByName(String name) {

        return workers
                .stream()
                .filter(worker -> worker.getName()
                .equals(name))
                .findFirst()
                .orElse(null);
    }



}
