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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * Custom Adapter class that is responsible for holding the list of sites after they
 * get parsed out of XML and returns the selected parsed data in a view fragment
 * Created on the 01/04/2022 by Gemma Grant s2030516
 */
public class ItemAdapter extends ArrayAdapter<Item> implements View.OnClickListener{

    private List<Item> items;
    Context mContext;
    private Context ctx;
    int resourceInt;

    public ItemAdapter(Context context, int resource, ArrayList<Item> data) {
        super(context, resource, data);
        this.items = data;
        this.mContext = context;
        resourceInt = resource;
    }

    @Override
    public void onClick(View v) {
        int position=(Integer) v.getTag();
        Object item = getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Get the data item for this position
        Item selected_item = getItem(position);
        /**
         * Inflating the views from the layout in order to display the listview
         */
         if (convertView == null){
             LayoutInflater inflater = LayoutInflater.from(getContext());
             convertView = inflater.inflate(R.layout.row_item, parent, false);
         }
        /**
         * Initiating the textviews from the .xml file in the layout folder
         */

        Log.d("Position", ":" + position);

        /**
         * Inflating the views from the layout in order to display the listview
         */


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_item, parent, false);
        }


        TextView locationName = (TextView) convertView.findViewById(R.id.locationName);
        locationName.setText(getItem(position).getLocation());
        TextView day1 =(TextView) convertView.findViewById(R.id.day1);
        day1.setText(getItem(position).getDay().get(0));     //getDay().get(0));
        System.out.println(day1);
        TextView day2 = (TextView)convertView.findViewById(R.id.day2);
        day2.setText(getItem(position).getDay().get(1));
        TextView day3 = (TextView)convertView.findViewById(R.id.day3);
        day3.setText(getItem(position).getDay().get(2));

        TextView temp1 = (TextView)convertView.findViewById(R.id.min_temp1);
        temp1.setText(getItem(position).getMinTemp().get(0));
        TextView temp2 = (TextView)convertView.findViewById(R.id.min_temp2);
        temp2.setText(getItem(position).getMinTemp().get(1));
        TextView temp3 = (TextView)convertView.findViewById(R.id.min_temp3);
        temp3.setText(getItem(position).getMinTemp().get(2));

        TextView max_temp1 = (TextView)convertView.findViewById(R.id.max_temp1);
        max_temp1.setText(getItem(position).getMaxTemp().get(0));
        TextView max_temp2 = (TextView)convertView.findViewById(R.id.max_temp2);
        max_temp2.setText(getItem(position).getMaxTemp().get(0));
        TextView max_temp3 = (TextView)convertView.findViewById(R.id.max_temp3);
        max_temp3.setText(getItem(position).getMaxTemp().get(1));

        TextView condition1 = (TextView)convertView.findViewById(R.id.condition1);
        condition1.setText(getItem(position).getCondition().get(0));
        TextView condition2 = (TextView)convertView.findViewById(R.id.condition2);
        condition2.setText(getItem(position).getCondition().get(1));
        TextView condition3 = (TextView)convertView.findViewById(R.id.condition3);
        condition3.setText(getItem(position).getCondition().get(2));

        TextView wind_speed1 = (TextView)convertView.findViewById(R.id.wind_speed1);
        wind_speed1.setText(getItem(position).getWindSpeed().get(0));
        TextView wind_speed2 = (TextView)convertView.findViewById(R.id.wind_speed2);
        wind_speed2.setText(getItem(position).getWindSpeed().get(1));
        TextView wind_speed3 = (TextView)convertView.findViewById(R.id.wind_speed3);
        wind_speed3.setText(getItem(position).getWindSpeed().get(2));

        TextView wind_direction1 = (TextView)convertView.findViewById(R.id.wind_direction1);
        wind_direction1.setText(getItem(position).getWindDirection().get(0));
        TextView wind_direction2 = (TextView)convertView.findViewById(R.id.wind_direction2);
        wind_direction2.setText(getItem(position).getWindDirection().get(1));
        TextView wind_direction3 = (TextView)convertView.findViewById(R.id.wind_direction3);
        wind_direction3.setText(getItem(position).getWindDirection().get(2));

        TextView visibility1 = (TextView)convertView.findViewById(R.id.visibility1);
        visibility1.setText(getItem(position).getVisibility().get(0));
        TextView visibility2 = (TextView)convertView.findViewById(R.id.visibility2);
        visibility2.setText(getItem(position).getVisibility().get(1));
        TextView visibility3 = (TextView)convertView.findViewById(R.id.visibility3);
        visibility3.setText(getItem(position).getVisibility().get(2));

        TextView humidity1 = (TextView)convertView.findViewById(R.id.humidity1);
        humidity1.setText(getItem(position).getHumidity().get(0));
        TextView humidity2 = (TextView)convertView.findViewById(R.id.humidity2);
        humidity2.setText(getItem(position).getHumidity().get(1));
        TextView humidity3 = (TextView)convertView.findViewById(R.id.humidity3);
        humidity3.setText(getItem(position).getHumidity().get(2));

        TextView pressure1 = (TextView)convertView.findViewById(R.id.pressure1);
        pressure1.setText(getItem(position).getPressure().get(0));
        TextView pressure2 = (TextView)convertView.findViewById(R.id.pressure2);
        pressure2.setText(getItem(position).getPressure().get(1));
        TextView pressure3 = (TextView)convertView.findViewById(R.id.pressure3);
        pressure3.setText(getItem(position).getPressure().get(2));

        TextView uv_risk1 = (TextView)convertView.findViewById(R.id.uv_risk1);
        uv_risk1.setText(getItem(position).getUvrisk().get(0));
        TextView uv_risk2 = (TextView)convertView.findViewById(R.id.uv_risk2);
        uv_risk2.setText(getItem(position).getUvrisk().get(1));
        TextView uv_risk3 = (TextView)convertView.findViewById(R.id.uv_risk3);
        uv_risk3.setText(getItem(position).getUvrisk().get(2));

        TextView pollution1 = (TextView)convertView.findViewById(R.id.pollution1);
        pollution1.setText(getItem(position).getPollution().get(0));
        TextView pollution2 = (TextView)convertView.findViewById(R.id.pollution2);
        pollution2.setText(getItem(position).getPollution().get(1));
        TextView pollution3 = (TextView)convertView.findViewById(R.id.pollution3);
        pollution3.setText(getItem(position).getPollution().get(2));

        TextView sunrise2 = (TextView)convertView.findViewById(R.id.sunrise2);
        sunrise2.setText(getItem(position).getSunrise().get(0));
        TextView sunrise3 = (TextView)convertView.findViewById(R.id.sunrise3);
        sunrise3.setText(getItem(position).getSunrise().get(1));

        TextView sunset1 = (TextView)convertView.findViewById(R.id.sunset1);
        sunset1.setText(getItem(position).getSunset().get(0));
        TextView sunset2 = (TextView)convertView.findViewById(R.id.sunset2);
        sunset2.setText(getItem(position).getSunset().get(1));
        TextView sunset3 = (TextView)convertView.findViewById(R.id.sunset3);
        sunset3.setText(getItem(position).getSunset().get(2));

        Log.d("IN_ADAPTER" ,"convertView returned");
        return convertView;
    } // End of getView method


    /**
     * This method calculates the count of the number of items in the item list and returns it back to the user
     * @return the number of items in the item list

    @Override
    public int getCount()
    {

        return items.size();

    } */

}// End of ItemAdapter class