package LLD.ObserverPattern.PullModel.Observable;

import LLD.ObserverPattern.PullModel.Observer.WeatherObserver;
import LLD.ObserverPattern.PullModel.WeatherData;


import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements WeatherObservable {
    private List<WeatherObserver> observers;
    public WeatherData weatherData;

    public WeatherStation() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(WeatherObserver observer) {
        // Implementation to add observer
        observers.add(observer);//storing all observers
    }

    @Override
    public void removeObserver(WeatherObserver observer) {
        // Implementation to remove observer
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        // Implementation to notify observers with the latest weather data
        for(WeatherObserver observer : observers) {
            observer.update();//no need  to pass weather data as observer will have Observables reference and can pull data from it
        }
    }

    @Override
    public void setWeatherReading(float temperature, float humidity, float pressure) {
        this.weatherData =new WeatherData(temperature, humidity, pressure);
        notifyObservers();
    }
}
