package no.uib.info216.Models;

/**
 * Created by fox on 5/20/16.
 */
public class Weather {
    private String Temrature;
    private String startDate;
    private String weatherCondition;

    public Weather(String temrature, String startDate, String weatherCondition) {
        Temrature = temrature;
        this.startDate = startDate;
        this.weatherCondition = weatherCondition;
    }

    public String getTemrature() {
        return Temrature;
    }

    public void setTemrature(String temrature) {
        Temrature = temrature;
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
