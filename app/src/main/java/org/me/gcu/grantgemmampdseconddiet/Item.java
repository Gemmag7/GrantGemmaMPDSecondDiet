package org.me.gcu.grantgemmampdseconddiet;

// All imports used for the Item class
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * This class obtains all variables, getters & Setters as well as constructors that are needed for an  item found in the rss data feed.
 * Created by Gemma Grant S2030516
 * On 20/06/2022
 */
public class Item {


    /**
     * Declaring all properties of an item here
     */
   // private String title, description, windDirection, windSpeed, Visibility, Pressure, Humidity, Pollution, minTemp, maxTemp, Sunset, Sunrise, uv_risk;
    private ArrayList<String> day = new ArrayList<>(), minTemp = new ArrayList<>(),  maxTemp = new ArrayList<>(), windSpeed = new ArrayList<>(), Pressure = new ArrayList<>(), Humidity = new ArrayList<>(), uv_risk = new ArrayList<>(), condition = new ArrayList<>(), windDirection = new ArrayList<>(), Visibility = new ArrayList<>(), Pollution = new ArrayList<>(), sunrise = new ArrayList<>(), sunset = new ArrayList<>();


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



    /**
     * Empty Constructor for an item.
     * If there is no data to assign, then a new item is created
     * DEFAULT CONSTRUCTOR
     */
    public Item() {
    }



    /**
     * Getter method for finding the title of the item in the rss feed data
     *
     * @return the title of the item that is obtained

    public String getTitle() {
        return title;
    }

    /**
     * Setter method for setting the title of an item in the xml data
     *

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter method for finding the description of the item in the rss feed data
     *
     * @return the found description of the item that is obtained

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter method for finding the wind direction of the item in the rss feed data
     *
     * @return the found wind direction of the item that is obtained

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    /**
     * Getter method for finding the wind speed of the item in the rss feed data
     *
     * @return the found wind speed of the item that is obtained

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    /**
     * Getter method for finding the visibility of the item in the rss feed data
     *
     * @return the visibility of the item that is obtained

    public String getVisibility() {
        return Visibility;
    }

    public void setVisibility(String visibility) {
        Visibility = visibility;
    }

    /**
     * Getter method for finding the pressure of the item in the rss feed data
     *
     * @return the title of the pressure that is obtained

    public String getPressure() {
        return Pressure;
    }

    public void setPressure(String pressure) {
        Pressure = pressure;
    }

    /**
     * Getter method for finding the humidity of the item in the rss feed data
     *
     * @return the humidity of the item that is obtained

    public String getHumidity() {
        return Humidity;
    }

    public void setHumidity(String humidity) {
        Humidity = humidity;
    }

    /**
     * Getter method for finding the UV risk of the item in the rss feed data
     *
     * @return the uv risk of the item that is obtained

    public String getUv_risk() {
        return uv_risk;
    }

    public void setUv_risk(String uv_risk) {
        this.uv_risk = uv_risk;
    }

    /**
     * Getter method for finding the pollution of the item in the rss feed data
     *
     * @return the pollution of the item that is obtained

    public String getPollution() {
        return Pollution;
    }

    public void setPollution(String pollution) {
        Pollution = pollution;
    }

    /**
     * Getter method for finding the minimum temperature of the item in the rss feed data
     *
     * @return the minimum temperature of the item that is obtained

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    /**
     * Getter method for finding the time of when sunset will occur of the item in the rss feed data
     *
     * @return the time for sunset of the item that is obtained

    public String getSunrise() {
        return Sunrise;
    }

    public void setSunrise(String sunrise) {
        Sunrise = sunrise;
    }

    public String getSunset() {
        return Sunset;
    }

    public void setSunset(String sunset) {
        Sunset = sunset;
    }

    /**
     * Getter method for finding the maximum temperature of day item in the rss feed data
     *
     * @return the maximum temperature of the item that is obtained

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    /**
     * Constructor which accepts in parsed title and description of an rss feed item
     * Other details such as min/max temperature can be extracted from the description found
     *
     *
     *                    <p>
     *                    public Item(String title, String description){
     *                    this.title = title;
     *                    this.description = description;
     *                    <p>
     *                    }
     **/

    @Override
    public String toString() {
        return maxTemp + ", " + minTemp + ", " + Humidity + ", " + Pollution + "," + Pressure + ", " + uv_risk + ", " + windSpeed + "," + windDirection + "," + sunset + "," + sunrise + "," + Visibility;
    }// End of toString Method


} // End of Item class
