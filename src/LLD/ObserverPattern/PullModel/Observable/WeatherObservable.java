package LLD.ObserverPattern.PullModel.Observable;

import LLD.ObserverPattern.PullModel.Observer.WeatherObserver;

public interface WeatherObservable {
    void addObserver(WeatherObserver observer);

    void removeObserver(WeatherObserver observer);

    void notifyObservers();

    void setWeatherReading(float temperature, float humidity, float pressure);
}
