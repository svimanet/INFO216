package no.uib.info216.Models;

/**
 * Created by fox on 5/20/16.
 */
public class Weather {
    private String Temperature;
    private String startDate;
    private String weatherCondition;

    public Weather(String temperature, String startDate, String weatherCondition) {
        this.Temperature = temperature;
        this.startDate = startDate;
        this.weatherCondition = weatherCondition;
    }

    public String getTemprature() {
        return Temperature;
    }

    public void setTemprature(String temperature) {
        Temperature = temperature;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }
}
