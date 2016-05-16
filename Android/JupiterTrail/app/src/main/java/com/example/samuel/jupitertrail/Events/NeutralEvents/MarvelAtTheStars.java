package com.example.samuel.jupitertrail.Events.NeutralEvents;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.samuel.jupitertrail.Enum.DifficultyEnum;
import com.example.samuel.jupitertrail.Events.EventTemplate;
import com.example.samuel.jupitertrail.Events.Option;
import com.example.samuel.jupitertrail.Game;
import com.example.samuel.jupitertrail.GameScreens.JourneyScreen;

/**
 * Created by Samuel on 16/05/2016.
 */
public class MarvelAtTheStars extends EventTemplate {

    public MarvelAtTheStars(DifficultyEnum diff, Context G, JourneyScreen journey)
    {
        super(G, 1, journey);

        text = "Like sands on a beach the stars are limitless and burn brightly with feelings of melancholy.";

        Buttons[0] = new Button(Game);
        Buttons[0].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        Buttons[0].setText("Marvel at the stars.");
        Buttons[0].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast toast = Toast.makeText(Game, "Wonderful!", Toast.LENGTH_SHORT);
                toast.show();
                Buttons[0].setOnClickListener(null);
            }
        });
    }

}
