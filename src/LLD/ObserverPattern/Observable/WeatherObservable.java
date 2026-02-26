package LLD.ObserverPattern.Observable;

import LLD.ObserverPattern.Observer.WeatherObserver;

public interface WeatherObservable {
    void addObserver(WeatherObserver observer);

    void removeObserver(WeatherObserver observer);

    void notifyObservers();

    void setWeatherReading(float temperature, float humidity, float pressure);
}
