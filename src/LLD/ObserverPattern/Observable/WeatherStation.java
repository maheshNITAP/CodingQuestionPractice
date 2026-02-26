package LLD.ObserverPattern.Observable;

import LLD.ObserverPattern.Observer.WeatherObserver;
import LLD.ObserverPattern.WeatherData;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements WeatherObservable {
    private List<WeatherObserver> observers;
    private WeatherData weatherData;

    public WeatherStation() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(WeatherObserver observer) {
        // Implementation to add observer
        observers.add(observer);
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
            observer.update(weatherData);
        }
    }

    @Override
    public void setWeatherReading(float temperature, float humidity, float pressure) {
        this.weatherData =new WeatherData(temperature, humidity, pressure);
        notifyObservers();
    }
}
