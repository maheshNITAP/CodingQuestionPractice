package LLD.CommandDesignPattern;

public class AirCondition {
    boolean isOn;
    int temperature;

    public void turnOn() {
        isOn = true;
        System.out.println("AC is turned ON");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("AC is turned OFF");
    }

    public boolean isOn() {
        return isOn;
    }

    public boolean isOff() {
        return !isOn;
    }

    public int getTemperature() {
        return temperature;
    }
    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("AC temperature is set to " + temperature);
    }
}
