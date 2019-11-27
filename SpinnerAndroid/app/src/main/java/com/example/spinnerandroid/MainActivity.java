package com.example.spinnerandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> category = new ArrayList<String>();
        category.add("Automobile");
        category.add("Tourism");
        category.add("Education");
        category.add("Business services");
        category.add("Engineering");
        category.add("Medical");

        sp = findViewById(R.id.catspin);
        // Create an adaptor to connect between spinner and list nad fil it from the list
        ArrayAdapter<String> catAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,category);
        //make the dropdown style
        catAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        //fill the spinner with the adapter item
        sp.setAdapter(catAdapter);
        sp.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        //show the selected item
        Toast.makeText(parent.getContext(),"Selected:"+ item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
