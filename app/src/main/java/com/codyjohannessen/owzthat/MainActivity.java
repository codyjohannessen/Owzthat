package com.codyjohannessen.owzthat;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button startGame; // creating the variable for the start game button.
    private Button highScore; // button created for the high score.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startGame = (Button) findViewById(R.id.startGame); // Initializing the button
        startGame.setOnClickListener(new View.OnClickListener() { // Here is where we call the button
            @Override                                             // to switch to the game screen
            public void onClick(View v) {
                openGameScreen();
            }
        });
    }

    public void openGameScreen() {
        Intent intent = new Intent(this, GameScreen.class);// we pass the screen that we want to open
        startActivity(intent); // calls the intent to open the game screen
    }
}

