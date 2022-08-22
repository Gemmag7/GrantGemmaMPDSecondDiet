package org.me.gcu.grantgemmampdseconddiet;

//Imported Libraries
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import org.me.gcu.grantgemmampdseconddiet.Item;
import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * ListFragment class contains all view components and methods that are needed in order to display the fragment which contains all of the weather parsed data.
 * This class makes use of the AdapterView.OnItemClickListener so that the list is interactive and the user can click on an item in the list and
 * a more detailed description of weather for the selected day will display
 * Created on 04/04/2022 by Gemma Grant s2030516
 */
public class ListFragment extends Fragment implements AdapterView.OnItemClickListener {

    //Initiating all view components
    private ListView parsedListView;
    private ArrayList<Item> items;
    private ItemAdapter itemAdapter;
    private FileXmlPullParser parser;
    private TextView highest_temp, lowest_temp, wind_direction, wind_speed, uv_risk, visibility_score, pressure, humidity, condition, sunset, sunrise, pollution;
    Location.City locationUrl = Location.City.GLASGOW;

    /**
     *
     * @param inflater which contains the xml file that is being inflated into the view
     * @param container which holds the container for the fragment
     * @param savedInstanceState is used for when searching for a specific roadwork/incident as well as clicking
     *                           on a specific day selected for more details
     * @return the fragment whihc contains the list of parsed data as well as other data
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        String[] locationNames = {"Glasgow", "London", "New York", "Oman", "Mauritius", "Bangladesh"};
        Spinner spinner = (Spinner) v.findViewById(R.id.location_selector);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.locations, android.R.layout.simple_spinner_dropdown_item );
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
        /**
         * checks to see if the items list is empty as well as checking to see if it is null
         * if it is not null and is not null, then the items list is set to clear
         */

        Log.e("items in ListFragment", ": " + items);
        Log.e("parser.items in ListFragment", ": " + parser.items);
        if(items != null && !items.isEmpty()) {
            items.clear();
        }

        Bundle bundle = getArguments();
        items = (ArrayList<Item>) bundle.getSerializable("ITEMLIST");

        //
        itemAdapter = new ItemAdapter(getActivity().getApplicationContext(), R.layout.row_item, items);



        //initiating variables to view components in the fragment_list.xml file
        parsedListView = (ListView) v.findViewById(R.id.parsedListView);


       // highest_temp = (TextView) v.findViewById(R.id.highest_temp);

        //Setting the arrayAdapter to the parsedListView
        parsedListView.setAdapter(itemAdapter);
        parsedListView.setOnItemClickListener(this);



        // the view being returned to the app - the list fragment will display the list of parsed items whether filtered or not
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


        @Override
        public void onItemClick (AdapterView < ? > adapterView, View view,int i, long l){

            //get the item from that index that we clicked in the listview
            Item itemArray = itemAdapter.getItem(i);

            ArrayList<String> selectedItem = itemArray.getDay();

            itemArray.getDay().get(i);


            //Setting the textView to the values of the selected item when a user clicks on a specific incident
            highest_temp.setText(selectedItem.get(i));
            //lowest_temp.setText(selectedItem.getMinTemp().get(i));
            // pressure.setText(selectedItem.getPressure().get(i));
            //pollution.setText(selectedItem.getPollution().get(i));
            //condition.setText(selectedItem.getCondition().get(i));
            //sunrise.setText(selectedItem.getSunrise().get(i));
            //sunset.setText(selectedItem.getSunset().get(i));
            //   wind_direction.setText(selectedItem.getWindDirection().get(i));
            //     wind_speed.setText(selectedItem.getWindSpeed().get(i));
            //       humidity.setText(selectedItem.getHumidity().get(i));

        } //end of onItemClick method

} //end of ListFragment class