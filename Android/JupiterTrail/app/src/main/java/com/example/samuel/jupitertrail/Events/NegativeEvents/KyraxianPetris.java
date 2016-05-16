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
public class KyraxianPetris extends EventTemplate {

    public KyraxianPetris(DifficultyEnum diff, Context G, JourneyScreen journey)
    {
        super(G, 0, journey);

        text = "Kyraxian larvae burrow beneath the base of the skull, they feed on brain matter and excrete neurotransmitters which drive the host slowly insane. In its final, and only detectable stage, the host will cannibalise on another before himself.";


            for (CrewMember c : Game.Crew)
            {
                if (!c.KyraxianPetris)
                {
                    c.KyraxianPetris = true;
                    c.KyraxianPetrisTimer = 5;
                    c.RationConsumption = 0;
                    break;
                }
            }

                Toast toast = Toast.makeText(Game, "A crew member has contracted Kyraxian Petris! They have 5 before going sucidial!", Toast.LENGTH_SHORT);
                toast.show();
                journey.Update();
    }

}
