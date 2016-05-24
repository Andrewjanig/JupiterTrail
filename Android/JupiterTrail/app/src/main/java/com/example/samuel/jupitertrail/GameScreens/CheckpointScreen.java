package com.example.samuel.jupitertrail.GameScreens;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.samuel.jupitertrail.Enum.ResourceEnum;
import com.example.samuel.jupitertrail.Enum.ScreenEnum;
import com.example.samuel.jupitertrail.Game;
import com.example.samuel.jupitertrail.R;
import com.example.samuel.jupitertrail.Ship;

import org.w3c.dom.Text;


/**
 * Created by Samuel on 27/04/2016.
 */
public class CheckpointScreen extends ContextWrapper {

    public CheckpointScreen(Context context)
    {
        super(context);
        final Context thisContext = context;
        final Activity a = (Activity) context;
        final Game Game = (Game)context;

        a.setContentView(R.layout.checkpoint_screen);

        final Button doctorButton = (Button) a.findViewById(R.id.btn_Doctor);
        doctorButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Game.Crew[0].CureAll();
                Game.Crew[1].CureAll();
                Game.Crew[2].CureAll();
                Game.Crew[3].CureAll();
                Toast toast = Toast.makeText(Game.context, "Crew cured!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        final Button leaveButton = (Button) a.findViewById(R.id.btn_Continue);
        leaveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {

                Game.PlayerShip.Reset();
                Game.Crew[0].Reset();
                Game.Crew[1].Reset();
                Game.Crew[2].Reset();
                Game.Crew[3].Reset();
                Game.ChangeScreen(ScreenEnum.Journey);
            }
        });

        final Button shopButton = (Button) a.findViewById(R.id.btn_Store);
        shopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                new ShopScreen(thisContext);
            }
        });

        Game.checkpointsTillVictory -=1;

        if (Game.checkpointsTillVictory == 0)
        {
            Game.ChangeScreen(ScreenEnum.Success);
        }
    }

}
