package org.me.gcu.grantgemmampdseconddiet;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * this class contains all main methods and tasks for the weather app
 * Created by Gemma Grant s2030516
 * On 07/07/2022
 */
public class MainActivity extends AppCompatActivity implements OnClickListener
{
    /**
     * Declaring all private view components as well as array adapter
     */
    //private Item_Adapter lAdapter;
    private ListView parsedListView;
    private FileXmlPullParser parser;

    //Handler for threading task
    private Handler mHandler;
    //the bottom navigation view
    BottomNavigationView navigationView;
    //private TextView rawDataDisplay;
    private TextView titleText;
    private Button startButton;
    private String result = "";
    private String url1="";
    // BBC Weather XML link
    private String urlSource="https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/2648579";
    private String baseUrl = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/";
    private String[] locationIDs = new String[]{"2648579", "2643743", "5128581", "287286", "934154", "1185241"};
    private String[] locationNames = new String[]{"Glasgow", "London", "New York", "Oman", "Mauritius", "Bangladesh"};
    private ArrayList<Item> items = new ArrayList<>();

    ListView listView;
    //ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Displays the Home Fragment as the default fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new HomeFragment()).commit();
       //
        Log.e("MyTag","in onCreate");
        // Set up the raw links to the graphical components
       // rawDataDisplay = (TextView)findViewById(R.id.rawDataDisplay);
        startButton = (Button)findViewById(R.id.startButton);
        startButton.setOnClickListener(this);
        //titleText = (TextView) findViewById(R.id.titleTxt);
        navigationView = findViewById(R.id.bottom_navigation);

        listView = (ListView) findViewById(R.id.parsedList);

        /**
         * This function allows the user switch from one view in the navigation menu to another
         * This is done by the use of onItemSelectedListener and fragments
         */
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                // A fragement instance set to null in order to be used in the switch statement
                Fragment fragment = null;

                /**
                 * Switch statement used instead of if statement since there are more than 2 options
                 */
                switch(item.getItemId()){
                    case R.id.nav_home:
                        //if the home menu item is set to null, then the fragment instance changes from null to the Home Fragment
                        fragment = new HomeFragment();

                        break;
                    case R.id.nav_weather:
                        //if the weather menu item is set to null, then the fragment instance changes from null to the Weather Fragment
                        fragment = new ListFragment();

                        break;
                    case R.id.nav_search:
                        //if the search menu item is set to null, then the fragment instance changes from null to the Search Fragment
                            fragment = new SearchFragment();

                            break;
                }
                //this code replaces the current fragment with the fragment instance that has been selected from the navigation menu
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();
                return true;
            }
        });
        Log.e("MyTag","after navigation menu selection");

    } // end of OnCreate method



    /**
     * Calls the startProgress method when the start button is envoked
     * @param v
     */
    @Override
    public void onClick(View v)
    {
        Log.e("MyTag","in onClick");
        runApp();
        listView.setVisibility(View.VISIBLE);
        Log.e("MyTag","after runApp");
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
                aurl = new URL(url);
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


               // FileXmlPullParser.parseData(result);
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
                    //creating a new fragment transaction and beginning it
                   // FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    //fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    //creating a new instance of the list fragment here
                    //HomeFragment hFragment = new HomeFragment();

                    //TextView titleText = (TextView) convertView.findViewById(R.id.titleTxt);
                    //titleText.setText(title);
                    //Create a new bundle which we will be used to pass in the list of items into the list view fragment
                    //Bundle bundle = new Bundle();
                    //outSerializable sets the items list to the list view fragment
                    //bundle.putSerializable("ITEMLIST", FileXmlPullParser.items);

                    Log.e("items list" ,": " + items);
                    Log.e("count" ,": " + parser.items.size());
                    //Set the arguments of our fragment to bundle we created with our list
                    //hFragment.setArguments(bundle);




                    ItemAdapter adapter = new ItemAdapter(MainActivity.this, -1,parser.items);
                    listView.setAdapter(adapter);

                    Log.d("post handler", "in thread");
                }
            });
        }
}).start();
}
}