package com.example.samuel.jupitertrail.Events.NegativeEvents;

import android.content.Context;
import android.widget.Toast;

import com.example.samuel.jupitertrail.Enum.DifficultyEnum;
import com.example.samuel.jupitertrail.Events.EventTemplate;
import com.example.samuel.jupitertrail.GameScreens.JourneyScreen;

/**
 * Created by Samuel on 16/05/2016.
 */
public class UnSherajDevourer extends EventTemplate {

    public UnSherajDevourer(DifficultyEnum diff, Context G, JourneyScreen journey)
    {
        super(G, 0, journey);

        text = "Most alien species are sophisticated and live a peaceful co-existence with the human race, the Un’Sheraj however are a lost race of mythical proportions. This one just ate and now it’s coming for you. Slowly.";
                Game.PlayerShip.TurnsTillLoss = 3;
                Toast toast = Toast.makeText(Game, "You have 3 days with which to reach your next destination. Hope they have guns - big guns.", Toast.LENGTH_SHORT);
                toast.show();
                journey.Update();
    }

}
