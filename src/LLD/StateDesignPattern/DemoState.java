package LLD.StateDesignPattern;

public class DemoState {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();

        // Simulate traffic light changes
        trafficLight.change(); // Red Light: Stop!---------Red to Green
        trafficLight.change(); // Green Light: Go!---------Green to Yellow
        trafficLight.change(); // Yellow Light: Caution!---------Yellow to Red
        trafficLight.change(); // Red Light: Stop!---------Red to Green

    }
}
