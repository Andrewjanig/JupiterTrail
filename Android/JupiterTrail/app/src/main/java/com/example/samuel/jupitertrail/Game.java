package com.example.samuel.jupitertrail;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;


import com.example.samuel.jupitertrail.Enum.DifficultyEnum;
import com.example.samuel.jupitertrail.Enum.ScreenEnum;
import com.example.samuel.jupitertrail.GameScreens.CharacterScreen;
import com.example.samuel.jupitertrail.GameScreens.CheckpointScreen;
import com.example.samuel.jupitertrail.GameScreens.JourneyScreen;
import com.example.samuel.jupitertrail.GameScreens.LoseScreen;
import com.example.samuel.jupitertrail.GameScreens.ProvisionsScreen;
import com.example.samuel.jupitertrail.GameScreens.WelcomeScreen;
import com.example.samuel.jupitertrail.GameScreens.WinScreen;

/**
 * Created by Samuel on 27/04/2016.
 */
public class Game extends Activity {

    public DifficultyEnum Difficulty = DifficultyEnum.Medium;
    private ScreenEnum CurrentScreen = ScreenEnum.CharacterCreation;

    public static CrewMember[] Crew;
    public int Credits = 100;

    public static Context context;

    public static Ship PlayerShip;

    public int checkpointsTillVictory = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        context = this;

        PlayerShip = new Ship();

        Crew = new CrewMember[4];
        Crew[0] = new CrewMember();
        Crew[1] = new CrewMember();
        Crew[2] = new CrewMember();
        Crew[3] = new CrewMember();


        ChangeScreen(ScreenEnum.CharacterCreation);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }


    public void ChangeScreen(ScreenEnum screen)
    {
        switch(screen)
        {
            case Menu:
                finish();
                break;
            case CharacterCreation:
                new CharacterScreen(this);
                break;
            case Provisions:
                new ProvisionsScreen(this);
                break;
            case Welcome:
                new WelcomeScreen(this);
                break;
            case Journey:
                new JourneyScreen(this);
                break;
            case Checkpoint:
                new CheckpointScreen(this);
                break;
            case Failure:
                new LoseScreen(this);
                break;
            case Success:
                new WinScreen(this);
                break;

        }
    }

}
