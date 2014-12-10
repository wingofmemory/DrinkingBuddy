package com.example.julianna.drinkingbuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class GameOfWar extends Activity implements View.OnClickListener
{

    Button button_gow1;

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_game_of_war);

        final Button button_gow2 = (Button) findViewById(R.id.button_gow2);
        button_gow2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent("com.example.julianna.drinkingbuddy.ReglerforGameofWar"));}
        });

        button_gow1 = (Button) findViewById(R.id.button_gow1);
        button_gow1.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_of_war, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void buttonGow1Click() {

        startActivity(new Intent("com.example.julianna.drinkingbuddy.GameOfWar"));

    }


    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button_gow1:
                buttonGow1Click();
                break;



        }

    }
    public void selfDestruct(View view) {
        // Kabloey
    }



}
