package com.cs126.jamesyu.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        topLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topLeft.setText(currentPlayer.getText());
            }
        });

        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topLeft.setText(currentPlayer.getText());
            }
        });

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

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.newGame:
                gameInProgress = true;
                resetGameBoard();
                currentPlayer.setText("X");
                victoryMessage.setText("");
                break;
            case R.id.topLeft:
                if (gameInProgress) {
                    topLeft.setText(currentPlayer.getText());
                }
                if(endGame()){
                    displayVictoryMessage();
                    gameInProgress = false;
                }
                break;
            case R.id.top:
                if (gameInProgress) {
                    top.setText(currentPlayer.getText());
                }
                if(endGame()){
                    displayVictoryMessage();
                    gameInProgress = false;
                }
                break;
            case R.id.topRight:
                if (gameInProgress) {
                    topRight.setText(currentPlayer.getText());
                }
                if(endGame()){
                    displayVictoryMessage();
                    gameInProgress = false;
                }
                break;
            case R.id.left:
                if (gameInProgress) {
                    left.setText(currentPlayer.getText());
                }
                if(endGame()){
                    displayVictoryMessage();
                    gameInProgress = false;
                }
                break;
            case R.id.mid:
                if (gameInProgress) {
                    mid.setText(currentPlayer.getText());
                }
                if(endGame()){
                    displayVictoryMessage();
                    gameInProgress = false;
                }
                break;
            case R.id.right:
                if (gameInProgress) {
                    right.setText(currentPlayer.getText());
                }
                if(endGame()){
                    displayVictoryMessage();
                    gameInProgress = false;
                }
                break;
            case R.id.botLeft:
                if (gameInProgress) {
                    botLeft.setText(currentPlayer.getText());
                }
                if(endGame()){
                    displayVictoryMessage();
                    gameInProgress = false;
                }
                break;
            case R.id.bot:
                if (gameInProgress) {
                    bot.setText(currentPlayer.getText());
                }
                if(endGame()){
                    displayVictoryMessage();
                    gameInProgress = false;
                }
                break;
            case R.id.botRight:
                if (gameInProgress) {
                    botRight.setText(currentPlayer.getText());
                }
                if(endGame()){
                    displayVictoryMessage();
                    gameInProgress = false;
                }
                break;
            case R.id.restart_user1:
                resetGameBoard();
                gameInProgress = true;
                currentPlayer.setText("X");
                victoryMessage.setText("");
                break;
            default:
                throw new RuntimeException("Unknown button ID");
        }
    }

    private boolean endGame() {
        if(notNull(topLeft)&&notNull(top)&&notNull(topRight)&&(top.getText().equals(topLeft.getText()))&&(top.getText().equals(topRight.getText()))){
            return true;
        } else if(notNull(left)&&notNull(mid)&&notNull(right)&&(mid.getText().equals(left.getText()))&&(mid.getText().equals(right.getText()))) {
            return true;
        } else if(notNull(botLeft)&&notNull(bot)&&notNull(botRight)&&(bot.getText().equals(botLeft.getText()))&&(bot.getText().equals(botRight.getText()))) {
            return true;
        } else if(notNull(topLeft)&&notNull(left)&&notNull(botLeft)&&(left.getText().equals(topLeft.getText()))&&(left.getText().equals(botLeft.getText()))) {
            return true;
        } else if(notNull(top)&&notNull(mid)&&notNull(bot)&&(mid.getText().equals(top.getText()))&&(mid.getText().equals(bot.getText()))) {
            return true;
        } else if(notNull(topRight)&&notNull(right)&&notNull(botRight)&&(right.getText().equals(topRight.getText()))&&(right.getText().equals(botRight.getText()))) {
            return true;
        } else if(notNull(topLeft)&&notNull(mid)&&notNull(botRight)&&(mid.getText().equals(topLeft.getText()))&&(mid.getText().equals(botRight.getText()))) {
            return true;
        } else if(notNull(topRight)&&notNull(mid)&&notNull(botLeft)&&(mid.getText().equals(botLeft.getText()))&&(mid.getText().equals(topRight.getText()))) {
            return true;
        } else {
            return false;
        }
    }

    private boolean notNull(Button b) {
        return !(b.getText().equals(""));
    }

    private void displayVictoryMessage() {
        if(markOfPlayer1.equals(currentPlayer.getText())) {
            victoryMessage.setText("Player 1 wins!");
        } else {
            victoryMessage.setText("Player 2 wins!");
        }
    }

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

    private TextView victoryMessage = (TextView) findViewById(R.id.victoryMessage);
    private TextView currentPlayer = (TextView) findViewById(R.id.currentPlayer);
    private Button topLeft = (Button) findViewById(R.id.topLeft);
    private Button top = (Button) findViewById(R.id.top);
    private Button topRight = (Button) findViewById(R.id.topRight);
    private Button left = (Button) findViewById(R.id.left);
    private Button mid = (Button) findViewById(R.id.mid);
    private Button  right = (Button) findViewById(R.id.right);
    private Button botLeft = (Button) findViewById(R.id.botLeft);
    private Button bot = (Button) findViewById(R.id.bot);
    private Button botRight = (Button) findViewById(R.id.botRight);
    private String markOfPlayer1 = "X";
    private Boolean gameInProgress = false;
}
