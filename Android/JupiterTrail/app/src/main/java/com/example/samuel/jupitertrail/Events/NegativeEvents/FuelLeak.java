package com.example.samuel.jupitertrail.Events.NegativeEvents;

import android.content.Context;
import android.widget.Toast;

import com.example.samuel.jupitertrail.CrewMember;
import com.example.samuel.jupitertrail.Enum.DifficultyEnum;
import com.example.samuel.jupitertrail.Events.EventTemplate;
import com.example.samuel.jupitertrail.GameScreens.JourneyScreen;

/**
 * Created by Samuel on 16/05/2016.
 */
public class FuelLeak extends EventTemplate {

    public FuelLeak(DifficultyEnum diff, Context G, JourneyScreen journey)
    {
        super(G, 0, journey);

        text = "FUEL LEAK DETECTED. SYSTEMS CRITICAL!";

        Game.PlayerShip.fuelPerEvent*=2;

                Toast toast = Toast.makeText(Game, "Fuel Consumption doubled!", Toast.LENGTH_SHORT);
                toast.show();
                journey.Update();
    }

}
