package com.example.samuel.jupitertrail.Events.NegativeEvents;

import android.content.Context;
import android.widget.Toast;

import com.example.samuel.jupitertrail.Enum.DifficultyEnum;
import com.example.samuel.jupitertrail.Events.EventTemplate;
import com.example.samuel.jupitertrail.GameScreens.JourneyScreen;

/**
 * Created by Samuel on 16/05/2016.
 */
public class CosmicWinds extends EventTemplate {

    public CosmicWinds(DifficultyEnum diff, Context G, JourneyScreen journey)
    {
        super(G, 0, journey);

        text = "Detours are fun, but when there’s only 9 inches of steel and fibreglass between you and certain death you may wish you’d never left the space station.";

        journey.eventNumber-=1;

                Toast toast = Toast.makeText(Game, "Endure an extra day in space.", Toast.LENGTH_SHORT);
                toast.show();
                journey.Update();
    }

}
