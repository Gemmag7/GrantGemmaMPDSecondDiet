package org.me.gcu.grantgemmampdseconddiet;

/**
 * This class is called when user selects the location they wish to view the weather forecast on.
 * the spinner view component will call this class to find the location ID that is required for the URL to display the corresponding data
 * Created by Gemma Grant s2030516 on 19/08/2022
 */
public class Location {

    /**
     * Enum that holds all of the locations for the GCU campuses which is passed into the getLocationID method
     */
    enum City {
        GLASGOW,
        LONDON,
        NEW_YORK,
        OMAN,
        MAURITIUS,
        BANGLADESH
    }


    /**
     * This method finds the id of the location selected by the user.
     * The user selects a location and the method will return the id for the link to the rss feed.
     * The enum previously declared will be passed into the method
     * @return the ID of the location selected by the user
     */
    public static String getLocationID(City location) {

        switch (location) {
            case GLASGOW:
                return "2648579";
            case LONDON:
                return "2643743";
            case NEW_YORK:
                return "5128581";
            case OMAN:
                return "287286";
            case MAURITIUS:
                return "934154";
            case BANGLADESH:
                return "1185241";
            default:
                return "2648579";
        }


    } //End of getLocationID method

}//End of location class
