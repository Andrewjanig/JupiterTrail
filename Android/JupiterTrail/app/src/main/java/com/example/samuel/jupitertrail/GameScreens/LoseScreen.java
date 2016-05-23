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
 * Created by Samuel on 24/05/2016.
 */
public class LoseScreen extends ContextWrapper{
    public LoseScreen(Context context)
    {
        super(context);

        final Game Game = (Game)context;
        Activity a = (Activity) context;

        a.setContentView(R.layout.lose_screen);

        final Button menu_button = (Button) a.findViewById(R.id.menu_button);
        menu_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.ChangeScreen(ScreenEnum.Menu);
            }
        });
    }
}
