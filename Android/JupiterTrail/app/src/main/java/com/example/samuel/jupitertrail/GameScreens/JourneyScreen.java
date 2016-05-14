package com.example.samuel.jupitertrail.GameScreens;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.samuel.jupitertrail.Enum.ResourceEnum;
import com.example.samuel.jupitertrail.Enum.ScreenEnum;
import com.example.samuel.jupitertrail.EventInstance;
import com.example.samuel.jupitertrail.Events.Negative;
import com.example.samuel.jupitertrail.Events.Neutral;
import com.example.samuel.jupitertrail.Events.Option;
import com.example.samuel.jupitertrail.Events.Positive;
import com.example.samuel.jupitertrail.Game;
import com.example.samuel.jupitertrail.R;

import java.util.Random;


/**
 * Created by Samuel on 27/04/2016.
 */
public class JourneyScreen extends ContextWrapper {

    Game Game;
    Activity a;

    private int eventNumber  = 0;

    public JourneyScreen(Context context)
    {
        super(context);

        Game = (Game)context;
        a = (Activity) context;


        NewEvent();
    }

    private EventInstance GetEvent()
    {
        Random rand = new Random();
        int num = rand.nextInt((3 - 1) + 1) + 1;

        switch(num)
        {
            case 1: //positive
                return new Positive(Game.Difficulty, Game);
            case 2: //neutral
                return new Neutral(Game.Difficulty, Game);
            case 3: //negative
                return new Negative(Game.Difficulty, Game);
            default:
                return new Neutral(Game.Difficulty, Game);
        }
    }

    private void NewEvent()
    {

        eventNumber++; //Increment the number of events that has occurred since the last checkpoint
        Game.Ship.MoveShip();
        if (Game.Ship.ResourceList.get(ResourceEnum.Fuel).Amount < 0)
        {
            Game.ChangeScreen(ScreenEnum.Failure);
        }

        boolean atLeastOneAlive = false;
        if (Game.Crew[0].CheckAlive())
            atLeastOneAlive = true;
        if (Game.Crew[1].CheckAlive())
            atLeastOneAlive = true;
        if (Game.Crew[2].CheckAlive())
            atLeastOneAlive = true;
        if (Game.Crew[3].CheckAlive())
            atLeastOneAlive = true;

        if (atLeastOneAlive == false)
            Game.finish();

        a.setContentView(R.layout.journey_screen);

        final TextView resource1Text = (TextView) a.findViewById(R.id.resource1);
        final TextView resource2Text = (TextView) a.findViewById(R.id.resource2);
        final TextView resource3Text = (TextView) a.findViewById(R.id.resource3);
        final TextView eventsToGoText = (TextView) a.findViewById(R.id.eventstogo);

        resource1Text.setText("Fuel: " + Game.Ship.ResourceList.get(ResourceEnum.Fuel).Amount);
        resource2Text.setText("Resource 2: " + Game.Ship.ResourceList.get(ResourceEnum.Oxygen).Amount);
        resource2Text.setText("Resource 3: " + Game.Ship.ResourceList.get(ResourceEnum.Rockets).Amount);
        eventsToGoText.setText("Distance to next space station: " + (Game.Ship.eventsBetweenCheckpoints - eventNumber + 1));

        final TextView eventText = (TextView) a.findViewById(R.id.event_text);

        EventInstance CurrentEvent = GetEvent();

        eventText.setText(CurrentEvent.Text);

        LinearLayout buttonsLayout = (LinearLayout) a.findViewById(R.id.buttonlayout);

        for (Option o : CurrentEvent.Options)
        {
            buttonsLayout.addView(o.button);
        }

        //For Debugging: Generate New Event
        Button generateButton = new Button(this);
        generateButton.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        generateButton.setText("Generate New Event");
        buttonsLayout.addView(generateButton);

        generateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (eventNumber< Game.Ship.eventsBetweenCheckpoints)
                {
                    NewEvent();
                }
                else
                {
                   Game.ChangeScreen(ScreenEnum.Checkpoint);
                }
            }
        });

    }
}
