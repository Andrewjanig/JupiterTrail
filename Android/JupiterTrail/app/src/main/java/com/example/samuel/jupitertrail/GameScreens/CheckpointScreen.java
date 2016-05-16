package com.example.samuel.jupitertrail.GameScreens;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.samuel.jupitertrail.Enum.ResourceEnum;
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
        final Activity a = (Activity) context;

        a.setContentView(R.layout.checkpoint_screen);

        final Button doctorButton = (Button) a.findViewById(R.id.btn_Doctor);
        doctorButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                OpenDoctorScreen(a);
            }
        });
    }
    private void OpenDoctorScreen(Activity a)
    {
        // Dummy function

        //final TextView levelText =  (TextView) a.findViewById(R.id.levelTxt);

        //levelText.setText("Level: " + "1");
    }
}
