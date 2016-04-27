package com.example.samuel.jupitertrail.GameScreens;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.widget.Button;

import com.example.samuel.jupitertrail.Enum.ProfessionEnum;
import com.example.samuel.jupitertrail.Enum.ScreenEnum;
import com.example.samuel.jupitertrail.Game;
import com.example.samuel.jupitertrail.R;


/**
 * Created by Samuel on 27/04/2016.
 */
public class CharacterScreen extends ContextWrapper {

    public CharacterScreen(Context context) {
        super(context);

        final Game Game = (Game) context;
        Activity a = (Activity) context;

        a.setContentView(R.layout.character_creation_screen);

        final Button optionsButton = (Button) a.findViewById(R.id.miner_button);
        optionsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Player.AssignProfession(ProfessionEnum.Miner);
                Game.ChangeScreen(ScreenEnum.Provisions);
            }
        });

        final Button scoresButton = (Button) a.findViewById(R.id.doctor_button);
        scoresButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Player.AssignProfession(ProfessionEnum.Doctor);
                Game.ChangeScreen(ScreenEnum.Provisions);
            }
        });

        final Button quitButton = (Button) a.findViewById(R.id.astronaut_button);
        quitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Player.AssignProfession(ProfessionEnum.Astronaut);
                Game.ChangeScreen(ScreenEnum.Provisions);
            }
        });
    }
}
