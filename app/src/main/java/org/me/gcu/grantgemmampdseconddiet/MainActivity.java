package org.me.gcu.grantgemmampdseconddiet;

import androidx.appcompat.app.AppCompatActivity;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


/**
 * this class contains all main methods and tasks for the weather app
 * Created by Gemma Grant s2030516
 * On 07/07/2022
 */
public class MainActivity extends AppCompatActivity {
    /**
     * Declaring all private view components as well as array adapter
     */
    private ItemAdapter itemAdapter;
    private ListView parsedListView;
    private FileXmlPullParser parser;
    ItemAdapter arrayAdapter;
    //Handler for threading task
    private Handler mHandler;
    private String result = "";
    // BBC Weather XML link
    private String baseUrl;

     private ArrayList<Item> items = new ArrayList<>();

    //Declaring listview variable here since multiple listviews are used in application
    ListView listView;

    //String array locationNames declared here to be added to Item array list
    String[] locationNames = {"Glasgow", "London", "New York", "Oman", "Mauritius", "Bangladesh"};
    //String array locationID declared here to find the weather data from using the baseURL and concantign with the locationID from the array
    String[] locationID = new String[] {"2648579", "2643743", "5128581", "287286", "934154", "1185241"};

    /**
     * OnCreate method loads all necessary methods and view components that are essential for the app to run/display when the user runs the application
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //Setting the content view to the activity_main.xml file
        setContentView(R.layout.activity_main);

        
        //Calls the runApp thread to begin the parsing of the data
        runApp();

        Log.e("MyTag","in onCreate");

        //baseUrl declared here to be used later in the application
        baseUrl = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/";

        // Set up the raw links to the graphical components
        //listview is set to the location_list listview component that is in the activity_main.xml file
         listView = (ListView) findViewById(R.id.location_list);

        /**
         * Method
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

           // Initiating a new intent and passing in the mainActivity context and the new Activity class
        Intent intent = new Intent(MainActivity.this, ListDataActivity.class);

        //passing in the selected location data to the intent
        intent.putExtra("items", items.get(position));
            
            //Starting the list_data_activity that will display the 3-day detailed weather forecast
            startActivity(intent);
        }
    });
        
    } // End of OnCreate method

    /**
     * This method is in charge of getting the input stream to
     * @param url passed in to the method
     * @return returns the input stream
     */
    public InputStream getInputStream(URL url){
        try {
            return url.openConnection().getInputStream();
        }
        catch(IOException e){
            return null;
        }
    } //end of getInputStream


