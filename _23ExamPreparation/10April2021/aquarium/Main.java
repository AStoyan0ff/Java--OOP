package aquarium;

import aquarium.core.interfaces.Engine;
import aquarium.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();
    }
}
