package aquarium.core;

import aquarium.common.Enums.AquariumTypes;
import aquarium.common.Enums.DecorationTypes;
import aquarium.common.Enums.FishTypes;
import aquarium.core.interfaces.Controller;
import aquarium.entries.aquariums.FreshwaterAquarium;
import aquarium.entries.aquariums.SaltwaterAquarium;
import aquarium.entries.aquariums.interfaces.Aquarium;
import aquarium.entries.decorations.Ornament;
import aquarium.entries.decorations.Plant;
import aquarium.entries.decorations.interfaces.Decoration;
import aquarium.entries.fish.FreshwaterFish;
import aquarium.entries.fish.SaltwaterFish;
import aquarium.entries.fish.interfaces.Fish;
import aquarium.repositories.DecorationRepository;


import java.util.ArrayList;
import java.util.Collection;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private DecorationRepository decorations;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.aquariums = new ArrayList<>();
        this.decorations = new DecorationRepository();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;

        if (AquariumTypes.FreshwaterAquarium.name().equals(aquariumType)) {
            aquarium = new FreshwaterAquarium(aquariumName);
        } else if (AquariumTypes.SaltwaterAquarium.name().equals(aquariumType)) {
            aquarium = new SaltwaterAquarium(aquariumName);
        } else {
            throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }

        this.aquariums.add(aquarium);
        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;

        if (DecorationTypes.Ornament.name().equals(type)) {
            decoration = new Ornament();
        } else if (DecorationTypes.Plant.name().equals(type)) {
            decoration = new Plant();
        } else {
            throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }

        this.decorations.add(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = this.decorations.findByType(decorationType);

        if (decoration == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }

        this.aquariums
                .stream()
                .filter(e -> e.getName().equals(aquariumName))
                .forEach(e -> e.addDecoration(decoration));
        this.decorations.remove(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;
        Aquarium aquarium = this.aquariums
                .stream()
                .filter(e -> e.getName().equals(aquariumName))
                .findFirst()
                .orElse(null);

        if (FishTypes.FreshwaterFish.name().equals(fishType)) {
            fish = new FreshwaterFish(fishName, fishSpecies, price);
        } else if (FishTypes.SaltwaterFish.name().equals(fishType)) {
            fish = new SaltwaterFish(fishName, fishSpecies, price);
        } else {
            throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }

        assert aquarium != null;
        if (!isSuitableWater(aquarium, fishType)) {
            return WATER_NOT_SUITABLE;
        }

        if (aquarium.getFish().size() >= aquarium.getCapacity()) {
            return NOT_ENOUGH_CAPACITY;
        }

        aquarium.addFish(fish);
        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    private boolean isSuitableWater(Aquarium aquarium, String fishType) {
        String aquariumType = aquarium.getClass().getSimpleName();

        return (AquariumTypes.SaltwaterAquarium.name().equals(aquariumType)
                && FishTypes.SaltwaterFish.name().equals(fishType))
                || (AquariumTypes.FreshwaterAquarium.name().equals(aquariumType)
                && FishTypes.FreshwaterFish.name().equals(fishType));
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = this.aquariums
                .stream()
                .filter(e -> e.getName().equals(aquariumName))
                .findFirst()
                .orElse(null);

        assert aquarium != null;
        aquarium.feed();
        return String.format(FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = this.aquariums
                .stream()
                .filter(e -> e.getName().equals(aquariumName))
                .findFirst()
                .orElse(null);

        assert aquarium != null;
        double sum = aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum()
                + aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();

        return String.format(VALUE_AQUARIUM, aquariumName, sum);
    }

    @Override
    public String report() {
        StringBuilder result = new StringBuilder();
        this.aquariums
                .forEach(e -> result.append(e.getInfo()).append(System.lineSeparator()));

        return result.toString().trim();
    }
}
