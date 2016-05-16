package com.example.samuel.jupitertrail.Events.NegativeEvents;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.samuel.jupitertrail.CrewMember;
import com.example.samuel.jupitertrail.Enum.DifficultyEnum;
import com.example.samuel.jupitertrail.Events.EventTemplate;
import com.example.samuel.jupitertrail.GameScreens.JourneyScreen;

/**
 * Created by Samuel on 16/05/2016.
 */
public class Phalanxus extends EventTemplate {

    public Phalanxus(DifficultyEnum diff, Context G, JourneyScreen journey)
    {
        super(G, 0, journey);

        text = "My stomach, my stomach! Aah it hurts! It hurts! The food turns to bitter ash in my mouth and throat but the hunger pains are killing me! - Arthur Flemeth, First documented case of Phalanxus in domestic New Earth.";


            for (CrewMember c : Game.Crew)
            {
                if (!c.Phalanxus)
                {
                    c.Phalanxus = true;
                    break;
                }
            }

                Toast toast = Toast.makeText(Game, "A crew member has contracted Phalanxus!", Toast.LENGTH_SHORT);
                toast.show();
                journey.Update();
    }

}
