package com.example.samuel.jupitertrail.GameScreens;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.widget.Button;

import com.example.samuel.jupitertrail.Enum.ScreenEnum;
import com.example.samuel.jupitertrail.Game;
import com.example.samuel.jupitertrail.R;


/**
 * Created by Samuel on 27/04/2016.
 */
public class WelcomeScreen extends ContextWrapper {

    public WelcomeScreen(Context context)
    {
        super(context);

        final Game Game = (Game)context;
        Activity a = (Activity) context;

        a.setContentView(R.layout.welcome_screen);

        final Button departButton = (Button) a.findViewById(R.id.depart_button);
        departButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.ChangeScreen(ScreenEnum.Journey);
            }
        });
    }
}
