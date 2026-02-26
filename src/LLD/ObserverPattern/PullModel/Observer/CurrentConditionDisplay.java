package LLD.ObserverPattern.PullModel.Observer;

import LLD.ObserverPattern.PullModel.Observable.WeatherStation;
import LLD.ObserverPattern.PullModel.WeatherData;

public class CurrentConditionDisplay implements WeatherObserver {


    private float temperature;
    private float humidity;
    private float pressure;

    private final WeatherStation weatherStation;

    public CurrentConditionDisplay(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        this.weatherStation.addObserver(this);
    }

    @Override
    public void update() {
        display();
    }

    public void display() {
        System.out.println("Displaying current conditions:");
        System.out.println("Current conditions: " + weatherStation.weatherData.getTemperature()+ "F degrees, " + weatherStation.weatherData.getHumidity() + "% humidity, " + weatherStation.weatherData.getPressure() + " Pa");
        System.out.println("---------------------------------------------");
    }
}
