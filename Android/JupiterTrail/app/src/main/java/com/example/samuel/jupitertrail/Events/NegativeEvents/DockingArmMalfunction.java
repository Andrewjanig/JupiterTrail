package com.example.samuel.jupitertrail.Events.NegativeEvents;

import android.content.Context;
import android.widget.Toast;

import com.example.samuel.jupitertrail.Enum.DifficultyEnum;
import com.example.samuel.jupitertrail.Events.EventTemplate;
import com.example.samuel.jupitertrail.GameScreens.JourneyScreen;

/**
 * Created by Samuel on 16/05/2016.
 */
public class DockingArmMalfunction extends EventTemplate {

    public DockingArmMalfunction(DifficultyEnum diff, Context G, JourneyScreen journey)
    {
        super(G, 0, journey);

        text = "Uhh, Buzz, we missed the truck! - Woody, Toy Story";

        journey.eventNumber-=Game.PlayerShip.eventsBetweenCheckpoints;
        Game.checkpointsTillVictory-=1;

                Toast toast = Toast.makeText(Game, "Skip the next checkpoint.", Toast.LENGTH_SHORT);
                toast.show();
                journey.Update();
    }

}
