package _01WorkingAbstraction.TrafficLights;

public class TrafficLight {

    private Signal signal;

    public TrafficLight(Signal signal) {
        this.signal = signal;
    }

    public void update() {
        this.signal = this.signal.next();
    }

    @Override
    public String toString() {
        return signal.name();
    }
}
