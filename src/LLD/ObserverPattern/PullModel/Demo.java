package LLD.ObserverPattern.PullModel;

import LLD.ObserverPattern.PullModel.Observable.WeatherObservable;
import LLD.ObserverPattern.PullModel.Observable.WeatherStation;
import LLD.ObserverPattern.PullModel.Observer.CurrentConditionDisplay;
import LLD.ObserverPattern.PullModel.Observer.ForcastDisplay;

public class Demo {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        //creating Obervers
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherStation);
        ForcastDisplay forcastDisplay = new ForcastDisplay(weatherStation);

        //change in state so observer get notified
        weatherStation.setWeatherReading(25.0f, 65.0f, 1013.0f);

        //removed observer
        weatherStation.removeObserver(forcastDisplay);

        //again change in state so observer get notified
        weatherStation.setWeatherReading(22.0f, 62.0f, 1022.0f);
    }
}
