package _05Inheritance.NeedForSpeed;

public class Main {
    public static void main(String[] args) {

        Car car = new Car(100, 150);
        car.drive(10.20);

        FamilyCar familyCar = new FamilyCar(60, 150);
        familyCar.drive(10);

        SportCar sportCar = new SportCar(100, 300);
        sportCar.drive(10);

        Motorcycle motorcycle = new Motorcycle(50, 100);
        motorcycle.drive(10);

        RaceMotorcycle raceMotorcycle = new RaceMotorcycle(50, 200);
        raceMotorcycle.drive(10);

        CrossMotorcycle crossMotorcycle = new CrossMotorcycle(50, 150);
        crossMotorcycle.drive(10);
    }
}
