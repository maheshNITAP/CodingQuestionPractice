package LLD.ObserverPattern.PullModel.Observer;

import LLD.ObserverPattern.PullModel.Observable.WeatherStation;
import LLD.ObserverPattern.PushModel.WeatherData;

public class ForcastDisplay implements WeatherObserver {


    private final WeatherStation weatherStation;

    public ForcastDisplay(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        this.weatherStation.addObserver(this);
    }

    @Override
    public void update() {
        display();
    }

    public void display() {
        System.out.println("Displaying forecast conditions:");
        System.out.println("Forcast Display: " + weatherStation.weatherData.getTemperature() + "°C, " + weatherStation.weatherData.getHumidity() + "%, " + weatherStation.weatherData.getPressure() + " hPa");
            System.out.println("---------------------------------------------");
    }
}
