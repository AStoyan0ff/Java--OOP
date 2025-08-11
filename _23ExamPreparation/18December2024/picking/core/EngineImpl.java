package picking.core;

import picking.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {

    private Controller controller;
    private BufferedReader reader;

    public EngineImpl(Controller controller) {
        this.controller = controller;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public void run() {
        while (true) {
            String result;
            try {
                result = processInput();

                if (result.equals(Command.Exit.name())) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }

    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case AddPlace:
                result = addPlace(data);
                break;
            case AddPicker:
                result = addPicker(data);
                break;
            case StartPicking:
                result = startPicking(data);
                break;
            case GetStatistics:
                result = getStatistics();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }

        return result;
    }

    private String addPlace(String[] data) {
        return controller.addPlace(data[0], Arrays.stream(data).skip(1).toArray(String[]::new));
    }

    private String addPicker(String[] data) {
        return controller.addPicker(data[0], data[1], data[2]);
    }

    private String startPicking(String[] data){
        return controller.startPicking(data[0]);
    }

    private String getStatistics() {
        return controller.getStatistics();
    }
}
