package com.josh.kingsarmorycompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

public class MonstersActivity extends AppCompatActivity {

    int chart[][];
    public String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monsters);

        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
    }

    protected void onStart(){

        super.onStart();
        chart = new int[][]{
            {1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3},
            {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4},
            {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4},
            {1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5},
            {1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5},
            {2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5},
            {2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5}};
        int[] monsterArray = {0, 3, 5, 7, 9, 11, 13, 15};

        int wave = MainActivity.wave;
        int numPlayers = MainActivity.numPlayers;

        int numMonsters = 0;
        switch (numPlayers) {
            case 1:
                numMonsters = monsterArray[numPlayers] - 1;
                break;
            case 2:
                numMonsters = monsterArray[numPlayers];
                break;
            case 3:
                numMonsters = monsterArray[numPlayers] + 1;
                break;
            case 4:
                numMonsters = monsterArray[numPlayers] + 2;
                break;
            case 5:
                numMonsters = monsterArray[numPlayers] + 3;
                break;
            case 6:
                numMonsters = monsterArray[numPlayers] + 3;
                break;
            case 7:
                numMonsters = monsterArray[numPlayers] + 3;
                break;
            default:
                //error
                break;
        }

        for(int i=0; i<numMonsters; i++ ){
            Random r = new Random();
            int m1 = r.nextInt(13-1)+1;
            
            switch (numPlayers){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    m1+= 1;
                    break;
                case 5:
                    m1+= 1;
                    break;
                case 6:
                    m1+= 2;
                    break;
                case 7:
                    m1+= 3;
                    break;
                default:
                    //error
                    break;
            }

            if(m1 > 12)
                m1 = 12;
        }
    }

}

