package org.me.gcu.grantgemmampdseconddiet;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

/*
 * Custom Adapter class that is responsible for holding the list of sites after they
 * get parsed out of XML and returns the selected parsed data in a view fragment
 * Created on the 01/04/2022 by Gemma Grant s2030516
 */
public class ItemAdapter extends ArrayAdapter<Item> {

    private List<Item> items;
    Context mContext;
    private Context ctx;
   // private final List<Item> items;
    int resourceInt;

    public ItemAdapter(Context context, int resource, ArrayList<Item> data) {
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
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_item, parent, false);
        }

        TextView locationName = convertView.findViewById(R.id.locationName);
        //locationName.setText(currentItem.getLocationName());

        TextView day1 = (TextView) convertView.findViewById(R.id.day1);

        day1.setText(currentItem.getDay().get(0));
        Log.d("day1", ":" + day1);
        TextView day2 = (TextView) convertView.findViewById(R.id.day2);
        day2.setText(currentItem.getDay().get(1));
        //day2.setText(currentItem.getDay().get(1));
        TextView day3 = convertView.findViewById(R.id.day3);
        day3.setText(currentItem.getDay().get(2));

        TextView temp1 = convertView.findViewById(R.id.temp1);
        temp1.setText(currentItem.getMinTemp().get(0));
       // TextView lowest_temp = convertView.findViewById(R.id.lowest_temp);
        //lowest_temp.setText(currentItem.getMinTemp().get(0));
        TextView temp2 = convertView.findViewById(R.id.temp2);
        temp2.setText(currentItem.getMinTemp().get(1));
        TextView temp3 = convertView.findViewById(R.id.temp3);
        temp3.setText(currentItem.getMinTemp().get(2));

        TextView maxTemp1 = convertView.findViewById(R.id.maxTemp1);
        maxTemp1.setText(currentItem.getMaxTemp().get(0));
        TextView maxTemp2 = convertView.findViewById(R.id.maxTemp2);
        maxTemp2.setText(currentItem.getMaxTemp().get(0));
        TextView maxTemp3 = convertView.findViewById(R.id.maxTemp3);
        maxTemp3.setText(currentItem.getMaxTemp().get(1));

        TextView rain1 = convertView.findViewById(R.id.condition1);
        rain1.setText(currentItem.getCondition().get(0));
        TextView rain2 = convertView.findViewById(R.id.condition2);
        rain2.setText(currentItem.getCondition().get(1));
        TextView rain3 = convertView.findViewById(R.id.condition3);
        rain3.setText(currentItem.getCondition().get(2));

        TextView windspeed1 = convertView.findViewById(R.id.windspeed1);
        windspeed1.setText(currentItem.getWindSpeed().get(0));
        TextView windspeed2 = convertView.findViewById(R.id.windspeed2);
        windspeed2.setText(currentItem.getWindSpeed().get(1));
        TextView windspeed3 = convertView.findViewById(R.id.windspeed3);
        windspeed3.setText(currentItem.getWindSpeed().get(2));

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