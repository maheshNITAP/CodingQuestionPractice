package LLD.ObserverPattern.Observer;

import LLD.ObserverPattern.WeatherData;

public class CurrentConditionDisplay implements WeatherObserver {

    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void update(WeatherData weather) {
        this.temperature = weather.getTemperature();
        this.humidity = weather.getHumidity();
        this.pressure = weather.getPressure();
        display();
    }

    public void display() {
        System.out.println("Displaying current conditions:");
        System.out.println("Current conditions: " + temperature + "F degrees, " + humidity + "% humidity, " + pressure + " Pa");
        System.out.println("---------------------------------------------");
    }
}
