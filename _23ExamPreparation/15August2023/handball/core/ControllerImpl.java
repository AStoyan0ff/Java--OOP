package handball.core;

import handball.common.ConstantMessages;
import handball.common.ExceptionMessages;
import handball.entities.equipment.ElbowPad;
import handball.entities.equipment.Equipment;
import handball.entities.equipment.Kneepad;
import handball.entities.gameplay.Gameplay;
import handball.entities.gameplay.Indoor;
import handball.entities.gameplay.Outdoor;
import handball.entities.team.Bulgaria;
import handball.entities.team.Germany;
import handball.entities.team.Team;
import handball.repositories.EquipmentRepository;
import handball.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private Repository equipment;
    private Collection<Gameplay> gameplays; // Може би и с Map ще стане

    public ControllerImpl() {

        this.equipment = new EquipmentRepository();
        this.gameplays = new ArrayList<>();
    }

    @Override
    public String addGameplay(String gameplayType, String gameplayName) {

        Gameplay gameplay;

        if (gameplayType.equals("Outdoor")) {
            gameplay = new Outdoor(gameplayName);
        }
        else if (gameplayType.equals("Indoor")) {
            gameplay = new Indoor(gameplayName);
        }
        else {
            throw new NullPointerException(ExceptionMessages.INVALID_GAMEPLAY_TYPE);
        }

        gameplays.add(gameplay);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_GAMEPLAY_TYPE, gameplayType);
    }

    @Override
    public String addEquipment(String equipmentType) {
        Equipment equipmentAdd;

        if (equipmentType.equals("Kneepad")) {
            equipmentAdd = new Kneepad();
        }
        else if (equipmentType.equals("ElbowPad")) {
            equipmentAdd = new ElbowPad();
        }
        else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_EQUIPMENT_TYPE);
        }

        equipment.add(equipmentAdd);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_EQUIPMENT_TYPE, equipmentType);
    }

    @Override
    public String equipmentRequirement(String gameplayName, String equipmentType) {
        Equipment equipmentInsert = equipment.findByType(equipmentType);

        if (equipmentInsert == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_EQUIPMENT_FOUND, equipmentType));
        }

        Gameplay gameplay = gameToName(gameplayName);
        gameplay.addEquipment(equipmentInsert);
        equipment.remove(equipmentInsert);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_EQUIPMENT_IN_GAMEPLAY, equipmentType, gameplayName);
    }

    @Override
    public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {
        Team team;

        if (teamType.equals("Bulgaria")) {
            team = new Bulgaria(teamName, country, advantage);
        }
        else if (teamType.equals("Germany")) {
            team = new Germany(teamName, country, advantage);
        }
        else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TEAM_TYPE);
        }

        Gameplay gameplay = gameToName(gameplayName);

        if ((team instanceof Bulgaria && gameplay instanceof Indoor) ||
            (team instanceof Germany  && gameplay instanceof Outdoor)) {

            return ConstantMessages.GAMEPLAY_NOT_SUITABLE;
        }

        gameplay.addTeam(team);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);
    }

    @Override
    public String playInGameplay(String gameplayName) {
        Gameplay gameplay = gameToName(gameplayName);

        gameplay.teamsInGameplay();
        int playedCnt = gameplay.getTeam().size();

        return String.format(ConstantMessages.TEAMS_PLAYED, playedCnt);
    }

    @Override
    public String percentAdvantage(String gameplayName) {
        Gameplay gameplay = gameToName(gameplayName);

        int value = gameplay
                .getTeam()
                .stream()
                .mapToInt(Team::getAdvantage)
                .sum();

        return String.format(ConstantMessages.ADVANTAGE_GAMEPLAY, gameplayName, value);
    }

    @Override
    public String getStatistics() {
        StringBuilder buff = new StringBuilder();

        for (Gameplay gameplay : gameplays) {

            buff.append(gameplay.toString())
                .append(System.lineSeparator());
        }
        return buff.toString().trim();
    }

    private Gameplay gameToName(String name) {

        return gameplays
                .stream()
                .filter(game -> game.getName()
                .equals(name))
                .findFirst()
                .orElseThrow(); // null
    }
}
