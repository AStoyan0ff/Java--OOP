package _07InterfacesAbstraction.MilitaryElite;

public class MissionImpl implements Mission {

    private String codeName;
    private String state;

    public MissionImpl(String codeName, String state) {
        this.codeName = codeName;
        this.state = state;
    }

    @Override public String getCodeName() {
        return codeName;
    }
    @Override public String getState() {
        return state;
    }

    @Override
    public void completeMission() {
        this.state = "finished";
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", codeName, state);
    }
}
