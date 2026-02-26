package LLD.ObserverPattern.PushModel.Observer;

import LLD.ObserverPattern.PushModel.WeatherData;

public interface WeatherObserver {
    void update(WeatherData weather);//passes weather info to observers
}
