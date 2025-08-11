package harpoonDiver.core;

import harpoonDiver.common.ConstantMessages;
import harpoonDiver.common.ExceptionMessages;
import harpoonDiver.models.diver.DeepWaterDiver;
import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.diver.OpenWaterDiver;
import harpoonDiver.models.diver.WreckDiver;
import harpoonDiver.models.diving.Diving;
import harpoonDiver.models.diving.DivingImpl;
import harpoonDiver.models.divingSite.DivingSite;
import harpoonDiver.models.divingSite.DivingSiteImpl;
import harpoonDiver.repositories.DiverRepository;
import harpoonDiver.repositories.DivingSiteRepository;
import harpoonDiver.repositories.Repository;

import java.time.chrono.ThaiBuddhistChronology;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private Repository<Diver> diverRepository = new DiverRepository();
    private Repository<DivingSite> divingSiteRepository = new DivingSiteRepository();
    private int siteCount;

    public ControllerImpl()
    {}

    @Override
    public String addDiver(String kind, String diverName) {

        Diver diver;

        switch (kind) {

            case "OpenWaterDiver":
                diver = new OpenWaterDiver(diverName);
                break;

            case "DeepWaterDiver":
                diver = new DeepWaterDiver(diverName);
                break;

            case "WreckDiver":
                diver = new WreckDiver(diverName);
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.DIVER_INVALID_KIND);
        }
        diverRepository.add(diver);
        return String.format(ConstantMessages.DIVER_ADDED, kind, diverName);
    }

    @Override
    public String addDivingSite(String siteName, String... seaCreatures) {
        DivingSite divingSite = new DivingSiteImpl(siteName);

        for (String s : seaCreatures) {
            divingSite.getSeaCreatures().add(s);
        }

        divingSiteRepository.add(divingSite);
        return String.format(ConstantMessages.DIVING_SITE_ADDED, siteName);
    }

    @Override
    public String removeDiver(String diverName) {
        Diver diver = diverRepository.byName(diverName);

        if (diver == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DIVER_DOES_NOT_EXIST, diverName));
        }

        diverRepository.add(diver);
        return String.format(ConstantMessages.DIVER_REMOVE, diverName);
    }

    @Override
    public String startDiving(String siteName) {

        Collection<Diver> diverList = diverRepository
                .getCollection()
                .stream()
                .filter(diver -> diver.getOxygen() > 30)
                .collect(Collectors.toList());

        if (diverList.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.SITE_DIVERS_DOES_NOT_EXISTS);
        }

        DivingSite divingSite = divingSiteRepository.byName(siteName);
        Diving diving = new DivingImpl();

        diving.searching(divingSite, diverList);
        //long
        var remove = diverList
                .stream()
                .filter(diver -> diver.getOxygen() == 0)
                .count();

        siteCount++;
        return String.format(ConstantMessages.SITE_DIVING, siteName, remove);
    }

    @Override
    public String getStatistics() {

        StringBuilder buff = new StringBuilder();

        buff.append(String.format(ConstantMessages.FINAL_DIVING_SITES, this.siteCount));
        buff.append(System.lineSeparator());
        buff.append(ConstantMessages.FINAL_DIVERS_STATISTICS);

        Collection<Diver> divers = diverRepository.getCollection();

        for (Diver div : divers) {

            buff.append(System.lineSeparator());
            buff.append(String.format(ConstantMessages.FINAL_DIVER_NAME, div.getName()));
            buff.append(System.lineSeparator());
            buff.append(String.format(ConstantMessages.FINAL_DIVER_OXYGEN, div.getOxygen()));
            buff.append(System.lineSeparator());

            if (div.getSeaCatch().getSeaCreatures().isEmpty()) {
                buff.append(String.format(ConstantMessages.FINAL_DIVER_CATCH, "None"));

            }
            else {
                buff.append(String.format(ConstantMessages.FINAL_DIVER_CATCH,
                        String.join(ConstantMessages.FINAL_DIVER_CATCH_DELIMITER,
                                div.getSeaCatch().getSeaCreatures())));
            }
        }
        return buff.toString().trim();
    }
}
