package com.josh.kingsarmorycompanion;

import android.content.Intent;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.List;
import java.util.ArrayList;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    public static String EXTRA_MESSAGE = "com.josh.KingsArmoryCompanion.Message";
    public static int numPlayers;
    public static int wave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0){

    }

    public void generateResult(View view){

        Spinner heroesSpinner = (Spinner) findViewById(R.id.heroesSpinner);
        Spinner waveSpinner = (Spinner) findViewById(R.id.waveSpinner);
        numPlayers = Integer.parseInt((String) heroesSpinner.getSelectedItem());
        wave = Integer.parseInt((String) waveSpinner.getSelectedItem());
        Intent intent = new Intent(this, MonstersActivity.class);

        intent.putExtra(EXTRA_MESSAGE, "");
        startActivity(intent);
    }
}


