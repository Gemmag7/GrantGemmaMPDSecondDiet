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
        //locationName.setText(convertView.findViewById(R.id.location_selector.getItemAtPosition));


        TextView day1 = (TextView) convertView.findViewById(R.id.day1);
        Log.d("day1", ":" + day1);


        TextView min_temp = convertView.findViewById(R.id.min_temp);
        min_temp.setText("LO: "+ currentItem.getMinTemp().get(0));

        TextView maxTemp1 = convertView.findViewById(R.id.max_temp);
        maxTemp1.setText("HI: " +currentItem.getMaxTemp().get(0));

        TextView condition = convertView.findViewById(R.id.condition);
        condition.setText(currentItem.getCondition().get(0));

        System.out.println(condition);
        ImageView condition_image = (ImageView) convertView.findViewById(R.id.image_condition);
        if(currentItem.getCondition().get(0).contains("Light Cloud")){
            condition_image.setImageResource(R.drawable.cloudy);
        }
        if (currentItem.getCondition().get(0).contains("Light Rain")){
            condition_image.setImageResource(R.drawable.rain);
        }
        if (currentItem.getCondition().get(0).contains("thunder")){
            condition_image.setImageResource(R.drawable.rain_thunder);
        }
        if (currentItem.getCondition().get(0).contains( "sleet")){
            condition_image.setImageResource(R.drawable.sleet);
        }

        if (currentItem.getCondition().get(0).contains( "snow")){
            condition_image.setImageResource(R.drawable.snow);
        }
        if (currentItem.getCondition().get(0).contains( "Sunny" )){
            condition_image.setImageResource(R.drawable.day_clear);
        }
        if (currentItem.getCondition().get(0).contains("Clear Sky")){
            condition_image.setImageResource(R.drawable.day_clear);
        }
        if (currentItem.getCondition().get(0).contains( "fog")){
            condition_image.setImageResource(R.drawable.fog);
        }
        if (currentItem.getCondition().get(0).contains( "wind")){
            condition_image.setImageResource(R.drawable.wind);
        }
        if (currentItem.getCondition().get(0).contains( "Sunny Intervals")){
            condition_image.setImageResource(R.drawable.day_partial_cloud);
        }

        Log.d("IN_ADAPTER" ,"convertView returned");
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