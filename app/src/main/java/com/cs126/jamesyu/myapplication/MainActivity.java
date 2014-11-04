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

        TextView victoryMessage = (TextView) findViewById(R.id.victoryMessage);
        final TextView currentPlayer = (TextView) findViewById(R.id.currentPlayer);
        final Button topLeft = (Button) findViewById(R.id.topLeft);
        Button top = (Button) findViewById(R.id.top);
        Button topRight = (Button) findViewById(R.id.topRight);
        Button left = (Button) findViewById(R.id.left);
        Button mid = (Button) findViewById(R.id.mid);
        Button right = (Button) findViewById(R.id.right);
        Button botLeft = (Button) findViewById(R.id.botLeft);
        Button bot = (Button) findViewById(R.id.bot);
        Button botRight = (Button) findViewById(R.id.botRight);

        topLeft.setOnClickListener(new View.OnClickListener() {
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



    public boolean Text[];
}
