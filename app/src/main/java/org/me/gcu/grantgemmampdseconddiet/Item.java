package org.me.gcu.grantgemmampdseconddiet;

// All imports used for the Item class
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * This class obtains all variables, getters & Setters as well as constructors that are needed for an  item found in the rss data feed.
 * Created by Gemma Grant S2030516
 * On 20/07/2022
 */
public class Item {


    /**
     * Declaring the item array list and String location name that will hold all data relating to the particular day that the user selects
     */
    private ArrayList<String> day = new ArrayList<>(), minTemp = new ArrayList<>(),  maxTemp = new ArrayList<>(), windSpeed = new ArrayList<>(), Pressure = new ArrayList<>(), Humidity = new ArrayList<>(), uv_risk = new ArrayList<>(), condition = new ArrayList<>(), windDirection = new ArrayList<>(), Visibility = new ArrayList<>(), Pollution = new ArrayList<>(), sunrise = new ArrayList<>(), sunset = new ArrayList<>();
    private String location;

    //Getter for obtaining the day for the forecast i.e. today, tomorrow or the day after
    public ArrayList<String> getDay() {
        return day;
    }

    public void setDay(ArrayList<String> day) {
        this.day = day;
    }
    //Getter for obtaining the minimum temperature for the forecast
    public ArrayList<String> getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(ArrayList<String> minTemp) {
        this.minTemp = minTemp;
    }

    //Getter for obtaining the day for the maximum temperature
    public ArrayList<String> getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(ArrayList<String> maxTemp) {
        this.maxTemp = maxTemp;
    }

    //Getter for obtaining the windspeed for the forecast
    public ArrayList<String> getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(ArrayList<String> windSpeed) {
        this.windSpeed = windSpeed;
    }

    public ArrayList<String> getPressure() {
        return Pressure;
    }

    public void setPressure(ArrayList<String> Pressure) {
        this.Pressure = Pressure;
    }

    public ArrayList<String> getHumidity() {
        return Humidity;
    }

    public void setHumidity(ArrayList<String> Humidity) {
        this.Humidity = Humidity;
    }

    public ArrayList<String> getUvrisk() {
        return uv_risk;
    }

    public void setUvrisk(ArrayList<String> uv_risk) {
        this.uv_risk = uv_risk;
    }

    public ArrayList<String> getCondition() {
        return condition;
    }

    public void setRain(ArrayList<String> condition) {
        this.condition = condition;
    }

    public ArrayList<String> getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(ArrayList<String> windDirection) {
        this.windDirection = windDirection;
    }

    //Getter for obtaining the day for the forecast i.e. today, tomorrow or the day after
    public ArrayList<String> getVisibility() {
        return Visibility;
    }

    public void setVisibility(ArrayList<String> Visibility) {
        this.Visibility = Visibility;
    }

    //Getter for obtaining the level of pollution for the forecast
    public ArrayList<String> getPollution() {
        return Pollution;
    }

    public void setPollution(ArrayList<String> Pollution) {
        this.Pollution = Pollution;
    }

    //Getter for obtaining the time for the sun to rise for the forecast
    public ArrayList<String> getSunrise() {
        return sunrise;
    }

    public void setSunrise(ArrayList<String> sunrise) {
        this.sunrise = sunrise;
    }

    //Getter for obtaining the time for the sunset for the forecast
    public ArrayList<String> getSunset() {
        return sunset;
    }

    public void setSunset(ArrayList<String> sunset) {
        this.sunset = sunset;
    }

    //Getter for obtaining the location for the forecast
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Empty Constructor for an item.
     * If there is no data to be assigned, then a new weather item is created
     * DEFAULT CONSTRUCTOR
     */
    public Item() {
    }


    /**
     * Returns a string array back to the application
     * @return the values for each detail in a array which is further contained in another array
     */
    @Override
    public String toString() {
        return location + ", " +maxTemp + ", " + minTemp + ", " + Humidity + ", " + Pollution + "," + Pressure + ", " + uv_risk + ", " + windSpeed + "," + windDirection + "," + sunset + "," + sunrise + "," + Visibility;
    }// End of toString Method


} // End of Item class
