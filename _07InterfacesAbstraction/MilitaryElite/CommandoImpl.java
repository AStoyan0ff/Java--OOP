package _07InterfacesAbstraction.MilitaryElite;
import java.util.ArrayList;
import java.util.List;

public abstract class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private List<Mission> missionList;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {

        super(id, firstName, lastName, salary, corps);
        this.missionList = new ArrayList<>();

    }

    @Override
    public void addMission(Mission mission) {
        missionList.add(mission);
    }

    @Override
    public Iterable<Mission> getMissions() {
        return missionList;
    }

    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder(super.toString()).append(System.lineSeparator()).append("Missions:");

        for (Mission mission : missionList) {
            buff.append(System.lineSeparator()).append("  ").append(mission.toString());
        }
        return buff.toString();
    }
}
