package com.example.samuel.jupitertrail.GameScreens;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.samuel.jupitertrail.Enum.ScreenEnum;
import com.example.samuel.jupitertrail.EventInstance;
import com.example.samuel.jupitertrail.Events.AlienAttack;
import com.example.samuel.jupitertrail.Events.Option;
import com.example.samuel.jupitertrail.Game;
import com.example.samuel.jupitertrail.R;

import java.util.Random;


/**
 * Created by Samuel on 27/04/2016.
 */
public class JourneyScreen extends ContextWrapper {

    Game Game;
    Activity a;

    public JourneyScreen(Context context)
    {
        super(context);

        Game = (Game)context;
        a = (Activity) context;

        a.setContentView(R.layout.journey_screen);

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
                Game.ChangeScreen(ScreenEnum.Journey);
            }
        });

        //For Debugging: Reach Checkpoint
        Button checkpointButton = new Button(this);
        checkpointButton.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        checkpointButton.setText("Reach Checkpoint");
        buttonsLayout.addView(checkpointButton);

        checkpointButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.ChangeScreen(ScreenEnum.Checkpoint);
            }
        });
    }

    private EventInstance GetEvent()
    {
        Random rand = new Random();
        int num = rand.nextInt((1 - 1) + 1) + 1;

        switch(num)
        {
            case 1:
                return new AlienAttack(Game.Difficulty, Game);
            case 2:

            case 3:

            case 4:

            default:
                return new AlienAttack(Game.Difficulty, Game);
        }
    }
}
