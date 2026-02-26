package LLD.ObserverPattern.PushModel;

import LLD.ObserverPattern.PushModel.Observable.WeatherObservable;
import LLD.ObserverPattern.PushModel.Observable.WeatherStation;
import LLD.ObserverPattern.PushModel.Observer.CurrentConditionDisplay;
import LLD.ObserverPattern.PushModel.Observer.ForcastDisplay;

public class Demo {
    public static void main(String[] args) {
        WeatherObservable weatherStation = new WeatherStation();

        //creating Obervers
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay();
        ForcastDisplay forcastDisplay = new ForcastDisplay();

        //Adding Observers to Observable/Producers
        weatherStation.addObserver(currentConditionDisplay);
        weatherStation.addObserver(forcastDisplay);

        //change in state so observer get notified
        weatherStation.setWeatherReading(25.0f, 65.0f, 1013.0f);

        //removed observer
        weatherStation.removeObserver(forcastDisplay);

        //again change in state so observer get notified
        weatherStation.setWeatherReading(22.0f, 62.0f, 1022.0f);

    }
}
