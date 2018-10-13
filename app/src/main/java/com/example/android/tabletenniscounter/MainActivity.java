package com.example.android.tabletenniscounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String gameScore = "0 : 0";
    String debuging = "DEBUG";
    int round = 1;
    int player1RoundScore = 0;
    int player1Score = 0;
    int player2RoundScore = 0;
    int player2Score = 0;
    TextView player1View;
    TextView player2View;
    TextView gameScoreTextView;
    TextView roundTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1View = (TextView) findViewById(R.id.first_player_tv);
        player2View = (TextView) findViewById(R.id.second_player_tv);
        gameScoreTextView = (TextView) findViewById(R.id.game_score_tv);
        roundTextView = (TextView) findViewById(R.id.round_tv);
    }

    public void givePointToPlayer1(View view) {
        player1RoundScore++;
        if(player1RoundScore > 10){
            checkRound();
        }
        player1View.setText(String.valueOf(player1RoundScore));
    }

    public void givePointToPlayer2(View view) {
        player2RoundScore++;
        if(player2RoundScore > 10){
            checkRound();
        }
        player2View.setText(String.valueOf(player2RoundScore));
    }

    private void displayScore() {
        gameScore = player1Score + " : " + player2Score;
        gameScoreTextView.setText(gameScore);
    }

    void checkRound(){
        if((player1RoundScore - player2RoundScore) >= 2){
            Log.d(debuging,"Player 1 won round");
            player1Score++;
            newRound();
        }else if((player1RoundScore - player2RoundScore) <= -2 ){

            Log.d(debuging,"Player 2 won round");
            player2Score++;
            newRound();
        }
        displayScore();
    }

    void newRound(){
        player1RoundScore = 0;
        player2RoundScore = 0;
        player1View.setText(String.valueOf(player1RoundScore));
        player2View.setText(String.valueOf(player2RoundScore));
        round++;
        roundTextView.setText("Round " + round);
    }

    public void reset(View view){
        player1RoundScore = 0;
        player2RoundScore = 0;
        player1Score = 0;
        player2Score = 0;
        round = 1;
        roundTextView.setText("Round " + round);
        player1View.setText(String.valueOf(player1RoundScore));
        player2View.setText(String.valueOf(player2RoundScore));
        displayScore();
    }
}
