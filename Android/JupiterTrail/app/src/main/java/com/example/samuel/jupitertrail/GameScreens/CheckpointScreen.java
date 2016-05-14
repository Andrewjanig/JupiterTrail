package com.example.samuel.jupitertrail.GameScreens;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.samuel.jupitertrail.Enum.ResourceEnum;
import com.example.samuel.jupitertrail.R;

import org.w3c.dom.Text;


/**
 * Created by Samuel on 27/04/2016.
 */
public class CheckpointScreen extends ContextWrapper {

    public CheckpointScreen(Context context)
    {
        super(context);
        Activity a = (Activity) context;

        a.setContentView(R.layout.checkpoint_screen);

        final Button fuelButton = (Button) a.findViewById(R.id.btn_Doctor);
        fuelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Game.Ship.AddResource(ResourceEnum.Fuel);
               // fuelText.setText(String.valueOf(Game.Ship.ResourceList.get(ResourceEnum.Fuel).Amount));
               // UpdateStorageText();

                OpenDoctorScreen();
            }
        });
    }
    private void OpenDoctorScreen()
    {
        // Dummy function
        final TextView levelText =  (TextView) a.findViewById(R.id.levelTxt);

        levelText.setText("Level: " + "1");
    }
}
