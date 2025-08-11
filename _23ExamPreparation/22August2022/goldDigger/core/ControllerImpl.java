package goldDigger.core;

import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.Repository;
import goldDigger.repositories.SpotRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private Repository<Discoverer> discovererRepository = new DiscovererRepository();
    private Repository<Spot> spotRepository = new SpotRepository();
    private int inspectedSpotCount;

    public ControllerImpl()
    {}

    @Override
    public String addDiscoverer(String kind, String discovererName) {

        Discoverer discoverer;

        if (kind.equals("Archaeologist")) {
            discoverer = new Archaeologist(discovererName);
        }
        else if (kind.equals("Anthropologist")) {
            discoverer = new Anthropologist(discovererName);
        }
        else if (kind.equals("Geologist")) {
            discoverer = new Geologist(discovererName);
        }
        else {
            throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_INVALID_KIND);
        }

        discovererRepository.add(discoverer);
        return String.format(ConstantMessages.DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);

        for (String e : exhibits) {
            spot.getExhibits().add(e);
        }
        spotRepository.add(spot);
        return String.format(ConstantMessages.SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discoverer = discovererRepository.byName(discovererName);

        if (discoverer == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DISCOVERER_DOES_NOT_EXIST,
                    discovererName));
        }

        discovererRepository.remove(discoverer);
        return String.format(ConstantMessages.DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {

        Collection<Discoverer> discoverersList = discovererRepository.getCollection()
                .stream()
                .filter(discoverer -> discoverer.getEnergy() > 45)
                .collect(Collectors.toList());

        if (discoverersList.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }

        Spot spot = this.spotRepository.byName(spotName);
        Operation operation = new OperationImpl();
        operation.startOperation(spot, discoverersList);

        long excludeCnt = discoverersList
                .stream()
                .filter(discoverer -> discoverer.getEnergy() == 0)
                .count();

        this.inspectedSpotCount++;
        return String.format(ConstantMessages.INSPECT_SPOT, spotName, excludeCnt);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%d spots were inspected.%n", inspectedSpotCount));
        sb.append("Information for the discoverers:\n");

        for (Discoverer d : discovererRepository.getCollection()) {

            sb.append(String.format("Name: %s%n", d.getName()));
            sb.append(String.format("Energy: %.0f%n", d.getEnergy()));

            if (d.getMuseum().getExhibits().isEmpty()) {
                sb.append("Museum exhibits: None\n");
            }
            else {
                sb.append("Museum exhibits: ")
                        .append(String.join(", ", d.getMuseum().getExhibits()))
                        .append("\n");
            }
        }

        return sb.toString().trim();
    }
}
