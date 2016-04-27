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

        final TextView fuelText = (TextView) a.findViewById(R.id.fuel_text);
        final TextView oxygenText = (TextView) a.findViewById(R.id.oxygen_text);
        final TextView rocketsText = (TextView) a.findViewById(R.id.rockets_text);

        final Button fuelButton = (Button) a.findViewById(R.id.fuel_button);
        fuelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Ship.AddResource(ResourceEnum.Fuel);
                fuelText.setText(String.valueOf(Game.Ship.ResourceList.get(ResourceEnum.Fuel).Amount));
                UpdateStorageText();
            }
        });
        final Button oxygenButton = (Button) a.findViewById(R.id.oxygen_button);
        oxygenButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Ship.AddResource(ResourceEnum.Oxygen);
                oxygenText.setText(String.valueOf(Game.Ship.ResourceList.get(ResourceEnum.Oxygen).Amount));
                UpdateStorageText();
            }
        });
        final Button rocketsButton = (Button) a.findViewById(R.id.rockets_button);
        rocketsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Game.Ship.AddResource(ResourceEnum.Rockets);
                rocketsText.setText(String.valueOf(Game.Ship.ResourceList.get(ResourceEnum.Rockets).Amount));
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
        final TextView storageText = (TextView) a.findViewById(R.id.storage_text);
        storageText.setText("Storage Used: " + String.valueOf(Game.Ship.StorageUsed) + "/" + String.valueOf(Game.Ship.MaxStorage));
    }
}
