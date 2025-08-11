package _07InterfacesAbstraction.CarShopExtended;

public interface Rentable extends Car {

    Integer getMinRentDay();
    Double getPricePerDay();
}
