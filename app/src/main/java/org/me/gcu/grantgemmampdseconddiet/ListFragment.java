package org.me.gcu.grantgemmampdseconddiet;

//Imported Libraries
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import org.me.gcu.grantgemmampdseconddiet.Item;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * ListFragment class contains all view components and methods that are needed in order to display the fragment which contains all of the weather parsed data.
 * This class makes use of the AdapterView.OnItemClickListener so that the list is interactive and the user can click on an item in the list and
 * a more detailed description of weather for the selected day will display
 * Created on 04/04/2022 by Gemma Grant s2030516
 */
public class ListFragment extends Fragment {

    //Initiating all view components
    private ListView parsedListView;
    private ArrayList<Item> items;
    private ItemAdapter itemAdapter;
    ListView allLocationsList;
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

        //initiating variables to view components in the fragment_list.xml file
       // parsedListView = (ListView) v.findViewById(R.id.parsedListView);
       // itemAdapter = new ItemAdapter(MainActivity.this, R.layout.row_item, items);
        // Set the adapter here
        //parsedListView.setAdapter(itemAdapter);
        //parsedListView.setOnItemClickListener(this);

        /**
         * checks to see if the items list is empty as well as checking to see if it is null
         * if it is not null and is not null, then the items list is set to clear
         */

        Log.e("items in ListFragment", ": " + items);
       // Log.e("parser.items in ListFragment", ": " + parser.items);
        if(items != null && !items.isEmpty()) {
            items.clear();
        }

        Bundle bundle = getArguments();
        items = (ArrayList<Item>) bundle.getSerializable("ITEMLIST");

        //setting the item adapter to its context, resource and the data ,
        ItemAdapter itemAdapter = new ItemAdapter(getActivity().getApplicationContext(), R.layout.fragment_list, items);


      //  allLocationsList = (ListView)v.findViewById(R.id.parsedListView) ;
        ListView listView = (ListView)v.findViewById(R.id.location_list);
        ListView details_list =(ListView) v.findViewById(R.id.parsedListView);
        details_list.setAdapter(itemAdapter);
        Button btnBack = (Button)v.findViewById(R.id.btnBack);

        /**
         * OnClick method used to direct user back to the homepage where the list of cities are displayed.
         */
        btnBack.setOnClickListener(view -> {
            listView.setVisibility(View.VISIBLE);
            //R.layout.fragment_list = clear();
            //parsedListView.setVisibility(View.GONE);
        });


        // the view being returned to the app - the list fragment will display the list of parsed items whether filtered or not
        return v;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //itemAdapter= new ItemAdapter( getContext(), R.layout.fragment_list, items);

    }
} //end of ListFragment class