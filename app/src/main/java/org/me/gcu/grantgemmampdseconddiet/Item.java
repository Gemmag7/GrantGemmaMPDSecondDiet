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
     * Declaring the item array list that will hold all data relating to the particular day that the user selects
     */
    private ArrayList<String> day = new ArrayList<>(), minTemp = new ArrayList<>(),  maxTemp = new ArrayList<>(), windSpeed = new ArrayList<>(), Pressure = new ArrayList<>(), Humidity = new ArrayList<>(), uv_risk = new ArrayList<>(), condition = new ArrayList<>(), windDirection = new ArrayList<>(), Visibility = new ArrayList<>(), Pollution = new ArrayList<>(), sunrise = new ArrayList<>(), sunset = new ArrayList<>(), location = new ArrayList<>();


    public ArrayList<String> getDay() {
        return day;
    }

    public void setDay(ArrayList<String> day) {
        this.day = day;
    }

    public ArrayList<String> getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(ArrayList<String> minTemp) {
        this.minTemp = minTemp;
    }

    public ArrayList<String> getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(ArrayList<String> maxTemp) {
        this.maxTemp = maxTemp;
    }

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

    public ArrayList<String> getVisibility() {
        return Visibility;
    }

    public void setVisibility(ArrayList<String> Visibility) {
        this.Visibility = Visibility;
    }

    public ArrayList<String> getPollution() {
        return Pollution;
    }

    public void setPollution(ArrayList<String> Pollution) {
        this.Pollution = Pollution;
    }

    public ArrayList<String> getSunrise() {
        return sunrise;
    }

    public void setSunrise(ArrayList<String> sunrise) {
        this.sunrise = sunrise;
    }

    public ArrayList<String> getSunset() {
        return sunset;
    }

    public void setSunset(ArrayList<String> sunset) {
        this.sunset = sunset;
    }

    public ArrayList<String> getLocation() {
        return location;
    }

    public void setLocation(ArrayList<String> location) {
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
        return maxTemp + ", " + minTemp + ", " + Humidity + ", " + Pollution + "," + Pressure + ", " + uv_risk + ", " + windSpeed + "," + windDirection + "," + sunset + "," + sunrise + "," + Visibility;
    }// End of toString Method


} // End of Item class
