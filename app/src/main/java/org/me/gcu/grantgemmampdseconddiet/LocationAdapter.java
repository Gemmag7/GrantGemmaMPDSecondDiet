package org.me.gcu.grantgemmampdseconddiet;

import android.content.Context;
import android.media.Image;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * Custom Adapter class that is responsible for holding the list of sites after they
 * get parsed out of XML and returns the selected parsed data in a view fragment
 * Created on the 08/08/2022 by Gemma Grant s2030516
 */
public class LocationAdapter extends ArrayAdapter<Item> {

    private List<Item> items;
    Context mContext;
    private Context ctx;
    int resourceInt;

    /**
     * Constructor used to pass in 3 parameters
     * @param context of the application
     * @param resource an integer number
     * @param data the array list of items
     */
    public LocationAdapter(Context context, int resource, ArrayList<Item> data) {
        super(context, resource, data);
        this.items = data;
        this.mContext = context;
        resourceInt = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Item currentItem = getItem(position);
        Log.d("Position", ":" + currentItem);

        /**
         * Inflating the views from the layout in order to display the listview
         */
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.location_row, parent, false);
        }


        TextView locationName = convertView.findViewById(R.id.location_name);
        locationName.setText(currentItem.getLocation());

        //Setting the cindition to the textview called condition in the xml file
        TextView today = (TextView) convertView.findViewById(R.id.day1);
        //Setting the today to the textview called day1 in the xml file
//        today.setText(currentItem.getDay().get(0));


        //Setting the min_temp to the textview called min_temp in the xml file
        TextView min_temp = convertView.findViewById(R.id.min_temp);
        min_temp.setText("LO: "+ currentItem.getMinTemp().get(0));

        //Setting the maximum temperature to the textview called max_temp in the xml file
        TextView maxTemp1 = convertView.findViewById(R.id.max_temp);
        maxTemp1.setText("HI: " +currentItem.getMaxTemp().get(0));

        //Setting the condition to the textview called condition in the xml file
        TextView condition = convertView.findViewById(R.id.condition);
        //Setting the condition of the weather to the condition of today's weather forecast
        condition.setText(currentItem.getCondition().get(0));

        //Setting the condition_image to the image view in the xml file
        ImageView condition_image = (ImageView) convertView.findViewById(R.id.image_condition);

        //IF and ELSE IF statements used to determine the condition_image component
        //Better coding practoce would be to use a SWITCH/CASE statement
        if(currentItem.getCondition().get(0).contains("Light Cloud")){
            condition_image.setImageResource(R.drawable.cloudy);
        }
        else if (currentItem.getCondition().get(0).contains("Light Rain")){
            condition_image.setImageResource(R.drawable.rain);
        }
        else if (currentItem.getCondition().get(0).contains("Thunder")){
            condition_image.setImageResource(R.drawable.rain_thunder);
        }
        else if (currentItem.getCondition().get(0).contains( "Sleet")){
            condition_image.setImageResource(R.drawable.sleet);
        }
        else if (currentItem.getCondition().get(0).contains( "Snow")){
            condition_image.setImageResource(R.drawable.snow);
        }
        else if (currentItem.getCondition().get(0).contains( "Sunny" )){
            condition_image.setImageResource(R.drawable.day_clear);
        }
        else if (currentItem.getCondition().get(0).contains("Clear Sky")){
            condition_image.setImageResource(R.drawable.day_clear);
        }
        else if (currentItem.getCondition().get(0).contains("Drizzle")){
            condition_image.setImageResource(R.drawable.day_rain);
        }
        else if (currentItem.getCondition().get(0).contains( "fog")){
            condition_image.setImageResource(R.drawable.fog);
        }
        else if (currentItem.getCondition().get(0).contains( "Wind")){
            condition_image.setImageResource(R.drawable.wind);
        }
        else if (currentItem.getCondition().get(0).contains( "Sunny Intervals")){
            condition_image.setImageResource(R.drawable.overcast);
        }
        else if (currentItem.getCondition().get(0).contains( "Partial Rain")){
            condition_image.setImageResource(R.drawable.rain);
        }
        else if (currentItem.getCondition().get(0).contains( "Thundery Showers")){
            condition_image.setImageResource(R.drawable.rain_thunder);
        }


        Log.d("IN_ADAPTER" ,"convertView returned");

        //retrurns the view to the fragment in order to be displayed
        return convertView;
    } // End of getView method


    /**
     * This method calculates the count of the number of items in the item list and returns it back to the user
     * @return the number of items in the item list
     */
    @Override
    public int getCount()
    {

        return items.size();

    } // end of getCount method

}// End of ItemAdapter class