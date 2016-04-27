package com.example.samuel.jupitertrail.GameScreens;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

import com.example.samuel.jupitertrail.R;


/**
 * Created by Samuel on 27/04/2016.
 */
public class CheckpointScreen extends ContextWrapper {

    public CheckpointScreen(Context context)
    {
        super(context);
        Activity a = (Activity) context;

        a.setContentView(R.layout.checkpoint_screen);
    }
}
