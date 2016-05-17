package com.example.samuel.jupitertrail.Events;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.samuel.jupitertrail.Enum.DifficultyEnum;
import com.example.samuel.jupitertrail.EventInstance;
import com.example.samuel.jupitertrail.Events.NeutralEvents.MarvelAtTheStars;
import com.example.samuel.jupitertrail.Events.NeutralEvents.NameAConstellation;
import com.example.samuel.jupitertrail.Events.NeutralEvents.SpyARogueSatellite;
import com.example.samuel.jupitertrail.Game;
import com.example.samuel.jupitertrail.GameScreens.JourneyScreen;
import com.example.samuel.jupitertrail.R;

import java.util.Random;

/**
 * Created by Samuel on 14/05/2016.
 */
public class Neutral extends EventInstance {

    public Neutral(DifficultyEnum diff, Context G, JourneyScreen journey)
    {
        Random rand = new Random();
        int num = rand.nextInt((3 - 1) + 1) + 1;
        EventTemplate event = new EventTemplate(G, 0, journey);

        switch(num)
        {
            case 1:
                event = new MarvelAtTheStars(diff, G, journey);
                break;
            case 2:
                event = new NameAConstellation(diff, G, journey);
                break;
            case 3:
                event = new SpyARogueSatellite(diff, G, journey);
                break;
            default:
                break;
        }

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


}