    /**
     * This thread is in charge of running the application
     */
    private void runApp(){

        //instantiating a new instance of handler
        mHandler=new Handler();

    new Thread(new Runnable()
{
    @Override
    // This is where you implement cod for the task
    public void run()
    {
            try
            {
                Log.e("In HANDLER thread", "in TRY");
                //Log.e("DSelected location", ":" + locationID);
                Thread.sleep(500);
                URL aurl;
                URLConnection yc;
                BufferedReader in = null;
                String inputLine = "";
                for (int i =0; i <locationID.length; i++) {
                    Item item = new  Item ();

                    try {
                        //aurl is set to both the baseUrl and the locationID which is obtained for each location and held in an array
                        aurl = new URL(baseUrl + locationID[i]);
                        //Keeping track of the urls so a log statement is used
                        Log.e("urls", ":" + aurl);
                        //Setting the item's location to each location name in the locationNames array
                        item.setLocation(locationNames[i]);
                        //Creating a new instance of the XmlPullParseFactory called newFcatory
                        XmlPullParserFactory newFactory =  XmlPullParserFactory.newInstance();
                        //Setting the namespace awareness to false
                        newFactory.setNamespaceAware(false);
                        //creating a new instance of XmlPullParser called pullParser
                        XmlPullParser pullParser = newFactory.newPullParser();
                        //Setting the input of pullParser to call the getInputStream method and pass in each url for each item created whilst ensuring that the encoding is utf_8
                        pullParser.setInput(getInputStream(aurl), "UTF_8");

                        int eventType = pullParser.getEventType();

                        /**
                         * Whilst there is a separate parsing file, the parsing code is repeated here in order to add the location names from the urls of the api and add each location name to the item object
                         * Until this is resolved, the parsing code will be kept here
                         */
                        boolean insideOfItem = false;


                        /**
                         * While loop is used to search through the xml data until the event type reaches until the end of the data
                         */
                        while (eventType != XmlPullParser.END_DOCUMENT) {
                            // Check carried out to see if the event type is viewing a start tag
                            if (eventType == XmlPullParser.START_TAG) {
                                // Check to see if the xpp.getName() will match with the channel tag in the xml data
                                if (pullParser.getName().equalsIgnoreCase("channel")) {
                                    insideOfItem = false;
                                }
                                // Check to see if the xpp.getName() will match with the image tag in the xml data
                                else if (pullParser.getName().equalsIgnoreCase("image")) {
                                    insideOfItem = false;
                                }
                                // Check to see if the xpp.getName() will match with the item tage in the xml data
                                // If it does match, then the insideOfItem variable will be set to true since we are now in the item tag
                                else if (pullParser.getName().equalsIgnoreCase("item")) {
                                    insideOfItem = true;
                                }
                                //
                                else if (pullParser.getName().equalsIgnoreCase("title") && insideOfItem) {
                                    String title = pullParser.nextText();
                                    String[] splitTitle = title.split(", ");
                                    item.getDay().add(splitTitle[0].split(": ")[0]);
                                    item.getCondition().add(splitTitle[0].split(": ")[1]);

                                } else if (pullParser.getName().equalsIgnoreCase("description") && insideOfItem) {
                                    //Setting the variable 'description' to the next text in the item in order to obtain the weather details
                                    String description = pullParser.nextText();

                                    //Extracting the weather details from the description variable by using the .split() method
                                    String[] descriptionDetails = description.split(", ");

                                    //Creating a detailTitles array which hiolds all of the relevant titles of each weather detail in the item data
                                    String[] detailTitles = {"Maximum Temperature", "Minimum Temperature", "Wind Direction", "Wind Speed", "Visibility", "Pressure", "Humidity", "UV Risk", "Pollution", "Sunrise", "Sunset"
                                    };
                                    /**
                                     * for loop used to loop through the titles of each details for each day for each location
                                     * this is done by utilising the descriptionDetails array to loop until the end of the descriptionDetails array
                                     * to find the relevant details for each currentItem which is then added to the items array.
                                     * This loop will complete once the end of the descriptionDetails array has ended.
                                     */
                                    for (int j = 0; j < descriptionDetails.length; j++) {
                                        //Finds and sets the maximum temperature value to the current item that is being created
                                        if (descriptionDetails[j].startsWith(detailTitles[0])) {
                                            item.getMaxTemp().add(descriptionDetails[j].split(": ")[1]);
                                            //Finds and sets the minimum temperature value to the current item that is being created
                                        } else if (descriptionDetails[j].startsWith(detailTitles[1])) {
                                            item.getMinTemp().add(descriptionDetails[j].split(": ")[1]);
                                            //Finds and sets the wind direction value to the current item that is being created
                                        } else if (descriptionDetails[j].startsWith(detailTitles[2])) {
                                            item.getWindDirection().add(descriptionDetails[j].split(": ")[1]);
                                            //Finds and sets the wind speed value to the current item that is being created
                                        } else if (descriptionDetails[j].startsWith(detailTitles[3])) {
                                            item.getWindSpeed().add(descriptionDetails[j].split(": ")[1]);
                                            //Finds and sets the visibility value to the current item that is being created
                                        } else if (descriptionDetails[j].startsWith(detailTitles[4])) {
                                            item.getVisibility().add(descriptionDetails[j].split(": ")[1]);
                                            //Finds and sets the pressure value to the current item that is being created
                                        } else if (descriptionDetails[j].startsWith(detailTitles[5])) {
                                            item.getPressure().add(descriptionDetails[j].split(": ")[1]);
                                            //Finds and sets the humidity value to the current item that is being created
                                        } else if (descriptionDetails[j].startsWith(detailTitles[6])) {
                                            item.getHumidity().add(descriptionDetails[j].split(": ")[1]);
                                            //Finds and sets the uv risk value to the current item that is being created
                                        } else if (descriptionDetails[j].startsWith(detailTitles[7])) {
                                            item.getUvrisk().add(descriptionDetails[j].split(": ")[1]);
                                            //Finds and sets the pollution value to the current item that is being created
                                        } else if (descriptionDetails[j].startsWith(detailTitles[8])) {
                                            item.getPollution().add(descriptionDetails[j].split(": ")[1]);
                                            //Finds and sets the sunrise value to the current item that is being created
                                        } else if (descriptionDetails[j].startsWith(detailTitles[9])) {
                                            item.getSunrise().add(descriptionDetails[j].split(": ")[1]);
                                            //Finds and sets the sunset value to the current item that is being created
                                        } else if (descriptionDetails[j].startsWith(detailTitles[10])) {
                                            item.getSunset().add(descriptionDetails[j].split(": ")[1]);
                                        }
                                    } // End of FOR LOOP
                                } //End of checking the description tag from rss feed

                            } //End of checking the starting tag

                            /**
                             * Checks to see if the name of the xml tag is an end tag and also checks if it isd called item
                             * if so, the insideOfItem variable is set to false as we are no longer inside of the item tag
                             */
                            else if (eventType == XmlPullParser.END_TAG && pullParser.getName().equalsIgnoreCase("item")) {
                                insideOfItem = false;
                            }
                            eventType = pullParser.next();
                        }
                        // Adds every currentItem variable to the item arraylist until the for loop is completed
                            items.add(item);





                        //items.add(item);
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
                } //End of FOR LOOP
            } //End of try
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }


            //This will inflate the homepage with the basic weather forecast
            mHandler.post(new Runnable()
            {
                @Override
                public void run()
                {
                    LocationAdapter lAdapter = new LocationAdapter(MainActivity.this, -1, items);
                    listView.setAdapter(lAdapter);
                }
            });
        } //end of run thread
    }).start();
} //end of runApp method
} //end of mainActiivty class