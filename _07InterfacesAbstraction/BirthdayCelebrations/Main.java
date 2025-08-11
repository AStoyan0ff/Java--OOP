package _07InterfacesAbstraction.BirthdayCelebrations;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthableList = new ArrayList<>();

        String input;
        while (!(input = scanner.nextLine()).equals("End")) {

            String[] data = input.split("\\s+");
            String type = data[0];

            switch (type) {
                case "Citizen" -> {

                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String id = data[3];
                    String birthDate = data[4];

                    birthableList.add(new Citizen(name, age, id, birthDate));

                }
                case "Pet" -> {

                    String petName = data[1];
                    String petBirthDate = data[2];

                    birthableList.add(new Pet(petName, petBirthDate));
                }
                case "Robot" -> {

                    String model = data[1];
                    String robotId = data[2];
                    new Robot(model, robotId); // Не се добавя
                }
            }
        }

        String year = scanner.nextLine();

        for (Birthable b : birthableList) {

            if (b.getBirthDate().endsWith(year)) {
                System.out.println(b.getBirthDate());
            }
        }
    }
}
