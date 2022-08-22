package org.me.gcu.grantgemmampdseconddiet;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
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
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    /**
     * Declaring all private view components as well as array adapter
     */
    //private Item_Adapter lAdapter;
    private ListView parsedListView;
    private FileXmlPullParser parser;
    Location.City locationUrl = Location.City.GLASGOW;
    //Handler for threading task
    private Handler mHandler;
    private String result = "";
    private String url1="";

    // BBC Weather XML link
    private String urlSource="https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/2648579";
    private String baseUrl = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/";


    private ArrayList<Item> items = new ArrayList<>();

    ListView listView;
    //ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  parsedListView.setVisibility(View.VISIBLE);
        String[] locationNames = {"Glasgow", "London", "New York", "Oman", "Mauritius", "Bangladesh"};
        Log.e("MyTag","in onCreate");
        // Set up the raw links to the graphical components
        Spinner spinner = (Spinner)findViewById(R.id.location_selector);
        ArrayAdapter adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, locationNames );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                /**
                 * Switch statement used instead of if statement since there are more than 2 options
                 */
                switch (position) {
                    case 0:
                        //if the home menu item is set to null, then the fragment instance changes from null to the Home Fragment

                        locationUrl = Location.City.GLASGOW;

                        break;
                    case 1:
                        //if the weather menu item is set to null, then the fragment instance changes from null to the Weather Fragment
                        locationUrl = Location.City.LONDON;

                        break;
                    case 2:
                        //if the weather menu item is set to null, then the fragment instance changes from null to the Weather Fragment
                        locationUrl = Location.City.NEW_YORK;

                        break;
                    case 3:
                        //if the weather menu item is set to null, then the fragment instance changes from null to the Weather Fragment
                        locationUrl = Location.City.OMAN;

                        break;
                    case 4:
                        //if the weather menu item is set to null, then the fragment instance changes from null to the Weather Fragment
                        locationUrl = Location.City.MAURITIUS;

                        break;
                    case 5:
                        //if the weather menu item is set to null, then the fragment instance changes from null to the Weather Fragment
                        locationUrl = Location.City.BANGLADESH;

                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
       // listView = (ListView) findViewById(R.id.location_list);
        runApp();
       // listView.setVisibility(View.VISIBLE);


        }


     // end of OnCreate method



    /**
     * Calls the startProgress method when the start button is envoked
     * @param v
     */
    public void onClick(View v)
    {
        Log.e("MyTag","in onClick");
        runApp();
        listView.setVisibility(View.VISIBLE);
        Log.e("MyTag","after runApp");
    }

    /**
     * This function allows the user switch from one view in the navigation menu to another
     * This is done by the use of onItemSelectedListener and fragments
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        /**
         * Switch statement used instead of if statement since there are more than 2 options
         */
        switch (position) {
            case 0:
                //if the home menu item is set to null, then the fragment instance changes from null to the Home Fragment

                locationUrl = Location.City.GLASGOW;

                break;
            case 1:
                //if the weather menu item is set to null, then the fragment instance changes from null to the Weather Fragment
                locationUrl = Location.City.LONDON;

                break;
            case 2:
                //if the weather menu item is set to null, then the fragment instance changes from null to the Weather Fragment
                locationUrl = Location.City.NEW_YORK;

                break;
            case 3:
                //if the weather menu item is set to null, then the fragment instance changes from null to the Weather Fragment
                locationUrl = Location.City.OMAN;

                break;
            case 4:
                //if the weather menu item is set to null, then the fragment instance changes from null to the Weather Fragment
                locationUrl = Location.City.MAURITIUS;

                break;
            case 5:
                //if the weather menu item is set to null, then the fragment instance changes from null to the Weather Fragment
                locationUrl = Location.City.BANGLADESH;

                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
            //When nothing is selected the default value i.e. GLASGOW will be selected
    }


    // Need separate thread to access the internet resource over network
    // Other neater solutions should be adopted in later iterations.
    private class Task implements Runnable
    {
        private String url;

        public Task(String aurl)
        {
            url = aurl;
        }

        @Override
        public void run()
        {

            URL aurl;
            URLConnection yc;
           // BufferedReader in = null;
            String inputLine = "";


            Log.e("MyTag","in run");

            try
            {
                Log.e("MyTag","in try");
                aurl = new URL(baseUrl + Location.getLocationID(locationUrl));
                yc = aurl.openConnection();
                Log.d("yc_open ",yc+"");
                BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
                Log.d("in_open ",in+"");
                Log.e("MyTag","after ready");
                //
                // Now read the data. Make sure that there are no specific hedrs
                // in the data file that you need to ignore.
                // The useful data that you need is in each of the item entries
                //
                while ((inputLine = in.readLine()) != null)
                {
                    result = result + inputLine;
                    //Log.e("MyTag",inputLine);

                }
                Log.d("Result", result + " ");


                in.close();
            }
            catch (IOException ae)
            {
                Log.e("MyTag", "ioexception in run");
            }

            //
            // Now that you have the xml data you can parse it
            //

            // Now update the TextView to display raw XML data
            // Probably not the best way to update TextView
            // but we are just getting started !

            MainActivity.this.runOnUiThread(new Runnable()
            {
                public void run() {
                    Log.d("UI thread", "I am the UI thread");
                    //rawDataDisplay.setText(result);
                    //calling the parseData method to display the parsed data
                    //parseData(result);
                  //  FileXmlPullParser.parseData(result);
                    parser.parseData(result);
                }
            });
        }

    }



    public InputStream getInputStream(URL url){
        try {
            return url.openConnection().getInputStream();
        }
        catch(IOException e){
            return null;
        }
    } //end of getInputStream

