package climbers.core;

import climbers.common.ConstantMessages;
import climbers.common.ExceptionMessages;
import climbers.models.climber.Climber;
import climbers.models.climber.RockClimber;
import climbers.models.climber.WallClimber;
import climbers.models.climbing.Climbing;
import climbers.models.climbing.ClimbingImpl;
import climbers.models.mountain.Mountain;
import climbers.models.mountain.MountainImpl;
import climbers.repositories.ClimberRepository;
import climbers.repositories.MountainRepository;
import climbers.repositories.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ControllerImpl implements Controller {

    private final Repository<Mountain> mountainRepository;
    private final Repository<Climber> climberRepository;
    private int climbedMountains;

    public ControllerImpl() {

        this.mountainRepository = new MountainRepository();
        this.climberRepository = new ClimberRepository();
        this.climbedMountains = 0;
    }

    @Override
    public String addClimber(String type, String climberName) {

        Climber climber;

        if (type.equals("WallClimber")) {
            climber = new WallClimber(climberName);
        }
        else if (type.equals("RockClimber")) {
            climber = new RockClimber(climberName);
        }
        else {
            throw new IllegalArgumentException(ExceptionMessages.CLIMBER_INVALID_TYPE);
        }

        climberRepository.add(climber);
        return String.format(ConstantMessages.CLIMBER_ADDED, type, climberName);
    }

    @Override
    public String addMountain(String mountainName, String... peaks) {
        Mountain mountain = new MountainImpl(mountainName);

        for (String peak : peaks) {
            mountain.getPeaksList().add(peak);
        }

        this.mountainRepository.add(mountain);
        return String.format(ConstantMessages.MOUNTAIN_ADDED, mountainName);
    }

    @Override
    public String removeClimber(String climberName) {
        Climber climber = climberRepository.byName(climberName);

        if (climber == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CLIMBER_DOES_NOT_EXIST, climberName));
        }

        climberRepository.remove(climber);
        return String.format(ConstantMessages.CLIMBER_REMOVE, climberName);
    }

    @Override
    public String startClimbing(String mountainName) {
        Collection<Climber> climbers = climberRepository.getCollection();

        if (climbers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.THERE_ARE_NO_CLIMBERS);
        }

        Mountain mountain = this.mountainRepository.byName(mountainName);

        Climbing climbing = new ClimbingImpl();
        climbing.conqueringPeaks(mountain, climbers);

        long removed = climbers
                .stream()
                .filter(d -> d
                        .getStrength() == 0).count();

        this.climbedMountains++;
        return String.format(ConstantMessages.PEAK_CLIMBING, mountainName, removed);
    }

    @Override
    public String getStatistics() {
        StringBuilder buff = new StringBuilder();

        buff.append(String.format(ConstantMessages.FINAL_MOUNTAIN_COUNT, this.climbedMountains));
        buff.append(System.lineSeparator());
        buff.append(ConstantMessages.FINAL_CLIMBERS_STATISTICS);

        Collection<Climber> climbers = climberRepository.getCollection();

        for (Climber climber : climbers) {

            buff.append(System.lineSeparator());
            buff.append(String.format(ConstantMessages.FINAL_CLIMBER_NAME, climber.getName()));
            buff.append(System.lineSeparator());
            buff.append(String.format(ConstantMessages.FINAL_CLIMBER_STRENGTH, climber.getStrength()));
            buff.append(System.lineSeparator());

            if (climber.getRoster().getPeaks().isEmpty()) {
                buff.append(String.format(ConstantMessages.FINAL_CLIMBER_PEAKS, "None"));

            }
            else {
                buff.append(String.format(ConstantMessages.FINAL_CLIMBER_PEAKS,
                        String.join(ConstantMessages.FINAL_CLIMBER_FINDINGS_DELIMITER,
                                climber.getRoster().getPeaks())));
            }
        }
        return buff.toString().trim();
    }
}