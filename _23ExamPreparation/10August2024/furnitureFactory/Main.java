package furnitureFactory;

import furnitureFactory.core.Interfaces.Engine;
import furnitureFactory.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}