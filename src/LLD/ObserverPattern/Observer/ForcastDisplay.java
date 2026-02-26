package LLD.ObserverPattern.Observer;

import LLD.ObserverPattern.WeatherData;

public class ForcastDisplay implements WeatherObserver {

    private WeatherData weatherData;

    @Override
    public void update(WeatherData weather) {
        this.weatherData = weather;
        display();
    }

    public void display() {
        System.out.println("Displaying forecast conditions:");
        System.out.println("Forcast Display: " + weatherData.getTemperature() + "°C, " + weatherData.getHumidity() + "%, " + weatherData.getPressure() + " hPa");
            System.out.println("---------------------------------------------");
    }
}
