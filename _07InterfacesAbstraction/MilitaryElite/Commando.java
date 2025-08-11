package _07InterfacesAbstraction.MilitaryElite;

public interface Commando extends SpecialisedSoldier {

    void addMission(Mission mission);
    Iterable<Mission> getMission();
}
