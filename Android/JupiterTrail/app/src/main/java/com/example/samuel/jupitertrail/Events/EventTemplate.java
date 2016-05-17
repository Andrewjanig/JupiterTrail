package com.example.samuel.jupitertrail.Events;

import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

import com.example.samuel.jupitertrail.Game;
import com.example.samuel.jupitertrail.GameScreens.JourneyScreen;
import com.example.samuel.jupitertrail.R;

/**
 * Created by Samuel on 16/05/2016.
 */
public class EventTemplate {

    public Button[] Buttons;
    public String text;
    public String title;
    public com.example.samuel.jupitertrail.Game Game;
    public JourneyScreen journey;

    public EventTemplate(Context G, int x, JourneyScreen journey)
    {
        Game = (Game)G;
        Buttons = new Button[x];
        this.journey = journey;


    }
}
