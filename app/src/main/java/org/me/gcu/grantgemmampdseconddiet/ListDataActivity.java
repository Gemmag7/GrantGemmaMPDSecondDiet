package org.me.gcu.grantgemmampdseconddiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListDataActivity extends AppCompatActivity {

    TextView location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        Bundle bundle = this.getIntent().getExtras();
        //List<Item> selectedItem = this.getIntent().getExtras().getSerializable("ITEMLIST");
        location = (TextView) findViewById(R.id.location);
        TextView max_temp1 = (TextView) findViewById(R.id.location_max_temp);
        Intent intent = getIntent();

        location.setText(intent.getStringExtra("locationName"));
        //max_temp1.setText(intent.getStringExtra("items"));

    }
}