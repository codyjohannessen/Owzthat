package com.codyjohannessen.owzthat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;


public class GameScreen extends AppCompatActivity {

    private Button rollButton; // Roll button being declared as a variable
    private Button umpireButton; // Only when needed will be available to roll.
    private TextView totalScore; // Text view for adding score from Roll Score
    private TextView umpireRoll; // Umpires outcome from Umpire Button roll

    private int batOneScore, batTwoScore, batThreeScore; // initialize the score calculator for each individual batter

    private int score = 0;
    private int count = 0;
    private int batters = 6;

    private TextView rollScore, rollScore1, rollScore2; // Text view being declared for each batter score


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        // initializing the buttons below.
        umpireButton = (Button) findViewById(R.id.umpireButton);
        rollButton = (Button) findViewById(R.id.rollButton);
        // initializing the text views below.
        umpireRoll = (TextView) findViewById(R.id.umpireRoll);
        rollScore = (TextView) findViewById(R.id.rollScore);
        rollScore1 = (TextView) findViewById(R.id.rollScore1);
        rollScore2 = (TextView) findViewById(R.id.rollScore2);
        totalScore = (TextView) findViewById(R.id.totalScore);




        // setting the umpire button to unclickable so the player can only
        // can click the roll button to start the game
        umpireButton.setEnabled(false);


        // Roll button method below. Gives us a random number on click
        //
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                int batsmanDice = random.nextInt(6); // 7 choices for batter to roll (1 - 6 and Owzthat)
                final int umpireDice = random.nextInt(4);  // 5 choice for the umpire to roll (1. Not Out 2. Caught 3. Wicket 4. LBW 5. Bowled)

                rollScore.setText(String.valueOf(batsmanDice)); // sets the total score next to the batters icon from the roll.

                if (batsmanDice > 0 && batsmanDice < 7) {
                    totalScore.setText(String.valueOf(score += batsmanDice));
                    batOneScore = score += batsmanDice;
                } else {

                    if (batsmanDice == 0) {
                        rollScore.setText(" ");// when rolling 0 we don't want zero on the game board.
                        count++;
                        Toast.makeText(GameScreen.this,
                                "Owzthat!", Toast.LENGTH_SHORT).show();


                        rollButton.setEnabled(false); // followed by disabling the player button.
                        umpireButton.setEnabled(true); // once Owzthat gets called in toast we enable the umpire button

                                umpireRoll();
                                batter2(); // calling the second batter method.

                    }

                }



            }
        });

    }



    public void batter2() {

        rollButton.setEnabled(true); // setting the buttons back to the correct state
        umpireButton.setEnabled(false);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                int batsmanDice = random.nextInt(6); // 7 choices for batter to roll (1 - 6 and Owzthat)
                final int umpireDice = random.nextInt(4);  // 5 choice for the umpire to roll (1. Not Out 2. Caught 3. Wicket 4. LBW 5. Bowled)
                umpireRoll.setText(" "); // clearing the umpire dice descion
                rollScore1.setText(String.valueOf(batsmanDice)); // sets the total score next to the batters icon from the roll.

                if (batsmanDice > 0 && batsmanDice < 7) {
                    totalScore.setText(String.valueOf(score += batsmanDice));
                } else {

                    if (batsmanDice == 0) {
                        rollScore1.setText(" ");// when rolling 0 we don't want zero on the game board.
                        count++;
                        Toast.makeText(GameScreen.this,
                                "Owzthat!", Toast.LENGTH_SHORT).show();
                        rollButton.setEnabled(false); // followed by disabling the player button.
                        umpireButton.setEnabled(true); // once Owzthat gets called in toast we enable the umpire button

                        // call the button for the Umpire descion to be used.
                        // after setting the button to be enabled from the boolean statement

                                umpireRoll();
                                batter3();



                    }

                }


            }
        });

    }

    public void batter3(){

        rollButton.setEnabled(true); // setting the buttons back to the correct state
        umpireButton.setEnabled(false);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                int batsmanDice = random.nextInt(6); // 7 choices for batter to roll (1 - 6 and Owzthat)
                umpireRoll.setText(" "); // clearing the umpire dice descion
                rollScore2.setText(String.valueOf(batsmanDice)); // sets the total score next to the batters icon from the roll.

                if (batsmanDice > 0 && batsmanDice < 7) {
                    totalScore.setText(String.valueOf(score += batsmanDice));
                } else {

                    if (batsmanDice == 0) {
                        rollScore2.setText(" ");// when rolling 0 we don't want zero on the game board.
                        count++;
                        Toast.makeText(GameScreen.this,
                                "Owzthat!", Toast.LENGTH_SHORT).show();
                        rollButton.setEnabled(false); // followed by disabling the player button.
                        umpireButton.setEnabled(true); // once Owzthat gets called in toast we enable the umpire button

                        umpireRoll(); // calling the umpire dice descion
                    }

                }


            }
        });

    }

    public void umpireRoll(){
        Random random = new Random();
        final int umpireDice = random.nextInt(4);  // 5 choice for the umpire to roll (1. Not Out 2. Caught 3. Wicket 4. LBW 5. Bowled)
        // call the button for the Umpire descion to be used.
        // after setting the button to be enabled from the boolean statement
        umpireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // setting the roll of the umpire here to a string
                //umpireRoll.setText(String.valueOf(umpireDice));
                // swtich statement to swtich the options of the umpires dice.
                switch (umpireDice) {
                    case 0:
                        umpireRoll.setText(R.string.caught);
                        break;
                    case 1:
                        umpireRoll.setText(R.string.notOut);
                        break;
                    case 2:
                        umpireRoll.setText(R.string.wicket);
                        break;
                    case 3:
                        umpireRoll.setText(R.string.lbw);
                        break;
                    case 4:
                        umpireRoll.setText(R.string.bowled);
                        break;
                }
            }
        });

    }

}

