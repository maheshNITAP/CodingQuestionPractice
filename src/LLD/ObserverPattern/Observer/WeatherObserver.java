package LLD.ObserverPattern.Observer;

import LLD.ObserverPattern.WeatherData;

public interface WeatherObserver {
    void update(WeatherData weather);
}
