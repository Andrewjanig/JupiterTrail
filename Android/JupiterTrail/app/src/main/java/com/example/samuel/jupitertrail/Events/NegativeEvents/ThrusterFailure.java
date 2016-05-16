package com.example.samuel.jupitertrail.Events.NegativeEvents;

import android.content.Context;
import android.widget.Toast;

import com.example.samuel.jupitertrail.Enum.DifficultyEnum;
import com.example.samuel.jupitertrail.Events.EventTemplate;
import com.example.samuel.jupitertrail.GameScreens.JourneyScreen;

/**
 * Created by Samuel on 16/05/2016.
 */
public class ThrusterFailure extends EventTemplate {

    public ThrusterFailure(DifficultyEnum diff, Context G, JourneyScreen journey)
    {
        super(G, 0, journey);

        text = "THRUSTER FAILURE IMMINENT. LANDING SHIP ON NEARBY ASTEROID.";

        journey.eventNumber-=3;

                Toast toast = Toast.makeText(Game, "3 extra days till checkpoint.", Toast.LENGTH_SHORT);
                toast.show();
                journey.Update();
    }

}
