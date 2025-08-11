package harvesters.core;

import harvesters.common.ConstantMessages;
import harvesters.common.ExceptionMessages;
import harvesters.entity.field.CornField;
import harvesters.entity.field.Field;
import harvesters.entity.field.RiceField;
import harvesters.entity.field.WheatField;
import harvesters.entity.harvester.ExpertHarvester;
import harvesters.entity.harvester.Harvester;
import harvesters.entity.harvester.ProficientHarvester;
import harvesters.entity.harvester.UntrainedHarvester;
import harvesters.entity.harvesting.Harvesting;
import harvesters.entity.harvesting.HarvestingImpl;
import harvesters.repository.FieldRepository;
import harvesters.repository.Repository;

public class ControllerImpl implements Controller {

    private Repository<Field> fieldRepository;
    private Harvesting harvesting;

    public ControllerImpl() {

        this.fieldRepository = new FieldRepository();
        this.harvesting = new HarvestingImpl();
    }

    //TODO - Implement all methods

    @Override
    public String addField(String fieldType, String fieldName, int crops) {

        if (crops < 0) {
            throw new IllegalArgumentException(ExceptionMessages.FIELD_CROP_CANNOT_BE_NEGATIVE);
        }

        if (fieldRepository.byName(fieldName) != null) {
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_FIELD);
        }

        Field field = switch (fieldType) {

            case "WheatField" -> new WheatField(fieldName, crops);
            case "RiceField" -> new RiceField(fieldName, crops);
            case "CornField" -> new CornField(fieldName, crops);
            default -> throw new IllegalArgumentException(ExceptionMessages.INVALID_FIELD_TYPE);
        };

        fieldRepository.add(field);
        return String.format(ConstantMessages.FIELD_ADDED, fieldName, fieldType);

    }

    @Override
    public String addHarvester(String fieldName, String harvesterType, String harvesterName) {
        Field field = fieldRepository.byName(fieldName);

        boolean isExists = field
                .getHarvesters()
                .stream()
                .anyMatch(harvester -> harvester.getName().equals(harvesterName));

        if (isExists) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_HARVESTER, harvesterName));
        }

        Harvester harvester = switch (harvesterType) {

            case "UntrainedHarvester" -> new UntrainedHarvester(harvesterName);
            case "ProficientHarvester" -> new ProficientHarvester(harvesterName);
            case "ExpertHarvester" -> new ExpertHarvester(harvesterName);
            default -> throw new IllegalArgumentException(ExceptionMessages.INVALID_HARVESTER);
        };

        field.getHarvesters().add(harvester);
        return String.format(ConstantMessages.HARVESTER_ADDED, harvesterType, harvesterName);

    }

    @Override
    public String goHarvesting(String fieldName) {
        Field field = fieldRepository.byName(fieldName);

        if (field == null) {
            throw new NullPointerException(String.format(ExceptionMessages.NON_EXISTING_FIELD, fieldName));
        }

        harvesting.startHarvesting(field);

        if (field.getCrop() == 0) {

            return String.format(ConstantMessages.NO_MORE_CROPS,
                    field.getName(), field.getClass().getSimpleName());

        }
        else {

            return String.format(ConstantMessages.HARVESTING_FIELD,
                    field.getName(), field.getClass().getSimpleName(), field.getCrop());

        }
    }

    @Override
    public String getStatistics() {
        StringBuilder buff = new StringBuilder();

        for (Field field : fieldRepository.getCollection()) {

            boolean anyHarvest = field
                    .getHarvesters()
                    .stream()
                    .anyMatch(harvester -> harvester.getHarvest() > 0);

            if (anyHarvest) {

                buff.append(String.format(FINAL_HARVEST_FIELD_INFO,
                        field.getName(), field.getClass().getSimpleName()));

                for (Harvester h : field.getHarvesters()) {
                    if (h.getHarvest() > 0) {

                        buff.append(String.format("Name: %s%n", h.getName()));
                        buff.append(String.format("Strength left: %d%n", h.getStrength()));
                        buff.append(String.format("Harvested crops: %d%n", h.getHarvest()));
                    }
                }
            }
        }
        return buff.toString().trim();
    }
}

