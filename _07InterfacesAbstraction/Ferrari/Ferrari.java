package _07InterfacesAbstraction.Ferrari;

public class Ferrari implements Car {

    //public static final String CAR_MODELS = "488-Spider";
    private static final String GAS_PEDAL = "brum-brum-brum-brrrrr";
    private static final String CAR_BRAKES = "Brakes!";

    private final String driverName;
    private final String model;

    public Ferrari(String driverName) {

        this.driverName = driverName;
        this.model ="488-Spider";
    }

    @Override
    public String brakes() {
        return CAR_BRAKES;
    }

    @Override
    public String gas() {
        return GAS_PEDAL;
    }

    @Override
    public String toString() {

        return String.format("%s/%s/%s/%s",
                model,
                brakes(),
                gas(),
                driverName);
    }
}
