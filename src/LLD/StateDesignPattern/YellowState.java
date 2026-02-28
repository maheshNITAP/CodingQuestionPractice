package LLD.StateDesignPattern;

public class YellowState implements TrafficLightState {

    @Override
    public void action(TrafficLight signal) {
        System.out.println("Yellow Light: Caution!");
        signal.setState(new RedState());
    }
}
