package com.josh.kingsarmorycompanion;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MonstersActivity extends AppCompatActivity {

    public String message;

    static final int CHART[][] = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3},
            {0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4},
            {0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4},
            {0, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5},
            {0, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5},
            {0, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5},
            {0, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5}};

    static final int[] NUM_MONSTERS = {0, 3, 5, 7, 9, 11, 13, 15};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monsters);
    }

    protected void onStart(){

        super.onStart();

        int wave = MainActivity.wave;
        int numPlayers = MainActivity.numPlayers;
        String side;
        Random r = new Random();
        int roll;
        ConstraintLayout main = (ConstraintLayout) findViewById(R.id.monsterLayout);
        ConstraintSet constraintSet = new ConstraintSet();
        int numMonsters = 0;
        int lastViewId = -1;

        switch (numPlayers) {
            case 1:
                numMonsters = NUM_MONSTERS[wave] - 1;
                break;
            case 2:
                numMonsters = NUM_MONSTERS[wave];
                break;
            case 3:
                numMonsters = NUM_MONSTERS[wave] + 1;
                break;
            case 4:
                numMonsters = NUM_MONSTERS[wave] + 2;
                break;
            case 5:
                numMonsters = NUM_MONSTERS[wave] + 3;
                break;
            case 6:
                numMonsters = NUM_MONSTERS[wave] + 3;
                break;
            case 7:
                numMonsters = NUM_MONSTERS[wave] + 3;
                break;
            default:
                //error
                break;
        }

        for(int i=0; i<numMonsters; i++ ){
            roll = r.nextInt(13-1)+1;

            side = (roll%2 == 1) ? "ODD" : "EVEN";

            switch (numPlayers){
                case 4:
                    roll+= 1;
                    break;
                case 5:
                    roll+= 1;
                    break;
                case 6:
                    roll+= 2;
                    break;
                case 7:
                    roll+= 3;
                    break;
                default:
                    break;
            }

            if (roll > 12) {
                roll = 12;
            }



            TextView resultText = new TextView(this);
            resultText.setId(View.generateViewId());
            resultText.setText("Level " + CHART[wave][roll] + " monster on " + side + " side. (" + roll + ")");
            resultText.setGravity(Gravity.CENTER);
            main.addView(resultText);
            constraintSet.clone(main);

            if (i == 0) {
                constraintSet.connect(resultText.getId(), ConstraintSet.TOP, main.getId(), ConstraintSet.BOTTOM, 0);
            } else {
                constraintSet.connect(resultText.getId(), ConstraintSet.TOP, lastViewId, ConstraintSet.BOTTOM, 0);
            }
            constraintSet.connect(resultText.getId(), ConstraintSet.RIGHT, main.getId(), ConstraintSet.RIGHT, 0);
            constraintSet.connect(resultText.getId(), ConstraintSet.LEFT, main.getId(), ConstraintSet.LEFT, 0);
            constraintSet.constrainHeight(resultText.getId(),150);
            lastViewId = resultText.getId();
            constraintSet.applyTo(main);
        }
        constraintSet.clone(main);
    }
}

