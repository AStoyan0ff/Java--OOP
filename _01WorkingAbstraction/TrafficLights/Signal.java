package _01WorkingAbstraction.TrafficLights;

public enum Signal {

    RED,
    GREEN,
    YELLOW;

    public Signal next() {

        return switch (this) {

            case RED -> GREEN;
            case GREEN -> YELLOW;
            case YELLOW -> RED;
        };
    }
}
