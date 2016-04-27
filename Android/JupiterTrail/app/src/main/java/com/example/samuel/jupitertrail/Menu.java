package com.example.samuel.jupitertrail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.samuel.jupitertrail.Enum.DifficultyEnum;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Menu extends Activity {

    private DifficultyEnum difficulty = DifficultyEnum.Medium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);


        final Button startgameButton = (Button) findViewById(R.id.startgame_button);
        startgameButton.setText( "Start Game (" + difficulty.toString() + ")" );
        startgameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Game.class);
                startActivity(intent);
            }
        });

        final Button optionsButton = (Button) findViewById(R.id.options_button);
        optionsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Difficulty.class);
                startActivityForResult(intent, 1);
            }
        });

        final Button scoresButton = (Button) findViewById(R.id.scores_button);
        scoresButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Intent intent = new Intent(Game.this, Scores.class);
                //startActivity(intent);
            }
        });

        final Button quitButton = (Button) findViewById(R.id.quit_button);
        quitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == 1)
        {
            if (resultCode == Activity.RESULT_OK)
            {
                final Button startgameButton = (Button) findViewById(R.id.startgame_button);
                difficulty = (DifficultyEnum)data.getSerializableExtra("result");
                startgameButton.setText( "Start Game (" + difficulty.toString() + ")" );
            }
        }
    }

}
