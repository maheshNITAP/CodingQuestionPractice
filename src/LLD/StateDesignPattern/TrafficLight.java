package LLD.StateDesignPattern;

public class TrafficLight {
    private TrafficLightState state;

    public TrafficLight() {
        this.state = new RedState(); // Initial state
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void change() {
        state.action(this);
    }
}
