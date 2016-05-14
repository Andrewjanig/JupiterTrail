package com.example.samuel.jupitertrail.Events;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.samuel.jupitertrail.Enum.DifficultyEnum;
import com.example.samuel.jupitertrail.EventInstance;
import com.example.samuel.jupitertrail.Game;

/**
 * Created by Samuel on 14/05/2016.
 */
public class Negative extends EventInstance {

    public Negative(DifficultyEnum diff, Context G)
    {
        Event1(diff, G);
    }

    private void Event1(DifficultyEnum diff, Context G)
    {
        //Event1

        final Game Game = (Game)G;
        Options = new Option[2];

        Text = "Malfunction! We will need to stop to fix the malfunction! (One extra event before checkpoint)";

        //Do Event
        Game.Ship.eventsBetweenCheckpoints += 1;

        Options[0] = new Option();

        Button generateButton = new Button(Game);
        generateButton.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        generateButton.setText("Do Something");
        generateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast toast = Toast.makeText(Game, "Something Done!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        Options[0].button = generateButton;

        Options[1] = new Option();

        Button Button2 = new Button(Game);
        Button2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        Button2.setText("Do Something Else!");
        Button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast toast = Toast.makeText(Game, "Something Else Done!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        Options[1].button = Button2;
    }

}
