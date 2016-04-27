package com.example.samuel.jupitertrail.GameScreens;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.samuel.jupitertrail.Enum.ScreenEnum;
import com.example.samuel.jupitertrail.Event;
import com.example.samuel.jupitertrail.Game;
import com.example.samuel.jupitertrail.R;


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

        Event Event = new Event(Game.Difficulty);


        eventText.setText(Event.EventText);


        for (int i = 0; i< Event.OptionText.length; i++)
        {
            LinearLayout buttonsLayout = (LinearLayout) a.findViewById(R.id.buttonlayout);
            Button optionButton = new Button(this);
            optionButton.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            optionButton.setText(Event.GetOptionText(i));
            buttonsLayout.addView(optionButton);
        }

        //For Debugging: Generate New Event
        LinearLayout buttonsLayout = (LinearLayout) a.findViewById(R.id.buttonlayout);
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
}
