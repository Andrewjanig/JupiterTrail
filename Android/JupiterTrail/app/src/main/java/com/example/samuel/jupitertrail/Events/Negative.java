package com.example.samuel.jupitertrail.Events;

import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

import com.example.samuel.jupitertrail.Enum.DifficultyEnum;
import com.example.samuel.jupitertrail.EventInstance;
import com.example.samuel.jupitertrail.Events.NegativeEvents.CosmicWinds;
import com.example.samuel.jupitertrail.Events.NegativeEvents.DockingArmMalfunction;
import com.example.samuel.jupitertrail.Events.NegativeEvents.FuelLeak;
import com.example.samuel.jupitertrail.Events.NegativeEvents.KhalariSpacePirates;
import com.example.samuel.jupitertrail.Events.NegativeEvents.KyraxianPetris;
import com.example.samuel.jupitertrail.Events.NegativeEvents.Mitogamoria;
import com.example.samuel.jupitertrail.Events.NegativeEvents.Phalanxus;
import com.example.samuel.jupitertrail.Events.NegativeEvents.ThrusterFailure;
import com.example.samuel.jupitertrail.Events.NegativeEvents.UnSherajDevourer;
import com.example.samuel.jupitertrail.Game;
import com.example.samuel.jupitertrail.GameScreens.JourneyScreen;
import com.example.samuel.jupitertrail.R;

import java.util.Random;

/**
 * Created by Samuel on 14/05/2016.
 */
public class Negative extends EventInstance {

    public Negative(DifficultyEnum diff, Context G, JourneyScreen journey, Button b)
    {
        this.journey = journey;

        EventTemplate event = RandomEvent(diff, G, journey, b);

        Game a = (Game)G;
        final TextView titleText = (TextView) a.findViewById(R.id.event_title);
        titleText.setText(event.getClass().getSimpleName());

        Options = new Option[event.Buttons.length];
        int i = 0;
        for (Button o : event.Buttons)
        {
            Options[i] = new Option();
            Options[i].button = o;
            i++;
        }

        Text = event.text;
    }

    public EventTemplate RandomEvent (DifficultyEnum diff, Context G, JourneyScreen journey, Button b)
    {
        Random rand = new Random();
        int num = rand.nextInt((9 - 1) + 1) + 1;

        switch(num)
        {
            case 1:
                return new KyraxianPetris(diff, G, journey);
            case 2:
                return new Mitogamoria(diff, G, journey);
            case 3:
                return new Phalanxus(diff, G, journey);
            case 4:
                return new DockingArmMalfunction(diff, G, journey);
            case 5:
                return new ThrusterFailure(diff, G, journey);
            case 6:
                return new FuelLeak(diff, G, journey);
            case 7:
                return new CosmicWinds(diff, G, journey);
            case 8:
                return new KhalariSpacePirates(diff, G, journey, b);
            case 9:
                return new UnSherajDevourer(diff, G, journey);
            default:
                return new EventTemplate(G, 0, journey);
        }
    }


}
