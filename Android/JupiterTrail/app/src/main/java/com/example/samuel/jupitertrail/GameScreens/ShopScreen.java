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
public class ShopScreen extends ContextWrapper {

    Game Game;
    Activity a;

    public ShopScreen(Context context)
    {
        super(context);

        Game = (Game)context;
        a = (Activity) context;

        a.setContentView(R.layout.provisions_screen);
        UpdateStorageText();

        final Button fuelButton = (Button) a.findViewById(R.id.fuel_button);
        fuelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.PlayerShip.AddResource(ResourceEnum.Fuel);
                UpdateStorageText();
            }
        });
        final Button oxygenButton = (Button) a.findViewById(R.id.oxygen_button);
        oxygenButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.PlayerShip.AddResource(ResourceEnum.Thruster);
                UpdateStorageText();
            }
        });
        final Button rocketsButton = (Button) a.findViewById(R.id.rockets_button);
        rocketsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.PlayerShip.AddResource(ResourceEnum.Rations);
                UpdateStorageText();
            }
        });
        final Button nextButton = (Button) a.findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.ChangeScreen(ScreenEnum.Checkpoint);
            }
        });
    }

    private void UpdateStorageText()
    {
        final TextView storageText = (TextView) a.findViewById(R.id.storage_text);
        final TextView fuelText = (TextView) a.findViewById(R.id.fuel_text);
        final TextView oxygenText = (TextView) a.findViewById(R.id.oxygen_text);
        final TextView rocketsText = (TextView) a.findViewById(R.id.rockets_text);

        storageText.setText("Storage Used: " + String.valueOf(Game.PlayerShip.StorageUsed) + "/" + String.valueOf(Game.PlayerShip.MaxStorage));
        fuelText.setText(String.valueOf(Game.PlayerShip.ResourceList.get(ResourceEnum.Fuel).Amount));
        oxygenText.setText(String.valueOf(Game.PlayerShip.ResourceList.get(ResourceEnum.Thruster).Amount));
        rocketsText.setText(String.valueOf(Game.PlayerShip.ResourceList.get(ResourceEnum.Rations).Amount));
    }
}
