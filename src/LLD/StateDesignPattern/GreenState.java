package LLD.StateDesignPattern;

public class GreenState implements TrafficLightState {

    @Override
    public void action(TrafficLight signal) {
        System.out.println("Green Light: Go!");
        signal.setState(new YellowState());
    }
}
