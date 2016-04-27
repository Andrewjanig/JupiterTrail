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
 * Created by Samuel on 28/04/2016.
 */
public class AlienAttack extends EventInstance
{
    public AlienAttack(DifficultyEnum diff, Context G)
    {

        final Game Game = (Game)G;
        Options = new Option[2];

        Text = "Sensors detect an incoming vessel!";

        Options[0] = new Option();

        Button generateButton = new Button(Game);
        generateButton.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        generateButton.setText("Engage aliens in dogfight");
        generateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast toast = Toast.makeText(Game, "Engaged!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        Options[0].button = generateButton;

        Options[1] = new Option();

        Button Button2 = new Button(Game);
        Button2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        Button2.setText("Run!");
        Button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast toast = Toast.makeText(Game, "Escaped!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        Options[1].button = Button2;
    }
}
