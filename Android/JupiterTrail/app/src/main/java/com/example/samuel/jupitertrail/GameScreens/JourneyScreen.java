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
import com.example.samuel.jupitertrail.Events.Positive;
import com.example.samuel.jupitertrail.Events.Neutral;
import com.example.samuel.jupitertrail.Events.Option;
import com.example.samuel.jupitertrail.Events.Negative;
import com.example.samuel.jupitertrail.Game;
import com.example.samuel.jupitertrail.R;

import java.util.Random;


/**
 * Created by Samuel on 27/04/2016.
 */
public class JourneyScreen extends ContextWrapper {

    Game Game;
    Activity a;

    public int eventNumber  = 0;

    public JourneyScreen(Context context)
    {
        super(context);

        Game = (Game)context;
        a = (Activity) context;


        NewEvent();
    }

    private EventInstance GetEvent(Button b)
    {
        Random rand = new Random();
        int num = rand.nextInt((3 - 1) + 1) + 1;

        switch(num)
        {
            case 1: //negative
                return new Negative(Game.Difficulty, Game, this, b);
            case 2: //neutral
                return new Neutral(Game.Difficulty, Game, this);
            case 3: //positive
                return new Positive(Game.Difficulty, Game, this);
            default:
                return new Neutral(Game.Difficulty, Game, this);
        }
    }

    private void NewEvent()
    {

        eventNumber++; //Increment the number of events that has occurred since the last checkpoint
        Game.PlayerShip.MoveShip();
        if (Game.PlayerShip.ResourceList.get(ResourceEnum.Fuel).Amount < 0)
        {
            Game.ChangeScreen(ScreenEnum.Failure);
        }

        boolean atLeastOneAlive = false;
        if (Game.Crew[0].CheckAlive())
        {
            if (!Game.PlayerShip.Eat(Game.Crew[0].FoodRequirement()))
                Game.Crew[0].Alive = false;
            else
             atLeastOneAlive = true;
        }
        if (Game.Crew[1].CheckAlive())
        {
            if (!Game.PlayerShip.Eat(Game.Crew[1].FoodRequirement()))
                Game.Crew[1].Alive = false;
            else
                atLeastOneAlive = true;
        }
        if (Game.Crew[2].CheckAlive())
        {
            if (!Game.PlayerShip.Eat(Game.Crew[2].FoodRequirement()))
                Game.Crew[2].Alive = false;
            else
                atLeastOneAlive = true;
        }
        if (Game.Crew[3].CheckAlive())
        {
            if (!Game.PlayerShip.Eat(Game.Crew[3].FoodRequirement()))
                Game.Crew[3].Alive = false;
            else
                atLeastOneAlive = true;
        }

        if (!atLeastOneAlive || (Game.PlayerShip.TurnsTillLoss <= 0))
            Game.finish();

        a.setContentView(R.layout.journey_screen);

        final TextView resource1Text = (TextView) a.findViewById(R.id.resource1);
        final TextView resource2Text = (TextView) a.findViewById(R.id.resource2);
        final TextView resource3Text = (TextView) a.findViewById(R.id.resource3);
        final TextView eventsToGoText = (TextView) a.findViewById(R.id.eventstogo);
        final TextView crew1 = (TextView) a.findViewById(R.id.crew1);
        final TextView crew2 = (TextView) a.findViewById(R.id.crew2);
        final TextView crew3 = (TextView) a.findViewById(R.id.crew3);
        final TextView crew4 = (TextView) a.findViewById(R.id.crew4);

        resource1Text.setText("Fuel Cells: " + Game.PlayerShip.ResourceList.get(ResourceEnum.Fuel).Amount + " -" + String.valueOf(Game.PlayerShip.fuelPerEvent));
        resource2Text.setText(" Thrusters: " + Game.PlayerShip.ResourceList.get(ResourceEnum.Thruster).Amount);
        resource3Text.setText(" Rations: " + Game.PlayerShip.ResourceList.get(ResourceEnum.Rations).Amount + " -" + String.valueOf(TotalRationConsumption()));
        eventsToGoText.setText("Distance to next space station: " + (Game.PlayerShip.eventsBetweenCheckpoints - eventNumber + 1));
        crew1.setText("Crew 1: " + Game.Crew[0].Status());
        crew2.setText(" Crew 2: " + Game.Crew[1].Status());
        crew3.setText(" Crew 3: " + Game.Crew[2].Status());
        crew4.setText(" Crew 4: " + Game.Crew[3].Status());

        final TextView eventText = (TextView) a.findViewById(R.id.event_text);
        LinearLayout buttonsLayout = (LinearLayout) a.findViewById(R.id.buttonlayout);

        //Generate New Event Button
        final Button generateButton = new Button(this);
        generateButton.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        generateButton.setText("Continue On");
        buttonsLayout.addView(generateButton);

        EventInstance CurrentEvent = GetEvent(generateButton);

        eventText.setText(CurrentEvent.Text);


        if (CurrentEvent.Options != null)
            for (Option o : CurrentEvent.Options)
            {
                buttonsLayout.addView(o.button);
            }



        generateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (eventNumber< Game.PlayerShip.eventsBetweenCheckpoints)
                {
                    NewEvent();
                }
                else
                {
                    eventNumber = 0;
                   Game.ChangeScreen(ScreenEnum.Checkpoint);
                }
            }
        });

    }

    public void Update()
    {
        final TextView resource1Text = (TextView) a.findViewById(R.id.resource1);
        final TextView resource2Text = (TextView) a.findViewById(R.id.resource2);
        final TextView resource3Text = (TextView) a.findViewById(R.id.resource3);
        final TextView eventsToGoText = (TextView) a.findViewById(R.id.eventstogo);
        final TextView crew1 = (TextView) a.findViewById(R.id.crew1);
        final TextView crew2 = (TextView) a.findViewById(R.id.crew2);
        final TextView crew3 = (TextView) a.findViewById(R.id.crew3);
        final TextView crew4 = (TextView) a.findViewById(R.id.crew4);

        resource1Text.setText("Fuel Cells: " + Game.PlayerShip.ResourceList.get(ResourceEnum.Fuel).Amount + " -" + String.valueOf(Game.PlayerShip.fuelPerEvent));
        resource2Text.setText(" Thrusters: " + Game.PlayerShip.ResourceList.get(ResourceEnum.Thruster).Amount);
        resource3Text.setText(" Rations: " + Game.PlayerShip.ResourceList.get(ResourceEnum.Rations).Amount + " -" + String.valueOf(TotalRationConsumption()));
        eventsToGoText.setText("Distance to next space station: " + (Game.PlayerShip.eventsBetweenCheckpoints - eventNumber + 1));
        crew1.setText("Crew 1: " + Game.Crew[0].Status());
        crew2.setText(" Crew 2: " + Game.Crew[1].Status());
        crew3.setText(" Crew 3: " + Game.Crew[2].Status());
        crew4.setText(" Crew 4: " + Game.Crew[3].Status());
    }

    private int TotalRationConsumption()
    {
        int i = 0;

        if (Game.Crew[0].Alive)
            i+= Game.Crew[0].FoodRequirement();
        if (Game.Crew[1].Alive)
            i+= Game.Crew[1].FoodRequirement();
        if (Game.Crew[2].Alive)
            i+= Game.Crew[2].FoodRequirement();
        if (Game.Crew[3].Alive)
            i+= Game.Crew[3].FoodRequirement();


        return i;
    }


}
