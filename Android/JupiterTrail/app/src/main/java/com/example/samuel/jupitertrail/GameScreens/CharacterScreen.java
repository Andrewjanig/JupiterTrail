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

        final Button proff1abutton = (Button) a.findViewById(R.id.miner_buttona);
        proff1abutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Crew[0].AssignProfession(ProfessionEnum.Miner);
                //proff1abutton.setBackgroundColor(0xFF00FF00);
            }
        });

        final Button proff1bbutton = (Button) a.findViewById(R.id.doctor_buttona);
        proff1bbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Crew[0].AssignProfession(ProfessionEnum.Doctor);
            }
        });

        final Button proff1cbutton = (Button) a.findViewById(R.id.astronaut_buttona);
        proff1cbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Crew[0].AssignProfession(ProfessionEnum.Astronaut);
            }
        });

        final Button proff2abutton = (Button) a.findViewById(R.id.miner_buttonb);
        proff2abutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Crew[1].AssignProfession(ProfessionEnum.Miner);
            }
        });

        final Button proff2bbutton = (Button) a.findViewById(R.id.doctor_buttonb);
        proff2bbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Crew[1].AssignProfession(ProfessionEnum.Doctor);
            }
        });

        final Button proff2cbutton = (Button) a.findViewById(R.id.astronaut_buttonb);
        proff2cbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Crew[1].AssignProfession(ProfessionEnum.Astronaut);
            }
        });

        final Button proff3abutton = (Button) a.findViewById(R.id.miner_buttonc);
        proff3abutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Crew[2].AssignProfession(ProfessionEnum.Miner);
            }
        });

        final Button proff3bbutton = (Button) a.findViewById(R.id.doctor_buttonc);
        proff3bbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Crew[2].AssignProfession(ProfessionEnum.Doctor);
            }
        });

        final Button proff3cbutton = (Button) a.findViewById(R.id.astronaut_buttonc);
        proff3cbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Crew[2].AssignProfession(ProfessionEnum.Astronaut);
            }
        });

        final Button proff4abutton = (Button) a.findViewById(R.id.miner_buttond);
        proff4abutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Crew[3].AssignProfession(ProfessionEnum.Miner);
            }
        });

        final Button proff4bbutton = (Button) a.findViewById(R.id.doctor_buttond);
        proff4bbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Crew[3].AssignProfession(ProfessionEnum.Doctor);
            }
        });

        final Button proff4cbutton = (Button) a.findViewById(R.id.astronaut_buttond);
        proff4cbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Crew[3].AssignProfession(ProfessionEnum.Astronaut);
            }
        });

        final Button readyButton = (Button) a.findViewById(R.id.readyButton);
        readyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Game.Crew[0].Profession != null && Game.Crew[1].Profession != null && Game.Crew[2].Profession != null && Game.Crew[3].Profession != null)
                    Game.ChangeScreen(ScreenEnum.Provisions);
            }
        });

    }
}
