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
public class Mitogamoria extends EventTemplate {

    public Mitogamoria(DifficultyEnum diff, Context G, JourneyScreen journey)
    {
        super(G, 0, journey);

        text = "In ancient Rome they used to bleed murderers until their veins emptied, but at least in those times the Romans were to blame.” - Sen. Dr. Vitris Egormer, Surgeon General of New Earth.";


            for (CrewMember c : Game.Crew)
            {
                if (!c.Mitogamoria)
                {
                    c.Mitogamoria = true;
                    c.TimeToDie = 3;
                    break;
                }
            }

                Toast toast = Toast.makeText(Game, "A crew member has contracted Mitogamora! They have 3 days to live!", Toast.LENGTH_SHORT);
                toast.show();
                journey.Update();
    }

}
