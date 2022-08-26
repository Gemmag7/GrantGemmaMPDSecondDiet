package org.me.gcu.grantgemmampdseconddiet;

// All imports used for the Item class
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * This class obtains all variables, getters & Setters as well as constructors that are needed for an  item found in the rss data feed.
 * Created by Gemma Grant S2030516 On 20/07/2022
 * Thisd class implements the parcelable class so that a selected item and all of its data can be passed to the detailed activity
 */
public class Item implements Parcelable {


    /**
     * Declaring the item array list and String location name that will hold all data relating to the particular day that the user selects
     */
    private ArrayList<String> day = new ArrayList<>(), minTemp = new ArrayList<>(),  maxTemp = new ArrayList<>(), windSpeed = new ArrayList<>(), Pressure = new ArrayList<>(), Humidity = new ArrayList<>(), uv_risk = new ArrayList<>(), condition = new ArrayList<>(), windDirection = new ArrayList<>(), Visibility = new ArrayList<>(), Pollution = new ArrayList<>(), sunrise = new ArrayList<>(), sunset = new ArrayList<>();
    private String location;

    /**
     * This creates an Item object that can be passed into the detailed activity by creating a new string array list
     * @param in
     */
    protected Item(Parcel in) {
        day = in.createStringArrayList();
        minTemp = in.createStringArrayList();
        maxTemp = in.createStringArrayList();
        windSpeed = in.createStringArrayList();
        Pressure = in.createStringArrayList();
        Humidity = in.createStringArrayList();
        uv_risk = in.createStringArrayList();
        condition = in.createStringArrayList();
        windDirection = in.createStringArrayList();
        Visibility = in.createStringArrayList();
        Pollution = in.createStringArrayList();
        sunrise = in.createStringArrayList();
        sunset = in.createStringArrayList();
        location = in.readString();
    }

    /**
     *This method creates the item that will be created to be parcelabel
     */
    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        /**
         * Creates a new array from the position of the selected Item
         * @param size an integer value that will be able to find the selected item
         * @return the selected value of the item
         */
        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    //Getter for obtaining the day value for the forecast i.e. today, tomorrow or the day after
    public ArrayList<String> getDay() {
        return day;
    }

    //Setter for setting the day to the weather forecast (i.e. Today, tomorrow and the day after)
    public void setDay(ArrayList<String> day) {
        this.day = day;
    }
    //Getter for obtaining the minimum temperature value for the forecast
    public ArrayList<String> getMinTemp() {
        return minTemp;
    }

    //Setter for setting the minimum temperature value to the minTemp arrayList
    public void setMinTemp(ArrayList<String> minTemp) {
        this.minTemp = minTemp;
    }

    //Getter for obtaining the day value for the maximum temperature
    public ArrayList<String> getMaxTemp() {
        return maxTemp;
    }

    //Setter for setting the maximum temperature value to the maxTemp arrayList
    public void setMaxTemp(ArrayList<String> maxTemp) {
        this.maxTemp = maxTemp;
    }

    //Getter for obtaining the windSpeed value for the forecast
    public ArrayList<String> getWindSpeed() {
        return windSpeed;
    }

    //Setter for setting the wind speed value to the windSpeed arrayList
    public void setWindSpeed(ArrayList<String> windSpeed) {
        this.windSpeed = windSpeed;
    }

    //Getter for obtaining the Pressure value for the forecast
    public ArrayList<String> getPressure() {
        return Pressure;
    }

    //Setter for setting the pressure value to the Pressure arrayList
    public void setPressure(ArrayList<String> Pressure) {
        this.Pressure = Pressure;
    }

    //Getter for obtaining the humidity value for the forecast
    public ArrayList<String> getHumidity() {
        return Humidity;
    }

    //Setter for setting the Humidity value to the Humidity arrayList
    public void setHumidity(ArrayList<String> Humidity) {
        this.Humidity = Humidity;
    }

    //Getter for obtaining the uv_risk value for the forecast
    public ArrayList<String> getUvrisk() {
        return uv_risk;
    }

    //Setter for setting the uv_risk value to the uv_risk arrayList
    public void setUvrisk(ArrayList<String> uv_risk) {
        this.uv_risk = uv_risk;
    }

    //Getter for obtaining the condition value for the forecast
    public ArrayList<String> getCondition() {
        return condition;
    }

    //Setter for setting the condition values to the condition arrayList
    public void setCondition(ArrayList<String> condition) {
        this.condition = condition;
    }

    //Getter for obtaining the windDirection value for the forecast
    public ArrayList<String> getWindDirection() {
        return windDirection;
    }

    //Setter for setting the wind direction value to the windDirection arrayList
    public void setWindDirection(ArrayList<String> windDirection) {
        this.windDirection = windDirection;
    }

    //Getter for obtaining the visibility value for the forecast
    public ArrayList<String> getVisibility() {
        return Visibility;
    }

    //Setter for setting the visibility value to the Visibility arrayList
    public void setVisibility(ArrayList<String> Visibility) {
        this.Visibility = Visibility;
    }

    //Getter for obtaining the level of pollution for the forecast
    public ArrayList<String> getPollution() {
        return Pollution;
    }

    //Setter for setting the pollution value to the Pollution arrayList
    public void setPollution(ArrayList<String> Pollution) {
        this.Pollution = Pollution;
    }

    //Getter for obtaining the time for the sun to rise for the forecast
    public ArrayList<String> getSunrise() {
        return sunrise;
    }

    //Setter for setting the sunrise value to the sunrise arrayList
    public void setSunrise(ArrayList<String> sunrise) {
        this.sunrise = sunrise;
    }

    //Getter for obtaining the time for the sunset for the forecast
    public ArrayList<String> getSunset() {
        return sunset;
    }

    //Setter for setting the sunset value to the sunset arrayList
    public void setSunset(ArrayList<String> sunset) {
        this.sunset = sunset;
    }

    //Getter for obtaining the string location value for the forecast
    public String getLocation() {
        return location;
    }

    //Setter for setting the string location value to the location variable
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


    //This is one of the many implemented Parcelable methods that is essential for the parcelable to be utilised in the application
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * This method creates the arraylist that has to be created to be passed into the detailed activity class
     * @param dest is the destination to where the string list is sending the variables
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(day);
        dest.writeStringList(minTemp);
        dest.writeStringList(maxTemp);
        dest.writeStringList(windSpeed);
        dest.writeStringList(Pressure);
        dest.writeStringList(Humidity);
        dest.writeStringList(uv_risk);
        dest.writeStringList(condition);
        dest.writeStringList(windDirection);
        dest.writeStringList(Visibility);
        dest.writeStringList(Pollution);
        dest.writeStringList(sunrise);
        dest.writeStringList(sunset);
        dest.writeString(location);
    } //End of writeToParcel method

} // End of Item class