// Create Thread to handle the "long running task"
    // In this case it is a counter that will be used
    // represent progress via a progress bar

    /**
     *
     */
    private void runApp(){

        mHandler=new Handler();
        /**
         *
         */
    new Thread(new Runnable()
{
    @Override
    // This is where you implement cod for the task
    public void run()
    {

            //final int currentProgressCount = i;
            try
            {
                Log.e("In HANDLER thread", "in TRY");
                Thread.sleep(50);
                URL aurl;
                URLConnection yc;
                BufferedReader in = null;
                String inputLine = "";


                try
                {
                    aurl = new URL(urlSource);
                    yc = aurl.openConnection();
                    in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

                    while ((inputLine = in.readLine()) != null)
                    {
                        result = result + inputLine;
                    }
                    in.close();
                } catch (MalformedURLException e)
                {
                    e.printStackTrace();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
                
                parser.parseData(result);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }


            // Update the value background thread to UI thread
            // This is done in a further short life length thread
            // to ensure the is no blocking of the "calculation" thread
            mHandler.post(new Runnable()
            {
                @Override
                public void run()
                {
                    Log.d("ItemList" , ": " + parser.items);
                    Log.d("ItemList" , ": " + items);

                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

                    //creating a new instance of the list fragment here
                    ListFragment listFragment = new ListFragment();

                    //Create a new bundle which we will be used to pass in the list of items into the list view fragment
                    Bundle bundle = new Bundle();
                    //outSerializable sets the items list to the list view fragment
                    bundle.putSerializable("ITEMLIST", parser.items);

                    Log.e("items list" ,": " + parser.items);
                    Log.e("count" ,": " + parser.items.size());
                    //Set the arguments of our fragment to bundle we created with our list
                    listFragment.setArguments(bundle);

                    //Tell the activity we are swapping the frameview with our fragment
                    fragmentTransaction.replace(R.id.container, listFragment);

                    fragmentTransaction.addToBackStack(null);

                    /**
                     * commiting the fragment transaction
                     * The commit() call signals to the FragmentManager that all operations have been added to the transaction.
                     **/
                    fragmentTransaction.commit();

                    //ItemAdapter list_adapter = new ItemAdapter(MainActivity.this, -1,parser.items);
                    //parsedListView.setAdapter(list_adapter);

                    Log.d("post handler", "in thread");
                }
            });
        }
}).start();
}
}