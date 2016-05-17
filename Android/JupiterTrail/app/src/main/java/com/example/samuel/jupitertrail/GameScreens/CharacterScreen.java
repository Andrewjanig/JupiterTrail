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
        final Button proff1bbutton = (Button) a.findViewById(R.id.doctor_buttona);
        final Button proff1cbutton = (Button) a.findViewById(R.id.astronaut_buttona);
        proff1abutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Crew[0].AssignProfession(ProfessionEnum.Miner);
                proff1bbutton.setVisibility(View.INVISIBLE);
                proff1cbutton.setVisibility(View.INVISIBLE);
            }
        });


        proff1bbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Crew[0].AssignProfession(ProfessionEnum.Doctor);
                proff1abutton.setVisibility(View.INVISIBLE);
                proff1cbutton.setVisibility(View.INVISIBLE);
            }
        });


        proff1cbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Crew[0].AssignProfession(ProfessionEnum.Astronaut);
                proff1abutton.setVisibility(View.INVISIBLE);
                proff1bbutton.setVisibility(View.INVISIBLE);
            }
        });

        final Button proff2abutton = (Button) a.findViewById(R.id.miner_buttonb);
        final Button proff2bbutton = (Button) a.findViewById(R.id.doctor_buttonb);
        final Button proff2cbutton = (Button) a.findViewById(R.id.astronaut_buttonb);
        proff2abutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Crew[1].AssignProfession(ProfessionEnum.Miner);
                proff2bbutton.setVisibility(View.INVISIBLE);
                proff2cbutton.setVisibility(View.INVISIBLE);
            }
        });


        proff2bbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Crew[1].AssignProfession(ProfessionEnum.Doctor);
                proff2abutton.setVisibility(View.INVISIBLE);
                proff2cbutton.setVisibility(View.INVISIBLE);
            }
        });


        proff2cbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Crew[1].AssignProfession(ProfessionEnum.Astronaut);
                proff2abutton.setVisibility(View.INVISIBLE);
                proff2bbutton.setVisibility(View.INVISIBLE);
            }
        });

        final Button proff3abutton = (Button) a.findViewById(R.id.miner_buttonc);
        final Button proff3bbutton = (Button) a.findViewById(R.id.doctor_buttonc);
        final Button proff3cbutton = (Button) a.findViewById(R.id.astronaut_buttonc);
        proff3abutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Crew[2].AssignProfession(ProfessionEnum.Miner);
                proff3bbutton.setVisibility(View.INVISIBLE);
                proff3cbutton.setVisibility(View.INVISIBLE);
            }
        });


        proff3bbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Crew[2].AssignProfession(ProfessionEnum.Doctor);
                proff3abutton.setVisibility(View.INVISIBLE);
                proff3cbutton.setVisibility(View.INVISIBLE);
            }
        });


        proff3cbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Crew[2].AssignProfession(ProfessionEnum.Astronaut);
                proff3abutton.setVisibility(View.INVISIBLE);
                proff3bbutton.setVisibility(View.INVISIBLE);
            }
        });

        final Button proff4abutton = (Button) a.findViewById(R.id.miner_buttond);
        final Button proff4bbutton = (Button) a.findViewById(R.id.doctor_buttond);
        final Button proff4cbutton = (Button) a.findViewById(R.id.astronaut_buttond);
        proff4abutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Crew[3].AssignProfession(ProfessionEnum.Miner);
                proff4bbutton.setVisibility(View.INVISIBLE);
                proff4cbutton.setVisibility(View.INVISIBLE);
            }
        });


        proff4bbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Crew[3].AssignProfession(ProfessionEnum.Doctor);
                proff4abutton.setVisibility(View.INVISIBLE);
                proff4cbutton.setVisibility(View.INVISIBLE);
            }
        });


        proff4cbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Crew[3].AssignProfession(ProfessionEnum.Astronaut);
                proff4abutton.setVisibility(View.INVISIBLE);
                proff4bbutton.setVisibility(View.INVISIBLE);
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
