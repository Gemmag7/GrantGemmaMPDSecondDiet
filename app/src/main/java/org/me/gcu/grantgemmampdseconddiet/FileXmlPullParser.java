package org.me.gcu.grantgemmampdseconddiet;

/**
 * This class is used to parse the xml data provided into an arraylist that can be used in the application
 * The data is parsed via the parseData method which produces the 'items' array list that is then called in another class
 * Created on the 14/07/2022
 * By Gemma Grant s2030516
 */

// Importing required libraries
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.util.ArrayList;

/**
 * The FileXmlPullParser class is used to read in the xml data and return a parsed version of the data into an arrayList
 * This is useful for displaying the parsed data in the application as it can be called to display android components
 */
public class FileXmlPullParser {

    /**
     * This is declared here since the items array list will be used for many methods
     */
     public static ArrayList<Item> items = new ArrayList<Item>();

    /**
     * parseData method accepts in the xml file and then
     * @param dataToBeParsed is the xml data that is to be parsed
     * @return the newly created array list of items that has been parsed
     */
    public static ArrayList<Item> parseData(String dataToBeParsed)
    {
        Log.d("FileXMLpullParser", "In class");
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(dataToBeParsed));
            int eventType = xpp.getEventType();

            //declaring inside of item to be false as data has not been parsed yet
            //this is useful when parsing so that the application will know when it is inside of item tag that is to be parsed
            boolean insideOfItem = false;
            Item currentItem = new Item();

            /**
             * While loop is used to search through the xml data until the event type reaches until the end of the data
             */
            while (eventType != XmlPullParser.END_DOCUMENT)
            {
               // Check carried out to see if the event type is viewing a start tag
                if (eventType == XmlPullParser.START_TAG)
                {
                    // Check to see if the xpp.getName() will match with the channel tag in the xml data
                    if (xpp.getName().equalsIgnoreCase("channel"))
                    {
                        insideOfItem = false;
                    }
                    // Check to see if the xpp.getName() will match with the image tag in the xml data
                    else if (xpp.getName().equalsIgnoreCase("image"))
                    {
                        insideOfItem = false;
                    }
                    // Check to see if the xpp.getName() will match with the item tage in the xml data
                    // If it does match, then the insideOfItem variable will be set to true since we are now in the item tag
                    else if (xpp.getName().equalsIgnoreCase("item"))
                    {
                        insideOfItem = true;
                    }
                    //
                    else if (xpp.getName().equalsIgnoreCase("title") && insideOfItem)
                    {
                            String title = xpp.nextText();
                            String[] splitTitle = title.split(", ");
                            currentItem.getDay().add(splitTitle[0].split(": ")[0]);
                           // System.out.println(currentItem.getDay().add(splitTitle[0].split(": ")[0]));
                            currentItem.getCondition().add(splitTitle[0].split(": ")[1]);
                            System.out.println(currentItem.getCondition().add(splitTitle[0].split(": ")[1]));
                    } else if (xpp.getName().equalsIgnoreCase("description") && insideOfItem) {
                        String description = xpp.nextText();
                        String[] descriptionDetails = description.split(", ");

                        String[] detailTitles = {"Maximum Temperature","Minimum Temperature", "Wind Direction","Wind Speed", "Visibility", "Pressure", "Humidity", "UV Risk", "Pollution", "Sunrise", "Sunset"
                        };
                        /**
                         * for loop used to loop through the titles of each details for each day for each location
                         * this is done by utilising the descriptionDetails array to find the number of titles to find
                         */
                        for (int j = 0; j < descriptionDetails.length; j++) {
                            //Finds and sets the maximum temperature value to the current item that is being created
                            if(descriptionDetails[j].startsWith(detailTitles[0])){
                                currentItem.getMaxTemp().add(descriptionDetails[j].split(": ")[1]);
                                //Finds and sets the minimum temperature value to the current item that is being created
                            } else if(descriptionDetails[j].startsWith(detailTitles[1])){
                                currentItem.getMinTemp().add(detailTitles[1] + ": " +descriptionDetails[j].split(": ")[1]);

                            }  else if(descriptionDetails[j].startsWith(detailTitles[2])){
                                currentItem.getWindDirection().add(detailTitles[2] + ": " +descriptionDetails[j].split(": ")[1]);
                            } else if(descriptionDetails[j].startsWith(detailTitles[3])){
                                currentItem.getWindSpeed().add(detailTitles[3] + ": " +descriptionDetails[j].split(": ")[1]);
                            } else if(descriptionDetails[j].startsWith(detailTitles[4])){
                                currentItem.getVisibility().add(detailTitles[4] + ": " +descriptionDetails[j].split(": ")[1]);
                            } else if(descriptionDetails[j].startsWith(detailTitles[5])){
                                currentItem.getPressure().add(descriptionDetails[j].split(": ")[1]);
                            } else if(descriptionDetails[j].startsWith(detailTitles[6])){
                                currentItem.getHumidity().add(detailTitles[6] + ": " +descriptionDetails[j].split(": ")[1]);
                            } else if(descriptionDetails[j].startsWith(detailTitles[7])){
                                currentItem.getUvrisk().add(detailTitles[7] + ": " +descriptionDetails[j].split(": ")[1]);
                            } else if(descriptionDetails[j].startsWith(detailTitles[8])){
                                currentItem.getPollution().add(detailTitles[8] + ": " +descriptionDetails[j].split(": ")[1]);
                            } else if(descriptionDetails[j].startsWith(detailTitles[9])){
                                currentItem.getSunrise().add(detailTitles[9] + ": " +descriptionDetails[j].split(": ")[1]);
                            } else if(descriptionDetails[j].startsWith(detailTitles[10])){
                                 currentItem.getSunset().add(detailTitles[10] + ": " +descriptionDetails[j].split(": ")[1]);
                            }
                        }
                    }

                }
                /**
                 * Checks to see if the name of the xml tag is an end tag and also checks if it isd called item
                 * if so, the insideOfItem variable is set to false as we are no longer inside of the item tag
                 */
                else if(eventType==XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("item"))
                {
                    insideOfItem=false;
                }

                else if(eventType==XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("channel"))
                {
                    insideOfItem=false;
                }
                eventType = xpp.next();
            }

            // Adds every currentItem variable to the item arraylist until the for loop is completed
            items.add(currentItem);
            Log.d("ITEMS", ": " +items);
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (XmlPullParserException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        /**
         * The items array list is returned back to the Main activity class in order to be used in the program further
         */
        return items;
    } // End of parseData method
    } //end of FileXmlPullParser class