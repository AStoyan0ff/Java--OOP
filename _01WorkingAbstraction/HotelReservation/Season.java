package _01WorkingAbstraction.HotelReservation;

public enum Season {

    Autumn(1),
    Spring(2),
    Winter(3),
    Summer(4);

    private final int multiplier;

    Season(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
