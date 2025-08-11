package _07InterfacesAbstraction.MilitaryElite;

public interface Engineer extends SpecialisedSoldier {

    void addRepairs(Repair repair);
    Iterable<Repair> getRepairs();
}
