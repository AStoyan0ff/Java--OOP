package furnitureFactory.core;

import furnitureFactory.common.ConstantMessages;
import furnitureFactory.common.ExceptionMessages;
import furnitureFactory.core.Interfaces.Controller;
import furnitureFactory.entities.factories.AdvancedFactory;
import furnitureFactory.entities.factories.Interfaces.Factory;
import furnitureFactory.entities.factories.OrdinaryFactory;
import furnitureFactory.entities.wood.Interfaces.Wood;
import furnitureFactory.entities.wood.OakWood;
import furnitureFactory.entities.workshops.DeckingWorkshop;
import furnitureFactory.entities.workshops.TableWorkshop;
import furnitureFactory.entities.workshops.Workshop;
import furnitureFactory.repositories.Interfaces.WoodRepository;
import furnitureFactory.repositories.Interfaces.WorkshopRepository;
import furnitureFactory.repositories.WoodRepositoryImpl;
import furnitureFactory.repositories.WorkshopRepositoryImpl;

import java.util.*;

public class ControllerImpl implements Controller {

    private WoodRepository woodRepository;
    private WorkshopRepository workshopRepository;
    private Collection<Factory> factories;

    public ControllerImpl() {

        this.woodRepository = new WoodRepositoryImpl();
        this.workshopRepository = new WorkshopRepositoryImpl();
        this.factories = new ArrayList<>();
    }

    @Override
    public String buildFactory(String factoryType, String factoryName) {
        Factory factory;

        switch (factoryType) {

            case "OrdinaryFactory" -> factory = new OrdinaryFactory(factoryName);
            case "AdvancedFactory" -> factory = new AdvancedFactory(factoryName);
            default -> throw new IllegalArgumentException(ExceptionMessages.INVALID_FACTORY_TYPE);
        }

        if (factories
                .stream()
                .anyMatch(f -> f.getName()
                .equals(factoryName))) {

            throw new NullPointerException(ExceptionMessages.FACTORY_EXISTS);
        }

        factories.add(factory);
        return String.format(ConstantMessages.SUCCESSFULLY_BUILD_FACTORY_TYPE, factoryType, factoryName);
    }

    @Override
    public Factory getFactoryByName(String factoryName) {

        return factories
                .stream()
                .filter(f -> f.getName()
                .equals(factoryName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String buildWorkshop(String workshopType, int woodCapacity) {
        Workshop workshop;

        switch (workshopType) {

            case "TableWorkshop" -> workshop = new TableWorkshop(woodCapacity);
            case "DeckingWorkshop" -> workshop = new DeckingWorkshop(woodCapacity);
            default -> throw new IllegalArgumentException(ExceptionMessages.INVALID_WORKSHOP_TYPE);
        }

        workshopRepository.add(workshop);
        return String.format(ConstantMessages.SUCCESSFULLY_BUILD_WORKSHOP_TYPE, workshopType);
    }

    @Override
    public String addWorkshopToFactory(String factoryName, String workshopType) {
        Workshop workshop = workshopRepository.findByType(workshopType);

        if (workshop == null) {
            throw new NullPointerException(String.format(ExceptionMessages.NO_WORKSHOP_FOUND, workshopType));
        }

        Factory factory = getFactoryByName(factoryName);

        /*if (factory.getWorkshops().contains(workshop)) {
            throw new IllegalArgumentException(ExceptionMessages.WORKSHOP_EXISTS);
        }*/

        boolean alreadyExists = factory
                .getWorkshops()
                .stream()
                .anyMatch(w -> w.getClass().getSimpleName()
                .equals(workshopType));

        if (alreadyExists) {
            throw new IllegalArgumentException(ExceptionMessages.WORKSHOP_EXISTS);
        }

        boolean bValid = (factory instanceof OrdinaryFactory
                && workshop instanceof TableWorkshop)
                || (factory instanceof AdvancedFactory
                && workshop instanceof DeckingWorkshop);

        if (!bValid) {
            return ExceptionMessages.NON_SUPPORTED_WORKSHOP;
        }

        factory.addWorkshop(workshop);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_WORKSHOP_IN_FACTORY, workshopType, factoryName);
    }


    @Override
    public String buyWoodForFactory(String woodType) {

        Wood wood;

        if (woodType.equals("OakWood")) {
            wood = new OakWood();
        }
        else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_WOOD_TYPE);
        }

        woodRepository.add(wood);
        return String.format(ConstantMessages.SUCCESSFULLY_BOUGHT_WOOD_FOR_FACTORY, woodType);
    }

