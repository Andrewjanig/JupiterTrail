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
 * Created by Samuel on 27/04/2016.
 */
public class Difficulty extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.difficulty_menu);

        final int diff = 0;

        final Button easyButton = (Button) findViewById(R.id.easy_button);
        final Button mediumButton = (Button) findViewById(R.id.medium_button);
        final Button hardButton = (Button) findViewById(R.id.hard_button);

        easyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", DifficultyEnum.Easy);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });
        mediumButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",DifficultyEnum.Medium);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });
        hardButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",DifficultyEnum.Hard);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }
}
