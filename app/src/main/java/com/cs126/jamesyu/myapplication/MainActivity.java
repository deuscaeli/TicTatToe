package com.cs126.jamesyu.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        victoryMessage = (TextView) findViewById(R.id.victoryMessage);
        currentPlayer = (TextView) findViewById(R.id.currentPlayer);
        assistMessage = (TextView) findViewById(R.id.assistMessage);
        topLeft = (Button) findViewById(R.id.topLeft);
        top = (Button) findViewById(R.id.top);
        topRight = (Button) findViewById(R.id.topRight);
        left = (Button) findViewById(R.id.left);
        mid = (Button) findViewById(R.id.mid);
        right = (Button) findViewById(R.id.right);
        botLeft = (Button) findViewById(R.id.botLeft);
        bot = (Button) findViewById(R.id.bot);
        botRight = (Button) findViewById(R.id.botRight);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    //Define the action taken when each button is clicked.
    public void onClick(View v) {
        switch (v.getId()) {
            //Start the game by clean up the canvas, reset counter, and display current player;
            case R.id.newGame:
                gameInProgress = true;
                move = 0;
                resetGameBoard();
                currentPlayer.setText("X");
                victoryMessage.setText("");
                assistMessage.setText("Currently Playing:");
                break;
            //For each area of the game board, if the game is in progress, click on it will mark it with the symbol of the current player.
            // And will then checked if any player wins or its the end of game.
            case R.id.topLeft:
                if (gameInProgress && topLeft.getText().equals("")) {
                    topLeft.setText(currentPlayer.getText());
                    if (victory()) {
                        displayVictoryMessage();
                        gameInProgress = false;
                        break;
                    }
                    if(endGame()) {
                        displayDraw();
                        gameInProgress = false;
                        break;
                    }
                    switchPlayer();
                }
                break;
            case R.id.top:
                if (gameInProgress && top.getText().equals("")) {
                    top.setText(currentPlayer.getText());
                    move++;
                    if (victory()) {
                        displayVictoryMessage();
                        gameInProgress = false;
                        break;
                    }
                    if(endGame()) {
                        displayDraw();
                        gameInProgress = false;
                        break;
                    }
                    switchPlayer();
                }
                break;
            case R.id.topRight:
                if (gameInProgress && topRight.getText().equals("")) {
                    topRight.setText(currentPlayer.getText());
                    move++;
                    if (victory()) {
                        displayVictoryMessage();
                        gameInProgress = false;
                        break;
                    }
                    if(endGame()) {
                        displayDraw();
                        gameInProgress = false;
                        break;
                    }
                    switchPlayer();
                }
                break;
            case R.id.left:
                if (gameInProgress && left.getText().equals("")) {
                    left.setText(currentPlayer.getText());
                    move++;
                    if (victory()) {
                        displayVictoryMessage();
                        gameInProgress = false;
                        break;
                    }
                    if(endGame()) {
                        displayDraw();
                        gameInProgress = false;
                        break;
                    }
                    switchPlayer();
                }
                break;
            case R.id.mid:
                if (gameInProgress && mid.getText().equals("")) {
                    mid.setText(currentPlayer.getText());
                    move++;
                    if (victory()) {
                        displayVictoryMessage();
                        gameInProgress = false;
                        break;
                    }
                    if(endGame()) {
                        displayDraw();
                        gameInProgress = false;
                        break;
                    }
                    switchPlayer();
                }
                break;
            case R.id.right:
                if (gameInProgress && right.getText().equals("")) {
                    right.setText(currentPlayer.getText());
                    move++;
                    if (victory()) {
                        displayVictoryMessage();
                        gameInProgress = false;
                        break;
                    }
                    if(endGame()) {
                        displayDraw();
                        gameInProgress = false;
                        break;
                    }
                    switchPlayer();
                }
                break;
            case R.id.botLeft:
                if (gameInProgress && botLeft.getText().equals("")) {
                    botLeft.setText(currentPlayer.getText());
                    move++;
                    if (victory()) {
                        displayVictoryMessage();
                        gameInProgress = false;
                        break;
                    }
                    if(endGame()) {
                        displayDraw();
                        gameInProgress = false;
                        break;
                    }
                    switchPlayer();
                }
                break;
            case R.id.bot:
                if (gameInProgress && bot.getText().equals("")) {
                    bot.setText(currentPlayer.getText());
                    move++;
                    if (victory()) {
                        displayVictoryMessage();
                        gameInProgress = false;
                        break;
                    }
                    if(endGame()) {
                        displayDraw();
                        gameInProgress = false;
                        break;
                    }
                    switchPlayer();
                }
                break;
            case R.id.botRight:
                if (gameInProgress && botRight.getText().equals("")) {
                    botRight.setText(currentPlayer.getText());
                    move++;
                    if (victory()) {
                        displayVictoryMessage();
                        gameInProgress = false;
                        break;
                    }
                    if(endGame()) {
                        displayDraw();
                        gameInProgress = false;
                        break;
                    }
                    switchPlayer();
                }
                break;
            //restart the game by clearing up the game board and reset the counter
            case R.id.restart_user1:
                gameInProgress = true;
                move = 0;
                resetGameBoard();
                currentPlayer.setText("X");
                victoryMessage.setText("");
                break;
            default:
                throw new RuntimeException("Unknown button ID");
        }
    }

    //check if any player wins the game by owning three area on the same line.
    private boolean victory() {
        if(topLeft.getText().equals("X") && top.getText().equals("X") && topRight.getText().equals("X")
                || topLeft.getText().equals("O") && top.getText().equals("O") && topRight.getText().equals("O")){
            return true;
        } else if(left.getText().equals("X") && mid.getText().equals("X") && right.getText().equals("X")
                || left.getText().equals("O") && mid.getText().equals("O") && right.getText().equals("O")) {
            return true;
        } else if(botLeft.getText().equals("X") && bot.getText().equals("X") && botRight.getText().equals("X")
                || botLeft.getText().equals("O") && bot.getText().equals("O") && botRight.getText().equals("O")) {
            return true;
        } else if(topLeft.getText().equals("X") && left.getText().equals("X") && botLeft.getText().equals("X")
                || topLeft.getText().equals("O") && left.getText().equals("O") && botLeft.getText().equals("O")) {
            return true;
        } else if(top.getText().equals("X") && mid.getText().equals("X") && bot.getText().equals("X")
                || top.getText().equals("O") && mid.getText().equals("O") && bot.getText().equals("O")) {
            return true;
        } else if(topRight.getText().equals("X") && right.getText().equals("X") && botRight.getText().equals("X")
                || topRight.getText().equals("O") && right.getText().equals("O") && botRight.getText().equals("O")) {
            return true;
        } else if(topLeft.getText().equals("X") && mid.getText().equals("X") && botRight.getText().equals("X")
                || topLeft.getText().equals("O") && mid.getText().equals("O") && botRight.getText().equals("O")) {
            return true;
        } else if(topRight.getText().equals("X") && mid.getText().equals("X") && botLeft.getText().equals("X")
                || topRight.getText().equals("O") && mid.getText().equals("O") && botLeft.getText().equals("O")) {
            return true;
        } else {
            return false;
        }
    }

    //check if it's draw by evaluating the counter.
    private boolean endGame() {
        return(move >= 8);
    }

    /*
    private boolean notNull(Button b) {
        return !(b.getText().equals(""));
    }
    */

    //display that the current player wins the game.
    private void displayVictoryMessage() {
        if(markOfPlayer1.equals(currentPlayer.getText())) {
            victoryMessage.setText("Player with X wins!");
        } else {
            victoryMessage.setText("Player with O wins!");
        }
    }

    private void displayDraw() {
        victoryMessage.setText("Draw!");
    }

    //change to another player.
    private void switchPlayer() {
        if(currentPlayer.getText().equals("O")) {
            currentPlayer.setText("X");
        } else if(currentPlayer.getText().equals("X")) {
            currentPlayer.setText("O");
        }
    }

    //set all game board button's text to be blank.
    private void resetGameBoard() {
        topLeft.setText("");
        top.setText("");
        topRight.setText("");
        left.setText("");
        mid.setText("");
        right.setText("");
        botLeft.setText("");
        bot.setText("");
        botRight.setText("");
    }

    private TextView victoryMessage;
    private TextView currentPlayer;
    private TextView assistMessage;
    private Button topLeft;
    private Button top ;
    private Button topRight ;
    private Button left;
    private Button mid;
    private Button  right;
    private Button botLeft;
    private Button bot;
    private Button botRight;
    //set the first player's mark to be X by default.
    private String markOfPlayer1 = "X";
    private Boolean gameInProgress = false;
    //counter of how many moves have been taken.
    private int move;
}