    @Override
    public String addWoodToWorkshop(String factoryName, String workshopType, String woodType) {
        Factory factory = getFactoryByName(factoryName);

        if (factory.getWorkshops().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.NO_WORKSHOP_ADDED);
        }
        Wood wood = woodRepository.findByType(woodType);

        if (wood == null) {
            throw new NullPointerException(String.format(ExceptionMessages.NO_WOOD_FOUND, woodType));
        }

        for (Workshop workshop : factory.getWorkshops()) {

            if (workshop.getClass().getSimpleName().equals(workshopType)) {

                workshop.addWood(wood);
                woodRepository.remove(wood);

                return String.format(ConstantMessages.SUCCESSFULLY_ADDED_WOOD_IN_WORKSHOP,
                        woodType, workshopType);
            }
        }
        throw new NullPointerException(ExceptionMessages.NO_WORKSHOP_ADDED);
    }

    @Override
    public String produceFurniture(String factoryName) {

        Factory factory = getFactoryByName(factoryName);

        if (factory.getWorkshops().isEmpty()) {
            throw new NullPointerException(String.format(ExceptionMessages.THERE_ARE_NO_WORKSHOPS, factoryName));
        }

        int produced = 0;

        Iterator<Workshop> it = factory.getWorkshops().iterator();
        List<Workshop> toRemove = new ArrayList<>();

        while (it.hasNext()) {
            Workshop workshop = it.next();

            if (workshop.getWoodQuantity() >= workshop.getWoodQuantityReduceFactor()) {

                workshop.produce();
                produced++;

                if (workshop.getWoodQuantity() <= 0) {
                    System.out.printf(ExceptionMessages.WORKSHOP_STOPPED_WORKING, workshop.getClass().getSimpleName());
                    toRemove.add(workshop);
                }
            } else if (workshop.getWoodQuantity() > 0) {
                System.out.println(ExceptionMessages.INSUFFICIENT_WOOD);
            }
            else {
                System.out.printf(ExceptionMessages.WORKSHOP_STOPPED_WORKING, workshop.getClass().getSimpleName());
                toRemove.add(workshop);
            }
        }

        for (Workshop w : toRemove) {

            factory.getWorkshops().remove(w);
            factory.getRemovedWorkshops().add(w);
            workshopRepository.remove(w);
        }

        if (produced > 0) {
            return String.format(ConstantMessages.SUCCESSFUL_PRODUCTION, produced, factoryName);
        } else {
            return String.format(ExceptionMessages.FACTORY_DO_NOT_PRODUCED, factoryName);
        }
    }

    @Override
    public String getReport() {

        StringBuilder buff = new StringBuilder();
        for (Factory factory : factories) {
            buff.append(String.format("Production by %s factory:%n", factory.getName()));

            if (factory.getWorkshops().isEmpty() && factory.getRemovedWorkshops().isEmpty()) {
                buff.append("  No workshops were added to produce furniture.").append(System.lineSeparator());
                continue;
            }

            Map<String, Integer> summary = getInfo(factory);

            for (Map.Entry<String, Integer> pair : summary.entrySet()) {
                buff.append(String.format("  %s: %d furniture produced%n", pair.getKey(), pair.getValue()));
            }
        }
        return buff.toString().trim();
    }

    private static Map<String, Integer> getInfo(Factory factory) {
        Map<String, Integer> summaryMap = new LinkedHashMap<>();

        for (Workshop w : factory.getWorkshops()) {

            String type = w.getClass().getSimpleName();
            summaryMap.put(type, summaryMap.getOrDefault(type, 0) + w.getProducedFurnitureCount());
        }

        for (Workshop w : factory.getRemovedWorkshops()) {

            String type = w.getClass().getSimpleName();
            summaryMap.put(type, summaryMap.getOrDefault(type, 0) + w.getProducedFurnitureCount());
        }
        return summaryMap;
    }
}
