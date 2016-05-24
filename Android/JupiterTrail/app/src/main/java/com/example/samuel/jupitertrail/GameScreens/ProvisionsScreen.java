package com.example.samuel.jupitertrail.GameScreens;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.samuel.jupitertrail.Enum.ResourceEnum;
import com.example.samuel.jupitertrail.Enum.ScreenEnum;
import com.example.samuel.jupitertrail.Game;
import com.example.samuel.jupitertrail.R;


/**
 * Created by Samuel on 27/04/2016.
 */
public class ProvisionsScreen extends ContextWrapper {

    Game Game;
    Activity a;

    public ProvisionsScreen(Context context)
    {
        super(context);

        Game = (Game)context;
        a = (Activity) context;

        a.setContentView(R.layout.provisions_screen);
        UpdateStorageText();

        final Button fuelButton = (Button) a.findViewById(R.id.fuel_button);
        fuelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Credits = Game.PlayerShip.AddResource(ResourceEnum.Fuel, Game.Credits);
                UpdateStorageText();
            }
        });
        final Button rations_button = (Button) a.findViewById(R.id.rations_button);
        rations_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Credits = Game.PlayerShip.AddResource(ResourceEnum.Rations, Game.Credits);
                UpdateStorageText();
            }
        });
        final Button thrusters_button = (Button) a.findViewById(R.id.thrusters_button);
        thrusters_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Credits = Game.PlayerShip.AddResource(ResourceEnum.Thruster, Game.Credits);
                UpdateStorageText();
            }
        });
        final Button nextButton = (Button) a.findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.ChangeScreen(ScreenEnum.Welcome);
            }
        });
    }

    private void UpdateStorageText()
    {
        final TextView creditsText = (TextView) a.findViewById(R.id.credits_text);
        final TextView fuelText = (TextView) a.findViewById(R.id.fuel_text);
        final TextView rations_text = (TextView) a.findViewById(R.id.rations_text);
        final TextView thrusters_text = (TextView) a.findViewById(R.id.thrusters_text);

        creditsText.setText("Credits: " + String.valueOf(Game.Credits));
        fuelText.setText(String.valueOf(Game.PlayerShip.ResourceList.get(ResourceEnum.Fuel).Amount));
        rations_text.setText(String.valueOf(Game.PlayerShip.ResourceList.get(ResourceEnum.Rations).Amount));
        thrusters_text.setText(String.valueOf(Game.PlayerShip.ResourceList.get(ResourceEnum.Thruster).Amount));
    }
}
