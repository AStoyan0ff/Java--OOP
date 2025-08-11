package _07InterfacesAbstraction.MilitaryElite;
import java.util.ArrayList;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {

    private List<Repair> repairList = new ArrayList<>();

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {

        super(id, firstName, lastName, salary, corps);
        this.repairList = new ArrayList<>();
    }

    @Override
    public Iterable<Mission> getMissions() {
        return getMissions();
    }

    @Override
    public void addRepairs(Repair repair) {
        repairList.add(repair);
    }

    @Override
    public Iterable<Repair> getRepairs() {
        return repairList;
    }

    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder(super.toString()).append(System.lineSeparator()).append("Repairs:");

        for (Repair repair : repairList) {
            buff.append(System.lineSeparator()).append("  ").append(repair.toString());
        }
        return buff.toString();
    }
}
