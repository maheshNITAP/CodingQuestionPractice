package LLD.StateDesignPattern;

public class RedState implements TrafficLightState {

    @Override
    public void action(TrafficLight signal) {
        System.out.println("Red Light: Stop!");
        signal.setState(new GreenState());
    }
}
