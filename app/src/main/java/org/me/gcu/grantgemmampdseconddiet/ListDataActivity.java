package org.me.gcu.grantgemmampdseconddiet;
//List Data Activity contains the onCreate method that will load the detailed weather forecast for the selected location
//This is invooked by parent Activity -> MainActivity.java class
//Created by Gemma Grant s2030516 on 22/08/2022
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        //Initiating the intent
        Intent intent = getIntent();
        //Setting the parcelabel extra data to item variable selectedItem
        Item selectedItem = intent.getParcelableExtra("items");

        //To keep track of the selected location
        System.out.println(selectedItem);
        /**
         * Declaring all view components here
         */
        TextView locationName = (TextView) findViewById(R.id.locationName);
        TextView day1 =(TextView) findViewById(R.id.day1);
        TextView day2 = (TextView)findViewById(R.id.day2);
        TextView day3 = (TextView)findViewById(R.id.day3);
        TextView min_temp1 = (TextView)findViewById(R.id.min_temp1);
        TextView min_temp2 = (TextView)findViewById(R.id.min_temp2);
        TextView min_temp3 = (TextView)findViewById(R.id.min_temp3);
        TextView max_temp1 = (TextView)findViewById(R.id.max_temp1);
        TextView max_temp2 = (TextView)findViewById(R.id.max_temp2);
        TextView max_temp3 = (TextView)findViewById(R.id.max_temp3);
        TextView condition1 = (TextView)findViewById(R.id.condition1);
        TextView condition2 = (TextView)findViewById(R.id.condition2);
        TextView condition3 = (TextView)findViewById(R.id.condition3);
        TextView wind_speed1 = (TextView)findViewById(R.id.wind_speed1);
        TextView wind_speed2 = (TextView)findViewById(R.id.wind_speed2);
        TextView wind_speed3 = (TextView)findViewById(R.id.wind_speed3);
        TextView wind_direction1 = (TextView)findViewById(R.id.wind_direction1);
        TextView wind_direction2 = (TextView)findViewById(R.id.wind_direction2);
        TextView wind_direction3 = (TextView)findViewById(R.id.wind_direction3);
        TextView visibility1 = (TextView)findViewById(R.id.visibility1);
        TextView visibility2 = (TextView)findViewById(R.id.visibility2);
        TextView visibility3 = (TextView)findViewById(R.id.visibility3);
        TextView humidity1 = (TextView)findViewById(R.id.humidity1);
        TextView humidity2 = (TextView)findViewById(R.id.humidity2);
        TextView humidity3 = (TextView)findViewById(R.id.humidity3);
        TextView pressure1 = (TextView)findViewById(R.id.pressure1);
        TextView pressure2 = (TextView)findViewById(R.id.pressure2);
        TextView pressure3 = (TextView)findViewById(R.id.pressure3);
        TextView uv_risk1 = (TextView)findViewById(R.id.uv_risk1);
        TextView uv_risk2 = (TextView)findViewById(R.id.uv_risk2);
        TextView uv_risk3 = (TextView)findViewById(R.id.uv_risk3);
        TextView pollution1 = (TextView)findViewById(R.id.pollution1);
        TextView pollution2 = (TextView)findViewById(R.id.pollution2);
        TextView pollution3 = (TextView)findViewById(R.id.pollution3);
        TextView sunrise2 = (TextView)findViewById(R.id.sunrise2);
        TextView sunrise3 = (TextView)findViewById(R.id.sunrise3);
        TextView sunset1 = (TextView)findViewById(R.id.sunset1);
        TextView sunset2 = (TextView)findViewById(R.id.sunset2);
        TextView sunset3 = (TextView)findViewById(R.id.sunset3);

        /**
         * Setting the text values of the previously declared view components to the selectedItem's data
         */
        day1.setText(selectedItem.getDay().get(0));
        day2.setText(selectedItem.getDay().get(1));
        day3.setText(selectedItem.getDay().get(2));
        min_temp1.setText(selectedItem.getMinTemp().get(0));
        min_temp2.setText(selectedItem.getMinTemp().get(1));
        min_temp3.setText(selectedItem.getMinTemp().get(2));
        //max_temp1.setText(selectedItem.getMaxTemp().get(0));
        max_temp2.setText(selectedItem.getMaxTemp().get(0));
        max_temp3.setText(selectedItem.getMaxTemp().get(1));
        wind_speed1.setText(selectedItem.getWindSpeed().get(0));
        wind_speed2.setText(selectedItem.getWindSpeed().get(1));
        wind_speed3.setText(selectedItem.getWindSpeed().get(2));
        pressure1.setText(selectedItem.getPressure().get(0));
        pressure2.setText(selectedItem.getPressure().get(1));
        pressure3.setText(selectedItem.getPressure().get(2));
        humidity1.setText(selectedItem.getHumidity().get(0));
        humidity2.setText(selectedItem.getHumidity().get(1));
        humidity3.setText(selectedItem.getHumidity().get(2));
        uv_risk1.setText(selectedItem.getUvrisk().get(0));
        uv_risk2.setText(selectedItem.getUvrisk().get(1));
        uv_risk3.setText(selectedItem.getUvrisk().get(2));
        condition1.setText(selectedItem.getCondition().get(0));
        condition2.setText(selectedItem.getCondition().get(1));
        condition3.setText(selectedItem.getCondition().get(2));
        wind_direction1.setText(selectedItem.getWindDirection().get(0));
        wind_direction2.setText(selectedItem.getWindDirection().get(1));
        wind_direction3.setText(selectedItem.getWindDirection().get(2));
        visibility1.setText(selectedItem.getVisibility().get(0));
        visibility2.setText(selectedItem.getVisibility().get(1));
        visibility3.setText(selectedItem.getVisibility().get(2));
        pollution1.setText(selectedItem.getPollution().get(0));
        pollution2.setText(selectedItem.getPollution().get(1));
        pollution3.setText(selectedItem.getPollution().get(2));
        sunrise2.setText(selectedItem.getSunrise().get(0));
        sunrise3.setText(selectedItem.getSunrise().get(1));
        sunset1.setText(selectedItem.getSunset().get(0));
        sunset2.setText(selectedItem.getSunset().get(1));
        sunset3.setText(selectedItem.getSunset().get(2));
        locationName.setText(selectedItem.getLocation());

    } //End of onCreate method

} //End of ListDataActivity Activity