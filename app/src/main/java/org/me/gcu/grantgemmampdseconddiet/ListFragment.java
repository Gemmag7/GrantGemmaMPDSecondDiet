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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import org.me.gcu.grantgemmampdseconddiet.Item;

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
    private ItemAdapter arrayAdapter;
    private FileXmlPullParser parser;
    /**
     *
     * @param inflater which contains the xml file that is being inflated into the view
     * @param container which holds the container for the fragment
     * @param savedInstanceState is used for when searching for a specific roadwork/incident as well as clicking
     *                           on a specific roadwork/incident for more details
     * @return the fragment whihc contains the list of parsed data as well as other data
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);

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
        arrayAdapter = new ItemAdapter(getActivity().getApplicationContext(), R.layout.row_item, items);



        //initiating variables to view components in the fragment_list.xml file
        parsedListView = (ListView) v.findViewById(R.id.parsedListView);


        //Setting the arrayAdapter to the parsedListView
        parsedListView.setAdapter(arrayAdapter);
        parsedListView.setOnItemClickListener(this);



        // the view being returned to the app - the list fragment will display the list of parsed items whether filtered or not
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //get the item from that index that we clicked in the listview
        Item selectedItem = arrayAdapter.getItem(i);




    } //end of onItemClick method

} //end of ListFragment class