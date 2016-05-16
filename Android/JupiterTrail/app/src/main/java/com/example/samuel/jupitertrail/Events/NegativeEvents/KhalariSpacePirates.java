package com.example.samuel.jupitertrail.Events.NegativeEvents;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.samuel.jupitertrail.Enum.DifficultyEnum;
import com.example.samuel.jupitertrail.Events.EventTemplate;
import com.example.samuel.jupitertrail.GameScreens.JourneyScreen;

/**
 * Created by Samuel on 16/05/2016.
 */
public class KhalariSpacePirates extends EventTemplate {

    public KhalariSpacePirates(DifficultyEnum diff, Context G, JourneyScreen journey, Button b)
    {
        super(G, 2, journey);
        final Button button  = b;
        b.setVisibility(View.INVISIBLE);
        text = "Your money or your life.";

        Buttons[0] = new Button(Game);
        Buttons[0].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        Buttons[0].setText("Pay 50 credits");
        Buttons[0].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Credits-=50;
                Toast toast = Toast.makeText(Game, "Paid 50 credits", Toast.LENGTH_SHORT);
                toast.show();
                Buttons[0].setOnClickListener(null);
                button.setVisibility(View.VISIBLE);
            }
        });

        Buttons[1] = new Button(Game);
        Buttons[1].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        Buttons[1].setText("Sacrifice a crew member");
        Buttons[1].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Game.Crew[0].Alive)
                    Game.Crew[0].Alive = false;
                else if (Game.Crew[1].Alive)
                    Game.Crew[1].Alive = false;
                else if (Game.Crew[2].Alive)
                    Game.Crew[2].Alive = false;
                else if (Game.Crew[3].Alive)
                    Game.Crew[3].Alive = false;
                Toast toast = Toast.makeText(Game, "Sacrificed a crew member.", Toast.LENGTH_SHORT);
                toast.show();
                Buttons[1].setOnClickListener(null);
                button.setVisibility(View.VISIBLE);
            }
        });
    }

}
