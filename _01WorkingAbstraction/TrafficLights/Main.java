package _01WorkingAbstraction.TrafficLights;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int N = Integer.parseInt(scanner.nextLine());

        List<TrafficLight> trafficLightList = new ArrayList<>();

        for (String s : input) {

            Signal signal = Signal.valueOf(s);
            trafficLightList.add(new TrafficLight(signal));
        }

        for(int r = 0; r < N; r++) {

            for (TrafficLight l : trafficLightList) {
                l.update();
            }

            for (int c = 0; c < trafficLightList.size(); c++) {
                System.out.print(trafficLightList.get(c));

                if (c < trafficLightList.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            scanner.close();
        }
    }
}
